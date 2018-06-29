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
            "&5&M------------------------------"
    ));

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        /* Player Object */
        Player player = event.getPlayer();

        /* Clear Inventory */
        player.getInventory().clear();
        player.setHealth(20);
        player.setFoodLevel(40);
        if (player.getVehicle() != null) {
            player.getVehicle().leaveVehicle();
        }


        /* Apply Join Items */
        JoinItems.applyItems(player);

        /* Remove Join Message */
        event.setJoinMessage(null);

        /* Send MOTD */
        for (String line : messages){
            player.sendMessage(line);
        }

        /* Set the Player Walk Speed */
        player.setWalkSpeed(0.5f);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        /* Player Object */
        Player player = event.getPlayer();

        /* Remove Quit Message */
        event.setQuitMessage(null);

        /* Stop Riding */
        if (player.getVehicle() != null) {
            player.getVehicle().leaveVehicle();
        }
    }

}
