package com.mineshaft.mineshaftAHardcodedItemPort.manager;

import com.mineshaft.mineshaftAHardcodedItemPort.MineshaftItemPort;
import com.mineshaft.mineshaftAHardcodedItemPort.items.CropXL;
import com.mineshaft.mineshaftapi.nbtapi.NBT;
import com.mineshaft.mineshaftapi.util.HeadUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.inventory.ItemStack;

public class CropListener implements Listener {

    @EventHandler
    void onCropGrow(BlockGrowEvent e) {
        try {
            NBT.get(e.getBlock().getState(), nbt->{
                String cropStr = nbt.getString("crop");
                if(cropStr==null) return;

                BlockData data = e.getBlock().getBlockData();

                if(data instanceof Ageable) {
                    CropXL crop = CropXL.getCropXL(cropStr);
                    if (((Ageable) data).getAge()>= CropXL.getCropXL(cropStr).getGrowthAge()) {
                        // Spawn the result
                        Block block = e.getBlock().getWorld().getBlockAt(e.getBlock().getLocation());
                        switch (crop.getResult().getFarmResultType()) {
                            case HEAD -> {
                                Bukkit.getScheduler().runTaskLater(MineshaftItemPort.getInstance(),()->{
                                    HeadUtil.setHead(crop.getResult().getHeadUrl(),block);
                                    NBT.modify(block.getWorld().getBlockAt(block.getLocation()).getState(),newestNbt->{
                                        newestNbt.setString("crop",cropStr);
                                    });
                                },1L);
                            }
                            case BLOCK -> {
                                Bukkit.getScheduler().runTaskLater(MineshaftItemPort.getInstance(),()->{
                                    block.setType(crop.getResult().getMaterial());
                                },1L);
                            }
                        }
                    }
                }

                NBT.modify(e.getNewState(), newNbt->{
                    newNbt.setString("crop",cropStr);
                });
            });
        } catch (Exception ignored) {}
    }

    @EventHandler
    void onBreakBlock(BlockBreakEvent e) {
        try {
            if(e.getBlock().getType()!= Material.AIR) {
                NBT.get(e.getBlock().getState(), nbt->{
                    // Drop items
                    CropXL crop = CropXL.getCropXL(nbt.getString("crop"));
                    if(crop==CropXL.EMPTY) return;
                    for(ItemStack item : crop.getDrops()) {
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), item);
                    }
                    e.setDropItems(false);
                    e.setExpToDrop(0);
                });
            }
        } catch (NullPointerException ignored) {}
    }

}
