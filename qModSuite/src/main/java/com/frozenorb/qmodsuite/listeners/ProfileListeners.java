package com.frozenorb.qmodsuite.listeners;

import com.frozenorb.basic.profile.events.ProfileCreateEvent;
import com.frozenorb.basic.profile.events.ProfileDestoryEvent;
import com.frozenorb.qmodsuite.profile.StaffProfile;
import com.frozenorb.qmodsuite.profile.StaffProfileHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ProfileListeners implements Listener {

    @EventHandler
    public void onProfileCreate(ProfileCreateEvent event) {
        /* Player Object */
        Player player = Bukkit.getPlayer(event.getPlayerProfile().getUuid());
        /* Check for correct permission */
        if (player.hasPermission("Staff.Mode")) {
            /* Create Staff Profile */
            StaffProfile staffProfile = new StaffProfile(event.getPlayerProfile());
            /* Add Staff Profile */
            StaffProfileHandler.addProfile(event.getPlayerProfile(), staffProfile);
        }
    }

    @EventHandler
    public void onProfileDestory(ProfileDestoryEvent event) {
        /* Get Staff Profile */
        StaffProfile staffProfile = StaffProfileHandler.getProfile(event.getPlayerProfile());
        if (staffProfile != null) {
            /* Remove Staff Profile */
            StaffProfileHandler.removeProfile(event.getPlayerProfile());
        }
    }
}
