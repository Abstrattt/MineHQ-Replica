package com.frozenorb.redstone.commands;

import com.frozenorb.commonlibs.utils.MessageUtility;
import com.frozenorb.redstone.RedstonePluginSettings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EnviromentCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(MessageUtility.formatMessage("&cRedstone Enviroment Dump"));
        commandSender.sendMessage(MessageUtility.formatMessage(""));
        commandSender.sendMessage(MessageUtility.formatMessage("&cName: &f" + RedstonePluginSettings.SERVER_NAME));
        commandSender.sendMessage(MessageUtility.formatMessage("&cGroup: &f" + RedstonePluginSettings.SERVER_GROUP));
        commandSender.sendMessage(MessageUtility.formatMessage("&cStage: &fN/A"));
        return false;
    }
}
