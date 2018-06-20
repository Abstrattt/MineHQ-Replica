package com.frozenorb.redstone;

import com.frozenorb.commonlibs.redis.RedisCredentials;
import com.frozenorb.commonlibs.redis.RedisHelper;
import com.frozenorb.redstone.server.ServerHandler;
import com.frozenorb.redstone.threads.FetchThread;
import com.frozenorb.redstone.threads.PayloadThread;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class RedstonePlugin extends JavaPlugin {

    private boolean setup = false;
    private ServerHandler serverHandler;
    @Getter private static RedisHelper redisHelper;
    private RedstoneConfig config;
    private RedstonePluginSettings pluginSettings;
    private Set<Thread> threads = new HashSet<Thread>();

    @Override
    public void onEnable() {
        if (!setup){
            /* Setup Redstone Configuration File */
            config = new RedstoneConfig("config", this.getDataFolder().getAbsolutePath());
            /* Redis Helper */
            redisHelper = new RedisHelper(new RedisCredentials(null, null, 1));
            /* Start Redstone Plugin Settings */
            pluginSettings = new RedstonePluginSettings();
            /* Start Server Handler */
            serverHandler = new ServerHandler();
            /* Add threads */
            threads.add(new FetchThread());
            threads.add(new PayloadThread());
        }
        startThreads();
        loadPluginSettings();
        registerCommands();
        registerListeners();
        setup = true;
    }

    @Override
    public void onDisable() {
        stopThreads();
    }

    public void startThreads(){
        for (Thread thread : threads){
            thread.start();
        }
    }

    public void stopThreads(){
        for (Thread thread : threads){
            thread.stop();
        }
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
