package de.jonathan57157.food_mod_2;

import de.jonathan57157.food_mod_2.block.ModBlocks;
import de.jonathan57157.food_mod_2.block.entity.ModBlockEntities;
import de.jonathan57157.food_mod_2.block.entity.renderer.CuttingBoardBlockEntityRenderer;
import de.jonathan57157.food_mod_2.screen.ModScreenHandlers;
import de.jonathan57157.food_mod_2.screen.custom.IceCreamMakerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class FoodMod2Client implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		System.out.println("FoodMod2Client initialized!");
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LETTUCE_CROP, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEBERRY_BUSH, RenderLayer.getCutout());

		HandledScreens.register(ModScreenHandlers.ICE_CREAM_MAKER_SCREEN_HANDLER, IceCreamMakerScreen::new);

		BlockEntityRendererFactories.register(ModBlockEntities.CUTTING_BOARD_BE, CuttingBoardBlockEntityRenderer::new);
	}
}