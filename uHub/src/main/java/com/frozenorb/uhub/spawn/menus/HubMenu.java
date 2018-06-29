package com.frozenorb.uhub.spawn.menus;

import com.frozenorb.commonlibs.utils.ItemUtility;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

@Getter @Setter
public class HubMenu {

    private String title;
    private int slots;
    private HashMap<Integer, InventorySlot> items = new HashMap<>();

    public HubMenu(String title, int slots) {
        this.title = title;
        this.slots = slots;
        for (int i= 0; i <= getSlots()-1; i++){
            getItems().put(i, new InventorySlot(i, new ItemUtility().material(Material.STAINED_GLASS_PANE).title("").durability((short) 7).amount(1).build(), player -> {
                //Blank
            }, ""));
        }
        MenuHandler.addMenu(this);
    }

    public Inventory open(Player player){
        Inventory inventory = Bukkit.createInventory(null, slots, title);
        for (InventorySlot slotItem : items.values()) {
            inventory.setItem(slotItem.getSlot(), slotItem.getItem());
        }
        player.openInventory(inventory);
        player.updateInventory();
        return inventory;
    }


}
