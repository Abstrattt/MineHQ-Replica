package com.frozenorb.qmodsuite;

import com.frozenorb.commonlibs.redis.RedisHelper;
import com.frozenorb.qmodsuite.commands.ReportCommand;
import com.frozenorb.qmodsuite.commands.RequestCommand;
import com.frozenorb.qmodsuite.commands.StaffChatCommand;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class qModSuitePlugin extends JavaPlugin {

    private static boolean setup = false;
    @Getter private static RedisHelper redisHelper;
    @Getter private static ModSuitePubSub pubSub;

    @Override
    public void onEnable() {
        if (!setup){
            //
            pubSub = new ModSuitePubSub();
            redisHelper = new RedisHelper(null);
            //redisHelper.getPool().getResource().subscribe(new dsa(),  );
        }
        /* Subscribe to the Pub Sub Channels */
        redisHelper.getPool().getResource().subscribe(pubSub, "qModSuite-SC", "qModSuite-RQ", "qModSuite-RP");
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
    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();

    }
}
