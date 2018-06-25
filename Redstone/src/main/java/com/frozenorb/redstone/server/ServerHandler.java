package com.frozenorb.redstone.server;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServerHandler {

    /* Collection of Servers */
    @Getter static List<Server> servers = new ArrayList<>();

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
    public static List<Server> getServersFromGroup(String serverGroup) {
        List<Server> cachedServers = new ArrayList<>();
        for (Server server : servers) {
            if (server.getGroup().equalsIgnoreCase(serverGroup)){
                cachedServers.add(server);
            }
        }
        return cachedServers;
    }

    /**
     * Get a list of the Server Groups
     */
    public static List<String> getServerGroups() {
        List<String> cachedGroups = new ArrayList<>();
        for (Server server : servers) {
            if (!cachedGroups.contains(server.getGroup())) {
                cachedGroups.add(server.getGroup());
            }
        }
        return cachedGroups;
    }

}
