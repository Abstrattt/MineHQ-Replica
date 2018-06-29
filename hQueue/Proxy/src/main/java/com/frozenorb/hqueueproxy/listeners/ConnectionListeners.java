package com.frozenorb.hqueueproxy.listeners;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ConnectionListeners implements Listener {

    @EventHandler
    public void onProxyLeave(PlayerDisconnectEvent event) {
        /* Player Object */
        ProxiedPlayer proxiedPlayer = event.getPlayer();

    }
}
