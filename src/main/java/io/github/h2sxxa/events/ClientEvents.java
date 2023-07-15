package io.github.h2sxxa.events;

import io.github.h2sxxa.regist.ModSounds;
import io.github.h2sxxa.Consts;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.ScreenshotEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@EventBusSubscriber(modid=Consts.MODID)
public class ClientEvents {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPlayerDeath(LivingDeathEvent e){
        if (e.getEntityLiving() instanceof EntityPlayer){
            if(!e.isCanceled()){
            ModSounds.playClientSound(PositionedSoundRecord.getRecord(ModSounds.SE_PLAYERDEAD, 1.0F, 1.0F));
        }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPlayerScreenshot(ScreenshotEvent e){
        if(!e.isCanceled()){
            ModSounds.playClientSound(PositionedSoundRecord.getRecord(ModSounds.SE_SCREENSHOT, 1.0F, 1.0F));
        } 
    }
}
