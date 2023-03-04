package com.kuollutkissa.susmod.world.feature;

import com.kuollutkissa.susmod.block.ModBlocks;
import com.kuollutkissa.susmod.util.RegMessage;
import com.kuollutkissa.susmod.util.SusID;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> SUS_ORE_KEY = registerKey("sus_ore");
    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context){
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);


        List<OreFeatureConfig.Target> OVERWORLD_SUS_ORES = List.of(
                OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.SUS_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_SUS_ORE.getDefaultState())
        );
        register(context, SUS_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SUS_ORES, 15));

    }
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new SusID(name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?,?>> context, RegistryKey<ConfiguredFeature<?,?>> key,
                                                                                   F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    public static void regConfiguredFeatures() {
        RegMessage.regMessage("Mod configured features");
    }
}
