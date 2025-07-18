package com.mineshaft.mineshaftAHardcodedItemPort.items.chocolate_frog_card;

import lombok.Getter;

@Getter
public enum ChocolateFrogCardType {
    BRONZE("Bronze"),
    SILVER("Silver"),
    GOLD("Gold"),
    CRYSTAL("Crystal"),
    EVENT("Event");

    private final String display;

    ChocolateFrogCardType(String display) {
        this.display=display;
    }

}