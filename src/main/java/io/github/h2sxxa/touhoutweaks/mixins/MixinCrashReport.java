package io.github.h2sxxa.touhoutweaks.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.h2sxxa.touhoutweaks.Consts;
import net.minecraft.crash.CrashReport;

@Mixin(value = CrashReport.class)
public class MixinCrashReport {
    @Inject(method = "getWittyComment", at = @At(value = "RETURN"),cancellable = true, remap = Consts.REMAP)
    private static void ongetWittyComment(CallbackInfoReturnable<String> cir) {
        System.out.println("We mixin crashreport successfully");
        String[] astring = new String[] { "Who set us up the TNT?",
                "Everything's going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.",
                "Why did you do that?", "I feel sad now :(", "My bad.", "I'm sorry, Dave.", "I let you down. Sorry :(",
                "On the bright side, I bought you a teddy bear!", "Daisy, daisy...", "Oh - I know what I did wrong!",
                "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!",
                "Don't be sad. I'll do better next time, I promise!", "Don't be sad, have a hug! <3",
                "I just don't know what went wrong :(", "Shall we play a game?",
                "Quite honestly, I wouldn't worry myself about that.", "I bet Cylons wouldn't have this problem.",
                "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?",
                "Hi. I'm Minecraft, and I'm a crashaholic.", "Ooh. Shiny.", "This doesn't make any sense!",
                "Why is it breaking :(", "Don't do that.", "Ouch. That hurt :(", "You're mean.",
                "This is a token for 1 free hug. Redeem at your nearest Mojangsta: [~~HUG~~]", "There are four lights!",
                "But it works on my machine." };
        String[] nstring = new String[astring.length + Consts.modWittyComment.length];
        for (int i = 0; i < astring.length; i++) {
            nstring[i] = astring[i];
        }
        for (int i = 0; i < Consts.modWittyComment.length; i++) {
            nstring[astring.length + i] = Consts.modWittyComment[i];
        }

        try {
            cir.setReturnValue(nstring[(int) (System.nanoTime() % (long) nstring.length)]);
        } catch (Throwable var2) {
            cir.setReturnValue("Witty comment unavailable :(");
        }

    }
}
