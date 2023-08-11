package io.github.h2sxxa.touhoutweaks.config;

import io.github.h2sxxa.touhoutweaks.Consts;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Consts.MODID)
public class ConfigSync {
    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Consts.MODID)) {
            ConfigManager.sync(Consts.MODID, Config.Type.INSTANCE);
        }
    }
}
