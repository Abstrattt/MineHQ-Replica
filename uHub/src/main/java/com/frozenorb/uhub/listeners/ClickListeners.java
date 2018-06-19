package com.frozenorb.uhub.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickListeners implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        Player player = event.getPlayer();
    }
}
