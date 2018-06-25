package com.frozenorb.uhub.spawn.menus;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class HubMenu {

    private String id;
    private int slots;
    private Set<UUID> viewers = new HashSet<>();

    public HubMenu(String id, int slots) {
        this.id = id;
        this.slots = slots;
    }

    public void open(Player player){
        viewers.add(player.getUniqueId());
    }

}
