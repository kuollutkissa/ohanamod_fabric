package com.kuollutkissa.susmod.world.feature;

import com.kuollutkissa.susmod.block.ModBlocks;
import com.kuollutkissa.susmod.util.Util;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_SUS_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SUS_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SUS_ORE.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SUS_ORE =
            ConfiguredFeatures.register("sus_ore_conf", Feature.ORE, new OreFeatureConfig(OVERWORLD_SUS_ORES, 16));
    public static void regConfiguredFeatures() {
        Util.regMessage("Mod configured features");
    }
}
