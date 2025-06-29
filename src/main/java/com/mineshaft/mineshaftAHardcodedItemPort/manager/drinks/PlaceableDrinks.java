package com.mineshaft.mineshaftAHardcodedItemPort.manager.drinks;

public enum PlaceableDrinks {

    EMPTY(""),
    ALE(""),
    ATHELAS(""),
    MIRUVOR(""),
    ORC_DRAUGHT(""),

    ;
    private final String modelData;

    PlaceableDrinks(String textureString) {
        this.modelData=textureString;
    }

    public String getTextureUrl() {return modelData;}

}
