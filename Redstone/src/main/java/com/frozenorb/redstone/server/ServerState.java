package com.frozenorb.redstone.server;

public enum ServerState {

    ONLINE(0),
    WHITELISTED(1),
    OFFLINE(2);

    private int ordinal;

    ServerState(int ordinal){
        this.ordinal = ordinal;
    }
}
