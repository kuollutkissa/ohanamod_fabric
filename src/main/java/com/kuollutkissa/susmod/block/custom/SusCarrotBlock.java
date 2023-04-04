package com.kuollutkissa.susmod.block.custom;

import com.kuollutkissa.susmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class SusCarrotBlock extends CropBlock {
    public static final IntProperty ageProperty = IntProperty.of("age", 0, 7);
    public SusCarrotBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ageProperty);
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.SUS_CARROT;
    }
}
