package com.frozenorb.qlib.scoreboard;

import org.bukkit.entity.Player;

import java.util.List;

public interface IScoreboardAdapter {

    /**
     * Get Title based on the player
     *
     * @param player - The player that the title will be displayed for.
     * @return String - Returns the title
     */
    String getScoreboardTitle(Player player);

    /**
     * Get Lines based on the player
     *
     * @param player - The player that the lines will be displayed for.
     * @return List<String> - Returns a list of all the lines that will be displayed for a specific player.
     */
    List<String> getScoreboardLines(Player player);

}
