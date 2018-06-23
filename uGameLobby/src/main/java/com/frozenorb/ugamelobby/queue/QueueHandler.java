package com.frozenorb.ugamelobby.queue;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QueueHandler {

    @Getter private static List<ModeQueue> queues = new ArrayList<>();
    @Getter private static boolean singularQueue = false;

    /**
     * Add a Queue
     */
    public static void addQueue(ModeQueue queue) {
        queues.add(queue);
    }

    /**
     * Remove a Queue
     */
    public static void removeQueue(ModeQueue queue) {
        queues.remove(queue);
    }

    /**
     * Check if a player is queued
     */
    public static boolean isPlayerQueued(Player player) {
        return isPlayerQueued(player.getUniqueId());
    }
    private static boolean isPlayerQueued(UUID uuid) {
        for (ModeQueue queue : queues) {
            if (queue.getQueued().contains(uuid)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get Queue from Player object
     */
    public static ModeQueue getQueue(Player player) {
        return getQueue(player.getUniqueId());
    }
    private static ModeQueue getQueue(UUID uuid) {
        for (ModeQueue queue : queues) {
            if (queue.getQueued().contains(uuid)) {
                return queue;
            }
        }
        return null;
    }

    /**
     * Get Queue from Queue ID
     */
    public static ModeQueue getQueue(String queueID) {
        for (ModeQueue queue : queues) {
            if (queue.getId().equalsIgnoreCase(queueID)) {
                return queue;
            }
        }
        return null;
    }

}
