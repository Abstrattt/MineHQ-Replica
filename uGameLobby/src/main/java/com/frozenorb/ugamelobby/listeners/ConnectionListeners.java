package com.frozenorb.ugamelobby.listeners;

import com.frozenorb.ugamelobby.queue.ModeQueue;
import com.frozenorb.ugamelobby.queue.QueueHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        /* Player Object */
        Player player = event.getPlayer();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        /* Player Object */
        Player player = event.getPlayer();

        /* Check if the player is queued */
        if (QueueHandler.isPlayerQueued(player)){
            ModeQueue queue = QueueHandler.getQueue(player);
            queue.getQueued().remove(player.getUniqueId());
        }
    }

}
