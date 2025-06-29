package com.mineshaft.mineshaftAHardcodedItemPort.items;

import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.Container;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.ContainerUtil;
import com.mineshaft.mineshaftapi.util.ItemUtil;
import com.mineshaft.mineshaftapi.util.formatter.TextFormatter;
import io.papermc.paper.datacomponent.DataComponentTypes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public enum FoodItemXL {

    /**
     * Missing items:
     * chocolate cake
     * chocolate cookie cake
     * cheese cake
     * nether cake
     * strawberry cake
     * pumpkin cake
     * pizza
     * all plants
     * rock salt and rock salt ore (rock salt added separately)
     * */

    /**
     * Default values:
     * nutrition: 1
     * saturation: 0.6
     * eat time: 1.6
     * container: no container
     * */

    // Item order taken from mod.

    RICE(Material.APPLE, 2),
    BUTTER_RICE(Material.APPLE, 6, 4, 0.6f),
    FRIED_RICE(Material.APPLE, 5, 3, 0.6f),

    PEPPER(Material.APPLE,7),
    RAW_CORN(Material.APPLE,8),
    CORN(Material.APPLE,9),
    CUCUMBER(Material.APPLE,10),
    LETTUCE(Material.APPLE,11),
    ONION(Material.APPLE,12),
    TOMATO(Material.APPLE,  1),
    STRAWBERRY(Material.APPLE,13),

    DOUGH(Material.APPLE,14),
    COOKED_DOUGH(Material.APPLE,15,2,1.2f),
    CROUTON(Material.APPLE,16,1,1.2f),
    BUTTER(Material.APPLE,17),
    CHEESE(Material.APPLE,18),
    CHEESE_PUFF(Material.APPLE,19),
    CHIPS(Material.APPLE,20),
    SALTY_CHIPS(Material.APPLE,21,1,1.2f),
    SPICY_CHIPS(Material.APPLE,22,1,1.2f),
    ONION_RINGS(Material.APPLE, 3, 2, 1.2f),
    CHEESY_BREAD(Material.APPLE,23,6),
    POTATO_BREAD(Material.APPLE,24, 6),
    CORN_BREAD(Material.APPLE,25, 8),
    RICE_BREAD(Material.APPLE,26, 5),
    BAGUETTE(Material.APPLE,27, 5),
    FRIED_EGG(Material.APPLE,28, 3),
    PANCAKE(Material.APPLE,29, 5),
    WAFFLE(Material.APPLE,30, 5),
    MACARONI_AND_CHEESE(Material.SUSPICIOUS_STEW,12, 9, Container.CERAMIC_BOWL), // IN BOWL

    SPAGHETTI(Material.SUSPICIOUS_STEW,13,9,Container.CERAMIC_BOWL),
    ENCHILADA(Material.APPLE,31,9),
    LASAGNE(Material.APPLE,32,12),
    JAMBON_BEURRE(Material.APPLE,33,15,0.4f),

    FLESH(Material.COOKED_BEEF,1,4,0.2f),
    HAM(Material.COOKED_BEEF,2,4),
    SAUSAGE(Material.COOKED_BEEF,3,3,1.2f),
    BACON(Material.COOKED_BEEF,4,3,1.2f),
    BEEF_JERKY(Material.COOKED_BEEF,5,3),
    GROUND_BEEF(Material.COOKED_BEEF,6,4,1.2f),
    RAW_CHICKEN_WING(Material.COOKED_BEEF,7,1),
    COOKED_CHICKEN_WING(Material.COOKED_BEEF,8,4,1.2f),
    SPICY_CHICKEN_WING(Material.COOKED_BEEF,9,4,1.4f),
    BUCKET_OF_FRIED_CHICKEN(Material.SUSPICIOUS_STEW,14,6, Container.BUCKET),

    TOP_BUN(Material.APPLE, 34, 4),
    BOTTOM_BUN(Material.APPLE, 35, 4),
    HAMBURGER(Material.APPLE, 36, 9),
    CHICKEN_BURGER(Material.APPLE, 37, 9),
    CHEESEBURGER(Material.APPLE, 38, 10),
    HOT_DOG(Material.APPLE, 39, 8),
    SAUSAGE_ROLL(Material.APPLE, 40, 7),
    SLICE_OF_PIZZA(Material.APPLE, 41, 7),
    TORTILLA(Material.APPLE, 42, 4),
    TACO(Material.APPLE, 43, 7),
    BURRITO(Material.APPLE, 44, 7),
    KEBAB(Material.APPLE, 45, 12, 0.4f),

    CHICKEN_SANDWICH(Material.APPLE, 46, 10),
    BLT_SANDWITCH(Material.APPLE, 47, 12),
    BREAKFAST_SANDWITCH(Material.APPLE, 48, 8),
    GRILLED_CHEESE_SANDWITCH(Material.APPLE, 49, 11, 0.4f),
    ICE_CREAM_SANDWITCH(Material.APPLE, 50, 6),

    // Half eat time for seaweed
    SEAWEED(Material.APPLE,51, 0, 0.2f, 0.8f),
    FUTOMAKI(Material.COD,1, 4),
    URAMAKI(Material.COD,2, 9, 0.4f),
    OSHIZUSHI(Material.COD,3, 12, 0.2f),

    GARDEN_SALAD(Material.SUSPICIOUS_STEW, 15, 5, Container.CERAMIC_BOWL),
    CHICKEN_SALAD(Material.SUSPICIOUS_STEW, 16, 8, Container.CERAMIC_BOWL),
    CAESAR_SALAD(Material.SUSPICIOUS_STEW, 17, 6, Container.CERAMIC_BOWL),
    ONION_SALAD(Material.SUSPICIOUS_STEW, 18, 4, Container.CERAMIC_BOWL),
    TACO_SALAD(Material.SUSPICIOUS_STEW, 19, 10, Container.CERAMIC_BOWL),

    CUCUMBER_SOUP(Material.SUSPICIOUS_STEW, 20, 6, 0.6f, 1.0f, Container.CERAMIC_BOWL),
    TOMATO_SOUP(Material.SUSPICIOUS_STEW, 21, 3, 0.6f, 1.0f, Container.CERAMIC_BOWL),
    VEGETABLE_SOUP(Material.SUSPICIOUS_STEW, 22, 8, 0.6f, 1.0f, Container.CERAMIC_BOWL),
    CHICKEN_SOUP(Material.SUSPICIOUS_STEW, 23, 10, 0.6f, 1.0f, Container.CERAMIC_BOWL),
    BEEF_STEW(Material.SUSPICIOUS_STEW, 24, 12, 0.6f, 1.0f, Container.CERAMIC_BOWL),
    PUMPKIN_STEW(Material.SUSPICIOUS_STEW, 25, 6, 0.6f, 1.0f, Container.CERAMIC_BOWL),

    CARAMEL_APPLE(Material.APPLE, 4, 6),
    MARSHMALLOW(Material.APPLE, 52,1),
    ROASTED_MARSHMALLOW(Material.APPLE,53,2),
    CHOCOLATE_COOKIE(Material.APPLE,54,3),
    VANILLA_COOKIE(Material.APPLE,55,4),
    BROWNIE(Material.APPLE,56,3),
    BOURBON_BISCUIT(Material.APPLE,57,3),
    CHOCOLATE(Material.APPLE,58,1),
    CHOCOLATE_ICE_CREAM_BALL(Material.APPLE,59,0,0),
    VANILLA_ICE_CREAM_BALL(Material.APPLE,60,0,0),
    STRAWBERRY_ICE_CREAM_BALL(Material.APPLE,61,0,0),
    ICE_CREAM_CONE(Material.APPLE,62,3,1.2f),
    CHOCOLATE_ICE_CREAM(Material.APPLE,63,4),
    VANILLA_ICE_CREAM(Material.APPLE,64,4),
    STRAWBERRY_ICE_CREAM(Material.APPLE,65,4),
    CRESCENT_ROLL(Material.APPLE,66,6),
    DONUT(Material.APPLE,67,4),
    SUGAR_DONUT(Material.APPLE,68,5),
    CHOCOLATE_DONUT(Material.APPLE,69,5),
    VANILLA_DONUT(Material.APPLE,70,5),

    VANILLA_CUPCAKE(Material.APPLE, 71,2, Container.PAPER_CUP),
    CHOCOLATE_CUPCAKE(Material.APPLE,72,3, Container.PAPER_CUP),
    CHOCOLATE_COOKIE_CUPCAKE(Material.APPLE,73,5, Container.PAPER_CUP),
    STRAWBERRY_CUPCAKE(Material.APPLE,74,3, Container.PAPER_CUP),

    PIE_SHELL(Material.PUMPKIN_PIE,9,0,0),
    APPLE_PIE(Material.PUMPKIN_PIE,1,8),
    GOLDEN_APPLE_PIE(Material.PUMPKIN_PIE,8,8),
    CHEESE_PIE(Material.PUMPKIN_PIE,2,8),
    CHICKEN_POT_PIE(Material.PUMPKIN_PIE,5,8),
    CHOCOLATE_PIE(Material.PUMPKIN_PIE,7,8),
    BACON_PIE(Material.PUMPKIN_PIE,3,8),
    FISH_PIE(Material.PUMPKIN_PIE,4,8),
    STRAWBERRY_PIE(Material.PUMPKIN_PIE,5,8),

    TOMATO_SAUCE(Material.APPLE,75,0,0),
    HOT_SAUCE(Material.APPLE,76,0,0),
    CHOCOLATE_SYRUP(Material.APPLE,77,0,0),
    VANILLA_EXTRACT(Material.APPLE,78,0,0),
    VANILLA_CREAM(Material.APPLE,79,0,0),

    SPEEDY_ENERGY_DRINK(Material.POTION,6,0,0.05f, 1.0f, Container.CAN, List.of(
            new PotionEffect(PotionEffectType.SPEED,500,0,false,false),
            new PotionEffect(PotionEffectType.HASTE,500,2,false,false)
    )),
    HEALTHY_ENERGY_DRINK(Material.POTION,5,0,0.05f,1.0f, Container.CAN, List.of(
            new PotionEffect(PotionEffectType.REGENERATION,600,0,false,false)
    )),
    STEALTHY_ENERGY_DRINK(Material.POTION,7,0,0.05f,1.0f, Container.CAN, List.of(
            new PotionEffect(PotionEffectType.SPEED,2400,0,false,false),
            new PotionEffect(PotionEffectType.NIGHT_VISION,2400,0,false,false),
            new PotionEffect(PotionEffectType.INVISIBILITY,2400,0,false,false)
    )),
    STRONG_ENERGY_DRINK(Material.POTION,8,0,0.05f,1.0f, Container.CAN, List.of(
            new PotionEffect(PotionEffectType.STRENGTH,2400,1,false,false),
            new PotionEffect(PotionEffectType.FIRE_RESISTANCE,2400,1,false,false)
            )),
    DEADLY_ENERGY_DRINK(Material.POTION,4,0,0.05f,1.0f, Container.CAN,List.of(
            new PotionEffect(PotionEffectType.POISON,1200,0,false,false)
            )),
    SUPER_ENERGY_DRINK(Material.POTION,9,0,0.05f,1.0f, Container.CAN, List.of(
            new PotionEffect(PotionEffectType.SPEED,3600,2,false,false),
            new PotionEffect(PotionEffectType.SPEED,3600,0,false,false),
            new PotionEffect(PotionEffectType.SPEED,3600,0,false,false),
            new PotionEffect(PotionEffectType.SPEED,3600,2,false,false),
            new PotionEffect(PotionEffectType.SPEED,3600,0,false,false),
            new PotionEffect(PotionEffectType.SPEED,3600,1,false,false),
            new PotionEffect(PotionEffectType.SPEED,3600,1,false,false),
            new PotionEffect(PotionEffectType.SPEED,3600,2,false,false)
            )),

    BEER(Material.POTION,10,1,0.2f,1.0f,Container.GLASS_MUG,List.of(
            new PotionEffect(PotionEffectType.NAUSEA,100,1,false,false)
    )),
    COFFEE(Material.POTION, 19,1,0.2f,Container.COFFEE_CUP),
    CAPPUCCINO(Material.POTION,20,2,0.2f,Container.COFFEE_CUP),

    // New 1.16.5 official mod items

    LEMON(Material.APPLE, 80),
    PINEAPPLE(Material.APPLE, 81),

    LEMON_SYRUP(Material.POTION, 27,2,0.2f,1.0f),
    STRAWBERRY_SYRUP(Material.POTION, 28,2,0.2f,1.0f),
    PINEAPPLE_SYRUP(Material.POTION,29,2,0.2f,1.0f),

    LEMON_JUICE(Material.POTION,21,2,0.2f,1.0f),
    STRAWBERRY_JUICE(Material.POTION,22,2,0.2f,1.0f),
    PINEAPPLE_JUICE(Material.POTION,23,2,0.2f,1.0f),
    LEMON_SLUSHIE(Material.POTION,24,3,0.4f,1.0f),
    STRAWBERRY_SLUSHIE(Material.POTION,25,3,0.4f,1.0f),
    PINEAPPLE_SLUSHIE(Material.POTION,26,3,0.4f,1.0f),

    ;

    private final Material material;
    private final int customModelData;
    private final int nutrition;
    private final float saturation;
    private final float eatTimeSeconds;
    private final List<PotionEffect> potionEffects;
    private Container container;

    FoodItemXL(Material material, int customModelData, int nutrition, float saturation, float eatTimeSeconds, Container container, List<PotionEffect> potionEffectList) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=eatTimeSeconds;
        this.container=container;
        potionEffects = potionEffectList;
    }

    FoodItemXL(Material material, int customModelData, int nutrition, float saturation, float eatTimeSeconds, Container container) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=eatTimeSeconds;
        this.container=container;
        potionEffects = List.of();
    }

    FoodItemXL(Material material, int customModelData, int nutrition, float saturation, Container container) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=1.6f;
        this.container=container;
        potionEffects = List.of();
    }

    FoodItemXL(Material material, int customModelData, int nutrition, float saturation, float eatTimeSeconds) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=eatTimeSeconds;
        container=null;
        potionEffects = List.of();
    }

    FoodItemXL(Material material, int customModelData, int nutrition, float saturation) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=saturation;
        this.eatTimeSeconds=getDefaultEatTimeInSeconds();
        this.container=null;
        potionEffects = List.of();
    }

    FoodItemXL(Material material, int customModelData, int nutrition, Container container) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=0.6f;
        this.eatTimeSeconds=getDefaultEatTimeInSeconds();
        this.container=container;
        potionEffects = List.of();
    }

    FoodItemXL(Material material, int customModelData, int nutrition) {
        this.material=material;
        this.customModelData=customModelData;
        this.nutrition=nutrition;
        this.saturation=0.6f;
        this.eatTimeSeconds=getDefaultEatTimeInSeconds();
        this.container=container;
        this.potionEffects=List.of();
    }

    FoodItemXL(Material material, int customModelData) {
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

    public static FoodItemXL getFoodItemXL(String name) {
        return FoodItemXL.valueOf(name.toUpperCase());
    }


}
