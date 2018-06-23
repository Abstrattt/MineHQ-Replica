package com.frozenorb.ugamelobby;

import com.frozenorb.qlib.scoreboard.IScoreboardAdapter;
import com.frozenorb.redstone.RedstonePlugin;
import com.frozenorb.redstone.server.Server;
import com.frozenorb.redstone.server.ServerHandler;
import com.frozenorb.ugamelobby.queue.ModeQueue;
import com.frozenorb.ugamelobby.queue.QueueHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameLobbyAdapter implements IScoreboardAdapter {

    @Override
    public String getScoreboardTitle(Player player) {
        return "&6&lMineHQ &7| &f" + uGameLobbyPlugin.GAMEMODE;
    }

    @Override
    public List<String> getScoreboardLines(Player player) {
        List<String> lines = new ArrayList<>();
        lines.add("&7&m---------------------");
        lines.add("&6In Lobby: &f" + Bukkit.getOnlinePlayers().size());
        int inGame = 0;
        for (Server server : ServerHandler.getServersFromGroup(uGameLobbyPlugin.GAMEMODE)){
            inGame += server.getData().getOnlinePlayers();
        }
        lines.add("&6In Game: &f" + inGame);
        if (QueueHandler.isSingularQueue()){
            ModeQueue queue = QueueHandler.getQueues().get(0);
            lines.add("&6In Queue: &f" + queue.getQueued().size());
        } else {
            for (ModeQueue queue : QueueHandler.getQueues()){
                lines.add("&6" + queue.getId() + " Queue: &f" + queue.getQueued().size());
            }
        }

        if (QueueHandler.isPlayerQueued(player)){
            lines.add("");
            lines.add("&a&l&oQueued for game...");
        }
        lines.add("&7&m---------------------");
        return lines;
    }
}
