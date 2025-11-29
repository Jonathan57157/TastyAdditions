package de.jonathan57157.food_mod_2.item;

import de.jonathan57157.food_mod_2.FoodMod2;
import de.jonathan57157.food_mod_2.block.ModBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item ICE_CREAM_1_2_3 = registerItem("ice_cream_1_2_3", new Item(new Item.Settings().food(ModFoodComponents.ICE_CREAM_CONE).maxCount(1)));
    public static final Item ICE_CREAM_WAFER = registerItem("ice_cream_wafer", new Item(new Item.Settings().food(ModFoodComponents.ICE_CREAM_WAFER).maxCount(16)));
    public static final Item SCOOP_OF_STRAWBERRY_ICE_CREAM = registerItem("scoop_of_strawberry_ice_cream", new Item(new Item.Settings()));
    public static final Item SCOOP_OF_BLUEBERRY_ICE_CREAM = registerItem("scoop_of_blueberry_ice_cream", new Item(new Item.Settings()));
    public static final Item SCOOP_OF_APPLE_ICE_CREAM = registerItem("scoop_of_apple_ice_cream", new Item(new Item.Settings()));
    public static final Item BURGER = registerItem("burger", new AliasedBlockItem(ModBlocks.BURGER_BLOCK, new Item.Settings().food(ModFoodComponents.BURGER)));
    public static final Item LETTUCE_SEEDS = registerItem("lettuce_seeds", new AliasedBlockItem(ModBlocks.LETTUCE_CROP, new Item.Settings()));
    public static final Item LETTUCE = registerItem("lettuce", new Item(new Item.Settings().food(ModFoodComponents.LETTUCE)));
    public static final Item CHEESE = registerItem("cheese", new Item(new Item.Settings().food(ModFoodComponents.CHEESE)));
    public static final Item APPLE_JUICE = registerItem("apple_juice", new DrinkableItem(new Item.Settings()));
    public static final Item PUMPKIN_SOUP = registerItem("pumpkin_soup", new Item(new Item.Settings().food(ModFoodComponents.PUMPKIN_SOUP)));
    public static final Item TOMATO = registerItem("tomato", new Item(new Item.Settings().food(ModFoodComponents.TOMATO)));
    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds", new AliasedBlockItem(ModBlocks.TOMATO_CROP, new Item.Settings()));
    public static final Item BLUEBERRIES = registerItem("blueberries", new Item(new Item.Settings().food(ModFoodComponents.BLUEBERRIES)));
    public static final Item BLUEBERRY_SEEDS = registerItem("blueberry_seeds", new AliasedBlockItem(ModBlocks.BLUEBERRY_BUSH, new Item.Settings()));

    private static Item registerItem(String name , Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FoodMod2.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FoodMod2.LOGGER.info("Registering Mod Items for " + FoodMod2.MOD_ID);
    }
}
