package com.frozenorb.meetup.backend.adapter.type;

import com.frozenorb.qlib.scoreboard.IScoreboardAdapter;
import org.bukkit.entity.Player;

import java.util.List;

public class WaitingAdapter implements IScoreboardAdapter {

    @Override
    public String getScoreboardTitle(Player player) {
        return null;
    }

    @Override
    public List<String> getScoreboardLines(Player player) {
        return null;
    }
}
