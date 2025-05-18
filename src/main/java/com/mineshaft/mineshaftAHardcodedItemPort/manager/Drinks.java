package com.mineshaft.mineshaftAHardcodedItemPort.manager;

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

    public int getBowlModelData() {return bowlModelData;}
    public int getBottleModelData() {return bottleModelData;}
    public int getTankardModelData() {return tankardmodelData;}
    public PlaceableDrinks getPlacedDrinks() {return placedDrinksData;}

}
