package com.frozenorb.basic.profile;

import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerProfile {

    /* Player UUID */
    private UUID uuid, previousMessager;
    /* Options */
    private boolean sounds, messages;

    public PlayerProfile(UUID uuid) {
        this.uuid = uuid;
        setupDefaults();
        loadProfile();
    }

    public PlayerProfile(Player player) {
        this(player.getUniqueId());
    }

    /**
     * Setup Defaults
     */
    private void setupDefaults(){
        sounds = true;
        messages = true;
    }

    /**
     * Load Profile
     */
    private void loadProfile() {

    }

    /**
     * Save Profile
     */
    private void saveProfile() {

    }
}
