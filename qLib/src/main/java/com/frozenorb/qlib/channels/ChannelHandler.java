package com.frozenorb.qlib.channels;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ChannelHandler {

    @Getter private static List<ChatChannel> channels = new ArrayList<>();

    public static void addChannel(ChatChannel channel) {
        channels.add(channel);
    }

    public static void removeChannel(ChatChannel channel) {
        channels.remove(channel);
    }
}
