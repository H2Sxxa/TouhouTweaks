package io.github.h2sxxa.events;

import io.github.h2sxxa.regist.ModSounds;
import io.github.h2sxxa.Consts;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(modid=Consts.MODID)
public class ModEvents {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPlayerDeath(LivingDeathEvent e){
        Minecraft mc = Minecraft.getMinecraft();
        if (mc != null){
            System.out.println("player death");
            mc.getSoundHandler().playSound(PositionedSoundRecord.getRecord(ModSounds.SE_PLAYERDEAD, 1.0F, 1.0F));
        }
    }
}
