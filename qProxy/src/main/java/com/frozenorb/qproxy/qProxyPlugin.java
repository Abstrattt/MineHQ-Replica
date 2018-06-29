package com.frozenorb.qproxy;

import net.md_5.bungee.api.plugin.Plugin;

public class qProxyPlugin extends Plugin {

    @Override
    public void onEnable() {
        this.getProxy().registerChannel("qProxy-Hub");
        this.getProxy().getPluginManager().registerListener(this, new ChannelListeners(this));
    }

    @Override
    public void onDisable() {
        this.getProxy().unregisterChannel("qProxy-Hub");
    }
}
