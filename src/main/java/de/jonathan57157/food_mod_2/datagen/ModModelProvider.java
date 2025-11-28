package de.jonathan57157.food_mod_2.datagen;

import de.jonathan57157.food_mod_2.block.ModBlocks;
import de.jonathan57157.food_mod_2.block.custom.BlueberryBushBlock;
import de.jonathan57157.food_mod_2.block.custom.LettuceCropBlock;
import de.jonathan57157.food_mod_2.block.custom.TomatoCropBlock;
import de.jonathan57157.food_mod_2.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.LETTUCE_CROP, LettuceCropBlock.AGE,0,1,2,3,4,5);
        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_CROP, TomatoCropBlock.AGE, 0,1,2,3,4,5);
        blockStateModelGenerator.registerCrop(ModBlocks.BLUEBERRY_BUSH, BlueberryBushBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHEESE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BLUEBERRIES, Models.GENERATED);
    }

}
