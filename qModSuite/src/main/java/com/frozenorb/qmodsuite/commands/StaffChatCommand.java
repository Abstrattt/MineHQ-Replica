package com.frozenorb.qmodsuite.commands;

import com.frozenorb.qmodsuite.ModSuitePubSub;
import com.frozenorb.qmodsuite.qModSuitePlugin;
import com.frozenorb.redstone.RedstonePluginSettings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class StaffChatCommand implements CommandExecutor {

    /* Channel ID */
    private static final String CHANNEL_ID = "SC";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        /* Check if the Command Sender is from console */
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You can not use staff chat from console");
            return false;
        }

        /* Player Object */
        Player player = (Player) commandSender;
        if (strings.length < 1) {
            commandSender.sendMessage("Command Usage");
            return false;
        }

        /* Execute all Database calls async */
        new BukkitRunnable(){
            @Override
            public void run() {
                /* Make Staff Message */
                StringBuilder staffMessage = new StringBuilder();
                for (String arg : strings) {
                    staffMessage.append(arg).append(" ");
                }

                /* Construct Message to send over Redis Pub Sub */
                String constructedMessage = RedstonePluginSettings.SERVER_NAME + ModSuitePubSub.SPLITER +
                        player.getName() + ModSuitePubSub.SPLITER +
                        staffMessage.toString();

                /* Send over Channel */
                qModSuitePlugin.getRedisHelper().getPool().getResource().publish(ModSuitePubSub.IDENTIFIER + CHANNEL_ID, constructedMessage);
            }
        }.runTaskAsynchronously(qModSuitePlugin.getProvidingPlugin(qModSuitePlugin.class));
        return false;
    }
}
