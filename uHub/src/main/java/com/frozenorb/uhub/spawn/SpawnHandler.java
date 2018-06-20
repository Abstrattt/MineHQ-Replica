package com.frozenorb.uhub.spawn;

import com.frozenorb.commonlibs.utils.LocationUtility;
import com.frozenorb.uhub.configs.ConfigurationHandler;
import com.frozenorb.uhub.configs.LocationsConfig;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

public class SpawnHandler {

    @Getter @Setter private static Location spawnLocation;

    public static void loadSpawnLocation(){
        String locationString = ConfigurationHandler.getLocations().getConfiguration().getString("Spawn-Location");
        spawnLocation = LocationUtility.parseToLocation(locationString);
    }
}
