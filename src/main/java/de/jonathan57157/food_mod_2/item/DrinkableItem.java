package de.jonathan57157.food_mod_2.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class DrinkableItem extends PotionItem {
    public DrinkableItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity) user : null;
        if (playerEntity instanceof ServerPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity) playerEntity, stack);
        }

        if (!world.isClient) {
            PotionContentsComponent potionContentsComponent = stack.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
            potionContentsComponent.forEachEffect(effect -> {
                if (effect.getEffectType().value().isInstant()) {
                    effect.getEffectType().value().applyInstantEffect(playerEntity, playerEntity, user, effect.getAmplifier(), 1.0);
                } else {
                    user.addStatusEffect(effect);
                }
            });
        }
        return new ItemStack(Items.GLASS_BOTTLE);
    }

}
