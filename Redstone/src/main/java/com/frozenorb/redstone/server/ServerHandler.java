package com.frozenorb.redstone.server;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class ServerHandler {

    /* Collection of Servers */
    @Getter private static Set<Server> servers = new HashSet<Server>();

    /**
     * Add server to the Handlers Collection
     */
    public static void addServer(Server server){
        servers.add(server);
    }

    /**
     * Remove server from the Handlers Collection
     */
    public static void removeServer(Server server){
        servers.remove(server);
    }

    /**
     * Get a Server from its Server ID
     */
    public static Server getServer(String serverID){
        for (Server server : servers) {
            if (server.getServerID().equalsIgnoreCase(serverID)) {
                return server;
            }
        }
        return null;
    }

    /**
     * Get a set of of Servers from a ServerGroup
     */
    public static Set<Server> getServersFromGroup(String serverGroup) {
        Set<Server> cachedServers = new HashSet<>();
        for (Server server : servers){
            if (server.getGroup().equalsIgnoreCase(serverGroup)){
                cachedServers.add(server);
            }
        }
        return cachedServers;
    }
}
