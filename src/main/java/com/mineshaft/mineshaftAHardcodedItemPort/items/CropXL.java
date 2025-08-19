package com.mineshaft.mineshaftAHardcodedItemPort.items;

import com.mineshaft.mineshaftAHardcodedItemPort.manager.farming.FarmResult;
import com.mineshaft.mineshaftapi.MineshaftApi;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

@Getter
public enum CropXL {

    ONION(FoodItemXL.ONION, FoodItemXL.ONION, 0, 3,6, new FarmResult("http://textures.minecraft.net/texture/a6ecc46dc3dc85fcd57198176ee841f1a041b15f73ecb19fde62ee4315c4a6")),
    LETTUCE(FoodItemXL.LETTUCE, FoodItemXL.LETTUCE, 0, 8,6, new FarmResult(Material.MANGROVE_LEAVES)),
    EMPTY(FoodItemXL.ONION, FoodItemXL.ONION, 0, 3,6, null);

    private final FoodItemXL seedItem;
    private final FoodItemXL dropItem;
    private final int dropAmountMax;
    private final int seedAmountMax;
    private final int growthAge;
    private final FarmResult result;

    CropXL(FoodItemXL seedItem, FoodItemXL dropItem, int seedAmountMax, int dropAmountMax, int growthAge, FarmResult result) {
        this.seedItem = seedItem;
        this.dropItem = dropItem;
        this.dropAmountMax = dropAmountMax;
        this.seedAmountMax = seedAmountMax;
        this.growthAge=growthAge;
        this.result=result;
    }

    public static CropXL getCropXL(FoodItemXL seedItem) {
        for(CropXL cropXL : CropXL.values()) {
            if(cropXL.getSeedItem()==(seedItem)) {
                return cropXL;
            }
        }
        return null;
    }

    @NotNull
    public static CropXL getCropXL(String crop) {
        return Objects.requireNonNullElse(CropXL.valueOf(crop.toUpperCase()), CropXL.EMPTY);
    }

    public ArrayList<ItemStack> getDrops() {
        ArrayList<ItemStack> drops = new ArrayList<>();
        if(seedAmountMax>0) {
            int seedAmount = MineshaftApi.getRandom().nextInt(this.getSeedAmountMax())+1;
            drops.add(this.getSeedItem().getItem(seedAmount));
        }
        if(dropAmountMax>0) {
            int dropAmount = MineshaftApi.getRandom().nextInt(this.getDropAmountMax())+1;
            drops.add(this.getDropItem().getItem(dropAmount));
        }
        return drops;
    }

}
