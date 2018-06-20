package com.frozenorb.meetup.listeners;

import com.frozenorb.meetup.MeetupPlugin;
import com.frozenorb.meetup.backend.game.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        /* Player Object */
        Player player = event.getPlayer();

        Game game = MeetupPlugin.getGame();
        game.join(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        /* Player Object */
        Player player = event.getPlayer();

    }

    @EventHandler
    public void onPreLogin(AsyncPlayerPreLoginEvent event) {
    }

}
