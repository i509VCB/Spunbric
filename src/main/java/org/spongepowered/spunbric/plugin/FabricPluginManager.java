package org.spongepowered.spunbric.plugin;

import com.google.inject.Singleton;
import net.fabricmc.loader.launch.common.FabricLauncherBase;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;

import java.util.Collection;
import java.util.Optional;

// TODO Impl
@Singleton
public class FabricPluginManager implements PluginManager {

    @Override
    public Optional<PluginContainer> fromInstance(Object instance) {
        return Optional.empty();
    }

    @Override
    public Optional<PluginContainer> getPlugin(String id) {
        return Optional.empty();
    }

    @Override
    public Collection<PluginContainer> getPlugins() {
        FabricLauncherBase.getLauncher().getTargetClassLoader();
        return null;
    }

    @Override
    public boolean isLoaded(String id) {
        return false;
    }
}
