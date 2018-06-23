package com.frozenorb.uhub.threads;

import org.bukkit.Bukkit;
import com.frozenorb.uhub.uHubPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.concurrent.TimeUnit;

public class PlayerCountThread extends Thread {

    public static int PLAYER_COUNT = 0;

    public PlayerCountThread(){
        setName("uHub-PlayerCount");
    }

    @Override
    public void run() {
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);
            out.writeUTF("PlayerCount");
            out.writeUTF("ALL");
            Bukkit.getServer().sendPluginMessage(uHubPlugin.getProvidingPlugin(uHubPlugin.class), "BungeeCord", b.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            sleep(TimeUnit.MILLISECONDS.toSeconds(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}