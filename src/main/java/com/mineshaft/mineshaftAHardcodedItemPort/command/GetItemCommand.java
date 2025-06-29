package com.mineshaft.mineshaftAHardcodedItemPort.command;

import com.dre.brewery.api.BreweryApi;
import com.mineshaft.mineshaftAHardcodedItemPort.items.ItemDrink;
import com.mineshaft.mineshaftAHardcodedItemPort.items.FoodItemXL;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.Container;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.drinks.DrinkManager;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.drinks.Drinks;
import com.mineshaft.mineshaftapi.nbtapi.NBT;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Consumable;
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

import java.util.ArrayList;

public class GetItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!sender.hasPermission("mineshaft.gethardcodeditem")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
        } else if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
        }
        Player player = (Player) sender;

        if(args.length==2 && args[0].equalsIgnoreCase("make_container")) {
            Container containerVar = Container.NULL;
            for(Container container : Container.values()) {
                if(args[1].equalsIgnoreCase(container.name())) {
                    containerVar=container;
                }
            }
            if(containerVar.equals(Container.NULL)) {
                player.sendMessage(ChatColor.RED + "Invalid container");
                return false;
            }
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            if(BreweryApi.isBrew(item)) {
                if(containerVar.equals(Container.TANKARD)) {
                    if(meta instanceof PotionMeta) {
                        meta.setCustomModelData(DrinkManager.getBrewModelData(BreweryApi.getBrew(item), containerVar));
                        //((PotionMeta) meta).setColor(Color.fromRGB(255,255,255));
                    }
                } else {
                    player.sendMessage("Must use 'TANKARD' for brewery items");
                    return false;
                }
            } else if(DrinkManager.isDrink(item)) {
                if(DrinkManager.getDrink(item).getContainerModelData(containerVar)<=0) {
                    player.sendMessage(ChatColor.RED + "Invalid container for this item");
                    return false;
                }
                assert meta != null;
                meta.setCustomModelData(DrinkManager.getDrink(item).getContainerModelData(containerVar));
            }
            item.setItemMeta(meta);
            // Set container NBT data:
            Container finalContainerVar = containerVar;
            NBT.modify(item, nbt -> {
                nbt.setString("Container", finalContainerVar.name().toLowerCase());
            });
            // Update the item.
            player.getInventory().setItemInMainHand(item);
        }

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
                        for (PotionEffect effect : potionEffects) {;
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


            player.getInventory().addItem(item);
        }

        if(args.length==2 || args.length==3) {
            ItemStack item = null;
            if (args[0].equals("ent_draught")) {
                item = (ItemDrink.getEntDraught(args[1]));
            } else if (args[0].equals("xl_food")) {
                item = FoodItemXL.getFoodItemXL(args[1]).getItem();
            }
            if(item!=null) {
                if(args.length==3) {
                    try {
                        item.setAmount(Integer.parseInt(args[2]));
                    } catch (NumberFormatException ignored) {
                        player.sendMessage(ChatColor.RED + "Invalid amount!");
                    }
                }
                player.getInventory().addItem(item);
            } else {
                player.sendMessage(ChatColor.RED + "Invalid item!");
            }
        }
        return false;
    }
}
