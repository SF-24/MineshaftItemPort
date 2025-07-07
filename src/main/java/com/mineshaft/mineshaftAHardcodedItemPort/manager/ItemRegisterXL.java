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
        // BASIC RECIPES
        //

        // Resin clumps are replaced with rock salt
        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(getItemStack(Material.WATER_BUCKET),getItemStack(Material.RESIN_CLUMP));

        // TODO: VANILLA FLOWERS

        // Vanilla Cream
        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(VANILLA_CREAM.getItem(), List.of(VANILLA_EXTRACT.getItem(),getItemStack(Material.SUGAR),getItemStack(Material.SUGAR)));

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
                VANILLA_CREAM.getItem(), DONUT.getItem()
        ));

        //
        // Traditional Food
        //

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(ENCHILADA.getItem(), List.of(
            RICE.getItem(),TOMATO_SAUCE.getItem(), CHEESE.getItem(), ONION.getItem(),GROUND_BEEF.getItem(), TORTILLA.getItem(), TORTILLA.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(SPAGHETTI.getItem(), List.of(
            Container.SALAD_BOWL.getItem(), TOMATO_SAUCE.getItem(), GROUND_BEEF.getItem(), COOKED_DOUGH.getItem(), COOKED_DOUGH.getItem()
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
            Container.SALAD_BOWL.getItem(), CHEESE.getItem(), COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
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

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(CHICKEN_SANDWICH.getItem(), List.of(
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),
                LETTUCE.getItem(),getItemStack(Material.COOKED_CHICKEN),LETTUCE.getItem(),
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
        ),CraftingBookCategory.MISC,true,3,3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(BLT_SANDWITCH.getItem(), List.of(
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),
                BACON.getItem(),LETTUCE.getItem(),TOMATO.getItem(),
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
         ),CraftingBookCategory.MISC,true,3,3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(BREAKFAST_SANDWITCH.getItem(), List.of(
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),
                BACON.getItem(),CHEESE.getItem(),FRIED_EGG.getItem(),
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
        ),CraftingBookCategory.MISC,true,3,3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(GRILLED_CHEESE_SANDWITCH.getItem(), List.of(
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),
                CHEESE.getItem(),CHEESE.getItem(),CHEESE.getItem(),
                COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem(),COOKED_DOUGH.getItem()
        ),CraftingBookCategory.MISC,true,3,3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(ICE_CREAM_SANDWITCH.getItem(),List.of(
                CHOCOLATE_SYRUP.getItem(),getItemStack(Material.COOKIE),CHOCOLATE_SYRUP.getItem(),
                VANILLA_ICE_CREAM_BALL.getItem(),VANILLA_ICE_CREAM_BALL.getItem(),VANILLA_ICE_CREAM_BALL.getItem(),
                CHOCOLATE_SYRUP.getItem(),getItemStack(Material.COOKIE),CHOCOLATE_SYRUP.getItem()
        ),CraftingBookCategory.MISC,true,3,3);

        //
        // SUSHI
        //

        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(getItemStack(Material.SEAGRASS),SEAWEED.getItem());

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(FUTOMAKI.getItem(), List.of(
                SEAWEED.getItem(),SEAWEED.getItem(),SEAWEED.getItem(),
                RICE.getItem(),CUCUMBER.getItem(),RICE.getItem(),
                SEAWEED.getItem(),SEAWEED.getItem(),SEAWEED.getItem()
        ),CraftingBookCategory.MISC,true,3,3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(URAMAKI.getItem(), List.of(
                RICE.getItem(),RICE.getItem(),RICE.getItem(),
                getItemStack(Material.CARROT),SEAWEED.getItem(),CUCUMBER.getItem(),
                RICE.getItem(),RICE.getItem(),RICE.getItem()
        ),CraftingBookCategory.MISC,true,3,3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(OSHIZUSHI.getItem(), List.of(
                RICE.getItem(),getItemStack(Material.SALMON),RICE.getItem(),
                RICE.getItem(),RICE.getItem(),RICE.getItem()
        ),CraftingBookCategory.MISC,true,3,3);

        //
        // SALADS
        //

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(Container.SALAD_BOWL.getItem(8), List.of(
                getItemStack(Material.STICK), getItemStack(Material.AIR), getItemStack(Material.STICK),
                getItemStack(Material.AIR), getItemStack(Material.IRON_INGOT), getItemStack(Material.AIR)
        ),CraftingBookCategory.MISC, true, 3, 2);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(GARDEN_SALAD.getItem(), List.of(
            getNullItem(), LETTUCE.getItem(), getNullItem(),
            CHEESE.getItem(), TOMATO.getItem(), CUCUMBER.getItem(),
            getNullItem(), Container.SALAD_BOWL.getItem(), getNullItem()
        ),CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(CHICKEN_SALAD.getItem(), List.of(
                ONION.getItem(), CUCUMBER.getItem(), getNullItem(),
                PEPPER.getItem(), getItemStack(Material.COOKED_CHICKEN), getItemStack(Material.EGG),
                getNullItem(), Container.SALAD_BOWL.getItem(), getNullItem()
        ),CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(CAESAR_SALAD.getItem(), List.of(
                LETTUCE.getItem(), getItemStack(Material.PUMPKIN_SEEDS), getNullItem(),
                CHEESE.getItem(), CROUTON.getItem(), getItemStack(Material.EGG),
                getNullItem(), Container.SALAD_BOWL.getItem(), getNullItem()
        ),CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(ONION_SALAD.getItem(), List.of(
                LETTUCE.getItem(), TOMATO.getItem(), ONION.getItem(),
                getNullItem(), Container.SALAD_BOWL.getItem(), getNullItem()
        ),CraftingBookCategory.MISC, true, 3, 2);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(TACO_SALAD.getItem(), List.of(
                getNullItem(), LETTUCE.getItem(), getNullItem(),
                CHEESE.getItem(), TORTILLA.getItem(), TOMATO.getItem(),
                getNullItem(), Container.SALAD_BOWL.getItem(), getNullItem()
        ),CraftingBookCategory.MISC, true, 3, 3);

        //
        // CUCUMBER SOUP
        //

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(CUCUMBER_SOUP.getItem(), List.of(
                getItemStack(Material.BAKED_POTATO), CUCUMBER.getItem(), Container.SALAD_BOWL.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(TOMATO_SOUP.getItem(), List.of(
                TOMATO.getItem(), Container.SALAD_BOWL.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(VEGETABLE_SOUP.getItem(), List.of(
                getItemStack(Material.POTATO), getItemStack(Material.CARROT), CUCUMBER.getItem(), PEPPER.getItem(), ONION.getItem(), TOMATO.getItem(), Container.SALAD_BOWL.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(CHICKEN_SOUP.getItem(), List.of(
                getItemStack(Material.CARROT), getItemStack(Material.COOKED_CHICKEN), Container.SALAD_BOWL.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(BEEF_STEW.getItem(), List.of(
                getItemStack(Material.CARROT), getItemStack(Material.COOKED_BEEF), ONION.getItem(), Container.SALAD_BOWL.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(PUMPKIN_STEW.getItem(), List.of(
                getItemStack(Material.PUMPKIN), getItemStack(Material.CARROT), getItemStack(Material.POTATO), PEPPER.getItem(), GROUND_BEEF.getItem()
        ));

        //
        // ICE CREAM, COOKIES, ETC.
        //

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(CARAMEL_APPLE.getItem(), List.of(
                getItemStack(Material.SUGAR),getItemStack(Material.SUGAR),getItemStack(Material.SUGAR),
                getItemStack(Material.SUGAR),getItemStack(Material.APPLE),getItemStack(Material.SUGAR),
                getItemStack(Material.SUGAR),getItemStack(Material.SUGAR),getItemStack(Material.SUGAR)
        ), CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(getItemStack(Material.SUGAR), MARSHMALLOW.getItem());
        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(MARSHMALLOW.getItem(),ROASTED_MARSHMALLOW.getItem());
        MineshaftItemPort.getRecipeRegistrar().registerFurnaceRecipeSimpleFood(getItemStack(Material.COCOA_BEANS),CHOCOLATE_SYRUP.getItem());

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(CHOCOLATE_COOKIE.getItem(),List.of(
                CHOCOLATE_SYRUP.getItem(),getItemStack(Material.COOKIE),CHOCOLATE_SYRUP.getItem(),
                getNullItem(),MARSHMALLOW.getItem(),getNullItem(),
                CHOCOLATE_SYRUP.getItem(),getItemStack(Material.COOKIE),CHOCOLATE_SYRUP.getItem()
        ),CraftingBookCategory.MISC,true,3,3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(VANILLA_COOKIE.getItem(),List.of(
                COOKED_DOUGH.getItem(),VANILLA_CREAM.getItem(),COOKED_DOUGH.getItem(),
                getNullItem(),COOKED_DOUGH.getItem(),getNullItem()
        ),CraftingBookCategory.MISC,true,3,2);

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(BROWNIE.getItem(), List.of(
                CHOCOLATE.getItem(),CHOCOLATE_SYRUP.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(BOURBON_BISCUIT.getItem(), List.of(
                CHOCOLATE.getItem(),CHOCOLATE_ICE_CREAM_BALL.getItem(), CHOCOLATE.getItem()
        ),CraftingBookCategory.MISC, true, 1, 3);

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(CHOCOLATE.getItem(), List.of(
                CHOCOLATE_SYRUP.getItem(),CHOCOLATE_SYRUP.getItem(),CHOCOLATE_SYRUP.getItem(),
                CHOCOLATE_SYRUP.getItem(),getItemStack(Material.COCOA_BEANS),CHOCOLATE_SYRUP.getItem(),
                CHOCOLATE_SYRUP.getItem(),CHOCOLATE_SYRUP.getItem(),CHOCOLATE_SYRUP.getItem()
        ),CraftingBookCategory.MISC,true,3,3);

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(VANILLA_ICE_CREAM_BALL.getItem(), List.of(
                getItemStack(Material.SNOWBALL),getItemStack(Material.MILK_BUCKET), VANILLA_CREAM.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(STRAWBERRY_ICE_CREAM_BALL.getItem(), List.of(
                getItemStack(Material.SNOWBALL),getItemStack(Material.MILK_BUCKET), STRAWBERRY.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(CHOCOLATE_ICE_CREAM_BALL.getItem(), List.of(
                getItemStack(Material.SNOWBALL),getItemStack(Material.MILK_BUCKET),getItemStack(Material.COCOA_BEANS), VANILLA_CREAM.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(ICE_CREAM_CONE.getItem(),List.of(
                getItemStack(Material.WHEAT), getNullItem(), getItemStack(Material.WHEAT),
                getItemStack(Material.WHEAT), getNullItem(), getItemStack(Material.WHEAT),
                getNullItem(),getItemStack(Material.WHEAT),getNullItem()
        ),CraftingBookCategory.MISC,true,3,3);

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(VANILLA_ICE_CREAM.getItem(),List.of(
                ICE_CREAM_CONE.getItem(),VANILLA_ICE_CREAM_BALL.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(STRAWBERRY_ICE_CREAM.getItem(),List.of(
                ICE_CREAM_CONE.getItem(),STRAWBERRY_ICE_CREAM_BALL.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(CHOCOLATE_ICE_CREAM.getItem(),List.of(
                ICE_CREAM_CONE.getItem(),CHOCOLATE_ICE_CREAM_BALL.getItem()
        ));

        //
        // CUPCAKES
        //

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeSimple(Container.PAPER_CUP.getItem(), List.of(
                Material.PAPER, Material.AIR, Material.PAPER,
                Material.AIR, Material.PAPER, Material.AIR
        ),CraftingBookCategory.MISC,true,3,2);

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(VANILLA_CUPCAKE.getItem(), List.of(
                Container.PAPER_CUP.getItem(),COOKED_DOUGH.getItem(),VANILLA_CREAM.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(CHOCOLATE_CUPCAKE.getItem(), List.of(
                Container.PAPER_CUP.getItem(),COOKED_DOUGH.getItem(),CHOCOLATE.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(CHOCOLATE_COOKIE_CUPCAKE.getItem(), List.of(
                Container.PAPER_CUP.getItem(),COOKED_DOUGH.getItem(),CHOCOLATE_COOKIE.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(STRAWBERRY_CUPCAKE.getItem(), List.of(
                Container.PAPER_CUP.getItem(),COOKED_DOUGH.getItem(),STRAWBERRY.getItem()
        ));

        //
        // PIES AND CAKES
        //

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(PIE_SHELL.getItem(), List.of(
                COOKED_DOUGH.getItem(), getNullItem(), COOKED_DOUGH.getItem(),
                COOKED_DOUGH.getItem(), COOKED_DOUGH.getItem(), COOKED_DOUGH.getItem()
        ), CraftingBookCategory.MISC, true, 3, 2);

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(APPLE_PIE.getItem(), List.of(
                PIE_SHELL.getItem(), getItemStack(Material.APPLE)
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(GOLDEN_APPLE_PIE.getItem(), List.of(
                PIE_SHELL.getItem(), getItemStack(Material.GOLDEN_APPLE)
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(CHEESE_PIE.getItem(), List.of(
                PIE_SHELL.getItem(), CHEESE.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(CHICKEN_POT_PIE.getItem(), List.of(
                PIE_SHELL.getItem(), getItemStack(Material.COOKED_CHICKEN)
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(CHOCOLATE_PIE.getItem(), List.of(
                PIE_SHELL.getItem(), CHOCOLATE.getItem(), CHOCOLATE_SYRUP.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(BACON_PIE.getItem(), List.of(
                PIE_SHELL.getItem(), BACON.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(FISH_PIE.getItem(), List.of(
                PIE_SHELL.getItem(), getItemStack(Material.COOKED_COD)
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(STRAWBERRY_PIE.getItem(), List.of(
                PIE_SHELL.getItem(), STRAWBERRY.getItem()
        ));

        // temp recipe, until whole pizzas are added
        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeComplex(SLICE_OF_PIZZA.getItem(4), List.of(
                COOKED_DOUGH.getItem(), COOKED_DOUGH.getItem(), COOKED_DOUGH.getItem(),
                COOKED_DOUGH.getItem(), CHEESE.getItem(), COOKED_DOUGH.getItem(),
                COOKED_DOUGH.getItem(), COOKED_DOUGH.getItem(), COOKED_DOUGH.getItem()
        ), CraftingBookCategory.MISC, true, 3, 3);

        //
        // DRINKS
        //

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeSimple(Container.CAN.getItem(2), List.of(
                Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
                Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
                Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT
        ),CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(SPEEDY_ENERGY_DRINK.getItem(), List.of(
                Container.CAN.getItem(), getItemStack(Material.SUGAR), RICE.getItem(), getItemStack(Material.WATER_BUCKET)
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(HEALTHY_ENERGY_DRINK.getItem(), List.of(
                Container.CAN.getItem(), getItemStack(Material.GHAST_TEAR), RICE.getItem(), getItemStack(Material.WATER_BUCKET), getItemStack(Material.GLISTERING_MELON_SLICE)
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(STEALTHY_ENERGY_DRINK.getItem(), List.of(
                Container.CAN.getItem(), getItemStack(Material.SUGAR), RICE.getItem(), getItemStack(Material.WATER_BUCKET), getItemStack(Material.GOLDEN_CARROT)
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(STRONG_ENERGY_DRINK.getItem(), List.of(
                Container.CAN.getItem(), getItemStack(Material.MAGMA_CREAM), RICE.getItem(), getItemStack(Material.WATER_BUCKET), getItemStack(Material.BLAZE_POWDER)
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(DEADLY_ENERGY_DRINK.getItem(), List.of(
                Container.CAN.getItem(), getItemStack(Material.FERMENTED_SPIDER_EYE), RICE.getItem(), getItemStack(Material.WATER_BUCKET), getItemStack(Material.SPIDER_EYE)
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(SUPER_ENERGY_DRINK.getItem(), List.of(
                getItemStack(Material.DIAMOND), STEALTHY_ENERGY_DRINK.getItem(), STRONG_ENERGY_DRINK.getItem(), SPEEDY_ENERGY_DRINK.getItem(), HEALTHY_ENERGY_DRINK.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeSimple(Container.GLASS_MUG.getItem(2), List.of(
                Material.GLASS, Material.GLASS, Material.AIR,
                Material.GLASS, Material.GLASS, Material.GLASS,
                Material.GLASS, Material.GLASS, Material.AIR
        ), CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(BEER.getItem(), List.of(
                RICE.getItem(), getItemStack(Material.FERMENTED_SPIDER_EYE), Container.GLASS_MUG.getItem()
        ));

        MineshaftItemPort.getRecipeRegistrar().registerCraftingRecipeSimple(Container.COFFEE_CUP.getItem(), List.of(
                Material.IRON_INGOT, Material.IRON_INGOT, Material.AIR,
                Material.IRON_INGOT, Material.IRON_INGOT, Material.STICK,
                Material.IRON_INGOT, Material.IRON_INGOT, Material.AIR
        ), CraftingBookCategory.MISC, true, 3, 3);

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(COFFEE.getItem(), List.of(
                Container.COFFEE_CUP.getItem(), getItemStack(Material.COCOA_BEANS)
        ));

        MineshaftItemPort.getRecipeRegistrar().registerShapelessRecipeMisc(CAPPUCCINO.getItem(), List.of(
                COFFEE.getItem(), getItemStack(Material.MILK_BUCKET)
        ));

        // TODO: Add remaining recipes


    }


    public static ItemStack getItemStack(Material material) {
        return new ItemStack(material);
    }

    public static ItemStack getNullItem() {
        return new ItemStack(Material.AIR);
    }

}
