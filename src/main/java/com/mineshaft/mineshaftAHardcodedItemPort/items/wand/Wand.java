package com.mineshaft.mineshaftAHardcodedItemPort.items.wand;

import com.mineshaft.mineshaftapi.nbtapi.NBT;
import com.mineshaft.mineshaftapi.util.ItemUtil;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Wand {

    // Currently wand length and flexibility are unused
    public static ItemStack getWand(WandType wandType, WandCore wandCore, WandWood wandWood) {
        ItemStack item = new ItemStack(wandType.getMaterial());
        ItemUtil.setDefaultData(item, ChatColor.GOLD + "Wand",wandType.getCustomModelData());

        // Modify the Item Meta
        ItemMeta meta = item.getItemMeta();
        meta.setMaxStackSize(1);
        List<String> lore = List.of(
            ChatColor.GOLD + wandCore.getDisplay() + " and " + wandWood.getDiplayName()
        );
        meta.setLore(lore);
        item.setItemMeta(meta);

        NBT.modify(item, nbt->{
            nbt.setBoolean("isWand",true);
            nbt.setString("sub_category","wand");
            nbt.setString("wandWood", wandWood.name());
            nbt.setString("wandCore", wandCore.name());
        });

        return item;
    }

}
