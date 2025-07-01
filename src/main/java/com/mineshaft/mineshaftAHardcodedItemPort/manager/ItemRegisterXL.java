package com.mineshaft.mineshaftAHardcodedItemPort.manager;

import com.mineshaft.mineshaftAHardcodedItemPort.MineshaftItemPort;
import com.mineshaft.mineshaftAHardcodedItemPort.manager.container.Container;
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

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(
                BUTTER_RICE.getItem(), List.of(RICE.getItem(),BUTTER.getItem())
        );

        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(
                RICE.getItem(),FRIED_RICE.getItem()
        );

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(
                RICE_BREAD.getItem(), List.of(getItemStack(Material.WHEAT), RICE.getItem(), getItemStack(Material.WHEAT)),
                CraftingBookCategory.MISC, true, 3, 1
        );

        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(
                PEPPER.getItem(), HOT_SAUCE.getItem()
        );

        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(
                RAW_CORN.getItem(), CORN.getItem()
        );

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(
                CORN_BREAD.getItem(), List.of(CORN.getItem(),getItemStack(Material.BREAD))
        );

        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(
                TOMATO.getItem(), TOMATO_SAUCE.getItem()
        );

        //
        // Dough, cheese, etc.
        //

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(
                DOUGH.getItem(8), List.of(getItemStack(Material.WHEAT),getItemStack(Material.WHEAT),getItemStack(Material.WHEAT),getItemStack(Material.WHEAT),getItemStack(Material.WATER_BUCKET))
        );

        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(
                DOUGH.getItem(), COOKED_DOUGH.getItem()
        );

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(
                CROUTON.getItem(4), List.of(getItemStack(Material.BREAD),BUTTER.getItem())
        );

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(
                POTATO_BREAD.getItem(), List.of(getItemStack(Material.WHEAT),getItemStack(Material.BAKED_POTATO),getItemStack(Material.WHEAT)),CraftingBookCategory.MISC,true,3,1
        );

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(
                BAGUETTE.getItem(), List.of(
                        getItemStack(Material.WHEAT), getItemStack(Material.AIR), getItemStack(Material.AIR),
                        getItemStack(Material.AIR), COOKED_DOUGH.getItem(), getItemStack(Material.AIR),
                        getItemStack(Material.AIR), getItemStack(Material.AIR), getItemStack(Material.WHEAT)
                ), CraftingBookCategory.MISC,true,3,3
        );

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(
                BUTTER.getItem(2), List.of(
                        getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.RESIN_CLUMP)
                )
        );

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(
                CHEESE.getItem(4), List.of(
                        getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET),getItemStack(Material.MILK_BUCKET)
                )
        );

        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(CHEESE.getItem(),CHEESE_PUFF.getItem());

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(CHEESY_BREAD.getItem(), List.of(
                getItemStack(Material.BREAD),CHEESE.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(CHIPS.getItem(8), List.of(
                getItemStack(Material.RESIN_CLUMP),COOKED_DOUGH.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(SALTY_CHIPS.getItem(), List.of(
                getItemStack(Material.RESIN_CLUMP),CHIPS.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(SPICY_CHIPS.getItem(), List.of(
                HOT_SAUCE.getItem(),CHIPS.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(ONION.getItem(),ONION_RINGS.getItem());

        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(getItemStack(Material.EGG),FRIED_EGG.getItem());

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(PANCAKE.getItem(), List.of(
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
        ), CraftingBookCategory.MISC,true,3,1);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(WAFFLE.getItem(), List.of(
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
        ), CraftingBookCategory.MISC,true,2,2);

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(WAFFLE.getItem(), List.of(
                COOKED_DOUGH.getItem(),getItemStack(Material.MILK_BUCKET)
        ));

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(PANCAKE.getItem(), List.of(
                COOKED_DOUGH.getItem(),getItemStack(Material.AIR),COOKED_DOUGH.getItem(),
                getItemStack(Material.AIR),COOKED_DOUGH.getItem(),getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC,true,3,2);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(DONUT.getItem(8), List.of(
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),
                COOKED_DOUGH.getItem(),getItemStack(Material.AIR),COOKED_DOUGH.getItem(),
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
        ),CraftingBookCategory.MISC,true,3,3);

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(SUGAR_DONUT.getItem(), List.of(
                getItemStack(Material.SUGAR), DONUT.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(CHOCOLATE_DONUT.getItem(), List.of(
                DONUT.getItem(),CHOCOLATE_SYRUP.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(VANILLA_DONUT.getItem(), List.of(
                VANILLA_EXTRACT.getItem(), DONUT.getItem()
        ));

        //
        // Traditional Food
        //

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(ENCHILADA.getItem(), List.of(
            RICE.getItem(),TOMATO_SAUCE.getItem(), CHEESE.getItem(), ONION.getItem(),GROUND_BEEF.getItem(), TORTILLA.getItem(), TORTILLA.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(SPAGHETTI.getItem(), List.of(
            Container.CERAMIC_BOWL.getItem(), TOMATO_SAUCE.getItem(), GROUND_BEEF.getItem(), COOKED_DOUGH.getItem(), COOKED_DOUGH.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(LASAGNE.getItem(), List.of(
            COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),GROUND_BEEF.getItem(),TOMATO_SAUCE.getItem(),CHEESE.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(SAUSAGE_ROLL.getItem(), List.of(
            COOKED_DOUGH.getItem(), SAUSAGE.getItem(), COOKED_DOUGH.getItem()
        ), CraftingBookCategory.MISC, true, 1, 3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(JAMBON_BEURRE.getItem(), List.of(
            getItemStack(Material.COOKED_PORKCHOP), BUTTER.getItem(), BAGUETTE.getItem()
        ), CraftingBookCategory.MISC, true, 1, 3);

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(MACARONI_AND_CHEESE.getItem(), List.of(
            Container.CERAMIC_BOWL.getItem(), CHEESE.getItem(), COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
        ));

        //
        // MEAT:
        //

        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(getItemStack(Material.ROTTEN_FLESH), FLESH.getItem());

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(HAM.getItem(), List.of(
            getItemStack(Material.PORKCHOP),getItemStack(Material.RESIN_CLUMP),getItemStack(Material.RESIN_CLUMP)
        ));

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(SAUSAGE.getItem(3), List.of(
                getItemStack(Material.COOKED_PORKCHOP), getItemStack(Material.AIR), getItemStack(Material.AIR),
                getItemStack(Material.AIR), getItemStack(Material.COOKED_PORKCHOP), getItemStack(Material.AIR),
                getItemStack(Material.AIR), getItemStack(Material.AIR), getItemStack(Material.COOKED_PORKCHOP)
        ), CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(SAUSAGE.getItem(3), List.of(
                getItemStack(Material.AIR), getItemStack(Material.AIR), getItemStack(Material.COOKED_PORKCHOP),
                getItemStack(Material.AIR), getItemStack(Material.COOKED_PORKCHOP), getItemStack(Material.AIR),
                getItemStack(Material.COOKED_PORKCHOP), getItemStack(Material.AIR), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(BACON.getItem(4), List.of(getItemStack(Material.PORKCHOP)));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(BEEF_JERKY.getItem(4), List.of(
                getItemStack(Material.COOKED_BEEF),getItemStack(Material.RESIN_CLUMP),getItemStack(Material.RESIN_CLUMP)
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(GROUND_BEEF.getItem(2), Collections.singletonList(getItemStack(Material.COOKED_BEEF)));
        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(RAW_CHICKEN_WING.getItem(2), Collections.singletonList(getItemStack(Material.CHICKEN)));
        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(RAW_CHICKEN_WING.getItem(), COOKED_CHICKEN_WING.getItem());
        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(COOKED_CHICKEN_WING.getItem(2), Collections.singletonList(getItemStack(Material.COOKED_CHICKEN)));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(SPICY_CHICKEN_WING.getItem(), List.of(
            COOKED_CHICKEN_WING.getItem(), HOT_SAUCE.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(BUCKET_OF_FRIED_CHICKEN.getItem(), List.of(
            getItemStack(Material.BUCKET), getItemStack(Material.COOKED_CHICKEN)
        ));

        //
        // FAST FOOD:
        //

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(TOP_BUN.getItem(), List.of(
                getItemStack(Material.AIR), getItemStack(Material.WHEAT), getItemStack(Material.AIR),
                getItemStack(Material.WHEAT), getItemStack(Material.AIR), getItemStack(Material.WHEAT)
        ), CraftingBookCategory.MISC, true, 3, 2);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(BOTTOM_BUN.getItem(), List.of(
                getItemStack(Material.WHEAT), getItemStack(Material.AIR), getItemStack(Material.WHEAT),
                getItemStack(Material.AIR), getItemStack(Material.WHEAT), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 2);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(HAMBURGER.getItem(), List.of(
                getItemStack(Material.AIR), TOP_BUN.getItem(), getItemStack(Material.AIR),
                TOMATO.getItem(), GROUND_BEEF.getItem(), CUCUMBER.getItem(),
                getItemStack(Material.AIR), BOTTOM_BUN.getItem(), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(HAMBURGER.getItem(), List.of(
                getItemStack(Material.AIR), TOP_BUN.getItem(), getItemStack(Material.AIR),
                CUCUMBER.getItem(), GROUND_BEEF.getItem(), TOMATO.getItem(),
                getItemStack(Material.AIR), BOTTOM_BUN.getItem(), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(CHICKEN_BURGER.getItem(), List.of(
                getItemStack(Material.AIR), TOP_BUN.getItem(), getItemStack(Material.AIR),
                HOT_SAUCE.getItem(), getItemStack(Material.COOKED_CHICKEN), LETTUCE.getItem(),
                getItemStack(Material.AIR), BOTTOM_BUN.getItem(), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(CHICKEN_BURGER.getItem(), List.of(
                getItemStack(Material.AIR), TOP_BUN.getItem(), getItemStack(Material.AIR),
                LETTUCE.getItem(), getItemStack(Material.COOKED_CHICKEN), HOT_SAUCE.getItem(),
                getItemStack(Material.AIR), BOTTOM_BUN.getItem(), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(CHEESEBURGER.getItem(), List.of(
                getItemStack(Material.AIR), TOP_BUN.getItem(), getItemStack(Material.AIR),
                CHEESE.getItem(), GROUND_BEEF.getItem(), CUCUMBER.getItem(),
                getItemStack(Material.AIR), BOTTOM_BUN.getItem(), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(CHEESEBURGER.getItem(), List.of(
                getItemStack(Material.AIR), TOP_BUN.getItem(), getItemStack(Material.AIR),
                CUCUMBER.getItem(), GROUND_BEEF.getItem(), CHEESE.getItem(),
                getItemStack(Material.AIR), BOTTOM_BUN.getItem(), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(HOT_DOG.getItem(), List.of(
                getItemStack(Material.AIR), COOKED_DOUGH.getItem(), getItemStack(Material.AIR),
                COOKED_DOUGH.getItem(), SAUSAGE.getItem(), COOKED_DOUGH.getItem(),
                getItemStack(Material.AIR), COOKED_DOUGH.getItem(), getItemStack(Material.AIR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(TORTILLA.getItem(), List.of(
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),
                COOKED_DOUGH.getItem(),CORN.getItem(),COOKED_DOUGH.getItem(),
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
        ),CraftingBookCategory.MISC,true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(TACO.getItem(), List.of(
                TORTILLA.getItem(), TOMATO.getItem(), ONION.getItem(),GROUND_BEEF.getItem(),LETTUCE.getItem(),CHEESE.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(BURRITO.getItem(), List.of(
            TORTILLA.getItem(), TORTILLA.getItem(), TOMATO.getItem(),CHEESE.getItem(), GROUND_BEEF.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(KEBAB.getItem(), List.of(
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
