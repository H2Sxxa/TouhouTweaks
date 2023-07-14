package io.github.h2sxxa.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.EntityPlayer;
import io.github.h2sxxa.regist.ModSounds;

@Mixin(EntityPlayer.class)
public class MixinEntityPlayer{
    @Inject(method = "onDeath",at = @At(value = "RETURN"),remap = false,cancellable = true)
    public void onDeath(CallbackInfo ci){
        System.out.println("mixinPlayerSuccess");
        EntityPlayer player = (EntityPlayer)(Object)this;
        player.playSound(ModSounds.SE_PLAYERDEAD, 1.0f, 1.0f);
    }

}
