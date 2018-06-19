package com.frozenorb.commonlibs.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemUtility {

    private Material material;
    private Short durability;
    private String title;
    private int amount;
    private List<String> lores;

    public ItemUtility material(Material material){
        this.material = material;
        return this;
    }

    public ItemUtility durability(short durability){
        this.durability = durability;
        return this;
    }

    public ItemUtility title(String title){
        this.title = title;
        return this;
    }

    public ItemUtility amount(int amount){
        this.amount = amount;
        return this;
    }

    public ItemUtility lores(List<String> lores){
        this.lores = lores;
        return this;
    }

    public ItemStack build(){
        ItemStack itemStack = new ItemStack(this.material);
        ItemMeta meta = itemStack.getItemMeta();
        if (this.amount > 0)
            itemStack.setAmount(this.amount);
        if (this.durability != null)
            itemStack.setDurability(this.durability);
        if (this.title != null)
            meta.setDisplayName(MessageUtility.formatMessage("&r" + this.title));
        if (this.lores != null && this.lores.size() > 0)
            meta.setLore(MessageUtility.formatMessages(this.lores));
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
