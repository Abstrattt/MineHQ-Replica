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
        setName("Redstone-Fetch");
    }

    @Override
    public void run() {
        try(Jedis jedis = RedstonePlugin.getRedisHelper().getPool().getResource()){
            final Set<String> servers = jedis.keys("Redstone-Server:*");
            for (String loopServer : servers){
                String serverName = loopServer.replaceAll("Redstone-Server:", "");
                /* Get or Create new Server */
                Server server = ServerHandler.getServer(serverName);
                if (server == null){
                    server = new Server(serverName);
                    ServerHandler.addServer(server);
                }
                /* Server Group */
                server.setGroup(jedis.hget("Redstone-Server:" + serverName, "Group"));
                /* Server State */
                server.getData().setState(ServerState.getFromOrdinal(Integer.valueOf(jedis.hget("Redstone-Server:" + serverName, "State"))));
                /* TPS */
                server.getData().setTps(Double.valueOf(jedis.hget("Redstone-Server:" + serverName, "TPS")));
                /* Online Players */
                server.getData().setOnlinePlayers(Integer.valueOf(jedis.hget("Redstone-Server:" + serverName, "OnlinePlayers")));
                /* Max Players */
                server.getData().setMaxPlayers(Integer.valueOf(jedis.hget("Redstone-Server:" + serverName, "MaxPlayers")));
            }
        } try {
            sleep(TimeUnit.MILLISECONDS.toSeconds(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
