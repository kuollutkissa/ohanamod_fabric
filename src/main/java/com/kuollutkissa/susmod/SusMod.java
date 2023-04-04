package com.kuollutkissa.susmod;

import com.kuollutkissa.susmod.block.ModBlocks;
import com.kuollutkissa.susmod.block.entity.ModBlockEntities;
import com.kuollutkissa.susmod.entity.ModEntities;
import com.kuollutkissa.susmod.item.ModItemGroups;
import com.kuollutkissa.susmod.item.ModItems;
import com.kuollutkissa.susmod.screen.ModScreenHandlers;
import com.kuollutkissa.susmod.sounds.ModSoundEvents;
import com.kuollutkissa.susmod.util.Util;
import com.kuollutkissa.susmod.world.ModWorldGen;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class SusMod implements ModInitializer {
	public static final String MODID = "susmod";
	public static final Logger LOGGER = LoggerFactory.getLogger("susmod");

	@Override
	public void onInitialize() {
		ModItemGroups.regItemGroups();
		GeckoLib.initialize();
		ModEntities.registerEntityAttributes();
		ModWorldGen.registerModWorldGen();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		Util.regModCompostableItems();
		ModScreenHandlers.registerScreenHandlers();
		ModBlockEntities.registerModBlockEntities();
		ModSoundEvents.registerModSoundEvents();
		LOGGER.info("Hello Fabric world!");
	}
}