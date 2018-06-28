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

    public static ServerStage getFromOrdinal(int ordinal) {
        for (ServerStage stage : ServerStage.values()) {
            if (stage.getOrdinal() == ordinal) {
                return stage;
            }
        }
        return null;
    }

    public static ServerStage getFromString(String id) {
        for (ServerStage stage : ServerStage.values()) {
            if (stage.name().equalsIgnoreCase(id)) {
                return stage;
            }
        }
        return null;
    }
}
