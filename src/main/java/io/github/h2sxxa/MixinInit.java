package io.github.h2sxxa;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import zone.rong.mixinbooter.IEarlyMixinLoader;



@IFMLLoadingPlugin.Name("TouhouTweaks")
@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
public class MixinInit implements IFMLLoadingPlugin,IEarlyMixinLoader{
    
    @Override
    public List<String> getMixinConfigs() {
        return Lists.newArrayList("mixins.touhoutweaks.json");
    }

    @Override
    public String[] getASMTransformerClass()
    {
        return new String[0];
    }

    @Override
    public String getModContainerClass()
    {
        return "";
    }

    @Nullable
    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data)
    {

    }

    @Override
    public String getAccessTransformerClass()
    {
        return null;
    }
}
