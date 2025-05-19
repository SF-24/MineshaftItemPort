package com.mineshaft.mineshaftAHardcodedItemPort;

import com.mineshaft.mineshaftAHardcodedItemPort.manager.Container;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.PlayerManager;
import de.tr7zw.nbtapi.NBT;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class FoodListener implements Listener {

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        if (e.getItem().getType().equals(Material.SUSPICIOUS_STEW) || e.getItem().getType().equals(Material.POTION)) {
            e.setCancelled(true);


            NBT.get(e.getItem(), nbt -> {

                Container container = Container.valueOf(nbt.getString("Container").toUpperCase());
                System.out.println("container: " + container);

                if(container.equals(Container.TANKARD)) {
                    System.out.printf("tankard!");
                    ItemStack dropItem = container.getItem();
                    if (e.getItem().getAmount() > 1) {
                        System.out.println("more than one");
                        // Give the player the container item
                        if (PlayerManager.canTakeMoreOfItem(e.getPlayer(), dropItem)) {
                            e.getPlayer().getInventory().addItem(dropItem);
                        } else {
                            e.getPlayer().getWorld().dropItem(e.getPlayer().getLocation(), dropItem);
                        }

                        // Remove the glass bottle
                        MineshaftItemPort.getInstance().getServer().getScheduler().runTaskLaterAsynchronously(MineshaftItemPort.getInstance(), () -> {
                            PlayerManager.removeOneGlassBottle(e.getPlayer());
                        }, 1 / 40);


                    } else {
                        // Set hand item after drinking
                        if (e.getHand().equals(EquipmentSlot.HAND)) {
                            System.out.println("MAINHAND");
                            MineshaftItemPort.getInstance().getServer().getScheduler().runTaskLaterAsynchronously(MineshaftItemPort.getInstance(), () -> {
                                e.getPlayer().getInventory().setItemInMainHand(new ItemStack(dropItem));
                            }, 1/40);
                        } else if (e.getHand().equals(EquipmentSlot.OFF_HAND)) {

                            MineshaftItemPort.getInstance().getServer().getScheduler().runTaskLaterAsynchronously(MineshaftItemPort.getInstance(), () -> {
                                e.getPlayer().getInventory().setItemInOffHand(new ItemStack(dropItem));
                            }, 1 /40);
                        }
                    }
                }

                String potionType = (String) nbt.getString("Potion").toLowerCase();
                System.out.println("Checking drink....");
                if(potionType.contains("athelas")) {
                    // ATHELAS

                    Player player = e.getPlayer();
                    player.setFoodLevel(Math.min(player.getFoodLevel()+6, 20));
                    player.setSaturation(Math.min(player.getSaturation()+7.2F, 20));
                } else if(potionType.contains("miruvor")) {
                    // MIRUVOR

                    Player player = e.getPlayer();
                    player.setFoodLevel(Math.min(player.getFoodLevel()+8, 20));
                    player.setSaturation(Math.min(player.getSaturation()+8, 20));
                } else if(potionType.contains("orc_draught")) {
                    // ORC DRAUGHT

                    Player player = e.getPlayer();
                    player.setFoodLevel(Math.min(player.getFoodLevel()+6, 20));
                    player.setSaturation(Math.min(player.getSaturation()+6, 20));
                    player.setHealth(Math.max(player.getHealth()-2.0, 1.0));
                } else if(potionType.contains("entdraught_")) {
                    // ENT DRAUGHT

                    Player player = e.getPlayer();
                    String type = potionType.substring(potionType.lastIndexOf("_")+1);
                    switch(type) {
                        case "brown":
                            player.setFoodLevel(20);
                            break;
                        case "purple":
                            // HEALS PLAYER
                            player.setHealth(Math.min(player.getHealth() + 20, player.getMaxHealth()));
                            break;
                        case "gold":
                            player.setAbsorptionAmount(20);
                            break;
                        case "green", "red", "yellow", "silver", "blue":
                        default:
                            break;
                    }
                }
                e.setCancelled(false);
            });
        }
    }
}
