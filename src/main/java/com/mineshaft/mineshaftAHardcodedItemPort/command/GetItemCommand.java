package com.mineshaft.mineshaftAHardcodedItemPort.command;

import com.mineshaft.mineshaftAHardcodedItemPort.manager.Container;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.DrinkManager;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.Drinks;
import de.tr7zw.nbtapi.NBT;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SuspiciousStewMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GetItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!sender.hasPermission("mineshaft.gethardcodeditem")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
        } else if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
        }
        Player player = (Player) sender;

        if((args.length==1 || args.length==2) && DrinkManager.isDrink(args[0])) {

            if(DrinkManager.getPossibleContainers(DrinkManager.getDrink(args[0])).isEmpty()) {
                player.sendMessage(ChatColor.RED + "The drink container does not exist for this drink!");
                return false;
            }

            ItemStack item;
            ArrayList<PotionEffect> potionEffects = new ArrayList<>();

            Container container = Container.BOTTLE;
            if(args.length==2) {
                for (Container element : Container.values()) {
                    if (element.name().equalsIgnoreCase(args[1])) {
                        container = element;
                    }
                }
            }
            Drinks drink = DrinkManager.getDrink(args[0]);
            int modelData=0;

            switch(container) {
                case BOWL:
                    item = new ItemStack(Material.BOWL);
                    modelData = drink.getBowlModelData();
                    break;
                case TANKARD:
                    item=new ItemStack(Material.POTION);
                    PotionMeta meta1 = (PotionMeta) item.getItemMeta();
                    meta1.setColor(Color.fromRGB(255,255,255));
                    item.setItemMeta(meta1);
                    modelData=drink.getTankardModelData();
                    break;
                case BOTTLE:
                    item=new ItemStack(Material.POTION);
                    PotionMeta meta2 = (PotionMeta) item.getItemMeta();
                    meta2.setColor(Color.fromRGB(255,255,255));
                    item.setItemMeta(meta2);
                    modelData=drink.getBottleModelData();
                    break;
                default:
                    item=new ItemStack(Material.POTION);
                    break;
            }

            if(args[0].equals("athelas")) {
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(ChatColor.WHITE + "Athelas Brew");
                NBT.modify(item, nbt -> {
                    nbt.setString("Potion", "Athelas");
                });
                potionEffects.add(new PotionEffect(PotionEffectType.REGENERATION, 1200, 0, false, false, true));
                potionEffects.add(new PotionEffect(PotionEffectType.STRENGTH, 2400, 0, false, false, true));
                item.setItemMeta(meta);
            } else if(args[0].equals("orc_draught")) {
                ItemMeta meta = item.getItemMeta();
                assert meta != null;
                potionEffects.add(new PotionEffect(PotionEffectType.SPEED, 60, 0, false, false, true));
                potionEffects.add(new PotionEffect(PotionEffectType.STRENGTH, 60, 0, false, false, true));
                meta.setDisplayName(ChatColor.WHITE + "Orc Draught");
                item.setItemMeta(meta);
                NBT.modify(item, nbt -> {
                    nbt.setString("Potion", "Orc_draught");
                });
            } else if(args[0].equals("ale")) {
                ItemMeta meta = item.getItemMeta();
                assert meta != null;
                meta.setDisplayName(ChatColor.WHITE + "Ale");
                item.setItemMeta(meta);
                NBT.modify(item, nbt -> {
                    nbt.setString("Potion", "Ale");
                });
            } else if(args[0].equals("miruvor")) {
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
                player.sendMessage(ChatColor.RED + "Invalid arguments!");
                return false;
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

            player.getInventory().addItem(item);
        }

        if(args.length==2) {
            if(args[0].equals("ent_draught")) {
                ItemStack entDrink = new ItemStack(Material.SUSPICIOUS_STEW);
                SuspiciousStewMeta entDrinkMeta = (SuspiciousStewMeta) entDrink.getItemMeta();
                entDrinkMeta.setDisplayName(ChatColor.WHITE + args[1].substring(0,1).toUpperCase() + args[1].substring(1) + " Ent Draught");

                switch(args[1]) {
                    case "blue":
                        entDrinkMeta.addCustomEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 3000, 0, false, false, true),false);
                        entDrinkMeta.setCustomModelData(3);
                        entDrinkMeta.setLore(List.of(ChatColor.GRAY + "Used by divers... if they can afford it"));
                        break;
                    case "silver":
                        entDrinkMeta.addCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 3600, 0, false, false, true),false);
                        entDrinkMeta.setCustomModelData(4);
                        entDrinkMeta.setLore(Collections.singletonList(ChatColor.GRAY + "Has carrots, for better night vision."));
                        break;
                    case "yellow":
                        entDrinkMeta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200, 0, false, false, true),false);
                        entDrinkMeta.setCustomModelData(5);
                        entDrinkMeta.setLore(Collections.singletonList(ChatColor.GRAY + "Has mysterious healing properties..."));
                        break;
                    case "brown":
                        entDrinkMeta.setCustomModelData(6);
                        entDrinkMeta.setLore(Collections.singletonList(ChatColor.GRAY + "A hearty meal..."));
                        break;
                    case "red":
                        entDrinkMeta.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 0, false, false, true),false);
                        entDrinkMeta.setCustomModelData(7);
                        entDrinkMeta.setLore(Collections.singletonList(ChatColor.GRAY + "Said to put out any flames near the drinker."));
                        break;
                    case "gold":
                        entDrinkMeta.setCustomModelData(8);
                        entDrinkMeta.setLore(Collections.singletonList(ChatColor.GRAY + "Drunk by ents going into combat..."));
                        break;
                    case "green":
                        entDrinkMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 2400, 1, false, false, true),false);
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
                    nbt.setString("Potion", "EntDraught_" + args[1]);
                });
                player.getInventory().addItem(entDrink);

            } else if(args[0].equals("teleport_scroll")) {
                // TODO:
            }
        }

        return false;
    }
}
