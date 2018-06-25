package com.frozenorb.meetup.backend.adapter;

import com.frozenorb.meetup.backend.game.GameState;
import com.frozenorb.qlib.scoreboard.IScoreboardAdapter;
import com.frozenorb.qlib.tablist.ITablistAdapter;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetupAdapterResolver implements IScoreboardAdapter {

    private static Map<GameState, Map.Entry<IScoreboardAdapter, ITablistAdapter>> adapters = new HashMap<>();

    public MeetupAdapterResolver() {

    }

    @Override
    public String getScoreboardTitle(Player player) {
        return null;
    }

    @Override
    public List<String> getScoreboardLines(Player player) {
        return null;
    }
}
