package com.frozenorb.uhub.listeners;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class DoubleJumpListeners implements Listener {

    @EventHandler
    public void onDoubleJumpMove(PlayerMoveEvent event) {
        /* Player Object */
        Player player = event.getPlayer();

        /* Check if the player is in the right state */
        if (player.getGameMode().equals(GameMode.CREATIVE)) return;
        if (!player.isOnGround()) return;
        if (player.getAllowFlight()) return;

        /* Execute */
        player.setAllowFlight(true);
    }

    @EventHandler
    public void onDoubleJumpFlight(PlayerToggleFlightEvent event) {
        /* Player Object */
        Player player = event.getPlayer();

        /* Check if player is in the right gamemode */
        if (player.getGameMode().equals(GameMode.CREATIVE)) return;

        /* Cancel Event and Flying */
        event.setCancelled(true);
        player.setFlying(false);
        player.setAllowFlight(false);

        /* Variables */
        final Location loc = player.getLocation();
        final int teleportUp = 1;
        final double otherBoost = 1.25;
        final Sound sound = Sound.PISTON_EXTEND;

        /* Execute */
        player.teleport(loc.add(0, teleportUp, 0));
        final Vector vector = loc.getDirection().multiply(otherBoost);
        player.setVelocity(vector);
        player.playSound(loc, sound, 2,2);
    }
}
