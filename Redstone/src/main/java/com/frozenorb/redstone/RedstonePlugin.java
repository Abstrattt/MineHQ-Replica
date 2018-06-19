package com.frozenorb.redstone;

import com.frozenorb.redstone.server.ServerHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RedstonePlugin extends JavaPlugin {

    private boolean setup = false;
    private static ServerHandler serverHandler;
    private static RedstoneConfig config;
    private static RedstonePluginSettings pluginSettings;

    @Override
    public void onEnable() {
        if (!setup){
            pluginSettings = new RedstonePluginSettings();
            serverHandler = new ServerHandler();
            config = new RedstoneConfig("config", this.getDataFolder().getAbsolutePath());
        }
        loadPluginSettings();
        registerCommands();
        registerListeners();
        setup = true;
    }

    @Override
    public void onDisable() {

    }

    /**
     * Load the Plugin settings from the Redstone Plugin settings.yml
     */
    public void loadPluginSettings(){
        RedstonePluginSettings.SERVER_NAME = config.getConfiguration().getString("Server-Name");
        RedstonePluginSettings.SERVER_GROUP = config.getConfiguration().getString("Server-Group");
        //Add loggers
    }

    /**
     * Register Commands
     */
    private void registerCommands(){

    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();

    }
}
