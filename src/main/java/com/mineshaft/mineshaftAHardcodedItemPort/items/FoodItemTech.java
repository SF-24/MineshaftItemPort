package com.mineshaft.mineshaftAHardcodedItemPort.items;

import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.Container;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.ContainerUtil;
import com.mineshaft.mineshaftapi.util.item.ItemUtil;
import com.mineshaft.mineshaftapi.util.formatter.TextFormatter;
import io.papermc.paper.datacomponent.DataComponentTypes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

import java.util.List;

public enum FoodItemTech {

    CHOCOLATE_BAR(Material.APPLE,86,6,0.3f)
    ;

    private final Material material;
    private final int customModelData;
    private final int nutrition;
    private final float saturation;
    private final float eatTimeSeconds;
    private final List<PotionEffect> potionEffects;
    private Container container;

    FoodItemTech(Material material, int customModelData, int nutrition, float saturation, float eatTimeSeconds, Container container, List<PotionEffect> potionEffectList) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=eatTimeSeconds;
        this.container=container;
        potionEffects = potionEffectList;
    }

    FoodItemTech(Material material, int customModelData, int nutrition, float saturation, float eatTimeSeconds, Container container) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=eatTimeSeconds;
        this.container=container;
        potionEffects = List.of();
    }

    FoodItemTech(Material material, int customModelData, int nutrition, float saturation, Container container) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=1.6f;
        this.container=container;
        potionEffects = List.of();
    }

    FoodItemTech(Material material, int customModelData, int nutrition, float saturation, float eatTimeSeconds) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=eatTimeSeconds;
        container=Container.NULL;
        potionEffects = List.of();
    }

    FoodItemTech(Material material, int customModelData, int nutrition, float saturation) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=getDefaultEatTimeInSeconds();
        this.container=Container.NULL;
        potionEffects = List.of();
    }

    FoodItemTech(Material material, int customModelData, int nutrition, Container container) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=0.6f;
        this.eatTimeSeconds=getDefaultEatTimeInSeconds();
        this.container=container;
        potionEffects = List.of();
    }

    FoodItemTech(Material material, int customModelData, int nutrition) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=0.6f;
        this.eatTimeSeconds=getDefaultEatTimeInSeconds();
        this.container=container;
        this.potionEffects=List.of();
    }

    FoodItemTech(Material material, int customModelData) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=1;
        this.saturation=0.6f;
        this.eatTimeSeconds=getDefaultEatTimeInSeconds();
        this.container=null;
        potionEffects = List.of();
    }

    public Material getMaterial() {return material;}

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
        ItemStack xlItem = new ItemStack(material);
        ItemUtil.setDefaultData(xlItem, TextFormatter.capitaliseStringFully(this.name().toLowerCase().replace("_"," ")),customModelData);
        if(nutrition>0||saturation>0) {
            if(container!=null) {
                if (container.equals(Container.BOTTLE) || container.equals(Container.GLASS_MUG) || container.equals(Container.COFFEE_CUP) || container.equals(Container.TANKARD)) {
                    ItemUtil.setDefaultFood(xlItem, nutrition, saturation, eatTimeSeconds, true, true);
                } else {
                    ItemUtil.setDefaultFood(xlItem, nutrition, saturation, eatTimeSeconds, false, false);
                }
            } else {
                ItemUtil.setDefaultFood(xlItem, nutrition, saturation, eatTimeSeconds, false, false);
            }

            if(material.equals(Material.POTION)) {
                PotionMeta meta = (PotionMeta) xlItem.getItemMeta();
                for(PotionEffect potionEffect : potionEffects) {
                    meta.addCustomEffect(potionEffect,true);
                }
                xlItem.setItemMeta(meta);
            }

            // Set container
            if(container!=null) {
                ContainerUtil.setContainer(xlItem, container);
            }
        } else {
            xlItem.unsetData(DataComponentTypes.CONSUMABLE);
        }
        if(material.equals(Material.SUSPICIOUS_STEW)||material.equals(Material.RABBIT_STEW)||material.equals(Material.MUSHROOM_STEW)||material.equals(Material.BEETROOT_SEEDS)) {
            ItemMeta meta = xlItem.getItemMeta();
            meta.setMaxStackSize(8);
            xlItem.setItemMeta(meta);
        }
        xlItem.setAmount(amount);
        return xlItem;
    }

    public static FoodItemTech getFoodItemCreate(String name) {
        return FoodItemTech.valueOf(name.toUpperCase());
    }


}
