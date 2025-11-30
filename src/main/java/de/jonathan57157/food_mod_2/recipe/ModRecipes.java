package de.jonathan57157.food_mod_2.recipe;

import de.jonathan57157.food_mod_2.FoodMod2;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<IceCreamMakerRecipe> ICE_CREAM_MAKER_SERIALIZER = Registry.register(
        Registries.RECIPE_SERIALIZER, Identifier.of(FoodMod2.MOD_ID, "ice_cream_maker"),
            new IceCreamMakerRecipe.Serializer());

    public static final RecipeType<IceCreamMakerRecipe> ICE_CREAM_MAKER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(FoodMod2.MOD_ID, "ice_cream_maker"), new RecipeType<IceCreamMakerRecipe>() {
                @Override
                public String toString() {
                    return "ice_cream_maker";
                }
            });

    public static void registerRecipes() {
        FoodMod2.LOGGER.info("Registering Custom Recipes for " + FoodMod2.MOD_ID);
    }
}
