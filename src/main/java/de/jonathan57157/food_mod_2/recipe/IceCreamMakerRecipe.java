package de.jonathan57157.food_mod_2.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record IceCreamMakerRecipe(Ingredient input1, Ingredient input2, ItemStack output)
        implements Recipe<IceCreamMakerRecipeInput> {

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(2, Ingredient.EMPTY);
        list.set(0, input1());
        list.set(1, input2());
        return list;
    }

    @Override
    public boolean matches(IceCreamMakerRecipeInput input, World world) {
        if(world.isClient()) return false;

        return input1.test(input.getStackInSlot(0))
                && input2.test(input.getStackInSlot(1));
    }

    @Override
    public ItemStack craft(IceCreamMakerRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.ICE_CREAM_MAKER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.ICE_CREAM_MAKER_TYPE;
    }

    public static class Serializer implements RecipeSerializer<IceCreamMakerRecipe> {

        public static final MapCodec<IceCreamMakerRecipe> CODEC =
                RecordCodecBuilder.mapCodec(inst -> inst.group(
                        Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient1").forGetter(IceCreamMakerRecipe::input1),
                        Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient2").forGetter(IceCreamMakerRecipe::input2),
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