package com.kuollutkissa.susmod.block.entity.client;

import com.kuollutkissa.susmod.block.entity.SusStationBlockEntity;
import com.kuollutkissa.susmod.util.SusID;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;


public class SusStationBlockRenderer extends GeoBlockRenderer<SusStationBlockEntity> {
    public SusStationBlockRenderer(BlockEntityRendererFactory.Context context) {
        super(new SusStationBlockModel());
    }

    @Override
    public RenderLayer getRenderType(SusStationBlockEntity animatable, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, VertexConsumer buffer, int packedLight, Identifier texture) {
        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
