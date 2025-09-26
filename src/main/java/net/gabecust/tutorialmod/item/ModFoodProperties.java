package net.gabecust.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties OLD_ENCHANTED_GOLDEN_APPLE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1.2F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 600, 4), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F)
            .alwaysEdible()
            .build();
}
