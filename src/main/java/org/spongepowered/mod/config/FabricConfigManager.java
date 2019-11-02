package org.spongepowered.mod.config;

import org.spongepowered.api.config.ConfigManager;
import org.spongepowered.api.config.ConfigRoot;
import org.spongepowered.api.plugin.PluginContainer;

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
