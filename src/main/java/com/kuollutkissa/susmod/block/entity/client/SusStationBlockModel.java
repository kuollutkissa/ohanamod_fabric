package com.kuollutkissa.susmod.block.entity.client;

import com.kuollutkissa.susmod.block.entity.SusStationBlockEntity;
import com.kuollutkissa.susmod.util.SusID;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;


public class SusStationBlockModel extends GeoModel<SusStationBlockEntity> {

    @Override
    public Identifier getModelResource(SusStationBlockEntity object) {
        return new SusID("geo/sus_station.geo.json");
    }

    @Override
    public Identifier getTextureResource(SusStationBlockEntity object) {
        return new SusID("textures/block/sus_station.png");
    }

    @Override
    public Identifier getAnimationResource(SusStationBlockEntity animatable) {
        return new SusID("animations/sus_station.animation.json");
    }
}
