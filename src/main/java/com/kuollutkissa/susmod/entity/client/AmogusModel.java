package com.kuollutkissa.susmod.entity.client;

import com.kuollutkissa.susmod.entity.custom.AmogusEntity;
import com.kuollutkissa.susmod.util.SusID;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class AmogusModel extends GeoModel<AmogusEntity> {
    @Override
    public Identifier getModelResource(AmogusEntity object) {
        return new SusID("geo/amogus.geo.json");
    }

    @Override
    public Identifier getTextureResource(AmogusEntity object) {
        return AmogusRenderer.TEXTURE_BY_VARIANT.get(object.getVariant());
    }

    @Override
    public Identifier getAnimationResource(AmogusEntity animatable) {
        return new SusID("animations/amogus.animation.json");
    }
}
