package com.frozenorb.redstone.threads;

import com.frozenorb.commonlibs.utils.TPSUtility;
import com.frozenorb.redstone.RedstonePlugin;
import com.frozenorb.redstone.RedstonePluginSettings;
import com.frozenorb.redstone.server.ServerStage;
import com.frozenorb.redstone.server.ServerState;
import org.bukkit.Bukkit;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PayloadThread extends Thread {

    public PayloadThread() {
        setName("Redstone-Payload");
    }

    @Override
    public void run() {
        while (true) {
            ping();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * TODO going to make this more effcient by putting shit like Max Players, State, Group, Server Status
     */
    private void ping() {
        try(Jedis jedis = RedstonePlugin.getRedisHelper().getPool().getResource()){
            /* Get the data from the current server and display it in a hash map */
            Map<String, String> data = new HashMap<>();
            data.put("OnlinePlayers", Bukkit.getOnlinePlayers().size() + "");
            data.put("MaxPlayers", Bukkit.getMaxPlayers() + "");
            data.put("State", ServerState.getCurrent().getOrdinal() + "");
            data.put("Group", RedstonePluginSettings.SERVER_GROUP);
            data.put("Stage", ServerStage.getFromString(RedstonePluginSettings.SERVER_STAGE).getOrdinal() + "");
            data.put("TPS", TPSUtility.getRecentTps()[0] + "");

            /* Put that data into the database */
            jedis.hmset("Redstone-Server:" + RedstonePluginSettings.SERVER_NAME, data);
        }
    }
}
