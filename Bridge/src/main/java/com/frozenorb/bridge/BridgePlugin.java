package com.frozenorb.bridge;

import com.frozenorb.bridge.commands.ListCommand;
import com.frozenorb.bridge.commands.RegisterCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BridgePlugin extends JavaPlugin {

    private boolean setup = false;

    @Override
    public void onEnable() {
        if (!setup){
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
        getCommand("list").setExecutor(new ListCommand());
        getCommand("register").setExecutor(new RegisterCommand());
    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
    }
}
