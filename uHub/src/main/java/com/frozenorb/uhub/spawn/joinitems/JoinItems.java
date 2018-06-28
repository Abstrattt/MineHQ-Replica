package com.frozenorb.uhub.spawn.joinitems;

import com.frozenorb.commonlibs.utils.ItemUtility;
import com.frozenorb.uhub.spawn.SpawnHandler;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Getter
public enum JoinItems {

    /* Server Selector */
    SERVER_SELECTOR(new HubItem(
            0,
            /* Item */
            new ItemUtility()
                    .title("&9» &e&lServer Selector &9«")
                    .material(Material.WATCH)
                    .build(),
            /* Click Handler */
            player -> {

            }
    )),

    /* Cosmetics */
    COSMETICS(new HubItem(
            4,
            /* Item */
            new ItemUtility()
                    .title("&9» &d&lCosmetics &9«")
                    .material(Material.FEATHER)
                    .build(),
            /* Click Handler */
            player -> player.sendMessage("Attemping to open cosmetics")
    )),

    /* Ender Butt */
    ENDER_BUTT(new HubItem(
            8,
            /* Item */
            new ItemUtility()
                    .title("&9» &5&lEnder Butt &9«")
                    .material(Material.ENDER_PEARL)
                    .amount(64)
                    .build(),
            player -> {
                Item item = player.getWorld().dropItem(player.getLocation().add(0.0, 0.5, 0.0), new ItemStack(Material.ENDER_PEARL, 1));
                item.setPickupDelay(Integer.MAX_VALUE);
                item.setVelocity(player.getLocation().getDirection().normalize().multiply(1.5));
                item.setPassenger(player);
                player.getWorld().playSound(player.getLocation(), Sound.ENDERMAN_SCREAM, 1.0F, 1.0F);
                SpawnHandler.setupEnderpearl(item);
            }
    ));

    private HubItem hubItem;

    JoinItems(HubItem hubItem) {
        this.hubItem = hubItem;
    }

    /**
     * Apply join items to a player
     */
    public static void applyItems(Player player){
        for (JoinItems joinItem : JoinItems.values()){
            HubItem hubItem = joinItem.getHubItem();
            player.getInventory().setItem(hubItem.getSlot(), hubItem.getItem());
        }
    }
}
