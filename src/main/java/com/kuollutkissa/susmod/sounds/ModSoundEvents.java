package com.kuollutkissa.susmod.sounds;

import com.kuollutkissa.susmod.util.Util;
import com.kuollutkissa.susmod.util.SusID;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public class ModSoundEvents {
    public static final SoundEvent AMOGUS = registerSoundEvent("amogus");
    public static final SoundEvent AMOGUS_SHORT = registerSoundEvent("amogus_short");
    public static final SoundEvent AMOGUS_DEATH = registerSoundEvent("amogus_death");
    public static final SoundEvent SUS = registerSoundEvent("sus");
    public static final SoundEvent AMOGUS_AMBIENT = registerSoundEvent("amogus_ambient");
    private static SoundEvent registerSoundEvent(String id) {
        return Registry.register(Registry.SOUND_EVENT, new SusID(id), new SoundEvent(new SusID(id)));
    }
    public static void registerModSoundEvents() {
        Util.regMessage("sound events");
    }
}
