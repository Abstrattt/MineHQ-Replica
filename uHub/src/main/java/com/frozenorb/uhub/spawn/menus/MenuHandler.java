package com.frozenorb.uhub.spawn.menus;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class MenuHandler {

    /** Collection of Menus **/
    @Getter private static Set<HubMenu> menus = new HashSet<>();

    /**
     * Add a Menu to the Collection
     */
    public static void addMenu(HubMenu menu) {
        menus.add(menu);
    }

    /**
     * Remove a Menu from the Collection
     */
    public static void removeMenu(HubMenu menu) {
        menus.remove(menu);
    }
}
