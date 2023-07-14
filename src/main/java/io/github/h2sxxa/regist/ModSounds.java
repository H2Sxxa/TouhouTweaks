package io.github.h2sxxa.regist;

import java.util.ArrayList;
import java.util.List;

import io.github.h2sxxa.Consts;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ModSounds {
    public static void initModSounds(){};

    public static final List<SoundEvent> SOUNDS = new ArrayList<SoundEvent>();

    private static SoundEvent getThtSoundEvent(String pathIn){
        SoundEvent se  = new SoundEvent(new ResourceLocation(Consts.MODID, pathIn)).setRegistryName(Consts.MODID, pathIn);
        SOUNDS.add(se);
        return se;
    }

    public static final SoundEvent SE_PLAYERDEAD = getThtSoundEvent("thtplayerdeath");
    public static final SoundEvent SE_PLAYERPAUSE = getThtSoundEvent("thtpause");

    @SubscribeEvent
    public static void onSoundEvenrRegistration(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().registerAll(SOUNDS.toArray(new SoundEvent[0]));
    }
}
