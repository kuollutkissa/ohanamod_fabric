package com.kuollutkissa.susmod.entity.client;

import com.google.common.collect.Maps;
import com.kuollutkissa.susmod.entity.custom.AmogusEntity;
import com.kuollutkissa.susmod.entity.variants.AmogusVariant;
import com.kuollutkissa.susmod.util.SusID;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import java.util.Map;

public class AmogusRenderer extends GeoEntityRenderer<AmogusEntity> {
    public static Map<AmogusVariant, Identifier> TEXTURE_BY_VARIANT = Util.make(Maps.newEnumMap(AmogusVariant.class), (map) -> {
        map.put(AmogusVariant.RED, new SusID("textures/entity/amogus/red.png"));
        map.put(AmogusVariant.BLUE, new SusID("textures/entity/amogus/blue.png"));
        map.put(AmogusVariant.GREEN, new SusID("textures/entity/amogus/green.png"));
        map.put(AmogusVariant.PINK, new SusID("textures/entity/amogus/pink.png"));
        map.put(AmogusVariant.ORANGE, new SusID("textures/entity/amogus/orange.png"));
        map.put(AmogusVariant.YELLOW, new SusID("textures/entity/amogus/yellow.png"));
        map.put(AmogusVariant.BLACK, new SusID("textures/entity/amogus/black.png"));
        map.put(AmogusVariant.WHITE, new SusID("textures/entity/amogus/white.png"));
        map.put(AmogusVariant.PURPLE, new SusID("textures/entity/amogus/purple.png"));
        map.put(AmogusVariant.BROWN, new SusID("textures/entity/amogus/brown.png"));
        map.put(AmogusVariant.CYAN, new SusID("textures/entity/amogus/cyan.png"));
        map.put(AmogusVariant.LIME, new SusID("textures/entity/amogus/lime.png"));
        map.put(AmogusVariant.MAROON, new SusID("textures/entity/amogus/maroon.png"));
        map.put(AmogusVariant.ROSE, new SusID("textures/entity/amogus/rose.png"));
        map.put(AmogusVariant.BANANA, new SusID("textures/entity/amogus/banana.png"));
        map.put(AmogusVariant.GRAY, new SusID("textures/entity/amogus/gray.png"));
        map.put(AmogusVariant.TAN, new SusID("textures/entity/amogus/tan.png"));
        map.put(AmogusVariant.CORAL, new SusID("textures/entity/amogus/coral.png"));
    });

    @Override
    public Identifier getTextureLocation(AmogusEntity animatable) {
        return TEXTURE_BY_VARIANT.get(animatable.getVariant());
    }

    @Override
    public RenderLayer getRenderType(AmogusEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }

    @Override
    protected void applyRotations(AmogusEntity animatable, MatrixStack poseStack, float ageInTicks, float rotationYaw, float partialTick) {
        if(animatable.isBaby()){
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.applyRotations(animatable, poseStack, ageInTicks, rotationYaw, partialTick);
    }

    public AmogusRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new AmogusModel());
    }
}
