package io.github.h2sxxa.regist;

import java.util.ArrayList;
import java.util.List;

import io.github.h2sxxa.Consts;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ModSounds {
    public static void initModSounds(){};

    public static final List<SoundEvent> SOUNDS = new ArrayList<SoundEvent>();

    private static SoundEvent getThtSoundEvent(String soundName){
        SoundEvent se  = new SoundEvent(new ResourceLocation(Consts.MODID, soundName)).setRegistryName(Consts.MODID, soundName);
        SOUNDS.add(se);
        return se;
    }

    public static void playClientSound(ISound sound){
        Minecraft mc = Minecraft.getMinecraft();
        if (mc != null){
            mc.getSoundHandler().playSound(sound);
        }
    }

    public static final SoundEvent SE_PLAYERDEAD = getThtSoundEvent("thtplayerdead");
    public static final SoundEvent SE_PLAYERPAUSE = getThtSoundEvent("thtpause");
    public static final SoundEvent SE_SCREENSHOT = getThtSoundEvent("thtscreenshot");
    public static final SoundEvent SE_LEVITATION = getThtSoundEvent("thtlevitation");
    public static final SoundEvent SE_STRENGTH = getThtSoundEvent("thtstrength");

    @SubscribeEvent
    public static void onSoundEvenrRegistration(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().registerAll(SOUNDS.toArray(new SoundEvent[0]));
    }
}
