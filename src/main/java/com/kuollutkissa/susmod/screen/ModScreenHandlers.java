package com.kuollutkissa.susmod.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<SusStationScreenHandler> SUS_STATION_SCREEN_HANDLER;


    public static void registerScreenHandlers() {
        SUS_STATION_SCREEN_HANDLER = new ScreenHandlerType<>(SusStationScreenHandler::new);
    }
}
