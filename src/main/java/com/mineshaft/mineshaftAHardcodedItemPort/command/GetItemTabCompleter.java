package com.mineshaft.mineshaftAHardcodedItemPort.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetItemTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {

        if(args.length==1) {
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("athelas_soup","miruvor","ent_draught","ocr_draught","teleport_scroll"),new ArrayList<>());
        } else if(args.length==2 && args[0].equals("ent_draught")) {
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("blue","silver","yellow","brown","red","gold","green","purple"),new ArrayList<>());
        }

        return null;
    }
}
