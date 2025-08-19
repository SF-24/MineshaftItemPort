package com.mineshaft.mineshaftAHardcodedItemPort;

import com.mineshaft.mineshaftAHardcodedItemPort.items.CropXL;
import com.mineshaft.mineshaftAHardcodedItemPort.items.FoodItem;
import com.mineshaft.mineshaftAHardcodedItemPort.items.FoodItemXL;
import com.mineshaft.mineshaftapi.nbtapi.NBT;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Consumable;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class InteractListener implements Listener {

//    @EventHandler
//    public void onBrew(BrewModifyEvent e) {
//        if(e.getType().equals(BrewModifyEvent.Type.FILL)) {
//            ItemStack mainHand = e.getPlayer().getInventory().getItemInMainHand();
//            if (mainHand.getType().equals(Material.GLASS_BOTTLE) && mainHand.getItemMeta()!=null && mainHand.getItemMeta().hasCustomModelData() && mainHand.getItemMeta().getCustomModelData()==Container.TANKARD.getItem().getItemMeta().getCustomModelData()) {
//                MineshaftItemPort.getInstance().getServer().getScheduler().runTaskLaterAsynchronously(MineshaftItemPort.getInstance(), () -> {
//                    ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
//                    ItemMeta meta = item.getItemMeta();
//                    assert meta != null;
//                    meta.setCustomModelData(DrinkManager.getBrewModelData(e.getBrew(), Container.TANKARD));
//                    item.setItemMeta(meta);
//                    Container finalContainer = Container.TANKARD;
//                    NBT.modify(item, nbt -> {
//                        nbt.setString("Container", finalContainer.name().toLowerCase());
//                    });
//
//                    e.getPlayer().getInventory().setItemInMainHand(item);
//                }, 1 / 80);
//
//            }
//        }
//    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(e.getItem()!=null && e.getItem().getType()!=Material.AIR) {
            try {
                NBT.get(e.getPlayer().getInventory().getItemInMainHand(), nbt->{
                    if(nbt.getBoolean("disablePlacing")) {
                        e.setCancelled(true);
                    }
                    if(nbt.getString("onInteract")!=null) {
                        switch (nbt.getString("onInteract")) {
                            case "openChocolateFrog" -> Bukkit.getScheduler().runTaskLater(MineshaftItemPort.getInstance(), ()->{
                                e.getPlayer().getInventory().setItemInMainHand(FoodItem.CHOCOLATE_FROG_PACKAGED_OPENED.getItem());
                                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_LEATHER, 1.0f, 1.0f);
                            },1/20);
                            case "openChocolateFrogSpecial" -> Bukkit.getScheduler().runTaskLater(MineshaftItemPort.getInstance(), ()->{
                                e.getPlayer().getInventory().setItemInMainHand(FoodItem.CHOCOLATE_FROG_SPECIAL_PACKAGED_OPENED.getItem());
                                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_LEATHER, 1.0f, 1.0f);
                            },1/20);
                        }
                    }
                });
            } catch (Exception ignored) {}
        }

        // Removed: ||e.getItem().getType().equals(Material.SUSPICIOUS_STEW)||e.getItem().getType().equals(Material.MUSHROOM_STEW)||e.getItem().getType().equals(Material.RABBIT_STEW)||e.getItem().getType().equals(Material.BEETROOT_SOUP)
        if(e.getItem()!=null && (e.getItem().getType().equals(Material.POTION)) && e.getItem().getData(DataComponentTypes.CONSUMABLE).consumeSeconds()>1.0f) {
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

        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock()!=null && e.getClickedBlock().getType()!=Material.AIR && e.getClickedBlock().getType()==(Material.FARMLAND) && e.getBlockFace().equals(BlockFace.UP)) {
            if(e.getItem()!=null && e.getItem().getType()!=Material.AIR && e.getItem().hasItemMeta()) {
                for(FoodItemXL item : FoodItemXL.values()) {
                    if(item.getItem().getItemMeta().equals(e.getItem().getItemMeta())) {
                        // Check if the crop exists
                        if(CropXL.getCropXL(item)!=null) {
                            // The crop is valid
                            Block block = e.getClickedBlock().getLocation().getWorld().getBlockAt(e.getClickedBlock().getLocation().add(0,1,0));
                            block.setType(Material.WHEAT);
                            block=e.getClickedBlock().getLocation().getWorld().getBlockAt(e.getClickedBlock().getLocation().add(0,1,0));
                            NBT.modify(block.getState(), nbt->{
                                nbt.setString("crop",CropXL.getCropXL(item).name());
                            });
                            // Set the crop
                        }
                    }
                }
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
