package com.frozenorb.qlib.scoreboard;

import java.util.concurrent.TimeUnit;

public class ScoreboardThread extends Thread {

    private ScoreboardHandler handler;
    private long interval;

    ScoreboardThread(ScoreboardHandler handler, int interval) {
        setName("qLib-Scoreboard");
        this.handler = handler;
        this.interval = 1000;
    }

    @Override
    public void run() {
        while (true) {
            handler.getBoards().keySet().forEach(localPlayer -> {
                /* Get the scoreboard object */
                PlayerScoreboard scoreboard = handler.getBoards().get(localPlayer);
                /* Update the Scoreboard */
                scoreboard.updateLines();
            });
            try {
                sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
