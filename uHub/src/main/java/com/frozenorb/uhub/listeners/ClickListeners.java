package com.frozenorb.uhub.listeners;

import com.frozenorb.uhub.spawn.joinitems.JoinItems;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickListeners implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        Player player = event.getPlayer();

        //TODO make this more effcient
        if (player.getItemInHand() == null || player.getItemInHand().getType() == Material.AIR){
            return;
        }

        /*if (!event.getAction().equals(Action.RIGHT_CLICK_AIR) || !event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            return;
        }*/

        for (JoinItems joinItems : JoinItems.values()){
            if (joinItems.getHubItem().getItem().isSimilar(player.getItemInHand())){
                event.setCancelled(true);
                event.setUseItemInHand(Event.Result.DENY);
                event.setUseInteractedBlock(Event.Result.DENY);
                player.updateInventory();
                if (joinItems.getHubItem().getClickHandler() == null){
                    continue;
                }
                joinItems.getHubItem().getClickHandler().click(player);
                return;
            }
        }
    }
}
