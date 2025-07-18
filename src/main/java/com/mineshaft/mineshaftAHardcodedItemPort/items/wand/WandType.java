package com.mineshaft.mineshaftAHardcodedItemPort.items.wand;

import lombok.Getter;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@Getter
public enum WandType {

    SLEEK(Material.MINECART, 11, false, new ArrayList<>(), 5),
    CURVED_BIRCH(Material.MINECART, 12, false, new ArrayList<>(), 5),
    CURVED_BIRCH_2(Material.MINECART, 13, false, new ArrayList<>(), 5),
    CURVED_DARK_OAK(Material.MINECART, 17, false, new ArrayList<>(), 5),
    CURVED_DARK_OAK_2(Material.MINECART, 16, false, new ArrayList<>(), 5),
    CURVED_OAK(Material.MINECART, 22, false, new ArrayList<>(), 5),
    CURVED_SANDY(Material.MINECART, 23, false, new ArrayList<>(), 5),

    ELDER(Material.MINECART, 14, true, new ArrayList<>(Collections.singleton(WandWood.ELDER)), 1),

    BONE(Material.MINECART, 18, false, new ArrayList<>(), 5),
    WOLF(Material.MINECART, 15, false, new ArrayList<>(), 3),

    SLIM_LONG_HILT(Material.MINECART, 21, false, new ArrayList<>(), 5),
    BROWN(Material.MINECART, 20, false, new ArrayList<>(), 5),

    UMBRELLA(Material.MINECART, 19, false, new ArrayList<>(), 0);

    private final Material material;
    private final int customModelData, weight;
    private final boolean limitedWoodType;
    private final ArrayList<WandWood> wood;

    WandType(Material material, int customModelData, boolean limitedWoodTypes, ArrayList<WandWood> wood, int weight) {
        this.material = material;
        this.customModelData = customModelData;
        this.limitedWoodType = limitedWoodTypes;
        this.wood = wood;
        this.weight = weight;
    }

    public static WandType random() {
        return random(null);
    }

    public static WandType random(WandWood woodType) {
        WandType wandType;
        Random random = new Random();

        ArrayList<WandType> wandTextures = new ArrayList<>();

        for(WandType element : WandType.values()) {
            if(woodType!=null && element.isLimitedWoodType() && element.getWood().contains(woodType)) {
                for(int x = 0; x<element.getWeight(); x++)
                    wandTextures.add(element);
            } else if(!element.isLimitedWoodType()) {
                for(int x = 0; x<element.getWeight(); x++)
                    wandTextures.add(element);
            }
        }

        if(!wandTextures.isEmpty()) {
            int wandTypeNum = random.nextInt(wandTextures.size());
            wandType = wandTextures.get(wandTypeNum);
        } else {
            wandType = WandType.CURVED_BIRCH;
        }

        return wandType;
    }
}
