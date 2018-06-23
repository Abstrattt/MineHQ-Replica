package com.frozenorb.redstone;

import com.frozenorb.commonlibs.ConfigHelper;
import org.bukkit.plugin.java.JavaPlugin;

class RedstoneConfig extends ConfigHelper {

    RedstoneConfig(JavaPlugin plugin, String name, String directory) {
        super(plugin, name, directory);
    }
}
