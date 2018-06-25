package com.frozenorb.qmodsuite.profile;

import com.frozenorb.basic.profile.PlayerProfile;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StaffProfile {

    private boolean vanished;
    private PlayerProfile playerProfile;

    public StaffProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }
}
