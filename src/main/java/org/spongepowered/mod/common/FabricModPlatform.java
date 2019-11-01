package org.spongepowered.mod.common;

import net.fabricmc.loader.api.FabricLoader;
import org.spongepowered.api.MinecraftVersion;
import org.spongepowered.api.Platform;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.Map;

public class FabricModPlatform implements Platform {
    @Override
    public Type getType() {
        switch (FabricLoader.getInstance().getEnvironmentType()) { // Fabric Loader will always be true in it's result.
            case CLIENT:
                return Type.CLIENT;
            case SERVER:
                return Type.SERVER;
            default:
                return Type.UNKNOWN;
        }
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
