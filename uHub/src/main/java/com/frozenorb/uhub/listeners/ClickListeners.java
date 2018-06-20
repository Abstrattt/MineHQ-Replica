package com.frozenorb.uhub.listeners;

import com.frozenorb.uhub.spawn.joinitems.JoinItems;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickListeners implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if (player.getItemInHand() == null || player.getItemInHand().getType() == Material.AIR){
            return;
        }

        for (JoinItems joinItems : JoinItems.values()){
            if (joinItems.getHubItem().getItem().isSimilar(player.getItemInHand())){
                joinItems.getHubItem().getClickHandler().click(player);
                return;
            }
        }
    }
}
