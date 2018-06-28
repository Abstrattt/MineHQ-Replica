package com.frozenorb.basic.profile.events;

import com.frozenorb.basic.profile.PlayerProfile;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class ProfileDestoryEvent extends Event {

    /* Handler List */
    @Getter public static HandlerList handlerList = new HandlerList();

    /* Player Profile */
    private PlayerProfile playerProfile;

    public ProfileDestoryEvent(PlayerProfile playerProfile){
        this.playerProfile = playerProfile;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

}
