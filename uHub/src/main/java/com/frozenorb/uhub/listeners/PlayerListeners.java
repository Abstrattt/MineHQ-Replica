package com.frozenorb.uhub.listeners;

import com.frozenorb.uhub.spawn.SpawnHandler;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerListeners implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        /* Player Object */
        Player player = event.getPlayer();

        if (player.getGameMode() != GameMode.CREATIVE) return;

        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        /* Teleport when they fall off of the spawn */
        if (event.getCause() == EntityDamageEvent.DamageCause.VOID){
            event.getEntity().teleport(SpawnHandler.getSpawnLocation());
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event){
        /* Player Object */
        Player player = event.getPlayer();

        if (player.getGameMode() != GameMode.CREATIVE) return;

        event.setCancelled(true);
    }
}
