package com.mineshaft.mineshaftAHardcodedItemPort.items;

import com.mineshaft.mineshaftapi.util.item.ItemUtil;
import com.mineshaft.mineshaftapi.util.formatter.TextFormatter;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum ItemTech {

    ;

    @Getter
    private final Material material;
    private final int customModelData;

    ItemTech(Material material, int customModelData) {
        this.material=material;
        this.customModelData=customModelData;
    }

    public ItemStack getItem() {
        return getItem(1);
    }

    public ItemStack getItem(int amount) {
        ItemStack item = new ItemStack(material);
        ItemUtil.setDefaultData(item, TextFormatter.capitaliseStringFully(this.name().toLowerCase().replace("_"," ")),customModelData);
        item.setAmount(amount);
        return item;
    }

    public static CurrencyItem getCurrencyItem(String name) {
        return CurrencyItem.valueOf(name.toUpperCase());
    }
}