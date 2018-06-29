package com.frozenorb.qlib.channels;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ChannelHandler {

    /** Collection of Channels **/
    @Getter private static List<ChatChannel> channels = new ArrayList<>();

    /**
     * Add a Channel to the collection
     */
    public static void addChannel(ChatChannel channel) {
        channels.add(channel);
    }

    /**
     * Remove a Channel from the collection
     */
    public static void removeChannel(ChatChannel channel) {
        channels.remove(channel);
    }
}
