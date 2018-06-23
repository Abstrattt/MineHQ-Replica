package com.frozenorb.ugamelobby.queue;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class ModeQueue {

    private List<UUID> queued = new ArrayList<>();
    private String id;

    public ModeQueue(String id) {
        this.id = id;
    }
}
