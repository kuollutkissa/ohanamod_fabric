package com.kuollutkissa.susmod.item;

import com.kuollutkissa.susmod.SusMod;
import com.kuollutkissa.susmod.block.ModBlocks;
import com.kuollutkissa.susmod.entity.ModEntities;
import com.kuollutkissa.susmod.item.custom.ModHoeItem;
import com.kuollutkissa.susmod.item.custom.SusItem;
import com.kuollutkissa.susmod.item.custom.SusStationBlockItem;
import com.kuollutkissa.susmod.util.Pair;
import com.kuollutkissa.susmod.util.RegMessage;
import com.kuollutkissa.susmod.util.SusID;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item SUS_STATION = registerItem("sus_station",
            new SusStationBlockItem(ModBlocks.SUS_STATION,new FabricItemSettings()));
    public static final Item RAW_SUS = registerItem("raw_sus",
            new SusItem(new FabricItemSettings(), 1, 0.5f, 1.0f));
    public static final Item SUS_INGOT = registerItem("sus_ingot",
            new SusItem(new FabricItemSettings(), 0, 1f, 1.0f));
    public static final Item SUS_ESSENCE = registerItem("sus_essence",
            new SusItem(new FabricItemSettings(), 0, 1f, 1.0f));
    public static final Item SUS_SEEDS = registerItem("sus_seeds",
            new AliasedBlockItem(ModBlocks.SUS_WHEAT, new FabricItemSettings()));
    public static final Item SUS_WHEAT = registerItem("sus_wheat",
            new SusItem(new FabricItemSettings(),1, 0.2f, 1f));
        public static final Item SUS_FISH = registerItem("sus_fish",
            new SusItem(new FabricItemSettings()
                    .food(ModFoodComponents.SUS_FISH), 1, 0.2f, 1.5f));
    public static final Item SUS_BREAD = registerItem("sus_bread",
            new SusItem(new FabricItemSettings()
                    .food(ModFoodComponents.SUS_BREAD), 1, 0.4f, 1.1f));
    public static final Item AMOGUS_SPAWN_EGG = registerItem("amogus_spawn_egg",
            new SpawnEggItem(ModEntities.AMOGUS, 0xff5151, 0xd32323,
                    new FabricItemSettings()));
    //SUS TOOLSET
    public static final Item SUS_SWORD = registerItem("sus_sword",
            new SwordItem(ModToolMaterials.SUS,3, 2.9f,
                    new FabricItemSettings()));
    public static final Item SUS_PICKAXE = registerItem("sus_pickaxe",
            new PickaxeItem(ModToolMaterials.SUS,4, 0.5f,
                    new FabricItemSettings()));
    public static final Item SUS_AXE = registerItem("sus_axe",
            new AxeItem(ModToolMaterials.SUS,4, 1f,
                    new FabricItemSettings()));
    public static final Item SUS_SHOVEL = registerItem("sus_shovel",
            new ShovelItem(ModToolMaterials.SUS,3, 1f,
                    new FabricItemSettings()));
    public static final Item SUS_HOE = registerItem("sus_hoe",
            new ModHoeItem(ModToolMaterials.SUS,10, 1.5f,
                    new FabricItemSettings()));
    //SUS ARMOR SET
    public static final Item SUS_HELMET = registerItem("sus_helmet",
            new ArmorItem(ModArmorMaterials.SUS, EquipmentSlot.HEAD,
                    new FabricItemSettings()));
    public static final Item SUS_CHESTPLATE = registerItem("sus_chestplate",
            new ArmorItem(ModArmorMaterials.SUS, EquipmentSlot.CHEST,
                    new FabricItemSettings()));
    public static final Item SUS_LEGGINGS = registerItem("sus_leggings",
            new ArmorItem(ModArmorMaterials.SUS, EquipmentSlot.LEGS,
                    new FabricItemSettings()));

    public static final Item SUS_BOOTS = registerItem("sus_boots",
            new ArmorItem(ModArmorMaterials.SUS, EquipmentSlot.FEET,
                    new FabricItemSettings()));
    private static Item registerItem(String id, Item item) {
        Item res = Registry.register(Registries.ITEM, new SusID(id), item);
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.SUS_MOD).register(entries -> entries.add(new ItemStack(res)));
        return res;
    }

    private static void addItemsToTabs(){
        SusMod.LOGGER.debug("Adding susmod items to creative tabs...");
        addItemTo(SUS_STATION, new Pair[]{new Pair(ItemGroups.FUNCTIONAL, Blocks.CAULDRON)});
        addItemTo(RAW_SUS, new Pair[]{new Pair(ItemGroups.INGREDIENTS, Items.DIAMOND)});
        addItemTo(SUS_INGOT, new Pair[]{new Pair(ItemGroups.INGREDIENTS, Items.NETHERITE_INGOT)});
        addItemTo(SUS_ESSENCE, new Pair[]{new Pair(ItemGroups.INGREDIENTS, Items.NETHER_STAR)});
        addItemTo(SUS_SEEDS, new Pair[]{new Pair(ItemGroups.NATURAL, Items.BEETROOT_SEEDS)});
        addItemTo(SUS_WHEAT, new Pair[]{new Pair(ItemGroups.INGREDIENTS, Items.WHEAT)});
        addItemTo(SUS_BREAD, new Pair[]{new Pair(ItemGroups.FOOD_AND_DRINK, Items.BREAD)});
        addItemTo(SUS_FISH, new Pair[]{new Pair(ItemGroups.FOOD_AND_DRINK, Items.TROPICAL_FISH)});
        addItemTo(AMOGUS_SPAWN_EGG, new Pair[]{new Pair(ItemGroups.SPAWN_EGGS, Items.ALLAY_SPAWN_EGG)});
        addItemTo(SUS_SWORD, new Pair[]{new Pair(ItemGroups.COMBAT, Items.NETHERITE_SWORD)});
        addItemTo(SUS_SHOVEL, new Pair[]{new Pair(ItemGroups.TOOLS, Items.NETHERITE_HOE)});
        addItemTo(SUS_PICKAXE, new Pair[]{new Pair(ItemGroups.TOOLS, SUS_SHOVEL)});
        addItemTo(SUS_AXE, new Pair[]{new Pair(ItemGroups.COMBAT, Items.NETHERITE_AXE),
        new Pair(ItemGroups.TOOLS, SUS_PICKAXE)});
        addItemTo(SUS_HOE, new Pair[]{new Pair(ItemGroups.TOOLS, SUS_AXE)});
        addItemTo(SUS_HELMET, new Pair[]{new Pair(ItemGroups.COMBAT, Items.NETHERITE_BOOTS)});
        addItemTo(SUS_CHESTPLATE, new Pair[]{new Pair(ItemGroups.COMBAT, SUS_HELMET)});
        addItemTo(SUS_LEGGINGS, new Pair[]{new Pair(ItemGroups.COMBAT, SUS_CHESTPLATE)});
        addItemTo(SUS_BOOTS, new Pair[]{new Pair(ItemGroups.COMBAT, SUS_LEGGINGS)});
    }
    private static void addItemTo(Item item, Pair<ItemGroup, Item>[] tabs){
        for(var pair : tabs){
            ItemGroupEvents.modifyEntriesEvent(pair.first).register(entries -> entries.addAfter(new ItemStack(pair.second), new ItemStack(item)));
        }
    }
    public static void registerModItems() {
        RegMessage.regMessage("items");
        addItemsToTabs();
    }
}
