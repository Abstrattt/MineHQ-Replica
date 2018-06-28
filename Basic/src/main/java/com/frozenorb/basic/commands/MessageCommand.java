package com.frozenorb.basic.commands;

import com.frozenorb.basic.profile.PlayerProfile;
import com.frozenorb.basic.profile.ProfileHandler;
import com.frozenorb.commonlibs.utils.MessageUtility;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        /* Check if the Command Sender is from console */
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You can not message people from console.");
            return false;
        }

        /* Player Object */
        Player player = (Player) commandSender;
        if (strings.length < 2 || strings[0] == null) {
            commandSender.sendMessage(MessageUtility.formatMessage("&c/" + s + " [player] [message]"));
            return false;
        }

        /* Player Reporting himself */
        if (strings[0].equalsIgnoreCase(player.getName())) {
            player.sendMessage(MessageUtility.formatMessage("&cYou can not message yourself"));
            return false;
        }

        /* Check if the Player is online */
        Player messaged = Bukkit.getPlayer(strings[0]);
        if (messaged == null || !messaged.isOnline()) {
            player.sendMessage(MessageUtility.formatMessage("&cThis player is not online!"));
            return false;
        }

        /* Construct Message */
        StringBuilder constructedMessage = new StringBuilder();
        for (String arg : strings) {
            if (!arg.equalsIgnoreCase(strings[0])) {
                constructedMessage.append(arg).append(" ");
            }
        }

        /* Sender */
        player.sendMessage("(To " + messaged.getDisplayName() + ") " + constructedMessage.toString());
        PlayerProfile senderProfile = ProfileHandler.getProfile(player.getUniqueId());
        if (senderProfile != null) {
            senderProfile.setPreviousMessager(messaged.getUniqueId());
        }

        /* Reciever */
        messaged.sendMessage("(From " + player.getDisplayName() + ") " + constructedMessage.toString());
        PlayerProfile recieverProfile = ProfileHandler.getProfile(messaged.getUniqueId());
        if (recieverProfile != null) {
            recieverProfile.setPreviousMessager(player.getUniqueId());
        }
        return false;
    }
}
