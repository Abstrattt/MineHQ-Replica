package com.frozenorb.redstone;

import com.frozenorb.commonlibs.redis.RedisCredentials;
import com.frozenorb.commonlibs.redis.RedisHelper;
import com.frozenorb.commonlibs.utils.TPSUtility;
import com.frozenorb.redstone.commands.EnviromentCommand;
import com.frozenorb.redstone.commands.ServerCommand;
import com.frozenorb.redstone.server.ServerHandler;
import com.frozenorb.redstone.server.ServerState;
import com.frozenorb.redstone.threads.FetchThread;
import com.frozenorb.redstone.threads.PayloadThread;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedstonePlugin extends JavaPlugin {

    private static boolean setup = false;
    private ServerHandler serverHandler;
    @Getter private static RedisHelper redisHelper;
    private RedstoneConfig config;
    private RedstonePluginSettings pluginSettings;
    private Set<Thread> threads = new HashSet<>();

    @Override
    public void onEnable() {
        if (!setup){
            /* Setup Redstone Configuration File */
            config = new RedstoneConfig(this,"config", this.getDataFolder().getAbsolutePath());
            /* Configuration */
            Configuration c = config.getConfiguration();
            /* Redis Helper */
            redisHelper = new RedisHelper(new RedisCredentials(c.getString("Redis.IP"), c.getString("Redis.Password"), c.getInt("Redis.Port")));
            /* Start Redstone Plugin Settings */
            pluginSettings = new RedstonePluginSettings();
            /* Start Server Handler */
            serverHandler = new ServerHandler();
            /* Add threads */
            threads.add(new FetchThread());
            threads.add(new PayloadThread());
        }
        loadPluginSettings();
        startThreads();
        registerCommands();
        registerListeners();
        setup = true;
    }

    @Override
    public void onDisable() {
        stopThreads();

        try(Jedis jedis = RedstonePlugin.getRedisHelper().getPool().getResource()){
            /* Get the data from the current server and display it in a hash map */
            Map<String, String> data = new HashMap<>();
            data.put("OnlinePlayers", 0 + "");
            data.put("MaxPlayers", 0 + "");
            data.put("State", ServerState.OFFLINE.getOrdinal() + "");
            data.put("Group", RedstonePluginSettings.SERVER_GROUP);
            data.put("TPS", 0 + "");

            /* Put that data into the database */
            jedis.hmset("Redstone-Server:" + RedstonePluginSettings.SERVER_NAME, data);
        }
    }

    /**
     * Start Threads
     */
    private void startThreads(){
        for (Thread thread : threads){
            thread.start();
        }
    }

    /**
     * Stop Threads
     */
    private void stopThreads(){
        for (Thread thread : threads){
            thread.stop();
        }
    }

    /**
     * Load the Plugin settings from the Redstone Plugin settings.yml
     */
    private void loadPluginSettings(){
        RedstonePluginSettings.SERVER_NAME = config.getConfiguration().getString("Server-Name");
        RedstonePluginSettings.SERVER_GROUP = config.getConfiguration().getString("Server-Group");
        RedstonePluginSettings.SERVER_STAGE = config.getConfiguration().getString("Server-Stage");
    }

    /**
     * Register Commands
     */
    private void registerCommands() {
        getCommand("rsenviroment").setExecutor(new EnviromentCommand());
        getCommand("rsservers").setExecutor(new ServerCommand());
    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
    }
}
