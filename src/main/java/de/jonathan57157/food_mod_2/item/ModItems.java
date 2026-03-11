package de.jonathan57157.food_mod_2.item;

import de.jonathan57157.food_mod_2.FoodMod2;
import de.jonathan57157.food_mod_2.block.ModBlocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item BLUEBERRY_ICE_CREAM = registerItem("blueberry_ice_cream", setting -> new Item(setting.food(ModFoodComponents.ICE_CREAM).maxCount(1)));
    public static final Item STRAWBERRY_ICE_CREAM = registerItem("strawberry_ice_cream", setting -> new Item(setting.food(ModFoodComponents.ICE_CREAM).maxCount(1)));
    public static final Item APPLE_ICE_CREAM = registerItem("apple_ice_cream", setting -> new Item(setting.food(ModFoodComponents.ICE_CREAM).maxCount(1)));
    public static final Item ICE_CREAM_WAFER = registerItem("ice_cream_wafer", setting -> new Item(setting.food(ModFoodComponents.ICE_CREAM_WAFER).maxCount(16)));
    public static final Item SCOOP_OF_STRAWBERRY_ICE_CREAM = registerItem("scoop_of_strawberry_ice_cream", Item::new);
    public static final Item SCOOP_OF_BLUEBERRY_ICE_CREAM = registerItem("scoop_of_blueberry_ice_cream", Item::new);
    public static final Item SCOOP_OF_APPLE_ICE_CREAM = registerItem("scoop_of_apple_ice_cream", Item::new);
    public static final Item BURGER = registerItem("burger", setting -> new BlockItem(ModBlocks.BURGER_BLOCK, setting.food(ModFoodComponents.BURGER)));
    public static final Item LETTUCE_SEEDS = registerItem("lettuce_seeds", setting -> new BlockItem(ModBlocks.LETTUCE_CROP, setting));
    public static final Item LETTUCE = registerItem("lettuce", setting -> new Item(setting.food(ModFoodComponents.LETTUCE)));
    public static final Item CHEESE = registerItem("cheese", setting -> new Item(setting.food(ModFoodComponents.CHEESE)));
    public static final Item APPLE_JUICE = registerItem("apple_juice", DrinkableItem::new);
    public static final Item PUMPKIN_SOUP = registerItem("pumpkin_soup", setting -> new Item(setting.food(ModFoodComponents.PUMPKIN_SOUP)));
    public static final Item TOMATO = registerItem("tomato", setting -> new Item(setting.food(ModFoodComponents.TOMATO)));
    public static final Item HALF_TOMATO = registerItem("half_tomato", setting -> new Item(setting.food(ModFoodComponents.HALF_TOMATO)));
    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds", setting -> new BlockItem(ModBlocks.TOMATO_CROP, setting));
    public static final Item BLUEBERRY = registerItem("blueberry", setting -> new BlockItem(ModBlocks.BLUEBERRY_BUSH, setting.food(ModFoodComponents.BLUEBERRIES)));
    public static final Item STRAWBERRY = registerItem("strawberry", setting -> new Item(setting.food(ModFoodComponents.STRAWBERRY)));
    public static final Item KNIFE = registerItem("knife", Item::new);

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(FoodMod2.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FoodMod2.MOD_ID, name)))));
    }

    public static void registerModItems() {
        FoodMod2.LOGGER.info("Registering Mod Items for " + FoodMod2.MOD_ID);
    }
}
