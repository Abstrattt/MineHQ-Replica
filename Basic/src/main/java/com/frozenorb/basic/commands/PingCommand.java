package com.frozenorb.basic.commands;

import com.frozenorb.commonlibs.utils.MessageUtility;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Lol console can't have ping");
            return false;
        }
        Player player = (Player) commandSender;
        player.sendMessage(MessageUtility.formatMessage("&f" + player.getDisplayName() + "&e's Ping: &c0"));
        return false;
    }
}
