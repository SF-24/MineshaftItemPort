package com.mineshaft.mineshaftAHardcodedItemPort.command;

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

public class GetItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!sender.hasPermission("mineshaft.gethardcodeditem")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
        } else if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
        }
        Player player = (Player) sender;

        if(args.length==1) {
            if(args[0].equals("athelas_soup")) {
                ItemStack athelasSoup = new ItemStack(Material.SUSPICIOUS_STEW);
                ItemMeta meta = athelasSoup.getItemMeta();
                meta.setDisplayName(ChatColor.WHITE + "Athelas Brew");
                meta.setCustomModelData(11);
                athelasSoup.setItemMeta(meta);
                NBT.modify(athelasSoup, nbt -> {
                    nbt.setString("Potion", "Athelas");
                });
                player.getInventory().addItem(athelasSoup);
            } else if(args[0].equals("orc_draught")) {
                ItemStack athelasSoup = new ItemStack(Material.POTION);
                PotionMeta meta = (PotionMeta) athelasSoup.getItemMeta();
                assert meta != null;
                meta.setDisplayName(ChatColor.WHITE + "Orc Draught");
                meta.setCustomModelData(11);
                athelasSoup.setItemMeta(meta);
                NBT.modify(athelasSoup, nbt -> {
                    nbt.setString("Potion", "Orc_draught");
                });
                player.getInventory().addItem(athelasSoup);
            } else if(args[0].equals("miruvor")) {
                ItemStack miruvor = new ItemStack(Material.POTION);
                ItemMeta miruvorMeta = miruvor.getItemMeta();
                assert miruvorMeta != null;
                miruvorMeta.setDisplayName(ChatColor.WHITE + "Miruvor");
                miruvorMeta.setCustomModelData(2);
                miruvor.setItemMeta(miruvorMeta);
                NBT.modify(miruvor, nbt -> {
                    nbt.setString("Potion", "Miruvor");
                });

                player.getInventory().addItem(miruvor);
            } else {
                player.sendMessage(ChatColor.RED + "Invalid arguments!");
            }
        }

        if(args.length==2) {
            if(args[0].equals("ent_draught")) {
                ItemStack entDrink = new ItemStack(Material.SUSPICIOUS_STEW);
                ItemMeta entDrinkMeta = entDrink.getItemMeta();
                entDrinkMeta.setDisplayName(ChatColor.WHITE + args[1].substring(0,1).toUpperCase() + args[1].substring(1) + " Ent Draught");

                switch(args[1]) {
                    case "blue":
                        entDrinkMeta.setCustomModelData(3);
                        break;
                    case "silver":
                        entDrinkMeta.setCustomModelData(4);
                        break;
                    case "yellow":
                        entDrinkMeta.setCustomModelData(5);
                        break;
                    case "brown":
                        entDrinkMeta.setCustomModelData(6);
                        break;
                    case "red":
                        entDrinkMeta.setCustomModelData(7);
                        break;
                    case "gold":
                        entDrinkMeta.setCustomModelData(8);
                        break;
                    case "green":
                        entDrinkMeta.setCustomModelData(9);
                        break;
                    case "purple":
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
