package org.spongepowered.spunbric.plugin.sponge;

import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import org.spongepowered.api.plugin.PluginContainer;

import java.nio.file.Path;

public class FabricPluginModContainer implements ModContainer {
    private final PluginContainer container;
    private final FabricPluginModMetadata fabricMetadata;

    public FabricPluginModContainer(FabricPluginModMetadata fabricMetadata, PluginContainer container) {
        this.fabricMetadata = fabricMetadata;
        this.container = container;
    }

    @Override
    public ModMetadata getMetadata() {
        return fabricMetadata;
    }

    @Override
    public Path getRootPath() {
        return container.getSource().orElseGet(null);
    }
}
