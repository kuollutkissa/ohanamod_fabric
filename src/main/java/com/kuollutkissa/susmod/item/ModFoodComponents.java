package com.kuollutkissa.susmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;


public class ModFoodComponents {
    public static final FoodComponent SUS_FISH = new FoodComponent.Builder().hunger(6)
            .saturationModifier(0.7f).meat().alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER,
                    2000, 3), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE,
                    2000, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,
                    1000, 2), 1.0f)
            .build();
    public static final FoodComponent SUS_CHICKEN = new FoodComponent.Builder().hunger(8)
            .saturationModifier(0.8f).meat().alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,
                    2000, 3), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST,
                    1000, 2), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,
                    1000, 2), 1.0f)
            .build();
    public static final FoodComponent SUS_RABBIT = new FoodComponent.Builder().hunger(6)
            .saturationModifier(0.8f).meat().alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED,
                    2000, 3), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,
                    1000, 2), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,
                    2000, 4), 1.0f)
            .build();
    public static final FoodComponent SUS_CARROT = new FoodComponent.Builder().hunger(5)
            .saturationModifier(0.7f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,
                    2000, 2), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,
                    2000, 2), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,
                    2000, 1), 1.0f)
            .build();
    public static final FoodComponent SUS_GLOW_BERRIES = new FoodComponent.Builder().hunger(4)
            .saturationModifier(0.1f).snack().alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,
                    100, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING,
                    1000, 3), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,
                    2000, 3), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE,
                    2000, 1), 1.0f)
            .build();

    public static final FoodComponent SUS_BREAD = new FoodComponent.Builder().hunger(6)
            .saturationModifier(0.5f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,
                    500, 2), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,
                    2000, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION,
                    2000, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,
                    2000, 1), 1.0f)
            .build();
}
