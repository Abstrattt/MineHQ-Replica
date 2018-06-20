package com.frozenorb.qlib.scoreboard;

import com.frozenorb.qlib.misc.SimpleEntry;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class BufferedScoreObject {

    /* SimpleEntry */
    private SimpleEntry entry;

    /* Current Line Tracker */
    private int currentline;
}
