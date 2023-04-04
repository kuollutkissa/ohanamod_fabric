package com.kuollutkissa.susmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;


public class SusStationBlockItem extends BlockItem implements IAnimatable {
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public SusStationBlockItem(Block block, Settings settings) {
        super(block, settings);
    }
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> state) {
        state.getController().setAnimation(new AnimationBuilder()
                .addAnimation("animation.sus_station.extracting", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
