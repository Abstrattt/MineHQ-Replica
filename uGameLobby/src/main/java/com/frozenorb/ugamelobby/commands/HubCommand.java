package com.frozenorb.ugamelobby.commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.frozenorb.ugamelobby.uGameLobbyPlugin;

public class HubCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You need to be a player to execute this command!");
            return false;
        }
        /* Player Object */
        Player player = (Player) commandSender;
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        player.sendPluginMessage(uGameLobbyPlugin.getProvidingPlugin(uGameLobbyPlugin.class), "qProxy-Hub", out.toByteArray());
        return false;
    }
}
