package org.spongepowered.spunbric.mod;

import org.spongepowered.api.config.ConfigManager;
import org.spongepowered.api.config.ConfigRoot;
import org.spongepowered.api.plugin.PluginContainer;

// TODO Dummy Impl
public class FabricConfigManager implements ConfigManager {
    @Override
    public ConfigRoot getSharedConfig(PluginContainer plugin) {
        return null;
    }

    @Override
    public ConfigRoot getPluginConfig(PluginContainer plugin) {
        return null;
    }
}
