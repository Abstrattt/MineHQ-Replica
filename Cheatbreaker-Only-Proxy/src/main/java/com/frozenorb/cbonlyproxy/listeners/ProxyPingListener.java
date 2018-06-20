package com.frozenorb.cbonlyproxy.listeners;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProxyPingListener implements Listener {

    @EventHandler
    public void onServerConnect(ServerConnectEvent e) {
        ProxiedPlayer player = e.getPlayer();
        if (player.getPendingConnection().getVersion() != -1332){
            Logger.getAnonymousLogger().log(Level.SEVERE, "LOL");
        }
    }
}
