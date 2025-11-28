package de.jonathan57157.food_mod_2;

import de.jonathan57157.food_mod_2.block.ModBlocks;
import de.jonathan57157.food_mod_2.block.entity.ModBlockEntities;
import de.jonathan57157.food_mod_2.item.ModItemGroups;
import de.jonathan57157.food_mod_2.item.ModItems;
import de.jonathan57157.food_mod_2.recipe.ModRecipes;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FoodMod2 implements ModInitializer {
	public static final String MOD_ID = "food_mod_2";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ModRecipes.registerRecipes();

		CompostingChanceRegistry.INSTANCE.add(ModItems.LETTUCE_SEEDS,0.25f);
	}
}

