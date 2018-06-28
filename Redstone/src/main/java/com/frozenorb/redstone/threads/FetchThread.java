package com.frozenorb.redstone.threads;

import com.frozenorb.redstone.RedstonePlugin;
import com.frozenorb.redstone.server.Server;
import com.frozenorb.redstone.server.ServerHandler;
import com.frozenorb.redstone.server.ServerStage;
import com.frozenorb.redstone.server.ServerState;
import redis.clients.jedis.Jedis;
import java.util.Set;

public class FetchThread extends Thread {

    public FetchThread() {
        setName("Redstone-Fetch");
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

    private void ping(){
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
                /* Stage */
                server.setStage(ServerStage.getFromOrdinal(Integer.valueOf(jedis.hget("Redstone-Server:" + serverName, "Stage"))));
            }
        }
    }
}
