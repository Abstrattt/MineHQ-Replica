package com.frozenorb.uhub;

import com.frozenorb.qlib.scoreboard.IScoreboardAdapter;
import com.frozenorb.uhub.threads.PlayerCountThread;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HubAdapter implements IScoreboardAdapter {

    @Override
    public String getScoreboardTitle(Player player) {
        return "&6&lMineHQ Network";
    }

    @Override
    public List<String> getScoreboardLines(Player player) {
        List<String> lines = new ArrayList<>();
        lines.add("&7&m--------------------");
        lines.add("&6Online:");
        lines.add("&f" + PlayerCountThread.PLAYER_COUNT);
        lines.add("");
        lines.add("&6Rank:");
        lines.add("&fDefault");
        lines.add("");
        lines.add("&6www.minehq.com &7&o(Replica)");
        lines.add("&7&m--------------------");
        return lines;
    }
}
