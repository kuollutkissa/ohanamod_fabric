package com.kuollutkissa.susmod.block.entity;


import com.kuollutkissa.susmod.SusMod;
import com.kuollutkissa.susmod.item.ModItems;
import com.kuollutkissa.susmod.screen.SusStationScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;


public class SusStationBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory, IAnimatable {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public SusStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SUS_STATION, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch(index) {
                    case 0: return SusStationBlockEntity.this.progress;
                    case 1: return SusStationBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch(index) {
                    case 0: SusStationBlockEntity.this.progress = value;
                    case 1: SusStationBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("entity.susmod.sus_station");
    }

        @Nullable
        @Override
        public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
            return new SusStationScreenHandler(syncId, inv, this, this.propertyDelegate);
        }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("sus_station.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("sus_station.progress");
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, SusStationBlockEntity entity){
        if(world.isClient) {return;}

        if(hasRecipe(entity)) {
            entity.progress++;
            markDirty(world, blockPos, blockState);
            if(entity.progress>=entity.maxProgress){
                craftItem(entity);
            }
        } else {
            resetProgress(entity);
            markDirty(world, blockPos, blockState);
        }
    }



    private static void resetProgress(SusStationBlockEntity entity) {
        entity.progress = 0;
    }

    private static void craftItem(SusStationBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for(int i = 0; i<entity.size(); i++) {
            inventory.setStack(0, entity.getStack(i));
        }
        if(hasRecipe(entity)) {
            entity.removeStack(0, 1);
            entity.setStack(1, new ItemStack(ModItems.SUS_ESSENCE,
                    entity.getStack(1).getCount()+1));


            resetProgress(entity);
        }
    }

    private static boolean hasRecipe(SusStationBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for(int i = 0; i<entity.size(); i++) {
            inventory.setStack(0, entity.getStack(0));
        }
        boolean hasSusIngotInSlotOne = entity.getStack(0).getItem() == ModItems.SUS_INGOT;
        return hasSusIngotInSlotOne && canInsertAmountIntoOutputSlot(inventory, 1) && canInsertItemIntoSlotInventory(inventory, ModItems.SUS_ESSENCE);
    }

    private static boolean canInsertItemIntoSlotInventory(SimpleInventory inventory, Item output) {
        return inventory.getStack(1).getItem() == output || inventory.getStack(1).isEmpty();
    }
    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory, int count) {
        return inventory.getStack(1).getMaxCount() > inventory.getStack(1).getCount() + count;
    }


    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<>(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder()
                .addAnimation("animation.sus_station.extracting", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;

    }
}
