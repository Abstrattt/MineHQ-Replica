package com.frozenorb.redstone.server;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class ServerHandler {

    /** Collection of Servers **/
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
}
