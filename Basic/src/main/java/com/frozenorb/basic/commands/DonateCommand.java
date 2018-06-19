package com.frozenorb.basic.commands;

import com.frozenorb.commonlibs.utils.MessageUtility;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DonateCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(MessageUtility.formatMessage("&eYou can purchase a rank at: &dstore.minehq.com&e."));
        return false;
    }
}
