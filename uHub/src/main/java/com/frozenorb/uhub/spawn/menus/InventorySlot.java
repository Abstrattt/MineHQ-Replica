package com.frozenorb.uhub.spawn.menus;

import com.frozenorb.uhub.spawn.joinitems.ClickHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

@Getter @Setter @AllArgsConstructor
public class InventorySlot {

    /* Slot */
    private Integer slot;
    /* Item */
    private ItemStack item;
    /* Click Handler */
    private ClickHandler clickHandler;
    /* Linkage */
    private String linkage;
}
