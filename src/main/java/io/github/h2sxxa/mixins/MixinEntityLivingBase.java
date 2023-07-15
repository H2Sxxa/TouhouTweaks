package io.github.h2sxxa.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.h2sxxa.Consts;
import io.github.h2sxxa.regist.ModSounds;
import io.github.h2sxxa.libs.Utils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

@Mixin(value = EntityLivingBase.class,remap = Consts.IS_REMAP)
public class MixinEntityLivingBase {
    @Inject(method="addPotionEffect",at=@At(value="HEAD"))
    private void onaddPotionEffect(PotionEffect potioneffectIn,CallbackInfo ci){
        if (potioneffectIn.getPotion() == MobEffects.LEVITATION){
            EntityLivingBase entity = (EntityLivingBase)(Object)this;
            if (entity instanceof EntityPlayer){
                EntityPlayer player = (EntityPlayer)entity;
                Utils.matchPlayPotionSound(ModSounds.SE_LEVITATION,MobEffects.LEVITATION,player);
                Utils.matchPlayPotionSound(ModSounds.SE_STRENGTH, MobEffects.STRENGTH, player);
            }
        }
    }
}
