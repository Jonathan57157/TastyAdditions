package de.jonathan57157.food_mod_2.block;

import de.jonathan57157.food_mod_2.FoodMod2;
import de.jonathan57157.food_mod_2.block.custom.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block ICE_CREAM_MAKER = registerBlock("ice_cream_maker", properties -> new IceCreamMakerBlock(properties.nonOpaque()));
    public static final Block CHEESE_BLOCK = registerBlock("cheese_block", properties -> new Block(properties.sounds(BlockSoundGroup.MUD)));
    public static final Block BURGER_BLOCK = registerBlockWithoutBlockItem("burger_block", properties -> new BurgerBlock(properties.sounds(BlockSoundGroup.STEM).nonOpaque()));
    public static final Block BLUEBERRY_BUSH = registerBlock("blueberry_bush", properties -> new BlueberryBushBlock(properties.sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block LETTUCE_CROP = registerBlockWithoutBlockItem("lettuce_crop",
            properties -> new LettuceCropBlock(properties.noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.NORMAL).mapColor(MapColor.DARK_GREEN)));
    public static final Block TOMATO_CROP = registerBlockWithoutBlockItem("tomato_crop",
            properties -> new TomatoCropBlock(properties.noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.RED)));

    public static final Block CUTTING_BOARD = registerBlock("cutting_board", Block::new);

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(FoodMod2.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(FoodMod2.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(FoodMod2.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(FoodMod2.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FoodMod2.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FoodMod2.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        FoodMod2.LOGGER.info("Registering Mod Blocks for " + FoodMod2.MOD_ID);
    }
}
