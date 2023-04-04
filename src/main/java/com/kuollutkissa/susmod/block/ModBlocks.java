package com.kuollutkissa.susmod.block;


import com.kuollutkissa.susmod.block.custom.*;
import com.kuollutkissa.susmod.item.ModItemGroups;
import com.kuollutkissa.susmod.util.Util;
import com.kuollutkissa.susmod.util.SusID;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block SUS_ORE = registerBlock("sus_ore",
            new SusBlock(FabricBlockSettings.of(Material.STONE).requiresTool().hardness(3.1f)), ModItemGroups.SUS_MOD);
    public static final Block DEEPSLATE_SUS_ORE = registerBlock("deepslate_sus_ore",
            new SusBlock(FabricBlockSettings.of(Material.STONE).requiresTool().hardness(3.5f)), ModItemGroups.SUS_MOD);
    public static final Block SUS_BLOCK = registerBlock("sus_block",
            new SusBlock(FabricBlockSettings.of(Material.METAL).requiresTool().hardness(4f)), ModItemGroups.SUS_MOD);
    public static final Block SUS_ESSENCE_BLOCK = registerBlock("sus_essence_block",
            new SusBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).hardness(2f)), ModItemGroups.SUS_MOD);
    public static final Block SUS_WHEAT = registerItemlessBlock("sus_wheat",
            new SusWheatBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block SUS_CARROTS = registerItemlessBlock("sus_carrots",
            new SusCarrotBlock(FabricBlockSettings.copyOf(Blocks.CARROTS)));

    public static final Block SUS_ESSENTIUM = registerItemlessBlock("sus_essentium",
            new SusEssentiumBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block SUS_STATION = registerItemlessBlock("sus_station",
            new SusStationBlock(FabricBlockSettings.of(Material.WOOD).hardness(1.0f).nonOpaque()));

    private static  Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new SusID(name), block);
    }
    private static Block registerItemlessBlock(String name, Block block){
        return Registry.register(Registry.BLOCK, new SusID(name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        BlockItem item = Registry.register(Registry.ITEM, new SusID(name), new BlockItem(block, new FabricItemSettings().group(tab)));
        return item;
    }

    public static final void registerModBlocks() {
        Util.regMessage("blocks");
    }
}
