package com.frozenorb.redstone.server;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Server {

    private ServerGroup group;
    private ServerStage stage;
    private ServerState state;

    public Server(){

    }
}
