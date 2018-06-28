package com.frozenorb.uhub.spawn.joinitems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public class HubItem {

    /* Slot */
    private int slot;
    /* Item */
    private ItemStack item;
    /* Click Handler */
    private ClickHandler clickHandler;

    public HubItem(int slot, ItemStack item) {
        this.slot = slot;
        this.item = item;
    }

    public HubItem(int slot, ItemStack item, ClickHandler clickHandler) {
        this(slot, item);
        this.clickHandler = clickHandler;
    }

}
