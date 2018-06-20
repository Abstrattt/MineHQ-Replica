package com.frozenorb.qmodsuite;

import com.frozenorb.commonlibs.ConfigHelper;
import com.frozenorb.commonlibs.redis.RedisCredentials;
import com.frozenorb.commonlibs.redis.RedisHelper;
import com.frozenorb.qmodsuite.commands.ReportCommand;
import com.frozenorb.qmodsuite.commands.RequestCommand;
import com.frozenorb.qmodsuite.commands.StaffChatCommand;
import com.frozenorb.qmodsuite.commands.StaffModeCommand;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class qModSuitePlugin extends JavaPlugin {

    private static boolean setup = false;
    @Getter private static RedisHelper redisHelper;
    @Getter private static ModSuitePubSub pubSub;
    @Getter private static ConfigHelper config;

    @Override
    public void onEnable() {
        if (!setup){
            config = new ConfigHelper("config", getDataFolder().getAbsolutePath());
            pubSub = new ModSuitePubSub();
            redisHelper = new RedisHelper(new RedisCredentials(config.getConfiguration().getString("Redis.IP"),
                    config.getConfiguration().getString("Redis.Password"),
                    config.getConfiguration().getInt("Redis.Port")));
        }

        /* Subscribe to the Pub Sub Channels */
        pubSub.subscribe(ModSuitePubSub.IDENTIFIER + "SC",
                ModSuitePubSub.IDENTIFIER + "RQ",
                ModSuitePubSub.IDENTIFIER + "RP");
        /* Register Commands and Plugin Listeners */
        registerCommands();
        registerListeners();
        setup = true;
    }

    @Override
    public void onDisable() {
        /* Unsubscribe from the Pub Sub Channels */
        pubSub.unsubscribe();
    }

    /**
     * Register Commands
     */
    private void registerCommands(){
        getCommand("report").setExecutor(new ReportCommand());
        getCommand("request").setExecutor(new RequestCommand());
        getCommand("staffchat").setExecutor(new StaffChatCommand());
        getCommand("staffmode").setExecutor(new StaffModeCommand());
    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
    }
}
