package io.github.h2sxxa.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.h2sxxa.regist.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method ="displayInGameMenu", at = @At(value="RETURN"),remap=false)
    public void ondisplayInGameMenu(CallbackInfo ci){
        Minecraft mc = Minecraft.getMinecraft();
        if (mc != null){
            System.out.println("player pause");
            mc.getSoundHandler().playSound(PositionedSoundRecord.getRecord(ModSounds.SE_PLAYERPAUSE, 1.0F, 1.0F));
        }
    }

}
