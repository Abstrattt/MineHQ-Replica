package com.frozenorb.qlib.channels;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.frozenorb.qlib.qLibPlugin;
import org.bukkit.entity.Player;

public class ChatChannel implements CommandExecutor {

    private String prefix;
    private String format;

    public ChatChannel(String prefix, String command) {
        this.prefix = prefix;
        qLibPlugin.getProvidingPlugin(qLibPlugin.class).getCommand(command).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You must be a player to execute this command!");
            return false;
        }
        return false;
    }
}
