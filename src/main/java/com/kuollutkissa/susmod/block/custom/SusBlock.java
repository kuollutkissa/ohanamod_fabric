package com.kuollutkissa.susmod.block.custom;

import com.kuollutkissa.susmod.sounds.ModSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SusBlock extends Block {
    public SusBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (world.isClient()) {
            placer.playSound(ModSoundEvents.AMOGUS_SHORT, 1.0f, 0.7f);
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient() && hand == Hand.MAIN_HAND) {
            player.playSound(ModSoundEvents.AMOGUS, 1.0f, 1.0f);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
