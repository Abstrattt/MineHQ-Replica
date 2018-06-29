package com.frozenorb.qproxy;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ChannelListeners implements Listener {

    private qProxyPlugin plugin;

    public ChannelListeners(qProxyPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMessage(PluginMessageEvent event){
        ByteArrayDataInput in = ByteStreams.newDataInput(event.getData());
        switch (event.getTag()) {
            case "qProxy-Hub":
                if (event.getSender() instanceof ProxiedPlayer) {
                    String identifier = in.readUTF();
                    if (identifier.equalsIgnoreCase("Connect")){
                        ProxiedPlayer proxiedPlayer = (ProxiedPlayer) event.getSender();
                        proxiedPlayer.connect(plugin.getProxy().getServerInfo("Hub-1"));
                    }
                }
                break;
        }
    }

}
