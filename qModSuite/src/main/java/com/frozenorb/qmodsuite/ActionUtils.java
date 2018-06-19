package com.frozenorb.qmodsuite;

import org.bukkit.entity.Player;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class ActionUtils {

    /**
     * Add cooldown for function within Redis
     */
    private static void addCooldown(Player player, String channel, Integer cooldown){
        try (Jedis jedis = qModSuitePlugin.getRedisHelper().getPool().getResource()){
            Pipeline pipeline = jedis.pipelined();
            final String key = ModSuitePubSub.IDENTIFIER + channel + ":" + player.getName();
            pipeline.set(key, "true");
            pipeline.expire(key, cooldown);
            pipeline.sync();
            qModSuitePlugin.getRedisHelper().getPool().returnResource(jedis);
            jedis.close();
        }
    }

    /**
     * Check if a player has a cooldown for function within Redis
     */
    private static boolean hasCooldown(Player player, String channel){
        boolean cooldown = false;
        try (Jedis jedis = qModSuitePlugin.getRedisHelper().getPool().getResource()){
            cooldown = jedis.exists(ModSuitePubSub.IDENTIFIER + channel + ":" + player.getName());
            qModSuitePlugin.getRedisHelper().getPool().returnResource(jedis);
            jedis.close();
        }
        return cooldown;
    }
}
