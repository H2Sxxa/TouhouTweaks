package io.github.h2sxxa.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import io.github.h2sxxa.Consts;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.Locale;

@Mixin(value=I18n.class,remap = Consts.IS_REMAP)
public class MixinI18n {
    @Shadow
    static Locale i18nLocale;

    @Overwrite
    /**
     * @author H2Sxxa
     * @reason no need to inject it
     * Translates the given string and then formats it. Equivilant to String.format(translate(key), parameters).
     */
    public static String format(String translateKey, Object... parameters){
        if (I18n.hasKey("touhoutweaks.".concat(translateKey))){
         return i18nLocale.formatMessage("touhoutweaks.".concat(translateKey), parameters);
        }else{
         return i18nLocale.formatMessage(translateKey, parameters);
        }
    }
}
