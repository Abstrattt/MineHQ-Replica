package com.frozenorb.cbonlyproxy;

import com.frozenorb.cbonlyproxy.listeners.ProxyJoinListener;
import com.frozenorb.cbonlyproxy.listeners.ProxyPingListener;
import net.md_5.bungee.api.plugin.Plugin;

public class CBProxyPlugin extends Plugin {

    @Override
    public void onEnable() {
        registerListeners();
    }

    @Override
    public void onDisable() {

    }

    private void registerListeners(){
        getProxy().getPluginManager().registerListener(this, new ProxyJoinListener());
        getProxy().getPluginManager().registerListener(this, new ProxyPingListener());
    }
}
