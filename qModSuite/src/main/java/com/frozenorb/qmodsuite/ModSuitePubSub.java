package com.frozenorb.qmodsuite;

import com.frozenorb.commonlibs.utils.MessageUtility;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import redis.clients.jedis.JedisPubSub;

import java.util.regex.Pattern;

public class ModSuitePubSub extends JedisPubSub {

    /* Idententifier for PUBSUB channel */
    public static final String IDENTIFIER = "qModSuite-";

    /* Spliter for the incoming messages */
    public static final String SPLITER = "|||";

    @Override
    public void onMessage(String channel, String message) {
        String[] deserialized = message.split(Pattern.quote(SPLITER));
        String server = deserialized[0];
        String player = deserialized[1];
        String sendMessage = deserialized[2];
        switch (channel){
            /* Staff Chat */
            case IDENTIFIER + "SC":
                for (Player localPlayer : Bukkit.getOnlinePlayers()){
                    if (localPlayer.hasPermission("qModSuite.Staff.Recieve")){
                        localPlayer.sendMessage(MessageUtility.formatMessage("&7[" + server + "] &5" + player + " &d" + sendMessage));
                    }
                }
                return;
            /* Request */
            case IDENTIFIER + "RQ":
                for (Player localPlayer : Bukkit.getOnlinePlayers()){
                    if (localPlayer.hasPermission("qModSuite.Request.Recieve")){
                        localPlayer.sendMessage(MessageUtility.formatMessage("&3[Request]&7[" + server + "]" + "&b" + player + " &7requested assistance"));
                        localPlayer.sendMessage(MessageUtility.formatMessage("   &eReason: &7" + sendMessage));
                    }
                }
                return;
            /* Report */
            case IDENTIFIER + "RP":
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
        //TODO make this more effcient with less for loops
    }
}