package com.frozenorb.cbonlyproxy.listeners;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;


public class ProxyJoinListener implements Listener {

    @EventHandler(priority=64)
    public void onServerListPing(ProxyPingEvent e){
        ServerPing pingInfo = e.getResponse();
        ServerPing.Protocol version = pingInfo.getVersion();
        version.setProtocol(-1332);
        pingInfo.setVersion(version);
        e.setResponse(pingInfo);
    }
}
