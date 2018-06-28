package com.frozenorb.basic.profile;

import com.frozenorb.qlib.channels.ChatChannel;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter @Setter
public class PlayerProfile {

    /* Player UUID */
    private UUID uuid, previousMessager;
    /* Options */
    private boolean sounds, messages;
    /* Chat Channel */
    private ChatChannel chatChannel;

    public PlayerProfile(UUID uuid) {
        this.uuid = uuid;
        setupDefaults();
        loadProfile();
    }

    public PlayerProfile(Player player) {
        this(player.getUniqueId());
    }

    public Player getPlayer(){
        return Bukkit.getPlayer(uuid);
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
