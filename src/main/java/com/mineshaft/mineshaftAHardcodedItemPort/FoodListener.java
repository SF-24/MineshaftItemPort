package com.mineshaft.mineshaftAHardcodedItemPort;

import com.dre.brewery.api.BreweryApi;
import com.dre.brewery.api.events.brew.BrewDrinkEvent;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.Container;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.PlayerManager;
import com.mineshaft.mineshaftapi.nbtapi.NBT;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Objects;

public class FoodListener implements Listener {

    public static List<Material> flaggedMaterials = List.of(Material.POTION,Material.SUSPICIOUS_STEW,Material.MUSHROOM_STEM,Material.RABBIT_STEW,Material.BEETROOT_SOUP);

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        if(e.getItem().getType().equals(Material.AIR)) return;
        e.setCancelled(true);


        // Get properties
        NBT.get(e.getItem(), nbt -> {

            // If is brewery brew
            if(BreweryApi.isBrew(e.getItem())) {
                e.setCancelled(false);
                return;
            }

            // Get container
            String strContainer = nbt.getString("Container");
            Container container = Container.NULL;
            for(Container c : Container.values()) {
                if(strContainer.equalsIgnoreCase(c.name())) {
                    container=c;
                }
            }

            if(container.equals(Container.NULL)) {
                e.setCancelled(false);
                return;
            }

            System.out.println("container: " + container);

            // if is valid:
            if(!container.equals(Container.BOWL) && !container.equals(Container.BOTTLE)) {
                ItemStack dropItem = container.getItem();
                if (e.getItem().getAmount() > 1 && !BreweryApi.isBrew(e.getItem())) {
                    // Give the player the container item
                    if (PlayerManager.canTakeMoreOfItem(e.getPlayer(), dropItem)) {
                        e.getPlayer().getInventory().addItem(dropItem);
                    } else {
                        e.getPlayer().getWorld().dropItem(e.getPlayer().getLocation(), dropItem);
                    }

                    // Remove the glass bottle or bowl, depending on the item

                    if (flaggedMaterials.contains(e.getItem().getType())) {
                        MineshaftItemPort.getInstance().getServer().getScheduler().runTaskLaterAsynchronously(MineshaftItemPort.getInstance(), () -> {
                            PlayerManager.removeOneItem(e.getPlayer(), getDropMaterial(e.getItem().getType()));
                        }, 1 / 40);
                    }

                } else {
                    // Set hand item after drinking

                    if (e.getHand().equals(EquipmentSlot.HAND)) {
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

    @EventHandler
    public void drinkBrew(BrewDrinkEvent event) {
        ItemStack brew;
        final boolean mainHand;
        if(Objects.equals(event.getPlayer().getInventory().getItemInMainHand().getItemMeta(), event.getItemMeta())) {
            brew = event.getPlayer().getInventory().getItemInMainHand();
            mainHand=true;
        } else if(Objects.equals(event.getPlayer().getInventory().getItemInOffHand().getItemMeta(), event.getItemMeta())) {
            brew = event.getPlayer().getInventory().getItemInOffHand();
            mainHand=false;
        } else {
            return;
        }
        if (brew.getAmount() > 1) {
            System.out.printf("Returning vanished items...");
            // Recompense items which vanished due to the brewery plugin.

            NBT.get(brew, nbt -> {

                String strContainer = nbt.getString("Container");
                Container container = Container.NULL;
                for (Container c : Container.values()) {
                    if (strContainer.equalsIgnoreCase(c.name())) {
                        container = c;
                    }
                }
                Container finalContainer = container;
                MineshaftItemPort.getInstance().getServer().getScheduler().runTaskLaterAsynchronously(MineshaftItemPort.getInstance(), () -> {
                    brew.setAmount(brew.getAmount() - 1);
                    System.out.printf("Container " + finalContainer);
                    if (finalContainer.equals(Container.NULL)) {
                        event.getPlayer().getInventory().addItem(new ItemStack(Material.GLASS_BOTTLE));
                    } else {
                        event.getPlayer().getInventory().addItem(finalContainer.getItem());
                    }
                    if (mainHand) {
                        event.getPlayer().getInventory().setItemInMainHand(brew);
                    } else {
                        event.getPlayer().getInventory().setItemInOffHand(brew);
                    }
                }, 1 / 80);
            });
        } else {
            NBT.get(brew, nbt -> {

                String strContainer = nbt.getString("Container");
                Container container = Container.NULL;
                for (Container c : Container.values()) {
                    System.out.println("container:" + strContainer);
                    if (strContainer.equalsIgnoreCase(c.name())) {
                        container = c;
                    }
                }
                Container finalContainer = container;

                if(container == Container.NULL) {return;}
                MineshaftItemPort.getInstance().getServer().getScheduler().runTaskLaterAsynchronously(MineshaftItemPort.getInstance(), () -> {
                    if (mainHand) {
                        event.getPlayer().getInventory().setItemInMainHand(finalContainer.getItem());
                    } else {
                        event.getPlayer().getInventory().setItemInOffHand(finalContainer.getItem());
                    }
                }, 1 / 80);
            });
        }
    }

    public Material getDropMaterial(Material material) {
        if(material == Material.POTION) {return Material.GLASS_BOTTLE;}
        return Material.BOWL;
    }
}
