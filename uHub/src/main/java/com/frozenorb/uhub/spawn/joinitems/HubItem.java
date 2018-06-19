package com.frozenorb.uhub.spawn.joinitems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor @Getter
public class HubItem {

    /* Slot */
    private Integer slot;
    /* Item */
    private ItemStack item;
    /* Click Handler */
    private ClickHandler clickHandler;

}
