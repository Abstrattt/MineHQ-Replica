package com.frozenorb.uhub.configs;

import com.frozenorb.commonlibs.ConfigHelper;
import com.frozenorb.uhub.uHubPlugin;

public class LocationsConfig extends ConfigHelper {

    public LocationsConfig(String name, String directory) {
        super(uHubPlugin.getProvidingPlugin(uHubPlugin.class), name, directory);
    }
}
