package io.github.h2sxxa.touhoutweaks.mixins;

import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.h2sxxa.touhoutweaks.config.THTConfigs;
import io.github.h2sxxa.touhoutweaks.regist.ModSounds;
import io.github.h2sxxa.touhoutweaks.Consts;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;

@Mixin(value = Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "displayInGameMenu", at = @At(value = "RETURN"), remap = Consts.REMAP)
    private void ondisplayInGameMenu(CallbackInfo ci) {
        if (Display.isActive()) {
            if (THTConfigs.PauseSoundEffect) {
                ModSounds.playClientSound(PositionedSoundRecord.getRecord(ModSounds.SE_PLAYERPAUSE, 1.0F, 1.0F));
            }
        }
    }
}
