package com.frozenorb.redstone.server;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter @Setter
public class Server {

    /* Server Group */
    private String group;
    /* Server Stage */
    private ServerStage stage;
    /* Server ID */
    private String serverID;
    /* Server Data */
    private ServerData data;

    public Server(String serverID){
        this.serverID = serverID;
        this.data = new ServerData(this);
    }
}
