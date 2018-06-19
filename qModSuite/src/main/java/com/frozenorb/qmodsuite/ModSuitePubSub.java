package com.frozenorb.qmodsuite;

import redis.clients.jedis.JedisPubSub;

import java.util.regex.Pattern;

public class ModSuitePubSub extends JedisPubSub {

    /* Idententifier for PUBSUB channel */
    private static final String identifier = "qModSuite-";

    @Override
    public void onMessage(String channel, String message) {
        String[] deserialized = message.split(Pattern.quote("|||"));
        String server = deserialized[0];
        String player = deserialized[1];
        String sendMessage = deserialized[2];
        switch (channel){
            /* Staff Chat */
            case identifier + "SC":

                return;
            /* Request */
            case identifier + "RQ":

                return;
            /* Report */
            case identifier + "RP":
                String reported = deserialized[3];
                return;
            default:
                //Log that this in an invalid message
                return;
        }
    }
}