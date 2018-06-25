package com.frozenorb.ugamelobby;

import com.frozenorb.qlib.scoreboard.ScoreboardHandler;
import com.frozenorb.ugamelobby.commands.ModeQueuesCommand;
import com.frozenorb.ugamelobby.commands.SpectateCommand;
import com.frozenorb.ugamelobby.listeners.ConnectionListeners;
import com.frozenorb.ugamelobby.queue.QueueModeThread;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class uGameLobbyPlugin extends JavaPlugin {

    private static boolean setup = false;
    public static String GAMEMODE;
    public QueueModeThread queueThread;

    @Override
    public void onEnable() {
        if (!setup){
            new ScoreboardHandler(this, 10, new GameLobbyAdapter());
            queueThread = new QueueModeThread();
        }
        queueThread.start();
        registerCommands();
        registerListeners();
        setup = true;
    }

    @Override
    public void onDisable() {
        queueThread.stop();
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
