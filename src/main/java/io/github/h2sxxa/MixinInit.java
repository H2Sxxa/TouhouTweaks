package io.github.h2sxxa;

import java.util.List;
import com.google.common.collect.Lists;

import zone.rong.mixinbooter.IEarlyMixinLoader;



public class MixinInit implements IEarlyMixinLoader{
    @Override
    public List<String> getMixinConfigs() {
        return Lists.newArrayList("mixins.touhoutweaks.json");
    }
}
