package com.frozenorb.uhub.spawn.joinitems;

import com.frozenorb.commonlibs.utils.ItemUtility;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;

@Getter
public enum JoinItems {

    /* Server Selector */
    SERVER_SELECTOR(new HubItem(
            0,
            /* Item */
            new ItemUtility()
                    .title("&3&l» &e&lServer Selector &3&l«")
                    .material(Material.WATCH)
                    .build(),
            /* Click Handler */
            player -> {

            }
    )),

    /* Cosmetics */
    COSMETICS(new HubItem(
            0,
            /* Item */
            new ItemUtility()
                    .title("» Cosmetics «")
                    .material(Material.FEATHER)
                    .build(),
            /* Click Handler */
            player -> {

            }
    )),

    /* Ender Butt */
    ENDER_BUTT(new HubItem(
            0,
            /* Item */
            new ItemUtility()
                    .title("» Ender Butt «")
                    .material(Material.ENDER_PEARL)
                    .build(),
            /* Click Handler */
            player -> {

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
