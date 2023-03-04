package com.kuollutkissa.susmod.world;

import com.kuollutkissa.susmod.world.gen.ModEntitySpawn;
import com.kuollutkissa.susmod.world.gen.ModOreGeneration;

public class ModWorldGen {
    public static void registerModWorldGen() {
        ModOreGeneration.generateOres();
        ModEntitySpawn.spawnModEntities();
    }
}
