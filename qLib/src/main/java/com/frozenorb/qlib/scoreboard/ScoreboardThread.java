package com.frozenorb.qlib.scoreboard;

import java.util.concurrent.TimeUnit;

public class ScoreboardThread extends Thread {

    private ScoreboardHandler handler;
    private int interval;

    public ScoreboardThread(ScoreboardHandler handler, int interval) {
        this.handler = handler;
        this.interval = interval;
    }

    @Override
    public void run() {
        handler.getBoards().keySet().forEach(localPlayer -> {
            /* Get the scoreboard object */
            PlayerScoreboard scoreboard = handler.getBoards().get(localPlayer);
            /* Update the Scoreboard */
            scoreboard.updateLines();
        });
        try {
            sleep(TimeUnit.MILLISECONDS.toSeconds(interval));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
