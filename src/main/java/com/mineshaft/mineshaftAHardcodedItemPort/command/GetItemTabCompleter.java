package com.mineshaft.mineshaftAHardcodedItemPort.command;

import com.mineshaft.mineshaftAHardcodedItemPort.items.FoodItemXL;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.Container;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.drinks.DrinkManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.*;

public class GetItemTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {

        if(args.length==1) {
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("ale","athelas","miruvor","ent_draught","orc_draught","teleport_scroll","make_container","xl_food"),new ArrayList<>());
        } else if(args.length==2 && args[0].equals("ent_draught")) {
            return StringUtil.copyPartialMatches(args[1], Arrays.asList("blue","silver","yellow","brown","red","gold","green","purple"),new ArrayList<>());
        } else if(args.length==2 && args[0].equals("xl_food")) {
            ArrayList<String> itemList = new ArrayList<>();
            for(FoodItemXL foodItemXL: FoodItemXL.values()) {
                itemList.add(foodItemXL.name().toLowerCase());
            }
            return StringUtil.copyPartialMatches(args[1], itemList,new ArrayList<>());
        } else if(args.length==2 && DrinkManager.isDrink(args[0])) {
            return StringUtil.copyPartialMatches(args[1], DrinkManager.getPossibleContainers(Objects.requireNonNull(DrinkManager.getDrink(Objects.requireNonNullElse(args[0], "")))), new ArrayList<>());
        } else if(args.length==2 && args[0].equals("make_container")) {
            return StringUtil.copyPartialMatches(args[1], List.of(Container.TANKARD.name(),Container.BOTTLE.name(),Container.BOWL.name()), new ArrayList<>());
        }

        return null;
    }
}
