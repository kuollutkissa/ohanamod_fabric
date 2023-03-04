package com.kuollutkissa.susmod.entity;

import com.kuollutkissa.susmod.entity.custom.AmogusEntity;
import com.kuollutkissa.susmod.util.RegMessage;
import com.kuollutkissa.susmod.util.SusID;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEntities {
    public static final EntityType<AmogusEntity> AMOGUS = Registry.register(
            Registries.ENTITY_TYPE, new SusID("amogus"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AmogusEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());
    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(AMOGUS, AmogusEntity.setAttributes());
        RegMessage.regMessage("entity attributes");
    }
}