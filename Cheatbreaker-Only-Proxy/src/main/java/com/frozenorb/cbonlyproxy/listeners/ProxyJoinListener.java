package com.frozenorb.cbonlyproxy.listeners;

import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ProxyJoinListener implements Listener {

    @EventHandler(priority=64)
    public void onServerListPing(ProxyPingEvent e){
        /*ServerPing pingInfo = e.getResponse();
        ServerPing.Protocol version = pingInfo.getVersion();
        //version.setName(ChatColor.RED + "Cheatbreaker");
       version.setProtocol(-1332);
        //pingInfo.setVersion(version);
        e.setResponse(pingInfo);*/
        /*ServerPing pingInfo = e.getResponse();
        ServerPing.Protocol version = pingInfo.getVersion();
        if (e.getConnection().getVersion() == -1332){
            version.setProtocol(-1332);
            version.setName(ChatColor.RED + "Cheatbreaker");
            pingInfo.setVersion(version);
        }else{

        }*/
        Logger.getAnonymousLogger().log(Level.SEVERE, e.getConnection().getVersion() + "");
        //e.setResponse(pingInfo);
    }
}
