package io.github.h2sxxa.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import io.github.h2sxxa.Consts;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.Locale;

@Mixin(value=I18n.class,remap = Consts.IS_REMAP)
public class MixinI18n {
    @Redirect(method = "format",at = @At("INVOKE"))
    private static String onformat(Locale i18nLocale,String translateKey, Object... parameters){
        if (I18n.hasKey("touhoutweaks.".concat(translateKey))){
         return i18nLocale.formatMessage("touhoutweaks.".concat(translateKey), parameters);
        }else{
         return i18nLocale.formatMessage(translateKey, parameters);
        }
    }
}
