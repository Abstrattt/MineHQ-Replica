package com.frozenorb.cbonlyproxy.listeners;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
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
        Logger.getAnonymousLogger().log(Level.SEVERE, player.getPendingConnection().getVersion() + "");
        if (player.getPendingConnection().getVersion() != -1332){
            player.disconnect(new ComponentBuilder("You must be on CheatBreaker to join.\nDownload at www.cheatbreaker.com").color(ChatColor.RED).create());
        }
    }
}
