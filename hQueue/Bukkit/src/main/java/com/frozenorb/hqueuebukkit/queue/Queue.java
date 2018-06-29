package com.frozenorb.hqueuebukkit.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Queue {

    private List<UUID> queuedPlayers = new ArrayList<>();
    private boolean paused;

    public Queue() {

    }
}
