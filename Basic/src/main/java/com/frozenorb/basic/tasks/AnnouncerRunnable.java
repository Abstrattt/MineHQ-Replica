package com.frozenorb.basic.tasks;

import com.frozenorb.basic.BasicPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.List;

public class AnnouncerRunnable extends BukkitRunnable {

    private static final List<String> messages = Arrays.asList(
            "&6Be sure to follow us on Twitter for giveaways and more: \n&dTwitter.com/MineHQ"
    );

    private static int index = 0;

    public AnnouncerRunnable() {
        this.runTaskTimerAsynchronously(BasicPlugin.getProvidingPlugin(BasicPlugin.class), 0, 20*60);
    }

    @Override
    public void run() {

    }
}
