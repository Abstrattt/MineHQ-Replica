package com.frozenorb.qmodsuite.profile;

import com.frozenorb.basic.profile.PlayerProfile;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class StaffProfileHandler {

    /* Staff Profiles Collection */
    @Getter private static Map<PlayerProfile, StaffProfile> profiles = new HashMap<>();

    /**
     * Add a profile to the collection
     */
    public static void addProfile(PlayerProfile playerProfile, StaffProfile staffProfile) {
        profiles.put(playerProfile, staffProfile);
    }

    /**
     * Remove a profile from the collection
     */
    public static void removeProfile(PlayerProfile playerProfile) {
        profiles.remove(playerProfile);
    }

    /**
     * Get a profile
     */
    public static StaffProfile getProfile(PlayerProfile playerProfile){
        return profiles.get(playerProfile);
    }

}
