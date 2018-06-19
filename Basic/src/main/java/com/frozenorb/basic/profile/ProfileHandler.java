package com.frozenorb.basic.profile;

import java.util.HashSet;
import java.util.Set;

public class ProfileHandler {

    /** Collection of Profiles **/
    private static Set<PlayerProfile> profiles = new HashSet<PlayerProfile>();

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
}
