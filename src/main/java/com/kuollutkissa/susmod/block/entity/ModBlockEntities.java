package com.kuollutkissa.susmod.block.entity;

import com.kuollutkissa.susmod.block.ModBlocks;
import com.kuollutkissa.susmod.util.RegMessage;
import com.kuollutkissa.susmod.util.SusID;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;


public class ModBlockEntities {
    public static BlockEntityType<SusStationBlockEntity> SUS_STATION;

    public static void registerModBlockEntities() {
        SUS_STATION = Registry.register(Registries.BLOCK_ENTITY_TYPE, new SusID("sus_station"),
                FabricBlockEntityTypeBuilder.create(SusStationBlockEntity::new, ModBlocks.SUS_STATION).build(null));
        RegMessage.regMessage("block entities");
    }
}
