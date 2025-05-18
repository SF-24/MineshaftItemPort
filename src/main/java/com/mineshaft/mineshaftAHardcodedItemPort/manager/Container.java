package com.mineshaft.mineshaftAHardcodedItemPort.manager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Container {

    NULL(Material.AIR, -1, null),
    BOWL(Material.BOWL, 0, null),
    BOTTLE(Material.GLASS_BOTTLE, 0, null),
    TANKARD(Material.GLASS_BOTTLE, 13, "Tankard"),
    ;
    private final String name;
    private final int modelData;
    private final Material material;

    Container(Material material, int modelData, String name) {
        this.material=material;
        this.modelData=modelData;
        this.name=name;
    }

    public ItemStack getItem() {
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
        return item;

    }

}
