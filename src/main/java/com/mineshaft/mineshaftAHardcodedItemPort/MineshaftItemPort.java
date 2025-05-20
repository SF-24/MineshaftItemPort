package com.mineshaft.mineshaftAHardcodedItemPort;

import com.mineshaft.mineshaftAHardcodedItemPort.command.GetItemCommand;
import com.mineshaft.mineshaftAHardcodedItemPort.command.GetItemTabCompleter;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MineshaftItemPort extends JavaPlugin {

    private final ConfigManager configManager = new ConfigManager();

    @Override
    public void onEnable() {
        System.out.println("Mineshaft Item Port enabled");
        getCommand("gethardcodeditem").setExecutor(new GetItemCommand());
        getCommand("gethardcodeditem").setTabCompleter(new GetItemTabCompleter());

        Bukkit.getPluginManager().registerEvents(new FoodListener(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        configManager.setupConfig();
    }

    public static MineshaftItemPort getInstance() {
        return MineshaftItemPort.getPlugin(MineshaftItemPort.class);
    }
    public ConfigManager getConfigManager() {return configManager;}
}
