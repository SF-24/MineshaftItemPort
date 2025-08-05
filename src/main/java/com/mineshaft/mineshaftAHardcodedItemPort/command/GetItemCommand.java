package com.mineshaft.mineshaftAHardcodedItemPort.command;

import com.dre.brewery.api.BreweryApi;
import com.mineshaft.mineshaftAHardcodedItemPort.items.*;
import com.mineshaft.mineshaftAHardcodedItemPort.items.chocolate_frog_card.ChocolateFrogCard;
import com.mineshaft.mineshaftAHardcodedItemPort.items.wand.Wand;
import com.mineshaft.mineshaftAHardcodedItemPort.items.wand.WandCore;
import com.mineshaft.mineshaftAHardcodedItemPort.items.wand.WandType;
import com.mineshaft.mineshaftAHardcodedItemPort.items.wand.WandWood;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.Container;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.drinks.DrinkManager;
import com.mineshaft.mineshaftapi.nbtapi.NBT;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

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

        if(args.length==1 && args[0].equals("chocolate_frog_card")) {
            player.getInventory().addItem(ChocolateFrogCard.getRandomCard(1, new ArrayList<>()));
            return false;
        } else if(args.length==2 && args[0].equalsIgnoreCase("make_container")) {
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

        ItemStack item = null;
        if(args.length>=2 && args[0].equalsIgnoreCase("lotr")) {
            if(args.length>=3) {
                item = (ItemLotr.getItem(args[1], args[2]));
            } else {
                item = (ItemLotr.getItem(args[1], null));
            }
            if(args.length==4 && item!=null) {
                try {
                    item.setAmount(Integer.parseInt(args[3]));
                } catch (NumberFormatException ignored) {
                    player.sendMessage(ChatColor.RED + "Invalid amount");
                }
            }
        } else if(args.length>=2) {

            // Check different pack namespaces
            // Switch between different item classes
            switch (args[0]) {
                case "xl_food" -> item = FoodItemXL.getFoodItemXL(args[1].toUpperCase()).getItem();
                case "create" -> {
                    for(FoodItemCreate element : FoodItemCreate.values()) {
                        if(element.name().equalsIgnoreCase(args[1])) {
                            item= element.getItem();
                            break;
                        }
                    }
                    if(item==null) {
                        for (ItemCreate element : ItemCreate.values()) {
                            if(element.name().equalsIgnoreCase(args[1])) {
                                item=element.getItem();
                                break;
                            }
                        }
                    }
                }
                case "chocolate_frog_card" -> item = ChocolateFrogCard.valueOf(args[1].toUpperCase()).getItem();
                case "currency" -> item = CurrencyItem.getCurrencyItem(args[1].toUpperCase()).getItem();
                case "hp_food" -> item = FoodItemHp.getFoodItemHp(args[1].toUpperCase()).getItem();
                case "wand" -> {
                    WandType wandType;
                    try {
                        wandType = WandType.valueOf(args[1].toUpperCase());
                    } catch (NullPointerException ignored) {
                        sender.sendMessage(ChatColor.RED + "Invalid wand type");
                        return false;
                    }
                    WandCore wandCore = WandCore.random(1, 1);
                    WandWood wandWood = WandWood.random();
                    if(args.length>=3) {
                        try {
                            wandCore=WandCore.valueOf(args[2].toUpperCase());
                        } catch (NullPointerException ignored) {
                            sender.sendMessage(ChatColor.RED + "Invalid wand core");
                            return false;
                        }
                    }
                    if(args.length>=4) {
                        try {
                            wandWood=WandWood.valueOf(args[3].toUpperCase());
                        } catch (NullPointerException ignored) {
                            sender.sendMessage(ChatColor.RED + "Invalid wand wood");
                            return false;
                        }
                    }
                    player.getInventory().addItem(Wand.getWand(wandType,wandCore,wandWood));
                    return false;
                }
            }
            // Set count and run checks
            if(item.getType()!=Material.AIR) {
                if(args.length==3) {
                    try {
                        item.setAmount(Integer.parseInt(args[2]));
                    } catch (NumberFormatException ignored) {
                        player.sendMessage(ChatColor.RED + "Invalid amount!");
                    }
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid item!");
            }
        }
        player.getInventory().addItem(item);

        return false;
    }
}
