package com.frozenorb.redstone.server;

import lombok.Getter;

/**
 * This class is going to be super useful
 */
@Getter
public enum ServerStage {

    /* Actual Live Server */
    PRODUCTION(0),
    /* Mirror of Live Server w/ debug Messages */
    STAGING(1),
    /* Development Server */
    DEVELOPMENT(2);

    private int ordinal;

    ServerStage(int ordinal){
        this.ordinal = ordinal;
    }
}
