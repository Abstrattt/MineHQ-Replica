package com.frozenorb.qlib.listeners;

import com.frozenorb.qlib.scoreboard.PlayerScoreboard;
import com.frozenorb.qlib.scoreboard.ScoreboardHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListeners implements Listener {

    private ScoreboardHandler scoreboardHandler;

    public ConnectionListeners(ScoreboardHandler scoreboardHandler) {
        this.scoreboardHandler = scoreboardHandler;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

        scoreboardHandler.getBoards().put(player, new PlayerScoreboard(scoreboardHandler, player));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        scoreboardHandler.getBoards().get(player).remove();
    }
}
