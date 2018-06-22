package com.frozenorb.redstone.server;

import lombok.Getter;
import org.bukkit.Bukkit;

@Getter
public enum ServerState {

    ONLINE(0),
    WHITELISTED(1),
    OFFLINE(2);

    private int ordinal;

    ServerState(int ordinal){
        this.ordinal = ordinal;
    }

    public static ServerState getFromOrdinal(int ordinal) {
        for (ServerState state : ServerState.values()) {
            if (state.getOrdinal() == ordinal) {
                return state;
            }
        }
        return null;
    }

    public static ServerState getCurrent(){
        return Bukkit.hasWhitelist() ? WHITELISTED : ONLINE;
    }
}
