package com.frozenorb.uhub.commands;

import com.frozenorb.commonlibs.utils.MessageUtility;
import com.frozenorb.uhub.spawn.SpawnHandler;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        /* Command sent from the Console */
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("You can not teleport to spawn as console.");
            return false;
        }
        Player player = (Player) commandSender;
        final Location spawn = SpawnHandler.getSpawnLocation();
        player.teleport(spawn);
        player.sendMessage(MessageUtility.formatMessage("&aTeleported!"));
        return false;
    }
}
