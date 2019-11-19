package org.spongepowered.spunbric.plugin;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.Person;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class FabricLoaderPluginContainer implements PluginContainer {
    private final ModContainer container;
    private final List<String> authors;

    private FabricLoaderPluginContainer() {
        this.container = FabricLoader.getInstance().getModContainer("fabricloader").orElseThrow(() -> new IllegalStateException("Fabric Loader should always be present, something went horrible wrong."));
        this.authors = new ArrayList<>();

        for(Person author : this.container.getMetadata().getAuthors()) {
            authors.add(author.getName());
            // Sponge has no concept of author contact info, so we don't add it.
        }

    }

    private static FabricLoaderPluginContainer INSTANCE = new FabricLoaderPluginContainer();

    public static void register() {
        //SpongeImpl.setMinecraftPlugin(create()); // TODO Register the FabricPluginContainer
    }

    private static PluginContainer create() {
        return INSTANCE;
    }

    @Override
    public String getId() {
        return "fabricloader"; // This will always be constant.
    }

    @Override
    public Optional<String> getVersion() {
        return Optional.of(this.container.getMetadata().getVersion().getFriendlyString());
    }

    @Override
    public String getName() {
        return this.container.getMetadata().getName();
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.of(this.container.getMetadata().getDescription());
    }

    @Override
    public List<String> getAuthors() {
        return this.authors;
    }

    @Override
    public Optional<String> getUrl() {
        return this.container.getMetadata().getContact().get("homepage");
    }

    public Optional<FabricLoader> getInstance() {
        return Optional.of(FabricLoader.getInstance());
    }
}
