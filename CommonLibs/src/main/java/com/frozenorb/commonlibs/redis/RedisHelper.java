package com.frozenorb.commonlibs.redis;

import lombok.Getter;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Getter
public class RedisHelper {

    private JedisPool pool;

    public RedisHelper(RedisCredentials credentials){
        if (credentials.isAuth()) {
            pool = new JedisPool(new JedisPoolConfig(),
                    credentials.getIp(),
                    credentials.getPort(),
                    2000,
                    credentials.getPassword());
        }else{
            pool = new JedisPool(new JedisPoolConfig(),
                    credentials.getIp(),
                    credentials.getPort(),
                    2000);
        }
    }
}
