package com.frozenorb.redstone.threads;

import com.frozenorb.commonlibs.utils.TPSUtility;
import com.frozenorb.redstone.RedstonePlugin;
import com.frozenorb.redstone.RedstonePluginSettings;
import com.frozenorb.redstone.server.ServerState;
import org.bukkit.Bukkit;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FetchThread extends Thread {

    public FetchThread() {
        /*Jedis jedis = null;
        try {
            jedis = plugin.getJedisManager().getPool().getResource();
            Pipeline p = jedis.pipelined();
            final Set<String> servers = jedis.keys("AMC-Server:*");
            for (String server : servers) {
                String serverName = server.replaceAll("AMC-Server:", "");
                Server serverObject;
                if (ServerManager.getServerByID(serverName) == null) serverObject = new Server(serverName);
                else serverObject = ServerManager.getServerByID(serverName);
                try {
                    serverObject.setOnlinePlayers(Integer.valueOf(jedis.hget("AMC-Server:" + serverObject.getServerID(), "onlinePlayers")));
                    serverObject.setMaxPlayers(Integer.valueOf(jedis.hget("AMC-Server:" + serverObject.getServerID(), "maxPlayers")));
                    if (jedis.hget("AMC-Server:" + serverObject.getServerID(), "TPS") != null) {
                        serverObject.setServerTPS(Double.valueOf(jedis.hget("AMC-Server:" + serverObject.getServerID(), "TPS")));
                    }
                    serverObject.setServerState(ServerState.getStateFromID(Integer.valueOf(jedis.hget("AMC-Server:" +serverObject.getServerID(), "serverState"))));
                } catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
            p.sync();
            plugin.getJedisManager().getPool().returnResource(jedis);*/
        try(Jedis jedis = RedstonePlugin.getRedisHelper().getPool().getResource()){
            Pipeline pipeline = jedis.pipelined();
            final Set<String> servers = pipeline.keys("Redstone-Server:*").get();

            for (String server : servers){
                String serverName = server.replaceAll("Redstone-Server:", "");
            }

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
