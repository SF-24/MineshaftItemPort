package com.mineshaft.mineshaftAHardcodedItemPort.manager.drinks;

import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.Container;

public enum Drinks {

    ALE(PlaceableDrinks.ALE,-1,18,14),
    ATHELAS(PlaceableDrinks.ATHELAS,11, 1, 15),
    MIRUVOR(PlaceableDrinks.MIRUVOR,-1,2,16),
    ORC_DRAUGHT(PlaceableDrinks.ORC_DRAUGHT,-1,11,17),
    ;

    private final int bowlModelData;
    private final int bottleModelData;
    private final int tankardmodelData;
    private final PlaceableDrinks placedDrinksData;

    Drinks(PlaceableDrinks placedDrinksData, int bowlModelData, int bottleModelData, int tankardModelData) {
        this.bowlModelData=bowlModelData;
        this.bottleModelData=bottleModelData;
        this.tankardmodelData=tankardModelData;
        this.placedDrinksData=placedDrinksData;
    }

    public int getContainerModelData(Container container) {
        switch(container) {
            case NULL -> {
                return 0;
            }
            case BOWL -> {
                return bowlModelData;
            }
            case BOTTLE -> {
                return bottleModelData;
            }
            case TANKARD -> {
                return tankardmodelData;
            }
        }
        return 0;
    }

    @Deprecated
    public int getBowlModelData() {return bowlModelData;}
    @Deprecated
    public int getBottleModelData() {return bottleModelData;}
    @Deprecated
    public int getTankardModelData() {return tankardmodelData;}
    public PlaceableDrinks getPlacedDrinks() {return placedDrinksData;}

}
