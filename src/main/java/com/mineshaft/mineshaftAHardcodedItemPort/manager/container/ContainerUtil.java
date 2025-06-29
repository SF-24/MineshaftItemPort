package com.mineshaft.mineshaftAHardcodedItemPort.manager.container;

import com.mineshaft.mineshaftapi.nbtapi.NBT;
import org.bukkit.inventory.ItemStack;

public class ContainerUtil {

    public static void getContainer(ItemStack item) {
        NBT.get(item, nbt -> {
            nbt.getString("Container");
        });
    }

    public static void setContainer(ItemStack item, Container container) {
        NBT.modify(item, nbt -> {
            nbt.setString("Container", container.name().toLowerCase());
        });
    }

}
