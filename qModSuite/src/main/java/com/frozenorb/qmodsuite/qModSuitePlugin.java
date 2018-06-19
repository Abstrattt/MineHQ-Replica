package com.frozenorb.qmodsuite;

import com.frozenorb.commonlibs.redis.RedisHelper;
import com.frozenorb.qmodsuite.commands.ReportCommand;
import com.frozenorb.qmodsuite.commands.RequestCommand;
import com.frozenorb.qmodsuite.commands.StaffChatCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class qModSuitePlugin extends JavaPlugin {

    private boolean setup = false;
    private RedisHelper redisHelper;

    @Override
    public void onEnable() {
        if (!setup){
            //
            redisHelper = new RedisHelper(null);
            //redisHelper.getPool().getResource().subscribe(new dsa(),  );
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
