package com.kuollutkissa.susmod.sounds;

import com.kuollutkissa.susmod.util.RegMessage;
import com.kuollutkissa.susmod.util.SusID;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;

public class ModSoundEvents {
    public static final SoundEvent AMOGUS = registerSoundEvent("amogus");
    public static final SoundEvent AMOGUS_SHORT = registerSoundEvent("amogus_short");
    public static final SoundEvent AMOGUS_DEATH = registerSoundEvent("amogus_death");
    private static SoundEvent registerSoundEvent(String id) {
        return Registry.register(Registries.SOUND_EVENT, new SusID(id), SoundEvent.of(new SusID(id)));
    }
    public static void registerModSoundEvents() {
        RegMessage.regMessage("sound events");
    }
}
