package io.github.h2sxxa.touhoutweaks.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.h2sxxa.touhoutweaks.config.THTConfigs;
import io.github.h2sxxa.touhoutweaks.regist.ModSounds;
import io.github.h2sxxa.touhoutweaks.Consts;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

@Mixin(value = EntityLivingBase.class)
public class MixinEntityLivingBase {
    @Inject(method = "addPotionEffect", at = @At(value = "HEAD"), remap = Consts.REMAP)
    private void onaddPotionEffect(PotionEffect potioneffectIn, CallbackInfo ci) {
        EntityLivingBase entity = (EntityLivingBase) (Object) this;
        if (entity instanceof EntityPlayer) {
            if (THTConfigs.PotionSoundEffect) {
                EntityPlayer player = (EntityPlayer) entity;
                ModSounds.matchPlayPotionSound(ModSounds.SE_LEVITATION, potioneffectIn.getPotion(),
                        MobEffects.LEVITATION, player);
                ModSounds.matchPlayPotionSound(ModSounds.SE_STRENGTH, potioneffectIn.getPotion(), MobEffects.STRENGTH,
                        player);
            }
        }

    }
}
