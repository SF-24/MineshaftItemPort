package com.mineshaft.mineshaftAHardcodedItemPort;

import com.mineshaft.mineshaftAHardcodedItemPort.command.GetItemCommand;
import com.mineshaft.mineshaftAHardcodedItemPort.command.GetItemTabCompleter;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.ConfigManager;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.CropListener;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.ItemRegisterXL;
import com.mineshaft.mineshaftapi.manager.item.crafting.RecipeRegistrar;
import com.mineshaft.mineshaftapi.util.Logger;
import dev.jsinco.brewery.bukkit.api.TheBrewingProjectApi;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class MineshaftItemPort extends JavaPlugin {

    @Getter
    private static RecipeRegistrar recipeRegistrar;
    @Getter
    private final ConfigManager configManager = new ConfigManager();

    @Getter
    RegisteredServiceProvider<TheBrewingProjectApi> tbpProvider = Bukkit.getServicesManager().getRegistration(TheBrewingProjectApi.class);

    @Getter
    TheBrewingProjectApi brewingProjectApi;

    @Override
    public void onEnable() {
        System.out.println("Mineshaft Item Port enabled");

        // Load brewing project dependency
        if (tbpProvider != null) {
            brewingProjectApi = tbpProvider.getProvider();
            Logger.logInfo("Loaded The Brewing Project as a dependency");
//            // Add your integration
//            tbp.getIntegrationManager().register(IntegrationTypes.ITEM,
//                    new MyItemIntegration()
//            );
        }


        getCommand("gethardcodeditem").setExecutor(new GetItemCommand());
        getCommand("gethardcodeditem").setTabCompleter(new GetItemTabCompleter());

        Bukkit.getPluginManager().registerEvents(new FoodListener(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new CropListener(), this);
        configManager.setupConfig();

        recipeRegistrar = new RecipeRegistrar("mineshaftitemport");
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
