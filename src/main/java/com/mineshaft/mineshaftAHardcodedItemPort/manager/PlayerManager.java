package com.mineshaft.mineshaftAHardcodedItemPort.manager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class PlayerManager {

    public static int getEmptyInventorySlots(Player player) {
        int emptySlots = 0;
        for (int i = 9; i <= 44; i++) {
            if (player.getInventory().getItem(i)==null) {
                emptySlots++;
            }
        }
        return emptySlots;
    }

    public static boolean canTakeMoreOfItem(Player player, ItemStack item) {
        int emptySlots = 0;
        for (int i = 9; i <= 44; i++) {
            if ((player.getInventory().getItem(i)==null)) {
                emptySlots++;
            } else if(!(Objects.requireNonNull(player.getInventory().getItem(i)).getAmount()<63) && Objects.requireNonNull(player.getInventory().getItem(i)).getItemMeta().equals(item.getItemMeta())) {
                emptySlots++;
            }
        }
        return getEmptyInventorySlots(player)>0;
    }

    public static void removeOneGlassBottle(Player player) {
        for (int i = 9; i <= 44; i++) {
            if(player.getInventory().getItem(i)!=null) {
                if (player.getInventory().getItem(i).getType().equals(Material.GLASS_BOTTLE) && (player.getInventory().getItem(i).getItemMeta()==null || (!player.getInventory().getItem(i).getItemMeta().hasCustomModelData()))) {
                    ItemStack bottleStack = player.getInventory().getItem(i);
                    bottleStack.setAmount(bottleStack.getAmount()-1);
                    player.getInventory().setItem(i,bottleStack);
                    return;
                }
            }
        }
    }
}
