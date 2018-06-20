package com.frozenorb.qmodsuite;

import com.frozenorb.commonlibs.utils.MessageUtility;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import redis.clients.jedis.JedisPubSub;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

        List<String> lines = new ArrayList<>();
        String permission = "qModSuite.%channel%.Recieve";

        switch (channel){
            /* Staff Chat */
            case IDENTIFIER + "SC":
                permission.replaceAll("%channel%", "Staff");
                lines.add("&7[" + server + "] &5" + player + " &d" + sendMessage);
                break;
            /* Request */
            case IDENTIFIER + "RQ":
                permission.replaceAll("%channel%", "Request");
                lines.add("&3[Request]&7[" + server + "]" + "&b" + player + " &7requested assistance");
                lines.add("   &eReason: &7" + sendMessage);
                break;
            /* Report */
            case IDENTIFIER + "RP":
                String reported = deserialized[3];
                permission.replaceAll("%channel%", "Report");
                lines.add("&3[Report]&7[" + server + "]" + "&b" + reported + " &7reported by &b" + player);
                lines.add("   &eReason: &7" + sendMessage);
                break;
        }

        final String finalPermission = permission;
        Set<Player> notified = Bukkit.getOnlinePlayers().stream().filter(player1 -> player1.hasPermission(finalPermission)).distinct().collect(Collectors.toSet());
        notified.forEach(notifiedPlayer -> MessageUtility.formatMessages(lines).forEach(notifiedPlayer::sendMessage));
    }
}