package com.frozenorb.uhub.spawn.menus.type;

import org.bukkit.scheduler.BukkitRunnable;
import com.frozenorb.uhub.uHubPlugin;

public class ServerSelectorRunnable extends BukkitRunnable {

    private ServerSelectorMenu menu;

    public ServerSelectorRunnable(ServerSelectorMenu menu) {
        this.menu = menu;
        this.runTaskTimer(uHubPlugin.getProvidingPlugin(uHubPlugin.class), 10, 10);
    }

    @Override
    public void run() {

    }
}
