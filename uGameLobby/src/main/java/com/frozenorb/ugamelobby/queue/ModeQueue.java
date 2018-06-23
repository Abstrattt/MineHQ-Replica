package com.frozenorb.ugamelobby.queue;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class ModeQueue {

    private List<UUID> queued = new ArrayList<>();
    private String id;
    private int requiredPlayers;

    public ModeQueue(String id) {
        this.id = id;
    }
}
