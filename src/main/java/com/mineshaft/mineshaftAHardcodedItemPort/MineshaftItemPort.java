package com.mineshaft.mineshaftAHardcodedItemPort;

import com.mineshaft.mineshaftAHardcodedItemPort.command.GetItemCommand;
import com.mineshaft.mineshaftAHardcodedItemPort.command.GetItemTabCompleter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MineshaftItemPort extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gethardcodeditem").setExecutor(new GetItemCommand());
        getCommand("gethardcodeditem").setTabCompleter(new GetItemTabCompleter());
        Bukkit.getPluginManager().registerEvents(new FoodListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
