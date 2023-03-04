package com.kuollutkissa.susmod.block;


import com.kuollutkissa.susmod.SusMod;
import com.kuollutkissa.susmod.block.custom.SusBlock;
import com.kuollutkissa.susmod.block.custom.SusStationBlock;
import com.kuollutkissa.susmod.block.custom.SusWheatBlock;
import com.kuollutkissa.susmod.item.ModItemGroups;
import com.kuollutkissa.susmod.item.ModItems;
import com.kuollutkissa.susmod.util.Pair;
import com.kuollutkissa.susmod.util.RegMessage;
import com.kuollutkissa.susmod.util.SusID;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {
    public static final Block SUS_ORE = registerBlock("sus_ore",
            new SusBlock(FabricBlockSettings.of(Material.STONE).requiresTool().hardness(3.1f)));
    public static final Block DEEPSLATE_SUS_ORE = registerBlock("deepslate_sus_ore",
            new SusBlock(FabricBlockSettings.of(Material.STONE).requiresTool().hardness(3.5f)));
    public static final Block SUS_BLOCK = registerBlock("sus_block",
            new SusBlock(FabricBlockSettings.of(Material.METAL).requiresTool().hardness(4f)));
    public static final Block SUS_WHEAT = registerItemlessBlock("sus_wheat",
            new SusWheatBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block SUS_STATION = registerItemlessBlock("sus_station",
            new SusStationBlock(FabricBlockSettings.of(Material.WOOD).hardness(1.0f).nonOpaque()));

    private static  Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new SusID(name), block);
    }
    private static Block registerItemlessBlock(String name, Block block){
        return Registry.register(Registries.BLOCK, new SusID(name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        BlockItem item = Registry.register(Registries.ITEM, new SusID(name), new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.SUS_MOD).register(entries -> entries.add(new ItemStack(item)));
        return item;
    }
    private static void addItemsToTabs() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register(entries -> entries.addAfter(new ItemStack(Blocks.DEEPSLATE_DIAMOND_ORE), new ItemStack(SUS_ORE)));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register(entries -> entries.addAfter(new ItemStack(SUS_ORE), new ItemStack(DEEPSLATE_SUS_ORE)));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register(entries -> entries.addAfter(new ItemStack(Blocks.NETHERITE_BLOCK), new ItemStack(SUS_BLOCK)));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register(entries -> entries.addAfter(new ItemStack(Blocks.CAULDRON), new ItemStack(SUS_STATION)));
    }

    public static final void registerModBlocks() {
        RegMessage.regMessage("blocks");
        addItemsToTabs();
    }
}
