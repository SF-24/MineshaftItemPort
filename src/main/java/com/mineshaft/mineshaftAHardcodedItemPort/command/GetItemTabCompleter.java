package com.mineshaft.mineshaftAHardcodedItemPort.command;

import com.mineshaft.mineshaftAHardcodedItemPort.items.*;
import com.mineshaft.mineshaftAHardcodedItemPort.items.chocolate_frog_card.ChocolateFrogCard;
import com.mineshaft.mineshaftAHardcodedItemPort.items.wand.WandCore;
import com.mineshaft.mineshaftAHardcodedItemPort.items.wand.WandType;
import com.mineshaft.mineshaftAHardcodedItemPort.items.wand.WandWood;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.Container;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.drinks.DrinkManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GetItemTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if(args.length==1) {
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("lotr","teleport_scroll","make_container","xl_food","container","create","currency","wand","chocolate_frog_card","food"),new ArrayList<>());
        } else if(args.length==2 && args[0].equalsIgnoreCase("lotr")) {
            return StringUtil.copyPartialMatches(args[1], Arrays.asList("ale","athelas","miruvor","ent_draught","orc_draught"), new ArrayList<>());
        } else if(args.length==3 && args[0].equalsIgnoreCase("lotr") && args[1].equals("ent_draught")) {
            return StringUtil.copyPartialMatches(args[2], Arrays.asList("blue","silver","yellow","brown","red","gold","green","purple"),new ArrayList<>());
        } else if(args.length==2 && args[0].equals("xl_food")) {
            ArrayList<String> itemList = new ArrayList<>();
            for(FoodItemXL foodItemXL: FoodItemXL.values()) {
                itemList.add(foodItemXL.name().toLowerCase());
            }
            return StringUtil.copyPartialMatches(args[1], itemList,new ArrayList<>());
        } else if(args.length==2 && args[0].equals("create")) {
            ArrayList<String> itemList = new ArrayList<>();
            for(FoodItemTech item: FoodItemTech.values()) {
                itemList.add(item.name().toLowerCase());
            }
            for(ItemTech item: ItemTech.values()) {
                itemList.add(item.name().toLowerCase());
            }
            return StringUtil.copyPartialMatches(args[1], itemList,new ArrayList<>());
        } else if(args.length==2 && args[0].equals("container")) {
            ArrayList<String> itemList = new ArrayList<>();
            for(Container item: Container.values()) {
                itemList.add(item.name().toLowerCase());
            }
            return StringUtil.copyPartialMatches(args[1], itemList,new ArrayList<>());
        } else if(args.length==2 && args[0].equals("food")) {
            ArrayList<String> itemList = new ArrayList<>();
            for(FoodItem i: FoodItem.values()) {
                if(i!=FoodItem.CHOCOLATE_FROG_PACKAGED_OPENED && i!=FoodItem.CHOCOLATE_FROG_SPECIAL_PACKAGED_OPENED && i!=FoodItem.CHOCOLATE_FROG_SPECIAL_PACKAGED) {
                    itemList.add(i.name().toLowerCase());
                }
            }
            return StringUtil.copyPartialMatches(args[1], itemList,new ArrayList<>());
        } else if(args.length==2 && args[0].equals("currency")) {
            ArrayList<String> itemList = new ArrayList<>();
            for(CurrencyItem item: CurrencyItem.values()) {
                itemList.add(item.name().toLowerCase());
            }
            return StringUtil.copyPartialMatches(args[1], itemList,new ArrayList<>());
        } else if(args.length==2 && args[0].equals("chocolate_frog_card")) {
            ArrayList<String> itemList = new ArrayList<>();
            for(ChocolateFrogCard item: ChocolateFrogCard.values()) {
                itemList.add(item.name().toLowerCase());
            }
            return StringUtil.copyPartialMatches(args[1], itemList,new ArrayList<>());
        }else if(args.length>=2 && args[0].equals("wand")) {
            if(args.length==2) {
                ArrayList<String> itemList = new ArrayList<>();
                for(WandType item: WandType.values()) {
                    itemList.add(item.name().toLowerCase());
                }
                return StringUtil.copyPartialMatches(args[1], itemList,new ArrayList<>());
            } else if(args.length==3) {
                ArrayList<String> itemList = new ArrayList<>();
                for(WandCore item: WandCore.values()) {
                    itemList.add(item.name().toLowerCase());
                }
                return StringUtil.copyPartialMatches(args[2], itemList,new ArrayList<>());
            } else if(args.length==4) {
                ArrayList<String> itemList = new ArrayList<>();
                for(WandWood item: WandWood.values()) {
                    itemList.add(item.name().toLowerCase());
                }
                return StringUtil.copyPartialMatches(args[3], itemList,new ArrayList<>());
            }
        }else if(args.length==3 && DrinkManager.isDrink(args[1])) {
            return StringUtil.copyPartialMatches(args[1], DrinkManager.getPossibleContainers(Objects.requireNonNull(DrinkManager.getDrink(Objects.requireNonNullElse(args[0], "")))), new ArrayList<>());
        } else if(args.length==2 && args[0].equals("make_container")) {
            return StringUtil.copyPartialMatches(args[1], List.of(Container.TANKARD.name(),Container.BOTTLE.name(),Container.BOWL.name()), new ArrayList<>());
        }
        return null;
    }
}
