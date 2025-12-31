package de.jonathan57157.food_mod_2.item;

import de.jonathan57157.food_mod_2.FoodMod2;
import de.jonathan57157.food_mod_2.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup FOOD_MOD_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FoodMod2.MOD_ID, "food_mod_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ICE_CREAM_1_2_3))
                    .displayName(Text.translatable("itemgroup.food_mod_2.food_mod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ICE_CREAM_1_2_3);
                        entries.add(ModItems.ICE_CREAM_1);
                        entries.add(ModItems.ICE_CREAM_2);
                        entries.add(ModItems.ICE_CREAM_WAFER);
                        entries.add(ModItems.SCOOP_OF_STRAWBERRY_ICE_CREAM);
                        entries.add(ModItems.SCOOP_OF_BLUEBERRY_ICE_CREAM);
                        entries.add(ModItems.SCOOP_OF_APPLE_ICE_CREAM);
                        entries.add(ModItems.BURGER);
                        entries.add(ModItems.LETTUCE);
                        entries.add(ModItems.LETTUCE_SEEDS);
                        entries.add(ModItems.CHEESE);
                        entries.add(ModItems.PUMPKIN_SOUP);
                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.HALF_TOMATO);
                        entries.add(ModItems.QUARTERED_TOMATO);
                        entries.add(ModItems.TOMATO_SEEDS);
                        entries.add(ModItems.BLUEBERRY_SEEDS);
                        entries.add(ModItems.BLUEBERRY);
                        entries.add(ModItems.STRAWBERRY);
                        entries.add(ModItems.KNIFE);

                        entries.add(ModBlocks.ICE_CREAM_MAKER);
                        entries.add(ModBlocks.CHEESE_BLOCK);
                        entries.add(ModBlocks.CUTTING_BOARD);
                    }).build());

    public static void registerItemGroups() {
        FoodMod2.LOGGER.info("Registering Item Groups for " + FoodMod2.MOD_ID);
    }
}
