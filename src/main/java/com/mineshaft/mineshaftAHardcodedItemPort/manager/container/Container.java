package com.mineshaft.mineshaftAHardcodedItemPort.manager.container;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Container {

    NULL(Material.AIR, -1, null),
    BOWL(Material.BOWL, 0, null),
    SALAD_BOWL(Material.BOWL, 5, "Bowl"),
    COFFEE_CUP(Material.GLASS_BOTTLE, 1, "Coffee Cup"),
    PAPER_CUP(Material.GLASS_BOTTLE, 2, "Paper Cup"),
    GLASS_MUG(Material.GLASS_BOTTLE, 3, "Glass Mug"),
    CAN(Material.GLASS_BOTTLE, 4, "Can"),
    BOTTLE(Material.GLASS_BOTTLE, 0, null),
    TANKARD(Material.GLASS_BOTTLE, 13, "Tankard"),
    BUCKET(Material.BUCKET, 0, null),
    ;
    private final String name;
    private final int modelData;
    private final Material material;

    Container(Material material, int modelData, String name) {
        this.material=material;
        this.modelData=modelData;
        this.name=name;
    }

    public ItemStack getItem(int amount) {
        ItemStack item = new ItemStack(material);
        if(modelData>=0 || name!=null) {
            ItemMeta meta = item.getItemMeta();
            assert meta != null;
            if(modelData>0) {
                meta.setCustomModelData(modelData);
            }
            if (name != null) {
                meta.setDisplayName(ChatColor.WHITE + name);
            }
            item.setItemMeta(meta);
        }
        item.setAmount(amount);
        return item;
    }

    public ItemStack getItem() {
        return getItem(1);
    }

    public Material getMaterial() {return material;}

}
