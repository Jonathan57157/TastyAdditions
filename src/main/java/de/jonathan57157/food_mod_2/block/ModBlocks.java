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
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block ICE_CREAM_MAKER = registerBlock("ice_cream_maker", new IceCreamMakerBlock(AbstractBlock.Settings.create().nonOpaque()));
    public static final Block CHEESE_BLOCK = registerBlock("cheese_block", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.MUD)));
    public static final Block BURGER_BLOCK = registerBlockWithoutBlockItem("burger_block", new BurgerBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STEM).nonOpaque()));
    public static final Block BLUEBERRY_BUSH = registerBlockWithoutBlockItem("blueberry_bush", new BlueberryBushBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));

    public static final Block LETTUCE_CROP = registerBlockWithoutBlockItem("lettuce_crop",
            new LettuceCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.NORMAL).mapColor(MapColor.DARK_GREEN)));
    public static final Block TOMATO_CROP = registerBlockWithoutBlockItem("tomato_crop",
            new TomatoCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.RED)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FoodMod2.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(FoodMod2.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FoodMod2.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        FoodMod2.LOGGER.info("Registering Mod Blocks for " + FoodMod2.MOD_ID);
    }
}
