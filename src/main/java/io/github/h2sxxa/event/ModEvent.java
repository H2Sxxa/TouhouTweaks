package io.github.h2sxxa.event;

import io.github.h2sxxa.Consts;
import io.github.h2sxxa.regist.ModSounds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid=Consts.MODID)
public class ModEvent {
    @SubscribeEvent(priority = EventPriority.LOWEST)
	public static void playerDeathHandle(LivingDeathEvent e) {
		if (e.getEntity() instanceof EntityPlayer){
			System.out.println("Player Death!");
			e.getEntityLiving().playSound(ModSounds.SE_PLAYERDEAD, 1.0f, 1.0f);
		}
	}
}
