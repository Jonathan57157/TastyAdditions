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

public record IceCreamMakerRecipe(Ingredient inputItem, ItemStack output) implements Recipe<IceCreamMakerRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    // read Recipe JSON files --> new GrowthChamberRecipe

    @Override
    public boolean matches(IceCreamMakerRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
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
        return output;
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
        public static final MapCodec<IceCreamMakerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(IceCreamMakerRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(IceCreamMakerRecipe::output)
        ).apply(inst, IceCreamMakerRecipe::new));

        public static final PacketCodec<RegistryByteBuf, IceCreamMakerRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, IceCreamMakerRecipe::inputItem,
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
