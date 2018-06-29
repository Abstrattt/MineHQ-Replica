package com.frozenorb.qlib.listeners;

import com.frozenorb.qlib.channels.ChannelHandler;
import com.frozenorb.qlib.channels.ChatChannel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        for (ChatChannel chatChannel : ChannelHandler.getChannels()) {
            if (message.startsWith(chatChannel.getPrefix())){

            }
        }
    }
}
