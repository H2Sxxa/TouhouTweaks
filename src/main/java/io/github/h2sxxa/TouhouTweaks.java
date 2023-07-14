package io.github.h2sxxa;

import org.apache.logging.log4j.Logger;

import io.github.h2sxxa.regist.ModSounds;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
    modid = Consts.MODID,
    name = Consts.NAME
)
public class TouhouTweaks {
    @Instance(Consts.MODID)
    public static TouhouTweaks modInstance;

    public Logger logger;

    @EventHandler public void preInit(FMLPreInitializationEvent event)
    {
        logger=event.getModLog();
        ModSounds.initModSounds();
    }
}
