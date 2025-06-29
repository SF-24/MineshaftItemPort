package com.mineshaft.mineshaftAHardcodedItemPort.items;

import com.mineshaft.mineshaftapi.nbtapi.NBT;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Consumable;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SuspiciousStewMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collections;
import java.util.List;

public class ItemDrink {

    public static ItemStack getEntDraught(String colour) {
        ItemStack entDrink = new ItemStack(Material.SUSPICIOUS_STEW);
        SuspiciousStewMeta entDrinkMeta = (SuspiciousStewMeta) entDrink.getItemMeta();
        entDrinkMeta.setDisplayName(ChatColor.WHITE + colour.substring(0, 1).toUpperCase() + colour.substring(1) + " Ent Draught");

        switch (colour) {
            case "blue":
                entDrinkMeta.addCustomEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 3000, 0, false, false, true), false);
                entDrinkMeta.setCustomModelData(3);
                entDrinkMeta.setLore(List.of(ChatColor.GRAY + "Used by divers... if they can afford it"));
                break;
            case "silver":
                entDrinkMeta.addCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 3600, 0, false, false, true), false);
                entDrinkMeta.setCustomModelData(4);
                entDrinkMeta.setLore(Collections.singletonList(ChatColor.GRAY + "Has carrots, for better night vision."));
                break;
            case "yellow":
                entDrinkMeta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200, 0, false, false, true), false);
                entDrinkMeta.setCustomModelData(5);
                entDrinkMeta.setLore(Collections.singletonList(ChatColor.GRAY + "Has mysterious healing properties..."));
                break;
            case "brown":
                entDrinkMeta.setCustomModelData(6);
                entDrinkMeta.setLore(Collections.singletonList(ChatColor.GRAY + "A hearty meal..."));
                break;
            case "red":
                entDrinkMeta.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 0, false, false, true), false);
                entDrinkMeta.setCustomModelData(7);
                entDrinkMeta.setLore(Collections.singletonList(ChatColor.GRAY + "Said to put out any flames near the drinker."));
                break;
            case "gold":
                entDrinkMeta.setCustomModelData(8);
                entDrinkMeta.setLore(Collections.singletonList(ChatColor.GRAY + "Drunk by ents going into combat..."));
                break;
            case "green":
                entDrinkMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 2400, 1, false, false, true), false);
                entDrinkMeta.setCustomModelData(9);
                entDrinkMeta.setLore(Collections.singletonList(ChatColor.GRAY + "Said to give the drinker a burst of speed."));

                break;
            case "purple":
                entDrinkMeta.setLore(Collections.singletonList(ChatColor.GRAY + "Has even more mysterious healing properties..."));
                entDrinkMeta.setCustomModelData(10);
                break;
            default:
                break;
        }
        entDrink.setItemMeta(entDrinkMeta);
        NBT.modify(entDrink, nbt -> {
            nbt.setString("Potion", "EntDraught_" + colour);
        });
        Consumable c = entDrink.getData(DataComponentTypes.CONSUMABLE);
        assert c != null;
        float eatTime = 1.0f;
        Consumable c1 = Consumable.consumable().consumeSeconds(eatTime).animation(c.animation()).addEffects(c.consumeEffects()).hasConsumeParticles(c.hasConsumeParticles()).sound(c.sound()).build();
        entDrink.setData(DataComponentTypes.CONSUMABLE, c1);
        return entDrink;
    }

}
