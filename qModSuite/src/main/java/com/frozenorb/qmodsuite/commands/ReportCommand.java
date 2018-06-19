package com.frozenorb.qmodsuite.commands;

import com.frozenorb.qmodsuite.ActionUtils;
import com.frozenorb.qmodsuite.ModSuitePubSub;
import com.frozenorb.redstone.RedstonePluginSettings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import redis.clients.jedis.Jedis;
import com.frozenorb.qmodsuite.qModSuitePlugin;
import redis.clients.jedis.Pipeline;

public class ReportCommand implements CommandExecutor {

    /* Channel ID */
    private static final String CHANNEL_ID = "RP";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        /* Check if the Command Sender is from console */
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You can not report people from console.");
            return false;
        }

        /* Player Object */
        Player player = (Player) commandSender;
        if (strings.length < 2) {
            commandSender.sendMessage("Command Usage");
            return false;
        }

        /* Check if the player object exists */
        if (strings[0] == null) {
            return false;
        }

        /* Player Reporting himself */
        if (strings[0].equalsIgnoreCase(player.getName())){
            player.sendMessage("&cYou can not report yourself!");
            return false;
        }

        /* Check if the Player is online */
        Player reported = Bukkit.getPlayer(strings[0]);
        if (reported == null){
            player.sendMessage("&cThis player is not online!");
            return false;
        }

        /* Execute all Database calls async */
        new BukkitRunnable(){
            @Override
            public void run() {
                /* Check for Cooldown */
                if (ActionUtils.hasCooldown(player, CHANNEL_ID)){
                    player.sendMessage("cooldown message");
                    return;
                }

                /* Apply Cooldown */
                ActionUtils.addCooldown(player, CHANNEL_ID, 30);

                /* Make Report Message */
                StringBuilder reportMessage = new StringBuilder();
                for (String arg : strings) {
                    if (!arg.equalsIgnoreCase(strings[0])) {
                        reportMessage.append(arg).append(" ");
                    }
                }

                /* Construct Message to send over Redis Pub Sub */
                String constructedMessage = RedstonePluginSettings.SERVER_NAME + ModSuitePubSub.SPLITER +
                                            reported.getName() + ModSuitePubSub.SPLITER +
                                            player.getName() + ModSuitePubSub.SPLITER +
                                            reportMessage.toString();

                /* Send over Channel */
                qModSuitePlugin.getRedisHelper().getPool().getResource().publish(ModSuitePubSub.IDENTIFIER + CHANNEL_ID, constructedMessage);

                /* Success Message */
                player.sendMessage("You have sent a report");
            }
        }.runTaskAsynchronously(qModSuitePlugin.getProvidingPlugin(qModSuitePlugin.class));
        return false;
    }
}
