package com.kuollutkissa.susmod;

import com.kuollutkissa.susmod.block.ModBlocks;
import com.kuollutkissa.susmod.block.entity.ModBlockEntities;
import com.kuollutkissa.susmod.block.entity.client.SusStationBlockRenderer;
import com.kuollutkissa.susmod.entity.ModEntities;
import com.kuollutkissa.susmod.entity.client.AmogusRenderer;

import com.kuollutkissa.susmod.item.ModItems;
import com.kuollutkissa.susmod.item.client.SusStationBlockItemRenderer;
import com.kuollutkissa.susmod.screen.ModScreenHandlers;
import com.kuollutkissa.susmod.screen.SusStationScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class SusModClient implements  ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SUS_WHEAT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SUS_CARROTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SUS_ESSENTIUM, RenderLayer.getCutout());
        HandledScreens.register(ModScreenHandlers.SUS_STATION_SCREEN_HANDLER, SusStationScreen::new);
        GeoItemRenderer.registerItemRenderer(ModItems.SUS_STATION, new SusStationBlockItemRenderer());
        BlockEntityRendererFactories.register(ModBlockEntities.SUS_STATION, SusStationBlockRenderer::new);
        EntityRendererRegistry.register(ModEntities.AMOGUS, AmogusRenderer::new);
    }
}
