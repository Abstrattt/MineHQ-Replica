package com.frozenorb.redstone.server;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter @Setter
public class ServerData {

    /* Server Instance */
    private Server server;
    /* Online and Maximum Players */
    private int onlinePlayers, maxPlayers;
    /* Ticks Per Second */
    private double tps;
    /* Whitelisted Players */
    private Set<UUID> whitelistedPlayers;
    /* Server State */
    private ServerState state;

    public ServerData(Server server) {
        this.server = server;
        this.onlinePlayers = -1;
        this.maxPlayers = -1;
        this.tps = -1;
        this.state = ServerState.ONLINE;
        this.whitelistedPlayers = new HashSet<>();
    }
}
