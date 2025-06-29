package com.mineshaft.mineshaftAHardcodedItemPort;

import com.dre.brewery.api.events.brew.BrewModifyEvent;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.Container;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.drinks.DrinkManager;
import com.mineshaft.mineshaftapi.nbtapi.NBT;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Consumable;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractListener implements Listener {

    @EventHandler
    public void onBrew(BrewModifyEvent e) {
        if(e.getType().equals(BrewModifyEvent.Type.FILL)) {
            ItemStack mainHand = e.getPlayer().getInventory().getItemInMainHand();
            if (mainHand.getType().equals(Material.GLASS_BOTTLE) && mainHand.getItemMeta()!=null && mainHand.getItemMeta().hasCustomModelData() && mainHand.getItemMeta().getCustomModelData()==Container.TANKARD.getItem().getItemMeta().getCustomModelData()) {
                MineshaftItemPort.getInstance().getServer().getScheduler().runTaskLaterAsynchronously(MineshaftItemPort.getInstance(), () -> {
                    ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
                    ItemMeta meta = item.getItemMeta();
                    assert meta != null;
                    meta.setCustomModelData(DrinkManager.getBrewModelData(e.getBrew(), Container.TANKARD));
                    item.setItemMeta(meta);
                    Container finalContainer = Container.TANKARD;
                    NBT.modify(item, nbt -> {
                        nbt.setString("Container", finalContainer.name().toLowerCase());
                    });

                    e.getPlayer().getInventory().setItemInMainHand(item);
                }, 1 / 80);

            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        // Removed: ||e.getItem().getType().equals(Material.SUSPICIOUS_STEW)||e.getItem().getType().equals(Material.MUSHROOM_STEW)||e.getItem().getType().equals(Material.RABBIT_STEW)||e.getItem().getType().equals(Material.BEETROOT_SOUP)
        if(e.getItem()!=null && (e.getItem().getType().equals(Material.POTION)) && e.getItem().getData(DataComponentTypes.CONSUMABLE).consumeSeconds()!=1.0f) {
            Consumable c = e.getItem().getData(DataComponentTypes.CONSUMABLE);
            assert c != null;
            float eatTime = 1.0f;
            Consumable c1 = Consumable.consumable().consumeSeconds(eatTime).animation(c.animation()).addEffects(c.consumeEffects()).hasConsumeParticles(c.hasConsumeParticles()).sound(c.sound()).build();
            if(e.getHand().equals(EquipmentSlot.OFF_HAND)) {
                MineshaftItemPort.getInstance().getServer().getScheduler().runTaskLaterAsynchronously(MineshaftItemPort.getInstance(), () -> {
                    ItemStack item = e.getPlayer().getInventory().getItemInOffHand();
                    item.setData(DataComponentTypes.CONSUMABLE, c1);
                    e.getPlayer().getInventory().setItemInMainHand(item);
                }, 1 / 100);
            } else {
                MineshaftItemPort.getInstance().getServer().getScheduler().runTaskLaterAsynchronously(MineshaftItemPort.getInstance(), () -> {
                    ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
                    item.setData(DataComponentTypes.CONSUMABLE, c1);
                    e.getPlayer().getInventory().setItemInMainHand(item);
                }, 1 / 100);
            }
        }
    }

//    @EventHandler
//    public void onInteract(PlayerInteractEvent e) throws RuntimeException {
//        if(DrinkManager.isDrink(e.getItem()) && e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
//            e.setCancelled(true);
//
//            BlockState state = e.getClickedBlock().getRelative(e.getBlockFace()).getState();
//            state.setType(Material.PLAYER_HEAD);
//            BlockData blockData = state.getBlockData();
//            state.getWorld().setBlockData(state.getLocation(),blockData);
//
//            if(blockData instanceof Skull) {
//
//                Field field;
//                try {
//                    field = blockData.getClass().getDeclaredField("profile");
//                    field.setAccessible(true);
//                    field.set(blockData, DrinkManager.getPlacedTankardProfile(DrinkManager.getDrink(e.getItem()).getPlacedDrinks(), Container.TANKARD));
//                } catch (NoSuchFieldException | IllegalAccessException ex) {
//                    // TODO:
//                }
////                ((Skull) blockData).setOwnerProfile(
////                    DrinkManager.getPlacedTankardProfile(DrinkManager.getDrink(e.getItem()).getPlacedDrinks(), Container.TANKARD)
////                );
////                ((Skull) blockData).setRotation(e.getBlockFace());
//                state.setBlockData(blockData);
//                state.update(true);
//            }
//
////            Location loc = block.getLocation(); // put in the location here
////            loc.getBlock().setType(Material.PLAYER_HEAD);
////            loc.getBlock().setData((byte) 3);
////            Skull s = (Skull)loc.getBlock().getState();
////            s.setMetadata(INSERTPLAYERHERE);
//
//        }
//    }

}
