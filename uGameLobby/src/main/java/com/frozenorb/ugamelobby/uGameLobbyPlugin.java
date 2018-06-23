package com.frozenorb.ugamelobby;

import com.frozenorb.ugamelobby.commands.ModeQueuesCommand;
import com.frozenorb.ugamelobby.commands.SpectateCommand;
import com.frozenorb.ugamelobby.listeners.ConnectionListeners;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class uGameLobbyPlugin extends JavaPlugin {

    private static boolean setup = false;
    public static String GAMEMODE;

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
    private void registerCommands() {
        getCommand("spectate").setExecutor(new SpectateCommand());
        getCommand("modequeues").setExecutor(new ModeQueuesCommand());
    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ConnectionListeners(), this);
    }
}
