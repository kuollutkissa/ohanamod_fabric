package com.kuollutkissa.susmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SusSpecialisedToolItem extends MiningToolItem {
    public final Enchantment[] ENCHANTMENTS;

    public final Rarity RARITY;
    public SusSpecialisedToolItem(ToolMaterial material, TagKey<Block> effectiveBlocks,
                                     Settings settings, Enchantment[] enchantments, Rarity rarity) {
        super(5.0f, 2.0f, material, effectiveBlocks, settings);
        this.ENCHANTMENTS = enchantments;
        this.RARITY = rarity;
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
        for(var enchantment: ENCHANTMENTS){
            stack.addEnchantment(enchantment, 5);
        }
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return this.RARITY;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
    }
}

