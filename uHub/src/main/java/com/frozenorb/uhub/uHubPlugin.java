package com.frozenorb.uhub;

import com.frozenorb.qlib.scoreboard.ScoreboardHandler;
import com.frozenorb.uhub.commands.SpawnCommand;
import com.frozenorb.uhub.configs.ConfigurationHandler;
import com.frozenorb.uhub.listeners.*;
import com.frozenorb.uhub.spawn.SpawnHandler;
import com.frozenorb.uhub.threads.PlayerCountThread;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class uHubPlugin extends JavaPlugin {

    private boolean setup = false;
    private ScoreboardHandler scoreboardHandler;
    private PlayerCountThread playerCountThread;

    @Override
    public void onEnable() {
        if (!setup){
            new ConfigurationHandler();
            scoreboardHandler = new ScoreboardHandler(this, 10, new HubAdapter());
        }
        /* Load the Spawn */
        SpawnHandler.loadSpawnLocation();
        /* Register Commands and Plugin Listeners */
        registerBungeeListeners();
        registerCommands();
        registerListeners();
        setup = true;
    }

    @Override
    public void onDisable() {
    }

    /**
     * Register BungeeCord Channels
     */
    private void registerBungeeListeners(){
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new BungeecordListeners());
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
        pm.registerEvents(new PlayerListeners(), this);
        pm.registerEvents(new ConnectionListeners(), this);
        pm.registerEvents(new ClickListeners(), this);
    }
}
