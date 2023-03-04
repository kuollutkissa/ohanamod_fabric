package com.kuollutkissa.susmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;


public class ModFoodComponents {
    public static final FoodComponent SUS_FISH = new FoodComponent.Builder().hunger(9)
            .saturationModifier(1f).meat()
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER,
                    6000, 3), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE,
                    6000, 1), 1.0f)
            .build();
    public static final FoodComponent SUS_BREAD = new FoodComponent.Builder().hunger(7).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,
                    6000, 3), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,
                    6000, 3), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION,
                    6000, 3), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,
                    6000, 3), 1.0f)
            .build();
}
