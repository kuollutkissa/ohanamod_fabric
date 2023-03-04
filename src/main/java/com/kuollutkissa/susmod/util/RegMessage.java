package com.kuollutkissa.susmod.util;

import com.kuollutkissa.susmod.SusMod;

public class RegMessage {
    public static void regMessage(String obj) {
        SusMod.LOGGER.debug(String.format("Registering %s for %s", obj, SusMod.MODID));
    }
}
