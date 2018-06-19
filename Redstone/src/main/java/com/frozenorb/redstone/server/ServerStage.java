package com.frozenorb.redstone.server;

import lombok.Getter;

@Getter
public enum ServerStage {

    PRODUCTION(0),
    STAGING(1),
    DEVELOPMENT(2);

    private int ordinal;

    ServerStage(int ordinal){
        this.ordinal = ordinal;
    }
}
