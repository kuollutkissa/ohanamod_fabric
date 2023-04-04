package com.kuollutkissa.susmod.item;

import com.kuollutkissa.susmod.block.ModBlocks;
import com.kuollutkissa.susmod.entity.ModEntities;
import com.kuollutkissa.susmod.item.custom.*;
import com.kuollutkissa.susmod.util.Util;
import com.kuollutkissa.susmod.util.SusID;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item SUS_STATION = registerItem("sus_station",
            new SusStationBlockItem(ModBlocks.SUS_STATION,new FabricItemSettings().group(ModItemGroups.SUS_MOD)));
    public static final Item RAW_SUS = registerItem("raw_sus",
            new SusItem(new FabricItemSettings().group(ModItemGroups.SUS_MOD), 1, 0.5f, 1.0f, null));
    public static final Item SUS_INGOT = registerItem("sus_ingot",
            new SusItem(new FabricItemSettings().group(ModItemGroups.SUS_MOD), 0, 0.5f, 1.0f, Items.GOLD_INGOT));
    public static final Item SUS_ESSENCE = registerItem("sus_essence",
            new SusItem(new FabricItemSettings().group(ModItemGroups.SUS_MOD), 0, 1f, 1.0f, null));
    public static final Item SUS_SEEDS = registerItem("sus_seeds",
            new AliasedBlockItem(ModBlocks.SUS_WHEAT, new FabricItemSettings().group(ModItemGroups.SUS_MOD)));
    public static final Item SUS_WHEAT = registerItem("sus_wheat",
            new SusItem(new FabricItemSettings().group(ModItemGroups.SUS_MOD),1, 0.2f, 1f, Items.WHEAT));
    public static final Item SUS_FISH = registerItem("sus_fish",
            new SusItem(new FabricItemSettings()
                    .food(ModFoodComponents.SUS_FISH).group(ModItemGroups.SUS_MOD), 1, 0.2f, 1.5f, null));
    public static final Item SUS_CHICKEN = registerItem("sus_chicken",
            new SusItem(new FabricItemSettings().food(ModFoodComponents.SUS_CHICKEN).group(ModItemGroups.SUS_MOD), 1, 0.2f, 0.9f, null));
    public static final Item SUS_RABBIT = registerItem("sus_rabbit",
            new SusItem(new FabricItemSettings().food(ModFoodComponents.SUS_RABBIT).group(ModItemGroups.SUS_MOD), 1, 0.2f, 0.8f, null));
    public static final Item SUS_CARROT = registerItem("sus_carrot",
            new SusAliasedBlockItem(ModBlocks.SUS_CARROTS, new FabricItemSettings().food(ModFoodComponents.SUS_CARROT).group(ModItemGroups.SUS_MOD),
                    1, 0.2f, 1.1f, Items.CARROT));
    public static final Item SUS_GLOW_BERRIES = registerItem("sus_glow_berries",
            new SusItem(new FabricItemSettings().food(ModFoodComponents.SUS_GLOW_BERRIES).group(ModItemGroups.SUS_MOD),
                    1, 0.2f, 1.3f, Items.GLOW_BERRIES));
    public static final Item SUS_BREAD = registerItem("sus_bread",
            new SusItem(new FabricItemSettings()
                    .food(ModFoodComponents.SUS_BREAD).group(ModItemGroups.SUS_MOD),
                    1, 0.4f, 1.1f, null));
    public static final Item AMOGUS_SPAWN_EGG = registerItem("amogus_spawn_egg",
            new SpawnEggItem(ModEntities.AMOGUS, 0xff5151, 0xd32323,
                    new FabricItemSettings().group(ModItemGroups.SUS_MOD)));
    public static final Item SUS_ESSENTIUM = registerItem("sus_essentium",
            new SusAliasedBlockItem(ModBlocks.SUS_ESSENTIUM,
                    new FabricItemSettings().group(ModItemGroups.SUS_MOD), 1,0.5f, 0.9f, null));
    //SUS TOOLSET
    public static final Item SUS_SWORD = registerItem("sus_sword",
            new SwordItem(ModToolMaterials.SUS,3, 2.9f,
                    new FabricItemSettings().group(ModItemGroups.SUS_MOD)));
    public static final Item SUS_PICKAXE = registerItem("sus_pickaxe",
            new PickaxeItem(ModToolMaterials.SUS,2, 0.5f,
                    new FabricItemSettings().group(ModItemGroups.SUS_MOD)));
    public static final Item SUS_AXE = registerItem("sus_axe",
            new AxeItem(ModToolMaterials.SUS,5, 0.8f,
                    new FabricItemSettings().group(ModItemGroups.SUS_MOD)));
    public static final Item SUS_SHOVEL = registerItem("sus_shovel",
            new ShovelItem(ModToolMaterials.SUS,1, 0.5f,
                    new FabricItemSettings().group(ModItemGroups.SUS_MOD)));
    public static final Item SUS_HOE = registerItem("sus_hoe",
            new ModHoeItem(ModToolMaterials.SUS,4, 0.5f,
                    new FabricItemSettings().group(ModItemGroups.SUS_MOD)));
    //SUS ARMOR SET
    public static final Item SUS_HELMET = registerItem("sus_helmet",
            new ArmorItem(ModArmorMaterials.SUS, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroups.SUS_MOD)));
    public static final Item SUS_CHESTPLATE = registerItem("sus_chestplate",
            new ArmorItem(ModArmorMaterials.SUS, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroups.SUS_MOD)));
    public static final Item SUS_LEGGINGS = registerItem("sus_leggings",
            new ArmorItem(ModArmorMaterials.SUS, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroups.SUS_MOD)));

    public static final Item SUS_BOOTS = registerItem("sus_boots",
            new ArmorItem(ModArmorMaterials.SUS, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroups.SUS_MOD)));

    //SUS SPECIALISED TOOLS
    public static final Item SUS_PRECISION_TOOL = registerItem("sus_precision_tool",
            new SusSpecialisedToolItem(ModToolMaterials.SUS, BlockTags.PICKAXE_MINEABLE,
                    new FabricItemSettings().group(ModItemGroups.SUS_MOD),
                    new Enchantment[]{Enchantments.SILK_TOUCH, Enchantments.EFFICIENCY}, Rarity.RARE));
    private static Item registerItem(String id, Item item) {
        return Registry.register(Registry.ITEM, new SusID(id), item);
    }

    public static void registerModItems() {
        Util.regMessage("items");
    }
}
