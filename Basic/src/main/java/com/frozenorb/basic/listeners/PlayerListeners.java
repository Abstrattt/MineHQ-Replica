package com.frozenorb.basic.listeners;

import com.frozenorb.basic.profile.PlayerProfile;
import com.frozenorb.basic.profile.ProfileHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PlayerProfile profile = new PlayerProfile(player);
        ProfileHandler.addProfile(profile);

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        PlayerProfile profile = null;
        ProfileHandler.removeProfile(profile);
    }

}
