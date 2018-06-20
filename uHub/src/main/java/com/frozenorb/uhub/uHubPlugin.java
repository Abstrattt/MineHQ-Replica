package com.frozenorb.uhub;

import com.frozenorb.uhub.commands.SpawnCommand;
import com.frozenorb.uhub.configs.ConfigurationHandler;
import com.frozenorb.uhub.listeners.*;
import com.frozenorb.uhub.spawn.SpawnHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class uHubPlugin extends JavaPlugin {

    private boolean setup = false;

    @Override
    public void onEnable() {
        if (!setup){
            new ConfigurationHandler();
        }
        /* Load the Spawn */
        SpawnHandler.loadSpawnLocation();
        /* Register Commands and Plugin Listeners */
        registerCommands();
        registerListeners();
    }

    @Override
    public void onDisable() {

    }

    /**
     * Register Commands
     */
    private void registerCommands() {
        getCommand("spawn").setExecutor(new SpawnCommand());
    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new DoubleJumpListeners(), this);
        pm.registerEvents(new EnderbuttListeners(), this);
        pm.registerEvents(new PlayerListeners(), this);
        pm.registerEvents(new ConnectionListeners(), this);
        pm.registerEvents(new ClickListeners(), this);
    }
}
