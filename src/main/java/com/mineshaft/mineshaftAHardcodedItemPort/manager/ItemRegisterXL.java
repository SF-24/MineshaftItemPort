package com.mineshaft.mineshaftAHardcodedItemPort.manager;

import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.Container;
import com.mineshaft.mineshaftapi.manager.item.crafting.RecipeRegistrar;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.recipe.CraftingBookCategory;

import java.util.Collections;
import java.util.List;

import static com.mineshaft.mineshaftAHardcodedItemPort.items.FoodItemXL.*;

public class ItemRegisterXL {

    public static void register() {

        //
        // Rice, Pepper, Corn, Cucumber, Lettuce, Onion, Tomato & Strawberry recipes:
        //

        RecipeRegistrar.registerShapelessRecipeMisc(
                BUTTER_RICE.getItem(), List.of(RICE.getItem(),BUTTER.getItem())
        );

        RecipeRegistrar.registerFurnaceRecipeSimpleFood(
                RICE.getItem(),FRIED_RICE.getItem()
        );

        RecipeRegistrar.registerCraftingRecipeComplex(
                RICE_BREAD.getItem(), List.of(getItemStack(Material.WHEAT), RICE.getItem(), getItemStack(Material.WHEAT)),
                CraftingBookCategory.MISC, true, 3, 1
        );

        RecipeRegistrar.registerFurnaceRecipeSimpleFood(
                PEPPER.getItem(), HOT_SAUCE.getItem()
        );

        RecipeRegistrar.registerFurnaceRecipeSimpleFood(
                RAW_CORN.getItem(), CORN.getItem()
        );

        RecipeRegistrar.registerShapelessRecipeMisc(
                CORN_BREAD.getItem(), List.of(CORN.getItem(),getItemStack(Material.BREAD))
        );

        RecipeRegistrar.registerFurnaceRecipeSimpleFood(
                TOMATO.getItem(), TOMATO_SAUCE.getItem()
        );

        //
        // Dough, cheese, etc.
        //

        RecipeRegistrar.registerShapelessRecipeMisc(
                DOUGH.getItem(8), List.of(getItemStack(Material.WHEAT),getItemStack(Material.WHEAT),getItemStack(Material.WHEAT),getItemStack(Material.WHEAT),getItemStack(Material.WATER_BUCKET))
        );

        RecipeRegistrar.registerFurnaceRecipeSimpleFood(
                DOUGH.getItem(), COOKED_DOUGH.getItem()
        );

        RecipeRegistrar.registerShapelessRecipeMisc(
                CROUTON.getItem(4), List.of(getItemStack(Material.BREAD),BUTTER.getItem())
        );

        RecipeRegistrar.registerCraftingRecipeComplex(
                POTATO_BREAD.getItem(), List.of(getItemStack(Material.WHEAT),getItemStack(Material.BAKED_POTATO),getItemStack(Material.WHEAT)),CraftingBookCategory.MISC,true,3,1
        );

        RecipeRegistrar.registerCraftingRecipeComplex(
                BAGUETTE.getItem(), List.of(
                        getItemStack(Material.WHEAT), getItemStack(Material.AIR), getItemStack(Material.AIR),
                        getItemStack(Material.AIR), COOKED_DOUGH.getItem(), getItemStack(Material.AIR),
                        getItemStack(Material.AIR), getItemStack(Material.AIR), getItemStack(Material.WHEAT)
                ), CraftingBookCategory.MISC,true,3,3
        );

        RecipeRegistrar.registerShapelessRecipeMisc(
                BUTTER.getItem(2), List.of(
                        getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.RESIN_CLUMP)
                )
        );

