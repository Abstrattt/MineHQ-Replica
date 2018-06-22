package com.frozenorb.redstone.threads;

import com.frozenorb.commonlibs.utils.TPSUtility;
import com.frozenorb.redstone.RedstonePlugin;
import com.frozenorb.redstone.RedstonePluginSettings;
import com.frozenorb.redstone.server.Server;
import com.frozenorb.redstone.server.ServerHandler;
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

    }

    @Override
    public void run() {
        try(Jedis jedis = RedstonePlugin.getRedisHelper().getPool().getResource()){
            Pipeline pipeline = jedis.pipelined();
            final Set<String> servers = pipeline.keys("Redstone-Server:*").get();
            for (String loopServer : servers){
                String serverName = loopServer.replaceAll("Redstone-Server:", "");
                /* Get or Create new Server */
                Server server = ServerHandler.getServer(serverName);
                if (server == null){
                    server = new Server(serverName);
                }
                /* Server Group */
                server.setGroup(pipeline.hget("Redstone-Server:" + serverName, "Group").get());
                /* Server State */
                server.getData().setState(ServerState.getFromOrdinal(Integer.valueOf(pipeline.hget("Redstone-Server:" + serverName, "State").get())));
                /* TPS */
                server.getData().setTps(Double.valueOf(pipeline.hget("Redstone-Server:" + serverName, "TPS").get()));
                /* Online Players */
                server.getData().setOnlinePlayers(Integer.valueOf(pipeline.hget("Redstone-Server:" + serverName, "OnlinePlayers").get()));
                /* Max Players */
                server.getData().setMaxPlayers(Integer.valueOf(pipeline.hget("Redstone-Server:" + serverName, "MaxPlayers").get()));
            }
            RedstonePlugin.getRedisHelper().getPool().returnResource(jedis);
            jedis.close();
        } try {
            sleep(TimeUnit.MILLISECONDS.toSeconds(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
