package com.frozenorb.basic.commands;

import com.frozenorb.commonlibs.utils.MessageUtility;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class PingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Lol console can't have ping");
            return false;
        }
        Player player = (Player) commandSender;
        player.sendMessage(MessageUtility.formatMessage("&f" + player.getDisplayName() + "&e's Ping: &c" + pingPlayer(player)));
        return false;
    }

    /**
     * Neat little class to get a player's ping without using NMS
     *
     * @see "https://bukkit.org/threads/get-players-ping.337634/"
     */
    public int pingPlayer(Player who) {
        try {
            //Building the version of the server in such a form we can use it in NMS code.
            String bukkitversion = Bukkit.getServer().getClass().getPackage()
                    .getName().substring(23);
            //Getting craftplayer to cast later on
            Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit."
                    + bukkitversion + ".entity.CraftPlayer");
            //Invoking method getHandle() for the craftplayer we build above, and now we have a EntityPlayer
            Object handle = craftPlayer.getMethod("getHandle").invoke(who);
            //Getting field "ping" that holds player's ping obviously
            Integer ping = (Integer) handle.getClass().getDeclaredField("ping").get(handle);
            //Returning the ping
            return ping.intValue();
        } catch (ClassNotFoundException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException
                | NoSuchFieldException e) {
            //Handle exceptions however you like, i chose to return value of -1; since player's ping can't be -1.
            return -1;
        }
    }
}
