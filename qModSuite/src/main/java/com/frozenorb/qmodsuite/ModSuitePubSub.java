package com.frozenorb.qmodsuite;

import com.frozenorb.commonlibs.utils.MessageUtility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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
                for (Player localPlayer : Bukkit.getOnlinePlayers()){
                    if (localPlayer.hasPermission("qModSuite.Staff.Recieve")){
                        localPlayer.sendMessage(MessageUtility.formatMessage("&7[" + server + "] &5" + player + " &d" + sendMessage));
                    }
                }
                return;
            /* Request */
            case identifier + "RQ":
                for (Player localPlayer : Bukkit.getOnlinePlayers()){
                    if (localPlayer.hasPermission("qModSuite.Request.Recieve")){
                        localPlayer.sendMessage(MessageUtility.formatMessage("&3[Request]&7[" + server + "]" + "&b" + player + " &7requested assistance"));
                        localPlayer.sendMessage(MessageUtility.formatMessage("   &eReason: &7" + sendMessage));
                    }
                }
                return;
            /* Report */
            case identifier + "RP":
                String reported = deserialized[3];
                for (Player localPlayer : Bukkit.getOnlinePlayers()){
                    if (localPlayer.hasPermission("qModSuite.Report.Recieve")){
                        localPlayer.sendMessage(MessageUtility.formatMessage("&3[Report]&7[" + server + "]" + "&b" + reported + " &7reported by &b" + player));
                        localPlayer.sendMessage(MessageUtility.formatMessage("   &eReason: &7" + sendMessage));
                    }
                }
                return;
            default:
                //Log that this in an invalid message
                return;
        }
    }
}