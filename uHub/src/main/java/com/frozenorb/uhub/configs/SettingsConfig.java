package com.frozenorb.uhub.configs;

import com.frozenorb.commonlibs.ConfigHelper;
import com.frozenorb.uhub.uHubPlugin;

public class SettingsConfig extends ConfigHelper {

    public SettingsConfig(String name, String directory) {
        super(uHubPlugin.getProvidingPlugin(uHubPlugin.class), name, directory);
    }
}
