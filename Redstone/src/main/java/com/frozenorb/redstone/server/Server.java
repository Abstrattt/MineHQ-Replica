package com.frozenorb.redstone.server;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter @Setter
public class Server {

    /* Server Group */
    private ServerGroup group;
    /* Server Stage */
    private ServerStage stage;
    /* Server State */
    private ServerState state;

    public Server(){

    }
}
