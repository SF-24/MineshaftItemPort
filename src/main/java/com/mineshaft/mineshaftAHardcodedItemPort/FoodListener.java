package com.mineshaft.mineshaftAHardcodedItemPort;

import de.tr7zw.nbtapi.NBT;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FoodListener implements Listener {

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        if (e.getItem().getType().equals(Material.SUSPICIOUS_STEW) || e.getItem().getType().equals(Material.POTION)) {
            e.setCancelled(true);
            System.out.printf("Testing");
            NBT.get(e.getItem(), nbt -> {
                String potionType = (String) nbt.getString("Potion").toLowerCase();
                System.out.println("Checking drink....");
                if(potionType.contains("athelas")) {
                    Player player = e.getPlayer();
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200, 0, true, false, true));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 2400, 0, true, false, true));
                    player.setFoodLevel(Math.min(player.getFoodLevel()+6, 20));
                    player.setSaturation(Math.min(player.getSaturation()+7.2F, 20));
                } else if(potionType.contains("miruvor")) {
                    Player player = e.getPlayer();
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 800, 0, true, false, true));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 800, 0, true, false, true));
                    player.setFoodLevel(Math.min(player.getFoodLevel()+8, 20));
                    player.setSaturation(Math.min(player.getSaturation()+8, 20));
                } else if(potionType.contains("orc_draught")) {
                    Player player = e.getPlayer();
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 0, true, false, true));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 60, 0, true, false, true));
                    player.setFoodLevel(Math.min(player.getFoodLevel()+6, 20));
                    player.setSaturation(Math.min(player.getSaturation()+6, 20));
                    player.setHealth(Math.max(player.getHealth()-2.0, 1.0));
                } else if(potionType.contains("entdraught_")) {
                    Player player = e.getPlayer();
                    String type = potionType.substring(potionType.lastIndexOf("_")+1);
                    switch(type) {
                        case "blue":
                            player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 3000, 0, true, false, true));
                            break;
                        case "silver":
                            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 3600, 0, true, false, true));
                            break;
                        case "yellow":
                            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200, 0, true, false, true));
                            break;
                        case "brown":
                            player.setFoodLevel(20);
                            break;
                        case "red":
                            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 0, true, false, true));
                            break;
                        case "gold":
                            // GIVES FULL BAR OF ABSORPTION HEARTS FOR 3 MINUTES
                            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 3600, 4, true, false, true));
                            break;
                        case "green":
                            // UPGRADED SPEED!
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2400, 1, true, false, true));
                            break;
                        case "purple":
                            // HEALS PLAYER
                            player.setHealth(Math.min(player.getHealth() + 20, player.getMaxHealth()));
                            break;
                        default:
                            break;
                    }
                }
                e.setCancelled(false);
            });
        }
    }
}
