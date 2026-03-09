package com.mineshaft.mineshaftAHardcodedItemPort.items;

import com.mineshaft.mineshaftapi.util.item.ItemUtil;
import com.mineshaft.mineshaftapi.util.formatter.TextFormatter;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum CurrencyItem {

    GALLEON(Material.GOLD_NUGGET, 1),
    SICKLE(Material.GOLD_NUGGET, 2),
    KNUT(Material.GOLD_NUGGET, 3),
    TEN_PENCE(Material.IRON_INGOT, 13),
    ONE_POUND(Material.IRON_INGOT, 14),
    TEN_POUNDS(Material.IRON_INGOT, 15),
    ;

    @Getter
    private final Material material;
    private final int customModelData;

    CurrencyItem(Material material, int customModelData) {
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
