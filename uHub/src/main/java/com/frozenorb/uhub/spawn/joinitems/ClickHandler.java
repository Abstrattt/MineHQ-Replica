package com.frozenorb.uhub.spawn.joinitems;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

@FunctionalInterface
public interface ClickHandler {

    void click(Player player);

}
