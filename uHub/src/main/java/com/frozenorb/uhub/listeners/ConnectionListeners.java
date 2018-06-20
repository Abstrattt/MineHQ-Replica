package com.frozenorb.uhub.listeners;

import com.frozenorb.commonlibs.utils.MessageUtility;
import com.frozenorb.uhub.spawn.joinitems.JoinItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.omg.CORBA.StringHolder;

import java.util.Arrays;
import java.util.List;

public class ConnectionListeners implements Listener {

    /* Join MOTD Messages */
    private static final List<String> messages = MessageUtility.formatMessages(Arrays.asList(
            "&5&m------------------------------",
            "",
            "&eWelcome to the &6MineHQ Network&e!",
            "",
            "&5&l» &e&lWebsite: &awww.minehq.com",
            "&5&l» &e&lTwitter: &awww.twitter.com/minehq",
            "&5&l» &e&lDiscord: &adiscord.minehq.com",
            "&5&l» &e&lStore: &astore.minehq.com",
            "",
            "&6&l------------------------------"
    ));

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        /* Player Object */
        Player player = event.getPlayer();

        /* Apply Join Items */
        JoinItems.applyItems(player);

        /* Send MOTD */
        for (String line : messages){
            player.sendMessage(line);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        /* Player Object */
        Player player = event.getPlayer();
    }

}
