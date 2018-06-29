package com.frozenorb.hqueuebukkit.queue;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class QueueHandler {

    /** Collection of Queues **/
    @Getter private static Set<Queue> queues = new HashSet<>();

    /**
     * Add a Queue to the Collection
     */
    public static void addQueue(Queue queue) {
        queues.add(queue);
    }

    /**
     * Remove a Queue from the Collection
     */
    public static void removeQueue(Queue queue) {
        queues.add(queue);
    }


}
