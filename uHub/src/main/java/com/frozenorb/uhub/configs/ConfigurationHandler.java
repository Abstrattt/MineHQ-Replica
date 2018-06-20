package com.frozenorb.uhub.configs;

import com.frozenorb.commonlibs.ConfigHelper;
import lombok.Getter;

public class ConfigurationHandler {

    /* Locations Configuration File */
    @Getter private static ConfigHelper locations = new LocationsConfig(null, null);

    /* Settings Configuration File */
    @Getter private static ConfigHelper settings = new SettingsConfig(null, null);

}
