package com.mineshaft.mineshaftAHardcodedItemPort.items;

import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.Container;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.drinks.DrinkManager;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.drinks.Drinks;
import com.mineshaft.mineshaftapi.nbtapi.NBT;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Consumable;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SuspiciousStewMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemLotr {

    public static ItemStack getItem(String name, String type) {

        if(DrinkManager.getPossibleContainers(DrinkManager.getDrink(name)).isEmpty()) {
            // CONTAINER DOES NOT EXIST
            return new ItemStack(Material.BEDROCK);
        }

        if(name.equalsIgnoreCase("ent_draught")) {
            return getEntDraught(type);
        }

        ItemStack item;
        ArrayList<PotionEffect> potionEffects = new ArrayList<>();

        Container container = Container.BOTTLE;
        if(type!=null) {
            for (Container element : Container.values()) {
                if (element.name().equalsIgnoreCase(name)) {
                    container = element;
                }
            }
        }
        Drinks drink = DrinkManager.getDrink(name);
        int modelData=drink.getContainerModelData(container);

        switch(container) {
            case BOWL:
                item=new ItemStack(Material.SUSPICIOUS_STEW);
                break;
            case TANKARD, BOTTLE:
                item=new ItemStack(Material.POTION);
                PotionMeta meta1 = (PotionMeta) item.getItemMeta();
                assert meta1 != null;
                meta1.setColor(Color.fromRGB(255,255,255));
                item.setItemMeta(meta1);
                break;
            default:
                item=new ItemStack(Material.POTION);
                break;
        }

        if(name.equals("athelas")) {
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.WHITE + "Athelas Brew");
            NBT.modify(item, nbt -> {
                nbt.setString("Potion", "Athelas");
            });
            potionEffects.add(new PotionEffect(PotionEffectType.REGENERATION, 1200, 0, false, false, true));
            potionEffects.add(new PotionEffect(PotionEffectType.STRENGTH, 2400, 0, false, false, true));
            item.setItemMeta(meta);
        } else if(name.equals("orc_draught")) {
            ItemMeta meta = item.getItemMeta();
            assert meta != null;
            potionEffects.add(new PotionEffect(PotionEffectType.SPEED, 60, 0, false, false, true));
            potionEffects.add(new PotionEffect(PotionEffectType.STRENGTH, 60, 0, false, false, true));
            meta.setDisplayName(ChatColor.WHITE + "Orc Draught");
            item.setItemMeta(meta);
            NBT.modify(item, nbt -> {
                nbt.setString("Potion", "Orc_draught");
            });
        } else if(name.equals("ale")) {
            ItemMeta meta = item.getItemMeta();
            assert meta != null;
            meta.setDisplayName(ChatColor.WHITE + "Ale");
            item.setItemMeta(meta);
            NBT.modify(item, nbt -> {
                nbt.setString("Potion", "Ale");
            });
        } else if(name.equals("miruvor")) {
            ItemMeta miruvorMeta = item.getItemMeta();
            assert miruvorMeta != null;
            potionEffects.add(new PotionEffect(PotionEffectType.SPEED, 800, 0, false, false, true));
            potionEffects.add(new PotionEffect(PotionEffectType.STRENGTH, 800, 0, false, false, true));
            miruvorMeta.setDisplayName(ChatColor.WHITE + "Miruvor");
            item.setItemMeta(miruvorMeta);
            NBT.modify(item, nbt -> {
                nbt.setString("Potion", "Miruvor");
            });
        } else {
            return null;
        }

        switch (container) {
            case BOWL:
                // if it is a bowl
                SuspiciousStewMeta suspiciousStewMeta = (SuspiciousStewMeta) item.getItemMeta();
                for (PotionEffect effect : potionEffects) {
                    suspiciousStewMeta.addCustomEffect(effect, true);
                }
                suspiciousStewMeta.setCustomModelData(modelData);
                item.setItemMeta(suspiciousStewMeta);
                break;
            default:
                // if is not a bowl
                PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
                for (PotionEffect effect : potionEffects) {
                    potionMeta.addCustomEffect(effect, true);
                }
                potionMeta.setCustomModelData(modelData);
                item.setItemMeta(potionMeta);
                break;
        }

        Container finalContainer = container;
        NBT.modify(item, nbt -> {
            nbt.setString("Drink", drink.name().toLowerCase());
            nbt.setString("Container", finalContainer.name().toLowerCase());
        });

        Consumable c = item.getData(DataComponentTypes.CONSUMABLE);
        assert c != null;
        float eatTime = 1.0f;
        Consumable c1 = Consumable.consumable().consumeSeconds(eatTime).animation(c.animation()).addEffects(c.consumeEffects()).hasConsumeParticles(c.hasConsumeParticles()).sound(c.sound()).build();
        item.setData(DataComponentTypes.CONSUMABLE, c1);

        return item;
    }

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
                return null;
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
