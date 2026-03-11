package de.jonathan57157.food_mod_2.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record IceCreamMakerRecipe(Ingredient input1, Ingredient input2, ItemStack output)
        implements Recipe<IceCreamMakerRecipeInput> {
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(2);
        list.set(0, input1());
        list.set(1, input2());
        return list;
    }

    @Override
    public boolean matches(IceCreamMakerRecipeInput input, World world) {
        if (world.isClient()) return false;

        boolean normal =
                input1.test(input.getStackInSlot(0)) &&
                        input2.test(input.getStackInSlot(1));

        boolean swapped =
                input1.test(input.getStackInSlot(1)) &&
                        input2.test(input.getStackInSlot(0));

        return normal || swapped;
    }

    @Override
    public ItemStack craft(IceCreamMakerRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<IceCreamMakerRecipeInput>> getSerializer() {
        return ModRecipes.ICE_CREAM_MAKER_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<IceCreamMakerRecipeInput>> getType() {
        return ModRecipes.ICE_CREAM_MAKER_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        return null;
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<IceCreamMakerRecipe> {

        public static final MapCodec<IceCreamMakerRecipe> CODEC =
                RecordCodecBuilder.mapCodec(inst -> inst.group(
                        Ingredient.CODEC.fieldOf("ingredient1").forGetter(IceCreamMakerRecipe::input1),
                        Ingredient.CODEC.fieldOf("ingredient2").forGetter(IceCreamMakerRecipe::input2),
                        ItemStack.CODEC.fieldOf("result").forGetter(IceCreamMakerRecipe::output)
                ).apply(inst, IceCreamMakerRecipe::new));

        public static final PacketCodec<RegistryByteBuf, IceCreamMakerRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, IceCreamMakerRecipe::input1,
                        Ingredient.PACKET_CODEC, IceCreamMakerRecipe::input2,
                        ItemStack.PACKET_CODEC, IceCreamMakerRecipe::output,
                        IceCreamMakerRecipe::new);

        @Override
        public MapCodec<IceCreamMakerRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, IceCreamMakerRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}