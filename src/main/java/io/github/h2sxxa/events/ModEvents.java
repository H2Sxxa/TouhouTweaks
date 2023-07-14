package io.github.h2sxxa.events;

import io.github.h2sxxa.regist.ModSounds;
import io.github.h2sxxa.Consts;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid=Consts.MODID)
public class ModEvents {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPlayerDeath(LivingDeathEvent e){
        EntityLivingBase entity = e.getEntityLiving();
        if (entity instanceof EntityPlayer){
            entity.world.playSound(null,entity.getPosition(),ModSounds.SE_PLAYERDEAD,entity.getSoundCategory(), 1.0f, 1.0f);
        }
    }
}
