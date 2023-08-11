package io.github.h2sxxa.touhoutweaks.libs;

import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.SoundEvent;

import io.github.h2sxxa.touhoutweaks.regist.ModSounds;

public class Utils {
    public static void matchPlayPotionSound(SoundEvent sound, Potion potion, EntityPlayer player) {
        if (!player.isPotionActive(potion)) {
            ModSounds.playClientSound(PositionedSoundRecord.getRecord(sound, 1.0F, 1.0F));
        }

    }

}
