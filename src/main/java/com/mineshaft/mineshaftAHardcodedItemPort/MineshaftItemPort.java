package com.mineshaft.mineshaftAHardcodedItemPort;

import com.mineshaft.mineshaftAHardcodedItemPort.command.GetItemCommand;
import com.mineshaft.mineshaftAHardcodedItemPort.command.GetItemTabCompleter;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.ConfigManager;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.ItemRegisterXL;
import com.mineshaft.mineshaftapi.manager.item.crafting.RecipeRegistrar;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MineshaftItemPort extends JavaPlugin {

    @Getter
    private static final RecipeRegistrar recipeRegistrar = new RecipeRegistrar("mineshaft_item_port");
    @Getter
    private final ConfigManager configManager = new ConfigManager();

    @Override
    public void onEnable() {
        System.out.println("Mineshaft Item Port enabled");
        getCommand("gethardcodeditem").setExecutor(new GetItemCommand());
        getCommand("gethardcodeditem").setTabCompleter(new GetItemTabCompleter());

        Bukkit.getPluginManager().registerEvents(new FoodListener(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        configManager.setupConfig();

        ItemRegisterXL.register();
    }

    @Override
    public void onDisable() {
        // Deregister recipes
        getRecipeRegistrar().clearRecipes();
    }

    public static MineshaftItemPort getInstance() {
        return MineshaftItemPort.getPlugin(MineshaftItemPort.class);
    }
}
