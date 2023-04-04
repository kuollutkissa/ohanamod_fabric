package com.kuollutkissa.susmod.item;

import com.kuollutkissa.susmod.sounds.ModSoundEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    SUS("sus", 20, new int[]{3, 6, 7, 3}, 23, ModSoundEvents.AMOGUS_SHORT,
            0.9f, 0.1f, () -> Ingredient.ofItems(ModItems.SUS_INGOT));
    private String name;
    private int durability;
    private int protection [];
    private int enchantability;
    private SoundEvent equipSound;
    private float toughness;
    private float knockbackResistance;
    private Ingredient repairIngredient;
    ModArmorMaterials(String name, int durability, int[] protection, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durability = durability;
        this.protection = protection;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient.get();
    }
    @Override
    public int getDurability(EquipmentSlot slot) {
        return durability;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return protection[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
