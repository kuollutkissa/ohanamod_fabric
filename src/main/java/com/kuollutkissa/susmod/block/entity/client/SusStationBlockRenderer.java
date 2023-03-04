package com.kuollutkissa.susmod.block.entity.client;

import com.kuollutkissa.susmod.block.entity.SusStationBlockEntity;
import com.kuollutkissa.susmod.util.SusID;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoBlockRenderer;


public class SusStationBlockRenderer extends GeoBlockRenderer<SusStationBlockEntity> {
    public SusStationBlockRenderer(BlockEntityRendererFactory.Context context) {
        super(new SusStationBlockModel());
    }

    @Override
    public RenderLayer getRenderType(SusStationBlockEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
        return RenderLayer.getEntityTranslucent(new SusID("textures/block/sus_station.png"));
    }
}
