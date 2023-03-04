package com.kuollutkissa.susmod.item.custom;

import com.kuollutkissa.susmod.sounds.ModSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SusItem extends Item {
    private int index;
    private float volume;
    private float pitch;
    private static final SoundEvent[] AMOG = {ModSoundEvents.AMOGUS, ModSoundEvents.AMOGUS_SHORT, ModSoundEvents.AMOGUS_DEATH};
    public SusItem(Settings settings, int i, float vol, float pitch) {
        super(settings);
        this.index = i;
        this.volume = vol;
        this.pitch = pitch;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(user.getWorld().isClient()) {
            user.playSound(AMOG[index],volume, pitch);
        }
        return super.use(world, user, hand);
    }
}
