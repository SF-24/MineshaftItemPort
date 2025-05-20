package com.mineshaft.mineshaftAHardcodedItemPort;

import com.dre.brewery.api.BreweryApi;
import com.dre.brewery.api.events.brew.BrewModifyEvent;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.Container;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.DrinkManager;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.PlayerManager;
import de.tr7zw.nbtapi.NBT;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.nio.file.StandardWatchEventKinds;

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
                }, 1 / 40);

            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) throws RuntimeException {
        if(DrinkManager.isDrink(e.getItem()) && e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            e.setCancelled(true);

            BlockState state = e.getClickedBlock().getRelative(e.getBlockFace()).getState();
            state.setType(Material.PLAYER_HEAD);
            BlockData blockData = state.getBlockData();
            state.getWorld().setBlockData(state.getLocation(),blockData);

            if(blockData instanceof Skull) {

                Field field;
                try {
                    field = blockData.getClass().getDeclaredField("profile");
                    field.setAccessible(true);
                    field.set(blockData, DrinkManager.getPlacedTankardProfile(DrinkManager.getDrink(e.getItem()).getPlacedDrinks(), Container.TANKARD));
                } catch (NoSuchFieldException | IllegalAccessException ex) {
                    // TODO:
                }
//                ((Skull) blockData).setOwnerProfile(
//                    DrinkManager.getPlacedTankardProfile(DrinkManager.getDrink(e.getItem()).getPlacedDrinks(), Container.TANKARD)
//                );
//                ((Skull) blockData).setRotation(e.getBlockFace());
                state.setBlockData(blockData);
                state.update(true);
            }

//            Location loc = block.getLocation(); // put in the location here
//            loc.getBlock().setType(Material.PLAYER_HEAD);
//            loc.getBlock().setData((byte) 3);
//            Skull s = (Skull)loc.getBlock().getState();
//            s.setMetadata(INSERTPLAYERHERE);

        }
    }

}
