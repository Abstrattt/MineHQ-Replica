package com.frozenorb.basic.profile;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ProfileHandler {

    /** Collection of Profiles **/
    @Getter private static Set<PlayerProfile> profiles = new HashSet<>();

    /**
     * Add Profile to the Handler
     */
    public static void addProfile(PlayerProfile playerProfile){
        profiles.add(playerProfile);
    }

    /**
     * Remove Profile from the Handler
     */
    public static void removeProfile(PlayerProfile playerProfile){
        profiles.remove(playerProfile);
    }

    /**
     * Get Profile from the Collection
     */
    public static PlayerProfile getProfile(UUID uuid) {
        for (PlayerProfile playerProfile : profiles) {
            if (playerProfile.getUuid().equals(uuid)) {
                return playerProfile;
            }
        }
        return null;
    }
}
