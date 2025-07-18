package com.mineshaft.mineshaftAHardcodedItemPort.items.wand;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;

@Getter
public enum WandCore {

    KNEAZLE_WHISKER("Kneazle Whisker", 5),
    DITTANY_STALK("Dittany Stalk",5),
    TROLL_WHISKER("Troll Whisker", 5),

    KELPIE_HAIR("Kelpie Hair",4),
    WHITE_RIVER_MONSTER_SPINE("White River Monster Spine", 4),
    SNALLYGASTER_HEARTSTRING("Snallygaster Heartstring", 4),
    ROUGARU_HAIR("Rougaru Hair", 4),
    CORAL("Coral", 4),
    JACKALOPE_ANTLER("Jackalope Antler", 4),

    VEELA_HAIR("Veela Hair", 3),

    BASILISK_HORN("Basilisk Horn", 2),
    HORNED_SERPENT_HORN("Horned Serpent Horn", 2),
    WAMPUS_CAT_HAIR("Wampus Cat Hair", 2),
    THUNDERBIRD_TAIL_FEATHER("Thunderbird Tail Feather", 2),
    THESTRAL_TAIL_HAIR("Thestral Tail Hair",2),

    PHEONIX_FEATHER("Pheonix Feather", 1),
    DRAGON_HEARTSTRING("Dragon Heartstring", 1),
    UNICORN_HAIR("Unicorn Hair", 1);

    private final String display;
    private final int rating;

    WandCore(String display, int rating) {
        this.display = display;
        this.rating = rating;
    }

    public static WandCore random(int minRating, int maxRating) {
        Random random = new Random();
        WandCore wandCore;

        ArrayList<WandCore> cores = new ArrayList<>();

        wandCore = WandCore.UNICORN_HAIR;

        for(WandCore element : WandCore.values()) {
            if(element.getRating()>=minRating && element.getRating()<=maxRating) {
                cores.add(element);
            }
        }

        int coreNum = random.nextInt(cores.size()) + 1;
        int i = 0;

        for(WandCore element : cores) {
            i++;

            if(i==coreNum) {
                wandCore = element;
                break;
            }
        }

        return wandCore;
    }

}
