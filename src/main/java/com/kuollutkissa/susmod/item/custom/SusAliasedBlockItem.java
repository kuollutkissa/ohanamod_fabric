package com.kuollutkissa.susmod.item.custom;

import com.kuollutkissa.susmod.block.ModBlocks;
import com.kuollutkissa.susmod.item.ModItems;
import com.kuollutkissa.susmod.sounds.ModSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SusAliasedBlockItem extends AliasedBlockItem {
    private final int index;
    private final float volume;
    private final float pitch;
    private final Item baseItem;
    private static final SoundEvent[] AMOG = {ModSoundEvents.AMOGUS, ModSoundEvents.AMOGUS_SHORT, ModSoundEvents.AMOGUS_DEATH, ModSoundEvents.SUS};
    public SusAliasedBlockItem(Block block, Settings settings, int i, float vol, float pitch, @Nullable Item baseItem) {
        super(block, settings);
        this.index = i;
        this.volume = vol;
        this.pitch = pitch;
        this.baseItem = baseItem;
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(user.getWorld().isClient()) {
            user.playSound(AMOG[index],volume, pitch);
        }
        return super.use(world, user, hand);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemStack stack = context.getStack();
        BlockState state = context.getWorld().getBlockState(context.getBlockPos());
        if(!context.getWorld().isClient() && state.isOf(ModBlocks.SUS_STATION) && baseItem != null){
            if(!context.getPlayer().getAbilities().creativeMode){
                stack.decrement(1);
            }
            ItemStack essence = new ItemStack(ModItems.SUS_ESSENCE);
            context.getPlayer().giveItemStack(new ItemStack(baseItem));
            context.getPlayer().giveItemStack(essence);
        }
        return super.useOnBlock(context);
    }
}
