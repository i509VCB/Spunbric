package org.spongepowered.spunbric.plugin;

import com.google.inject.Injector;

public interface PluginContainerExtension {
    Injector getInjector();
}
