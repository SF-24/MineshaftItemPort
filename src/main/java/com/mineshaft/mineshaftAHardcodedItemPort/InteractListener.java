package com.mineshaft.mineshaftAHardcodedItemPort;

import com.mineshaft.mineshaftAHardcodedItemPort.manager.Container;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.DrinkManager;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.Drinks;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.lang.reflect.Field;

public class InteractListener implements Listener {

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
