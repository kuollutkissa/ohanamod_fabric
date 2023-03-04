package com.kuollutkissa.susmod.item.client;

import com.kuollutkissa.susmod.item.custom.SusStationBlockItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SusStationBlockItemRenderer extends GeoItemRenderer<SusStationBlockItem> {
    public SusStationBlockItemRenderer() {
        super(new SusStationBlockItemModel());
    }
}
