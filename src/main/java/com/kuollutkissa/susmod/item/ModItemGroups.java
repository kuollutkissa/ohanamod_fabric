package com.kuollutkissa.susmod.item;

import com.kuollutkissa.susmod.util.Util;
import com.kuollutkissa.susmod.util.SusID;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups {
    public static ItemGroup SUS_MOD = FabricItemGroupBuilder.build(new SusID("sus_group"), () -> new ItemStack(ModItems.RAW_SUS));
    public static void regItemGroups(){
        Util.regMessage("item groups");
    }
}
