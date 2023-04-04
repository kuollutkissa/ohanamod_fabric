package com.kuollutkissa.susmod.util;

import com.kuollutkissa.susmod.SusMod;
import com.kuollutkissa.susmod.item.ModItems;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

public class Util {
    public static void regMessage(String obj) {
        SusMod.LOGGER.debug(String.format("Registering %s for %s", obj, SusMod.MODID));
    }
    public static void regModCompostableItems(){
        CompostingChanceRegistry.INSTANCE.add(ModItems.SUS_WHEAT, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.SUS_CARROT, 0.4f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.SUS_GLOW_BERRIES, 0.5f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.SUS_SEEDS, 0.2f);
    }
}
