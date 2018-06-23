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

}
