package com.frozenorb.basic;

import com.frozenorb.basic.commands.DonateCommand;
import com.frozenorb.basic.commands.MessageCommand;
import com.frozenorb.basic.commands.PingCommand;
import com.frozenorb.basic.listeners.PlayerListeners;
import com.frozenorb.basic.profile.ProfileHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicPlugin extends JavaPlugin {

    private boolean setup = false;
    private ProfileHandler profileHandler;

    @Override
    public void onEnable() {
        if (!setup){
            profileHandler = new ProfileHandler();
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
        getCommand("donate").setExecutor(new DonateCommand());
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("message").setExecutor(new MessageCommand());
    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerListeners(), this);
    }
}
