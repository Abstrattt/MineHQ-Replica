package com.frozenorb.qmodsuite.commands;

import com.frozenorb.commonlibs.utils.MessageUtility;
import com.frozenorb.qmodsuite.ActionUtils;
import com.frozenorb.qmodsuite.ModSuitePubSub;
import com.frozenorb.qmodsuite.qModSuitePlugin;
import com.frozenorb.redstone.RedstonePluginSettings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class RequestCommand implements CommandExecutor {

    /* Channel ID */
    private static final String CHANNEL_ID = "RQ";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        /* Check if the Command Sender is from console */
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You can not send a request from console");
            return false;
        }

        /* Player Object */
        Player player = (Player) commandSender;
        if (strings.length < 1) {
            commandSender.sendMessage(MessageUtility.formatMessage("&c/" + s + " [message]"));
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
                StringBuilder requestMessage = new StringBuilder();
                for (String arg : strings) {
                    requestMessage.append(arg).append(" ");
                }

                /* Construct Message to send over Redis Pub Sub */
                String constructedMessage = RedstonePluginSettings.SERVER_NAME + ModSuitePubSub.SPLITER +
                        player.getName() + ModSuitePubSub.SPLITER +
                        requestMessage.toString();

                /* Send over Channel */
                qModSuitePlugin.getRedisHelper().getPool().getResource().publish(ModSuitePubSub.IDENTIFIER + CHANNEL_ID, constructedMessage);

                /* Success Message */
                player.sendMessage("You have sent a request");
            }
        }.runTaskAsynchronously(qModSuitePlugin.getProvidingPlugin(qModSuitePlugin.class));
        return false;
    }
}
