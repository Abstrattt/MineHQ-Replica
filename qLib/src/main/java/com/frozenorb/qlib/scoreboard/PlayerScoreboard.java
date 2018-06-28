package com.frozenorb.qlib.scoreboard;

import com.frozenorb.commonlibs.utils.MathsUtility;
import com.frozenorb.commonlibs.utils.MessageUtility;
import com.frozenorb.qlib.misc.FakePlayer;
import com.frozenorb.qlib.misc.SimpleEntry;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.*;

@Getter
public class PlayerScoreboard {

    /* Max Entries Constant */
    private final static int MAX_ENTRIES = 15;

    /* Objective Name Constant */
    private final static String OBJECTIVE_NAME = "SB";

    /* Cached Entries */
    private Map<Integer, FakePlayer> cache = new HashMap<>();
    /* Player */
    private Player player;
    /* Objective */
    private Objective objective;
    /* Scoreboard */
    private Scoreboard scoreboard;

    /* Scoreboard Handler */
    private ScoreboardHandler handler;

    /**
     * Player Scoreboard Class
     */
    public PlayerScoreboard(ScoreboardHandler handler, Player player) {
        this.handler = handler;
        /* Define Player Object */
        this.player = player;
        /* Setup Scoreboard Module for player */
        setupModule();
        /* Update Lines initially */
        updateLines();
    }

    /**
     * Setup up all of the items for the scoreboard.
     */
    private void setupModule(){
        /* Create Scoreboard Variable */
        scoreboard = player.getScoreboard();
        /* Create or get Objective */
        objective = scoreboard.getObjective(OBJECTIVE_NAME) == null
                ? scoreboard.registerNewObjective(OBJECTIVE_NAME, "dummy")
                : scoreboard.getObjective(OBJECTIVE_NAME);
        /* Set the display slot */
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        /* Set the display name to nothing */
        objective.setDisplayName("");
    }

    /**
     * Updates all of the Lines
     */
    public void updateLines() {
        /* See if the board is active */
        if (!isActive()) return;
        /* Get all the buffered entries */
        List<BufferedScoreObject> scoreObjects = processToBuffer();
        /* Reset the Entries if the size is different */
        if (scoreObjects.size() != scoreboard.getEntries().size()) {
            scoreboard.getEntries().forEach(score -> scoreboard.resetScores(score));
        }
        /* Loop through each of the Score Objects */
        scoreObjects.forEach(scoreObject -> {
            /* Apply the prefix and suffix */
            FakePlayer localFakePlayer = applyFakePlayer(scoreObject);
            /* Get the team and reset the line number in the case that the order may have changed */
            objective.getScore(localFakePlayer).setScore(scoreObject.getCurrentline());
        });
    }

    /**
     * Apply Fake Player
     */
    private FakePlayer applyFakePlayer(BufferedScoreObject scoreObject){
        /* Setup Team */
        Team team = scoreboard.getTeam("SB-" + scoreObject.getCurrentline());
        if (team == null){
            team = scoreboard.registerNewTeam("SB-" + scoreObject.getCurrentline());
        }
        /* Setup FakePlayer */
        FakePlayer fakePlayer = getFakePlayer(team);
        if (fakePlayer == null){
            fakePlayer = new FakePlayer(team);
        }
        /* Setup Simple Entry */
        final SimpleEntry simpleEntry = scoreObject.getEntry();
        /* Prefix, Suffix, and Middle */
        team.setPrefix(simpleEntry.getPrefix());
        team.setSuffix(simpleEntry.getSuffix());
        /* Set Player Name */
        fakePlayer.setName(ChatColor.values()[MathsUtility.convertToPositive(scoreObject.getCurrentline())]
                + ChatColor.WHITE.toString()
                + ChatColor.getLastColors(simpleEntry.getPrefix())
                + simpleEntry.getMiddle());
        /* Apply correct team mappings */
        fakePlayer.setTeam(team);
        team.removePlayer(fakePlayer);
        team.addPlayer(fakePlayer);
        /* Add to cache */
        cache.put(scoreObject.getCurrentline(), fakePlayer);
        /* Return FakePlayer object */
        return fakePlayer;
    }

    /**
     * Get Fake Player
     */
    private FakePlayer getFakePlayer(Team team){
        return cache.values().stream().filter(fakePlayer -> fakePlayer.getTeam().equals(team)).findFirst().orElse(null);
    }
    private FakePlayer getFakePlayer(Integer integer){
        return cache.get(integer);
    }

    /**
     * Update Scoreboard Title
     */
    private void updateTitle(String title) {
        if (title != null && !title.equalsIgnoreCase("") && !objective.getDisplayName().equals(title)) {
            objective.setDisplayName(MessageUtility.formatMessage(title));
        }
    }

    /**
     * Process to Buffer
     */
    private List<BufferedScoreObject> processToBuffer() {
        /* Current Line */
        int currentLine = 1;
        /* Create new list */
        List<BufferedScoreObject> bufferedLines = new ArrayList<>();

        IScoreboardAdapter adapter = handler.getAdapter();
        /* Update Scoreboard Title*/
        updateTitle(adapter.getScoreboardTitle(player));
        /* Grab the lines specific to the adapter */
        List<String> lines = adapter.getScoreboardLines(player);
        /* Flip lines if the style permits */
        Collections.reverse(lines);
        /* Loop through each line */
        for (String lineObj : lines) {
            /* Create a Buffered Score Object */
            BufferedScoreObject bufferedScoreObject = getScoreObject(currentLine, lineObj);
            /* Add the object to the list */
            bufferedLines.add(bufferedScoreObject);
            /* Generate the local current line */
            currentLine = bufferedScoreObject.getCurrentline();
            /* Check if the amount of lines that are being looped is greater than the max */
            if (bufferedLines.size() >= MAX_ENTRIES) {
                /* Return all the Buffered Entries*/
                return bufferedLines;
            }
        }
        /* Return all the Buffered Entries */
        return bufferedLines;
    }

    /**
     * Get Buffered Scoreboard Object
     */
    private BufferedScoreObject getScoreObject(Integer currentLine, String text){
        return new BufferedScoreObject(new SimpleEntry(text), getScore(currentLine));
    }

    /**
     * Increment
     */
    private Integer getScore(Integer currentScore){
        return ++currentScore;
    }

    /**
     * Method to check if the Player is still actively on the server
     */
    private boolean isActive() {
        return player != null && player.isOnline() && player.getScoreboard() == scoreboard;
    }

    /**
     * Removes the Scoreboard and unregisters all of the Teams.
     */
    public void remove() {
        /* Reset all the scores */
        scoreboard.getEntries().forEach(scoreboard :: resetScores);
        /* Unregisters the Objective */
        objective.unregister();
        /* Unregisters all of the Teams */
        scoreboard.getTeams().forEach(Team:: unregister);
        /* Remove the Board from the Scaffold Scoreboard Module */
        handler.getBoards().remove(player);
    }
}
