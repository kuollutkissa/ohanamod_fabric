package com.kuollutkissa.susmod.item.client;

import com.kuollutkissa.susmod.item.custom.SusStationBlockItem;
import com.kuollutkissa.susmod.util.SusID;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class SusStationBlockItemModel extends DefaultedItemGeoModel<SusStationBlockItem>
{
    public SusStationBlockItemModel() {
        super(new SusID("sus_station"));

    }

    @Override
    public Identifier getTextureResource(SusStationBlockItem animatable) {
        return new SusID("textures/block/sus_station.png");
    }

    @Override
    public Identifier getModelResource(SusStationBlockItem animatable) {
        return new SusID("geo/sus_station.geo.json");
    }

    @Override
    public Identifier getAnimationResource(SusStationBlockItem animatable) {
        return new SusID("animations/sus_station.animation.json");
    }
}