        RecipeRegistrar.registerShapelessRecipeMisc(
                CHEESE.getItem(4), List.of(
                        getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET)
                )
        );

        RecipeRegistrar.registerFurnaceRecipeSimpleFood(CHEESE.getItem(),CHEESE_PUFF.getItem());

        RecipeRegistrar.registerShapelessRecipeMisc(CHEESY_BREAD.getItem(), List.of(
                getItemStack(Material.BREAD),CHEESE.getItem()
        ));

        RecipeRegistrar.registerShapelessRecipeMisc(CHIPS.getItem(8), List.of(
                getItemStack(Material.RESIN_CLUMP),COOKED_DOUGH.getItem()
        ));

        RecipeRegistrar.registerShapelessRecipeMisc(SALTY_CHIPS.getItem(), List.of(
                getItemStack(Material.RESIN_CLUMP),CHIPS.getItem()
        ));

        RecipeRegistrar.registerShapelessRecipeMisc(SPICY_CHIPS.getItem(), List.of(
                HOT_SAUCE.getItem(),CHIPS.getItem()
        ));

        RecipeRegistrar.registerFurnaceRecipeSimpleFood(ONION.getItem(),ONION_RINGS.getItem());

        RecipeRegistrar.registerFurnaceRecipeSimpleFood(getItemStack(Material.EGG),FRIED_EGG.getItem());

        RecipeRegistrar.registerCraftingRecipeComplex(PANCAKE.getItem(), List.of(
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
        ), CraftingBookCategory.MISC,true,3,1);

        RecipeRegistrar.registerCraftingRecipeComplex(WAFFLE.getItem(), List.of(
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
        ), CraftingBookCategory.MISC,true,2,2);

        RecipeRegistrar.registerShapelessRecipeMisc(WAFFLE.getItem(), List.of(
                COOKED_DOUGH.getItem(),getItemStack(Material.MILK_BUCKET)
        ));

        RecipeRegistrar.registerCraftingRecipeComplex(PANCAKE.getItem(), List.of(
                COOKED_DOUGH.getItem(),getItemStack(Material.AIR),COOKED_DOUGH.getItem(),
                getItemStack(Material.AIR),COOKED_DOUGH.getItem(),getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC,true,3,2);

        RecipeRegistrar.registerCraftingRecipeComplex(DONUT.getItem(8), List.of(
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),
                COOKED_DOUGH.getItem(),getItemStack(Material.AIR),COOKED_DOUGH.getItem(),
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
        ),CraftingBookCategory.MISC,true,3,3);

        RecipeRegistrar.registerShapelessRecipeMisc(SUGAR_DONUT.getItem(), List.of(
                getItemStack(Material.SUGAR), DONUT.getItem()
        ));

        RecipeRegistrar.registerShapelessRecipeMisc(CHOCOLATE_DONUT.getItem(), List.of(
                DONUT.getItem(),CHOCOLATE_SYRUP.getItem()
        ));

        RecipeRegistrar.registerShapelessRecipeMisc(VANILLA_DONUT.getItem(), List.of(
                VANILLA_EXTRACT.getItem(), DONUT.getItem()
        ));

        //
        // Traditional Food
        //

        RecipeRegistrar.registerShapelessRecipeMisc(ENCHILADA.getItem(), List.of(
            RICE.getItem(),TOMATO_SAUCE.getItem(), CHEESE.getItem(), ONION.getItem(),GROUND_BEEF.getItem(), TORTILLA.getItem(), TORTILLA.getItem()
        ));

        RecipeRegistrar.registerShapelessRecipeMisc(SPAGHETTI.getItem(), List.of(
            Container.CERAMIC_BOWL.getItem(), TOMATO_SAUCE.getItem(), GROUND_BEEF.getItem(), COOKED_DOUGH.getItem(), COOKED_DOUGH.getItem()
        ));

        RecipeRegistrar.registerShapelessRecipeMisc(LASAGNE.getItem(), List.of(
            COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),GROUND_BEEF.getItem(),TOMATO_SAUCE.getItem(),CHEESE.getItem()
        ));

        RecipeRegistrar.registerCraftingRecipeComplex(SAUSAGE_ROLL.getItem(), List.of(
            COOKED_DOUGH.getItem(), SAUSAGE.getItem(), COOKED_DOUGH.getItem()
        ), CraftingBookCategory.MISC, true, 1, 3);

        RecipeRegistrar.registerCraftingRecipeComplex(JAMBON_BEURRE.getItem(), List.of(
            getItemStack(Material.COOKED_PORKCHOP), BUTTER.getItem(), BAGUETTE.getItem()
        ), CraftingBookCategory.MISC, true, 1, 3);

        RecipeRegistrar.registerShapelessRecipeMisc(MACARONI_AND_CHEESE.getItem(), List.of(
            Container.CERAMIC_BOWL.getItem(), CHEESE.getItem(), COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
        ));

        //
        // MEAT:
        //

        RecipeRegistrar.registerFurnaceRecipeSimpleFood(getItemStack(Material.ROTTEN_FLESH), FLESH.getItem());

        RecipeRegistrar.registerShapelessRecipeMisc(HAM.getItem(), List.of(
            getItemStack(Material.PORKCHOP),getItemStack(Material.RESIN_CLUMP),getItemStack(Material.RESIN_CLUMP)
        ));

        RecipeRegistrar.registerCraftingRecipeComplex(SAUSAGE.getItem(3), List.of(
                getItemStack(Material.COOKED_PORKCHOP), getItemStack(Material.AIR), getItemStack(Material.AIR),
                getItemStack(Material.AIR), getItemStack(Material.COOKED_PORKCHOP), getItemStack(Material.AIR),
                getItemStack(Material.AIR), getItemStack(Material.AIR), getItemStack(Material.COOKED_PORKCHOP)
        ), CraftingBookCategory.MISC, true, 3, 3);

        RecipeRegistrar.registerCraftingRecipeComplex(SAUSAGE.getItem(3), List.of(
                getItemStack(Material.AIR), getItemStack(Material.AIR), getItemStack(Material.COOKED_PORKCHOP),
                getItemStack(Material.AIR), getItemStack(Material.COOKED_PORKCHOP), getItemStack(Material.AIR),
                getItemStack(Material.COOKED_PORKCHOP), getItemStack(Material.AIR), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        RecipeRegistrar.registerShapelessRecipeMisc(BACON.getItem(4), List.of(getItemStack(Material.PORKCHOP)));

        RecipeRegistrar.registerShapelessRecipeMisc(BEEF_JERKY.getItem(4), List.of(
                getItemStack(Material.COOKED_BEEF),getItemStack(Material.RESIN_CLUMP),getItemStack(Material.RESIN_CLUMP)
        ));

        RecipeRegistrar.registerShapelessRecipeMisc(GROUND_BEEF.getItem(2), Collections.singletonList(getItemStack(Material.COOKED_BEEF)));
        RecipeRegistrar.registerShapelessRecipeMisc(RAW_CHICKEN_WING.getItem(2), Collections.singletonList(getItemStack(Material.CHICKEN)));
        RecipeRegistrar.registerFurnaceRecipeSimpleFood(RAW_CHICKEN_WING.getItem(), COOKED_CHICKEN_WING.getItem());
        RecipeRegistrar.registerShapelessRecipeMisc(COOKED_CHICKEN_WING.getItem(2), Collections.singletonList(getItemStack(Material.COOKED_CHICKEN)));

        RecipeRegistrar.registerShapelessRecipeMisc(SPICY_CHICKEN_WING.getItem(), List.of(
            COOKED_CHICKEN_WING.getItem(), HOT_SAUCE.getItem()
        ));

        RecipeRegistrar.registerShapelessRecipeMisc(BUCKET_OF_FRIED_CHICKEN.getItem(), List.of(
            getItemStack(Material.BUCKET), getItemStack(Material.COOKED_CHICKEN)
        ));

        //
        // FAST FOOD:
        //

        RecipeRegistrar.registerCraftingRecipeComplex(TOP_BUN.getItem(), List.of(
                getItemStack(Material.AIR), getItemStack(Material.WHEAT), getItemStack(Material.AIR),
                getItemStack(Material.WHEAT), getItemStack(Material.AIR), getItemStack(Material.WHEAT)
        ), CraftingBookCategory.MISC, true, 3, 2);

        RecipeRegistrar.registerCraftingRecipeComplex(BOTTOM_BUN.getItem(), List.of(
                getItemStack(Material.WHEAT), getItemStack(Material.AIR), getItemStack(Material.WHEAT),
                getItemStack(Material.AIR), getItemStack(Material.WHEAT), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 2);

        RecipeRegistrar.registerCraftingRecipeComplex(HAMBURGER.getItem(), List.of(
                getItemStack(Material.AIR), TOP_BUN.getItem(), getItemStack(Material.AIR),
                TOMATO.getItem(), GROUND_BEEF.getItem(), CUCUMBER.getItem(),
                getItemStack(Material.AIR), BOTTOM_BUN.getItem(), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        RecipeRegistrar.registerCraftingRecipeComplex(HAMBURGER.getItem(), List.of(
                getItemStack(Material.AIR), TOP_BUN.getItem(), getItemStack(Material.AIR),
                CUCUMBER.getItem(), GROUND_BEEF.getItem(), TOMATO.getItem(),
                getItemStack(Material.AIR), BOTTOM_BUN.getItem(), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        RecipeRegistrar.registerCraftingRecipeComplex(CHICKEN_BURGER.getItem(), List.of(
                getItemStack(Material.AIR), TOP_BUN.getItem(), getItemStack(Material.AIR),
                HOT_SAUCE.getItem(), getItemStack(Material.COOKED_CHICKEN), LETTUCE.getItem(),
                getItemStack(Material.AIR), BOTTOM_BUN.getItem(), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        RecipeRegistrar.registerCraftingRecipeComplex(CHICKEN_BURGER.getItem(), List.of(
                getItemStack(Material.AIR), TOP_BUN.getItem(), getItemStack(Material.AIR),
                LETTUCE.getItem(), getItemStack(Material.COOKED_CHICKEN), HOT_SAUCE.getItem(),
                getItemStack(Material.AIR), BOTTOM_BUN.getItem(), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        RecipeRegistrar.registerCraftingRecipeComplex(CHEESEBURGER.getItem(), List.of(
                getItemStack(Material.AIR), TOP_BUN.getItem(), getItemStack(Material.AIR),
                CHEESE.getItem(), GROUND_BEEF.getItem(), CUCUMBER.getItem(),
                getItemStack(Material.AIR), BOTTOM_BUN.getItem(), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        RecipeRegistrar.registerCraftingRecipeComplex(CHEESEBURGER.getItem(), List.of(
                getItemStack(Material.AIR), TOP_BUN.getItem(), getItemStack(Material.AIR),
                CUCUMBER.getItem(), GROUND_BEEF.getItem(), CHEESE.getItem(),
                getItemStack(Material.AIR), BOTTOM_BUN.getItem(), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        RecipeRegistrar.registerCraftingRecipeComplex(HOT_DOG.getItem(), List.of(
                getItemStack(Material.AIR), COOKED_DOUGH.getItem(), getItemStack(Material.AIR),
                COOKED_DOUGH.getItem(), SAUSAGE.getItem(), COOKED_DOUGH.getItem(),
                getItemStack(Material.AIR), COOKED_DOUGH.getItem(), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        RecipeRegistrar.registerCraftingRecipeComplex(TORTILLA.getItem(), List.of(
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),
                COOKED_DOUGH.getItem(),CORN.getItem(),COOKED_DOUGH.getItem(),
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
        ),CraftingBookCategory.MISC,true, 3, 3);

        RecipeRegistrar.registerShapelessRecipeMisc(TACO.getItem(), List.of(
                TORTILLA.getItem(), TOMATO.getItem(), ONION.getItem(),GROUND_BEEF.getItem(),LETTUCE.getItem(),CHEESE.getItem()
        ));

        RecipeRegistrar.registerShapelessRecipeMisc(BURRITO.getItem(), List.of(
            TORTILLA.getItem(), TORTILLA.getItem(), TOMATO.getItem(),CHEESE.getItem(), GROUND_BEEF.getItem()
        ));

        RecipeRegistrar.registerShapelessRecipeMisc(KEBAB.getItem(), List.of(
            TORTILLA.getItem(), LETTUCE.getItem(), ONION.getItem(), TOMATO.getItem(), GROUND_BEEF.getItem()
        ));

        //
        // SANDWICHES
        //



        //
        // SUSHI
        //

        //
        // SALADS
        //

        // TODO: Add remaining recipes


    }


    public static ItemStack getItemStack(Material material) {
        return new ItemStack(material);
    }

}
