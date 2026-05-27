package de.jonathan57157.food_mod_2.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent ICE_CREAM = new FoodComponent.Builder().nutrition(5).saturationModifier(0.5f).build();
    public static final FoodComponent ICE_CREAM_WAFER = new FoodComponent.Builder().snack().nutrition(1).saturationModifier(0.3f).build();
    public static final FoodComponent BURGER = new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build();
    public static final FoodComponent LETTUCE = new FoodComponent.Builder().snack().nutrition(2).saturationModifier(0.1f).build();
    public static final FoodComponent CHEESE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.6f).build();
    public static final FoodComponent PUMPKIN_SOUP = new FoodComponent.Builder().nutrition(5).saturationModifier(0.7f).build();
    public static final FoodComponent TOMATO = new FoodComponent.Builder().nutrition(2).saturationModifier(0.2f).snack().build();
    public static final FoodComponent BLUEBERRIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.15f).snack().build();
    public static final FoodComponent STRAWBERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.15f).snack().build();
    public static final FoodComponent HALF_TOMATO = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1f).snack().build();
}
