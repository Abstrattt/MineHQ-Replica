package com.frozenorb.qmodsuite.profile;

import com.frozenorb.basic.profile.PlayerProfile;

import java.util.HashMap;
import java.util.Map;

public class StaffProfileHandler {

    private static Map<PlayerProfile, StaffProfile> profiles = new HashMap<>();

    public static void addProfile(PlayerProfile playerProfile, StaffProfile staffProfile) {
        profiles.put(playerProfile, staffProfile);
    }

    public static void removeProfile(PlayerProfile playerProfile) {
        profiles.remove(playerProfile);
    }

    public static StaffProfile getProfile(PlayerProfile playerProfile){
        return profiles.get(playerProfile);
    }

}
