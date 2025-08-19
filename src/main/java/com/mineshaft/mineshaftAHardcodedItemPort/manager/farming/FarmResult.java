package com.mineshaft.mineshaftAHardcodedItemPort.manager.farming;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;

@Getter @Setter
public class FarmResult {

    public FarmResult(Material material) {
        this.farmResultType = FarmResultType.BLOCK;
        this.material = material;
        this.headUrl=null;
    }

    public FarmResult(String headUrl) {
        this.farmResultType = FarmResultType.HEAD;
        this.material = Material.PLAYER_HEAD;
        this.headUrl = headUrl;
    }

    FarmResultType farmResultType;
    String headUrl;
    Material material;

}
