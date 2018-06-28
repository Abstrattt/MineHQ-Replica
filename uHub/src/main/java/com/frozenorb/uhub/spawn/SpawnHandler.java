package com.frozenorb.uhub.spawn;

import com.frozenorb.commonlibs.utils.LocationUtility;
import com.frozenorb.uhub.configs.ConfigurationHandler;
import com.frozenorb.uhub.configs.LocationsConfig;
import com.frozenorb.uhub.uHubPlugin;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnHandler {

    @Getter @Setter private static Location spawnLocation;

    public static void loadSpawnLocation(){
        String locationString = ConfigurationHandler.getLocations().getConfiguration().getString("Spawn-Location");
        spawnLocation = LocationUtility.parseToLocation(locationString);
    }

    public static void setupEnderpearl(Item item) {
        new BukkitRunnable(){
            public void run() {
                /* Cancel if the item is gonski */
                if (item.isDead()) this.cancel();
                if (item.getPassenger() == null) {
                    item.remove();
                    this.cancel();
                }
                if ((item.getVelocity().getX() == 0.0D)
                        || (item.getVelocity().getY() == 0.0D)
                        || (item.getVelocity().getZ() == 0.0D)) {
                    Player player = (Player) item.getPassenger();
                    item.remove();
                    if (player != null) {
                        player.teleport(player.getLocation().add(0.0, 0.5, 0.0));
                    }
                    this.cancel();
                }
            }
        }.runTaskTimer(uHubPlugin.getProvidingPlugin(uHubPlugin.class), 1, 1);
    }
}
