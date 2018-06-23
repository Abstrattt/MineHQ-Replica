package com.frozenorb.uhub.listeners;

import com.frozenorb.uhub.threads.PlayerCountThread;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class BungeecordListeners implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(String s, Player player, byte[] bytes) {
        if (!s.equals("BungeeCord")) return;
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(bytes));
            String command = in.readUTF();
            if (command.equals("PlayerCount")) {
                PlayerCountThread.PLAYER_COUNT = in.readInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
