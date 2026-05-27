package de.jonathan57157.food_mod_2.block.entity;


import de.jonathan57157.food_mod_2.FoodMod2;
import de.jonathan57157.food_mod_2.block.ModBlocks;
import de.jonathan57157.food_mod_2.block.entity.custom.CuttingBoardBlockEntity;
import de.jonathan57157.food_mod_2.block.entity.custom.IceCreamMakerBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<IceCreamMakerBlockEntity> ICE_CREAM_MAKER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(FoodMod2.MOD_ID, "ice_cream_maker_be"),
                    BlockEntityType.Builder.create(IceCreamMakerBlockEntity::new, ModBlocks.ICE_CREAM_MAKER).build());

    public static final BlockEntityType<CuttingBoardBlockEntity> CUTTING_BOARD_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(FoodMod2.MOD_ID, "cutting_board_be"),
                    BlockEntityType.Builder.create(CuttingBoardBlockEntity::new, ModBlocks.CUTTING_BOARD).build());

    public static void registerBlockEntities(){
        FoodMod2.LOGGER.info("Registering Block Entities for " + FoodMod2.MOD_ID);
    }
}
