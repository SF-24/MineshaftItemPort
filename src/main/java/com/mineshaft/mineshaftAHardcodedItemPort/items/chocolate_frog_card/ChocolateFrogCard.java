package com.mineshaft.mineshaftAHardcodedItemPort.items.chocolate_frog_card;

import com.mineshaft.mineshaftapi.nbtapi.NBT;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Getter
public enum ChocolateFrogCard {
    ALBERIC_GRUINNION(112, "Alberic Grunnion",
            new ArrayList<>(Arrays.asList(
                    "Lived 1803-1882",
                    "Inventor of the Dungbomb"))
            , ChocolateFrogCardType.SILVER, -1),

    ALBERTA_TOOTHIL(113, "Alberta Toothil",
            new ArrayList<>(Arrays.asList(
                    "Lived 1391–1483",
                    "Winner of the All-England Wizarding Duelling Competition of 1430.",
                    "Famously overcame the favourite, Samson Wiblin, with a Blasting Curse."
            ))
            , ChocolateFrogCardType.SILVER, 89),

    BERTIE_BOTT(111, "Bertie Bott",
            new ArrayList<>(Arrays.asList(
                    "Inventor of Bertie Bott’s", "Every-Flavour Beans"))
            , ChocolateFrogCardType.GOLD, -1),

    DUMBLEDORE(110, "Albus Dumbledore",
            new ArrayList<>(Arrays.asList(
                    "Currently Headmaster of Hogwarts.",
                    "Considered by many the greatest",
                    "wizard of modern times,",
                    "",
                    "Professor Dumbledore is particularly",
                    "famous for his defeat",
                    "of the dark wizard Grindelwald in 1945,",
                    "for the discovery of the twelve uses of",
                    "dragon’s blood and his work on alchemy",
                    "with his partner, Nicolas Flamel.",
                    "",
                    "Professor Dumbledore enjoys chamber music",
                    "and tenpin bowling"))
            , ChocolateFrogCardType.GOLD, 101);

    final int modelData, number;
    final String display;
    final ArrayList<String> lore;
    final ChocolateFrogCardType type;

    ChocolateFrogCard(int modelData, String display, ArrayList<String> lore, ChocolateFrogCardType type, int number) {
        this.modelData=modelData;
        this.display=display;
        this.lore=lore;
        this.type=type;
        this.number=number;
    }

    public ItemStack getItem() {
        return getItem(1);
    }

    public ItemStack getItem(int amount) {
        ItemStack itemStack = new ItemStack(Material.MINECART, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();

        ArrayList<String> lore = new ArrayList<>();

        ArrayList<String> card_lore = this.getLore();

        card_lore.forEach((n) -> lore.add(ChatColor.GRAY+n));

        itemMeta.setDisplayName(ChatColor.WHITE + this.getDisplay());
        itemMeta.setLore(lore);
        itemMeta.setCustomModelData(this.getModelData());

        itemMeta.setMaxStackSize(8);
        itemStack.setItemMeta(itemMeta);

        NBT.modify(itemStack, nbt->{
            nbt.setBoolean("disablePlacing",true);
            nbt.setString("itemType","card");
        });

        return itemStack;
    }

    public static ItemStack getRandomCard(int amount, ArrayList<ChocolateFrogCardType> types) {
        ArrayList<ChocolateFrogCard> cards = new ArrayList<>();

        if(types!=null && !types.equals(new ArrayList<>())) {
            for(ChocolateFrogCard card : ChocolateFrogCard.values()) {
                if(types.contains(card.getType())) {
                    cards.add(card);
                }
            }
        }

        if(cards.isEmpty()) {
            cards.addAll(Arrays.asList(ChocolateFrogCard.values()));
        }

        int cardValue = new Random().nextInt(cards.size());

        ChocolateFrogCard card = cards.get(cardValue);
        return card.getItem(amount);
    }

}
