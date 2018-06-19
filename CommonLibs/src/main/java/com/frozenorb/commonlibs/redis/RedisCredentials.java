package com.frozenorb.commonlibs.redis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class RedisCredentials {

    private String ip, password;
    private int port;

    public boolean isAuth(){
        return password != null;
    }
}

