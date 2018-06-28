package com.frozenorb.uhub.configs;

import com.frozenorb.commonlibs.ConfigHelper;
import com.frozenorb.uhub.uHubPlugin;
import lombok.Getter;

public class ConfigurationHandler {

    /* Locations Configuration File */
    @Getter private static ConfigHelper locations = new LocationsConfig("locations", uHubPlugin.getProvidingPlugin(uHubPlugin.class).getDataFolder().getAbsolutePath());

    /* Settings Configuration File */
    @Getter private static ConfigHelper settings = new SettingsConfig("config", uHubPlugin.getProvidingPlugin(uHubPlugin.class).getDataFolder().getAbsolutePath());

}
