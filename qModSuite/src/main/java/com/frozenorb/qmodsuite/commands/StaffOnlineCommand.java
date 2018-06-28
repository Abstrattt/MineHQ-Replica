package com.frozenorb.qmodsuite.commands;

import com.frozenorb.basic.profile.PlayerProfile;
import com.frozenorb.qmodsuite.profile.StaffProfileHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StaffOnlineCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (PlayerProfile playerProfile : StaffProfileHandler.getProfiles().keySet()){
            stringBuilder.append(playerProfile.getPlayer().getDisplayName()).append(", ");
        }
        commandSender.sendMessage("Staff Online: " + stringBuilder.toString());
        return false;
    }
}
