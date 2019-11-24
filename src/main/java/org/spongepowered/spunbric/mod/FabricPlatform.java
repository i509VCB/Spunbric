package org.spongepowered.spunbric.mod;

import org.spongepowered.api.MinecraftVersion;
import org.spongepowered.api.Platform;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.Map;

// TODO Dummy Impl
public class FabricPlatform implements Platform {
    @Override
    public Type getType() {
        return null;
    }

    @Override
    public Type getExecutionType() {
        return null;
    }

    @Override
    public PluginContainer getContainer(Component component) {
        return null;
    }

    @Override
    public MinecraftVersion getMinecraftVersion() {
        return null;
    }

    @Override
    public Map<String, Object> asMap() {
        return null;
    }
}
