package de.jonathan57157.food_mod_2.block.custom;

import de.jonathan57157.food_mod_2.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class TomatoCropBlock extends CropBlock {
    public TomatoCropBlock(Settings settings) {
        super(settings);
    }

    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = IntProperty.of("age", 0, 5);

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.TOMATO_SEEDS;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

}
