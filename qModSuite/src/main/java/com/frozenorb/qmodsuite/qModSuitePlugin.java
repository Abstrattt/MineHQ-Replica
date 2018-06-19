package com.frozenorb.qmodsuite;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class qModSuitePlugin extends JavaPlugin {

    private boolean setup = false;

    @Override
    public void onEnable() {
        if (!setup){
            //
        }
        registerCommands();
        registerListeners();
        setup = true;
    }

    @Override
    public void onDisable() {

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
