package com.kuollutkissa.susmod.item;

import com.kuollutkissa.susmod.util.SusID;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class ModItemGroups {
    public static ItemGroup SUS_MOD;
    public static ItemGroup regItemGroup(String id) {
        return FabricItemGroup.builder(new SusID(id))
                .displayName(Text.translatable("itemGroup.susmod.sus_group"))
                .icon(() -> new ItemStack(ModItems.SUS_INGOT))
                .build();
    }
    public static void regItemGroups(){
        SUS_MOD = regItemGroup("sus_group");
    }
}
