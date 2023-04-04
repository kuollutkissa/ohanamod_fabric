package com.kuollutkissa.susmod.world;

import com.kuollutkissa.susmod.world.feature.ModConfiguredFeatures;
import com.kuollutkissa.susmod.world.gen.ModEntitySpawn;
import com.kuollutkissa.susmod.world.gen.ModOreGeneration;

public class ModWorldGen {
    public static void registerModWorldGen() {
        ModConfiguredFeatures.regConfiguredFeatures();
        ModOreGeneration.generateOres();
        ModEntitySpawn.spawnModEntities();
    }
}
