package com.frozenorb.uhub.listeners;

import com.frozenorb.uhub.spawn.menus.HubMenu;
import com.frozenorb.uhub.spawn.menus.InventorySlot;
import com.frozenorb.uhub.spawn.menus.MenuHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListeners implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (event.getCursor() == null || event.getCurrentItem() == null){
            return;
        }
        if (event.getClickedInventory() == player.getInventory()){
            event.setCancelled(true);
        }

        for (HubMenu menus : MenuHandler.getMenus()) {
            for (InventorySlot inventorySlot : menus.getItems().values()) {
                if (event.getCurrentItem().isSimilar(inventorySlot.getItem())) {
                    event.setResult(Event.Result.DENY);
                    event.setCancelled(true);
                    inventorySlot.getClickHandler().click(player);
                    return;
                }
            }
        }
    }
}
