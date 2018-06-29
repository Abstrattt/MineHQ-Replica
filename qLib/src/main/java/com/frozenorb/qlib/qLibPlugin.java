package com.frozenorb.qlib;

import com.frozenorb.qlib.channels.ChannelHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class qLibPlugin extends JavaPlugin {

    static ChannelHandler channelHandler;

    @Override
    public void onEnable() {
        channelHandler = new ChannelHandler();
    }

    @Override
    public void onDisable() {

    }
}
