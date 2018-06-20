package com.frozenorb.qlib.scoreboard;

import com.frozenorb.qlib.listeners.ConnectionListeners;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ScoreboardHandler {

    /* Player Scoreboards */
    private Map<Player, PlayerScoreboard> boards = new HashMap<>();
    /* Scoreboard Tick Thread */
    private ScoreboardThread thread;
    /* Plugin Instance */
    private JavaPlugin plugin;

    /**
     * Scoreboard Handler Class
     */
    ScoreboardHandler(JavaPlugin plugin, int interval){
        /* Plugin Instance */
        this.plugin = plugin;
        /* Register Listeners */
        this.plugin.getServer().getPluginManager().registerEvents(new ConnectionListeners(), this.plugin);
        /* Give everyone a scoreboard */
        this.applyScoreboards();
        /* Start the Scoreboard Thread */
        this.thread = new ScoreboardThread(this, interval);
    }

    /**
     * Applies a Scoreboard to all the Online Players
     */
    private void applyScoreboards(){
        Bukkit.getOnlinePlayers().forEach(player -> {
            boards.putIfAbsent(player, new PlayerScoreboard(player));
        });
    }
}
