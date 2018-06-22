package com.frozenorb.redstone.threads;

import com.frozenorb.commonlibs.utils.TPSUtility;
import com.frozenorb.redstone.RedstonePlugin;
import com.frozenorb.redstone.RedstonePluginSettings;
import com.frozenorb.redstone.server.ServerState;
import org.bukkit.Bukkit;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PayloadThread extends Thread {

    @Override
    public void run() {
        try(Jedis jedis = RedstonePlugin.getRedisHelper().getPool().getResource()){
            /* Get the data from the current server and display it in a hash map */
            Map<String, String> data = new HashMap<>();
            data.put("OnlinePlayers", Bukkit.getOnlinePlayers().size() + "");
            data.put("MaxPlayers", Bukkit.getMaxPlayers() + "");
            data.put("State", ServerState.getCurrent().getOrdinal() + "");
            data.put("Group", RedstonePluginSettings.SERVER_GROUP);
            data.put("TPS", TPSUtility.getRecentTps()[0] + "");

            /* Put that data into the database */
            jedis.hmset("Redstone-Server:" + RedstonePluginSettings.SERVER_NAME, data);
            RedstonePlugin.getRedisHelper().getPool().returnResource(jedis);
            jedis.close();
        }
        try {
            sleep(TimeUnit.MILLISECONDS.toSeconds(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
