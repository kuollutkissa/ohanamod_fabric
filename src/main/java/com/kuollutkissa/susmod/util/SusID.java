package com.kuollutkissa.susmod.util;

import com.kuollutkissa.susmod.SusMod;
import net.minecraft.util.Identifier;

public class SusID extends Identifier {

    public SusID(String path) {
        super(SusMod.MODID, path);
    }
}
