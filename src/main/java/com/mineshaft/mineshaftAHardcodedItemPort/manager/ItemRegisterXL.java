package com.mineshaft.mineshaftAHardcodedItemPort.manager;

import com.mineshaft.mineshaftAHardcodedItemPort.items.FoodItemXL;
import com.mineshaft.mineshaftapi.manager.item.crafting.RecipeRegistrar;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.recipe.CraftingBookCategory;

import java.util.List;

public class ItemRegisterXL {

    public static void register() {

        // Rice, Pepper, Corn, Cucumber, Lettuce, Onion, Tomato & Strawberry recipes:
        RecipeRegistrar.registerShapelessRecipeMisc(
                FoodItemXL.BUTTER_RICE.getFood(), List.of(FoodItemXL.RICE.getFood(),FoodItemXL.BUTTER.getFood())
        );

        RecipeRegistrar.registerFurnaceRecipeSimpleFood(
                FoodItemXL.RICE.getFood(),FoodItemXL.FRIED_RICE.getFood()
        );

        RecipeRegistrar.registerCraftingRecipeComplex(
                FoodItemXL.RICE_BREAD.getFood(), List.of(getItemStack(Material.WHEAT), FoodItemXL.RICE.getFood(), getItemStack(Material.WHEAT)),
                CraftingBookCategory.MISC, true, 3, 1
        );
    }

    public static ItemStack getItemStack(Material material) {
        return new ItemStack(material);
    }

}
