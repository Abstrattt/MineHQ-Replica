package com.frozenorb.uhub.spawn.menus.type;

import com.frozenorb.commonlibs.utils.ItemUtility;
import com.frozenorb.commonlibs.utils.MessageUtility;
import com.frozenorb.redstone.server.Server;
import com.frozenorb.redstone.server.ServerHandler;
import com.frozenorb.redstone.server.ServerState;
import com.frozenorb.uhub.spawn.menus.HubMenu;
import com.frozenorb.uhub.spawn.menus.InventorySlot;
import com.frozenorb.uhub.uHubPlugin;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class ServerSelectorMenu extends HubMenu {

    private Set<UUID> viewers = new HashSet<>();
    private ServerSelectorRunnable runnable;

    public ServerSelectorMenu() {
        super("Select a server to join", 45);
        setup();
        runnable = new ServerSelectorRunnable(this);
    }

    private void setup() {
        /* UHC Meetup */
        getItems().put(2,
                new InventorySlot(
                        2,
                        new ItemUtility()
                                .material(Material.APPLE)
                                .title("&c&lUHC Meetup")
                                .lores(Arrays.asList("",
                                        "&7* &616 Players Per Game!",
                                        "&7* &6Solo & Duo Queues!",
                                        "&7* &6Last Man Standing Wins!",
                                        "",
                                        "&eThis server is offline"))
                                .amount(1).build(),
                        player -> {
                            player.closeInventory();
                            ByteArrayDataOutput out = ByteStreams.newDataOutput();
                            out.writeUTF("Connect");
                            out.writeUTF("UHC-Meetup-Lobby");
                            player.sendPluginMessage(uHubPlugin.getProvidingPlugin(uHubPlugin.class), "BungeeCord", out.toByteArray());
                        },
                        "UHC-Meetup-Lobby"
                ));

        /* Practice */
        getItems().put(4,
                new InventorySlot(
                        4,
                        new ItemUtility()
                                .material(Material.BOW)
                                .title("&c&lPractice")
                                .lores(Arrays.asList("&ePlayers: &f(0/0)",
                                        "",
                                        "&7* &61v1s, 2v2s, 3v3s!",
                                        "&7* &6Leaderboards, Parties & Queues!",
                                        "&7* &6Tournaments, Redrovers & More!",
                                        "",
                                        "&eThis server is offline"))
                                .amount(1).build(),
                        player -> {
                            player.closeInventory();
                            player.sendMessage(MessageUtility.formatMessage("&cComing Soon!"));
                        },
                        "Practice"
                ));

        /* Kitmap */
        getItems().put(6,
                new InventorySlot(
                        6,
                        new ItemUtility()
                                .material(Material.ENDER_PEARL)
                                .title("&c&lKitmap")
                                .lores(Arrays.asList("&ePlayers: &f(0/0)",
                                        "",
                                        "&7* &65 Minute KOTHs",
                                        "&7* &624/7 PvP",
                                        "&7* &6Obstacles, Skybridges & More!",
                                        "",
                                        "&eThis server is offline"))
                                .amount(1).build(),
                        player -> {
                            player.closeInventory();
                            player.sendMessage(MessageUtility.formatMessage("&cComing Soon!"));
                        },
                        "Kitmap"
                ));

        /* MineSG */
        getItems().put(20,
                new InventorySlot(
                        20,
                        new ItemUtility()
                                .material(Material.CHEST)
                                .title("&c&lMineSG")
                                .lores(Arrays.asList("",
                                        "&7* &6Solo & Duo Queues!",
                                        "&7* &650 Players Per Game!",
                                        "&7* &6Last Man Standing Wins!",
                                        "",
                                        "&eThis server is offline"))
                                .amount(1).build(),
                        player -> {
                            player.closeInventory();
                            player.sendMessage(MessageUtility.formatMessage("&cComing Soon!"));
                        },
                        "MineSG-Lobby"
                ));

        /* Bunkers */
        getItems().put(22,
                new InventorySlot(
                        22,
                        new ItemUtility()
                                .material(Material.BEACON)
                                .title("&c&lBunkers")
                                .lores(Arrays.asList("",
                                        "&7* &65 Man Teams!",
                                        "&7* &620 Players Per Game!",
                                        "&7* &6The Best Team Wins!",
                                        "",
                                        "&eThis server is offline"))
                                .amount(1).build(),
                        player -> {
                            player.closeInventory();
                            player.sendMessage(MessageUtility.formatMessage("&cComing Soon!"));
                        },
                        "Bunkers-Lobby"
                ));
        /* UHC */
        getItems().put(24,
                new InventorySlot(
                        24,
                        new ItemUtility()
                                .material(Material.GOLDEN_APPLE)
                                .title("&c&lUHC")
                                .lores(Arrays.asList("",
                                        "&7* &6Scenario Based UHC!",
                                        "&7* &6Hardcore Healing!",
                                        "&7* &6FFA & Team Games!",
                                        "",
                                        "&eThis server is offline"))
                                .amount(1).build(),
                        player -> {
                            player.closeInventory();
                            player.sendMessage(MessageUtility.formatMessage("&cComing Soon!"));
                        },
                        "UHC-Lobby"
                ));
        /* HCTeams */
        getItems().put(38,
                new InventorySlot(
                        38,
                        new ItemUtility()
                                .material(Material.DIAMOND_SWORD)
                                .title("&c&lHCTeams")
                                .lores(Arrays.asList("&ePlayers: &f(0/0)",
                                        "",
                                        "&7* &630 Man Factions!",
                                        "&7* &6No Allies!",
                                        "&7* &6KOTHs, Conquest, & Citadel!",
                                        "",
                                        "&eThis server is offline"))
                                .amount(1).build(),
                        player -> {
                            player.closeInventory();
                            player.sendMessage(MessageUtility.formatMessage("&cComing Soon!"));
                        },
                        "HCTeams"
                ));
        /* Vault Battles */
        getItems().put(40,
                new InventorySlot(
                        40,
                        new ItemUtility()
                                .material(Material.NETHER_STAR)
                                .title("&c&lVault Battles")
                                .lores(Arrays.asList("",
                                        "&7* &625 Man Teams!",
                                        "&7* &6100 Players Per Game!",
                                        "&7* &6Last Bank Standing Wins!",
                                        "",
                                        "&eThis server is offline"))
                                .amount(1).build(),
                        player -> {
                            player.closeInventory();
                            player.sendMessage(MessageUtility.formatMessage("&cComing Soon!"));
                        },
                        "VaultBattles-Lobby"
                ));

        /* Siege */
        getItems().put(42,
                new InventorySlot(
                        42,
                        new ItemUtility()
                                .material(Material.SNOW_BALL)
                                .title("&c&lSiege")
                                .lores(Arrays.asList("",
                                        "&7* &625 Man Teams!",
                                        "&7* &6100 Players Per Game!",
                                        "&7* &6Last Nexus Standing Wins!",
                                        "",
                                        "&eThis server is offline"))
                                .amount(1).build(),
                        player -> {
                            player.closeInventory();
                            player.sendMessage(MessageUtility.formatMessage("&cComing Soon!"));
                        },
                        "VaultBattles-Lobby"
                ));

    }


    public Inventory open(Player player){
        Inventory inventory = super.open(player);
        viewers.add(player.getUniqueId());
        update(player);
        player.updateInventory();
        return null;
    }

    public void update(Player player){
        InventoryView inventory = player.getOpenInventory();
        for (InventorySlot slotItem : getItems().values()) {
            inventory.setItem(slotItem.getSlot(), processBuffer(slotItem, slotItem.getItem()));
        }
    }

    private ItemStack processBuffer(InventorySlot inventorySlot, ItemStack itemStack) {
        if (inventorySlot.getLinkage() == null || inventorySlot.getLinkage().isEmpty() || inventorySlot.getLinkage().equalsIgnoreCase("")){
            return itemStack;
        }
        Server server = ServerHandler.getServer(inventorySlot.getLinkage());
        int maxPlayers = 0;
        int onlinePlayers = 0;
        String bottomLine = "&eThis server is offline";
        boolean offline = true;
        if (server != null){
            if (server.getData().getState() != ServerState.OFFLINE){
                offline = false;
            }
            maxPlayers = server.getData().getMaxPlayers();
            onlinePlayers = server.getData().getOnlinePlayers();
        }
        if (offline) {
            itemStack.setType(Material.REDSTONE_BLOCK);
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> loreLines = itemMeta.getLore();
        if (!inventorySlot.getLinkage().contains("-Lobby")){
            if (!offline) {
                bottomLine = "&7» &eClick to join the queue! &7«";
            }
            loreLines.set(0, "&ePlayers: &f(" + onlinePlayers + "/" + maxPlayers + ")");
        }else{
            if (!offline) {
                bottomLine = "&7» &eClick to join! &7«";
            }
        }
        String title = ChatColor.stripColor(itemMeta.getDisplayName());
        if (offline) {
            title = "&c&l" + title;
        }else{
            title = "&a&l" + title;
        }
        loreLines.set(loreLines.size() - 1, bottomLine);
        itemMeta.setDisplayName(MessageUtility.formatMessage(title));
        itemMeta.setLore(MessageUtility.formatMessages(loreLines));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
