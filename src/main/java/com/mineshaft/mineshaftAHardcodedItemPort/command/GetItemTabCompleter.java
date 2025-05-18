package com.mineshaft.mineshaftAHardcodedItemPort.command;

import com.mineshaft.mineshaftAHardcodedItemPort.manager.DrinkManager;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.Drinks;
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
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("ale","athelas","miruvor","ent_draught","orc_draught","teleport_scroll"),new ArrayList<>());
        } else if(args.length==2 && args[0].equals("ent_draught")) {
            return StringUtil.copyPartialMatches(args[1], Arrays.asList("blue","silver","yellow","brown","red","gold","green","purple"),new ArrayList<>());
        } else if(args.length==2 && DrinkManager.isDrink(args[0])) {
            return StringUtil.copyPartialMatches(args[1], DrinkManager.getPossibleContainers(Objects.requireNonNull(DrinkManager.getDrink(Objects.requireNonNullElse(args[0], "")))), new ArrayList<>());
        }

        return null;
    }
}
