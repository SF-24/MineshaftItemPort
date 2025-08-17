package com.mineshaft.mineshaftAHardcodedItemPort.items;

import com.mineshaft.mineshaftAHardcodedItemPort.items.chocolate_frog_card.ChocolateFrogCard;
import com.mineshaft.mineshaftAHardcodedItemPort.items.chocolate_frog_card.ChocolateFrogCardType;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.Container;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.ContainerUtil;
import com.mineshaft.mineshaftapi.nbtapi.NBT;
import com.mineshaft.mineshaftapi.util.ItemUtil;
import com.mineshaft.mineshaftapi.util.formatter.TextFormatter;
import io.papermc.paper.datacomponent.DataComponentTypes;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BundleMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum FoodItem {
    CHOCOLATE_GLAZED_BERRIES(Material.APPLE,87, 6,8.0f),
    CHOCOLATE_FROG(Material.APPLE,85,3),
    CHOCOLATE_FROG_PACKAGED_OPENED(Material.BUNDLE,1),
    CHOCOLATE_FROG_PACKAGED(Material.IRON_INGOT,16),
    CHOCOLATE_FROG_SPECIAL_PACKAGED_OPENED(Material.BUNDLE,1),
    CHOCOLATE_FROG_SPECIAL_PACKAGED(Material.IRON_INGOT,16),

            ;

    @Getter
    private final Material material;
    private final int customModelData;
    private final int nutrition;
    private final float saturation;
    private final float eatTimeSeconds;
    private final List<PotionEffect> potionEffects;
    private Container container;

    FoodItem(Material material, int customModelData, int nutrition, float saturation, float eatTimeSeconds, Container container, List<PotionEffect> potionEffectList) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=eatTimeSeconds;
        this.container=container;
        potionEffects = potionEffectList;
    }

    FoodItem(Material material, int customModelData, int nutrition, float saturation, float eatTimeSeconds, Container container) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=eatTimeSeconds;
        this.container=container;
        potionEffects = List.of();
    }

    FoodItem(Material material, int customModelData, int nutrition, float saturation, Container container) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=1.6f;
        this.container=container;
        potionEffects = List.of();
    }

    FoodItem(Material material, int customModelData, int nutrition, float saturation, float eatTimeSeconds) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=eatTimeSeconds;
        container=null;
        potionEffects = List.of();
    }

    FoodItem(Material material, int customModelData, int nutrition, float saturation) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=getDefaultEatTimeInSeconds();
        this.container=null;
        potionEffects = List.of();
    }

    FoodItem(Material material, int customModelData, int nutrition, Container container) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=0.6f;
        this.eatTimeSeconds=getDefaultEatTimeInSeconds();
        this.container=container;
        potionEffects = List.of();
    }

    FoodItem(Material material, int customModelData, int nutrition) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=0.6f;
        this.eatTimeSeconds=getDefaultEatTimeInSeconds();
        this.container=container;
        this.potionEffects=List.of();
    }

    FoodItem(Material material, int customModelData) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=1;
        this.saturation=0.6f;
        this.eatTimeSeconds=getDefaultEatTimeInSeconds();
        this.container=null;
        potionEffects = List.of();
    }

    public float getDefaultEatTimeInSeconds() {
//        if(material.equals(Material.SUSPICIOUS_STEW)||material.equals(Material.RABBIT_STEW)||material.equals(Material.MUSHROOM_STEW)||material.equals(Material.BEETROOT_SEEDS)) {
//            return 1.0f;
//        }
        return 1.6f;
    }

    public ItemStack getItem() {
        return getItem(1);
    }

    public ItemStack getItem(int amount) {
        switch (this) {
            case CHOCOLATE_FROG_PACKAGED_OPENED -> {
                ItemStack item = new ItemStack(Material.BUNDLE);
                BundleMeta meta = (BundleMeta) item.getItemMeta();
                meta.addItem(CHOCOLATE_FROG.getItem());
                meta.addItem(ChocolateFrogCard.getRandomCard(1,new ArrayList<>()));
                meta.setCustomModelData(1);
                meta.setMaxStackSize(1);
                meta.setDisplayName(ChatColor.WHITE + "Chocolate Frog");
                item.setItemMeta(meta);
                return item;
            }
            case CHOCOLATE_FROG_PACKAGED -> {
                ItemStack item = new ItemStack(Material.IRON_INGOT);
                ItemMeta meta = item.getItemMeta();
                meta.setCustomModelData(16);
                meta.setMaxStackSize(1);
                meta.setDisplayName(ChatColor.WHITE + "Chocolate Frog");
                meta.setLore(Collections.singletonList(ChatColor.GRAY+"Right click to open"));
                item.setItemMeta(meta);
                NBT.modify(item, nbt->{
                    nbt.setString("onInteract","openChocolateFrog");
                });
                return item;
            }
            case CHOCOLATE_FROG_SPECIAL_PACKAGED_OPENED -> {
                ItemStack item = new ItemStack(Material.BUNDLE);
                BundleMeta meta = (BundleMeta) item.getItemMeta();
                meta.addItem(CHOCOLATE_FROG.getItem());
                meta.addItem(ChocolateFrogCard.getRandomCard(1, new ArrayList<>(Arrays.asList(ChocolateFrogCardType.EVENT,ChocolateFrogCardType.CRYSTAL,ChocolateFrogCardType.GOLD))));
                meta.setCustomModelData(2);
                meta.setMaxStackSize(1);
                meta.setDisplayName(ChatColor.WHITE + "Chocolate Frog");
                item.setItemMeta(meta);
                return item;
            }
            case CHOCOLATE_FROG_SPECIAL_PACKAGED -> {
                ItemStack item = new ItemStack(Material.IRON_INGOT);
                ItemMeta meta = item.getItemMeta();
                meta.setCustomModelData(17);
                meta.setMaxStackSize(1);
                meta.setDisplayName(ChatColor.WHITE + "Chocolate Frog");
                meta.setLore(Collections.singletonList(ChatColor.GRAY+"Right click to open"));
                item.setItemMeta(meta);
                NBT.modify(item, nbt->{
                    nbt.setString("onInteract","openChocolateFrogSpecial");
                });
                return item;
            }
            default -> {
                ItemStack foodItem = new ItemStack(material);
                ItemUtil.setDefaultData(foodItem, TextFormatter.capitaliseStringFully(this.name().toLowerCase().replace("_"," ")),customModelData);
                if(nutrition>0||saturation>0) {
                    if(container!=null) {
                        if (container.equals(Container.BOTTLE) || container.equals(Container.GLASS_MUG) || container.equals(Container.COFFEE_CUP) || container.equals(Container.TANKARD)) {
                            ItemUtil.setDefaultFood(foodItem, nutrition, saturation, eatTimeSeconds, true, true);
                        } else {
                            ItemUtil.setDefaultFood(foodItem, nutrition, saturation, eatTimeSeconds, false, false);
                        }
                    }
                    if(material.equals(Material.POTION)) {
                        PotionMeta meta = (PotionMeta) foodItem.getItemMeta();
                        for(PotionEffect potionEffect : potionEffects) {
                            meta.addCustomEffect(potionEffect,true);
                        }
                        foodItem.setItemMeta(meta);
                    }

                    // Set container
                    if(container!=null) {
                        ContainerUtil.setContainer(foodItem, container);
                    }
                } else {
                    foodItem.unsetData(DataComponentTypes.CONSUMABLE);
                }
                if(material.equals(Material.SUSPICIOUS_STEW)||material.equals(Material.RABBIT_STEW)||material.equals(Material.MUSHROOM_STEW)||material.equals(Material.BEETROOT_SEEDS)) {
                    ItemMeta meta = foodItem.getItemMeta();
                    meta.setMaxStackSize(8);
                    foodItem.setItemMeta(meta);
                }
                foodItem.setAmount(amount);
                return foodItem;
            }
        }
    }

    public static FoodItem getFoodItem(String name) {
        return FoodItem.valueOf(name.toUpperCase());
    }

}
