package com.frozenorb.uhub.threads;

import lombok.Setter;
import org.bukkit.Bukkit;
import com.frozenorb.uhub.uHubPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.concurrent.TimeUnit;

public class PlayerCountThread extends Thread {

    @Setter public static int PLAYER_COUNT = 1;

    public PlayerCountThread(){
        setName("uHub-PlayerCount");
    }

    @Override
    public void run() {
        while(true) {
            pingBungee();
            try {
                sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void pingBungee() {
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);
            out.writeUTF("PlayerCount");
            out.writeUTF("ALL");
            Bukkit.getServer().sendPluginMessage(uHubPlugin.getProvidingPlugin(uHubPlugin.class), "BungeeCord", b.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
