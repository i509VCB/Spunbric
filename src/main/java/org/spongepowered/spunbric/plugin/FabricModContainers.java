package org.spongepowered.spunbric.plugin;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.Person;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * TODO: When Loader has support for loading child mods, this will be replaced.
 * This is a class which generates all the PluginContainers for fabric mods.
 */
public final class FabricModContainers extends AbstractPluginContainer {
    private final ModContainer container;
    private final List<String> authors;
    private final String modid;

    private FabricModContainers(String modid, ModContainer container) {
        this.modid = modid;
        this.container = container;
        this.authors = new ArrayList<>();

        for(Person author : this.container.getMetadata().getAuthors()) {
            authors.add(author.getName());
            // Sponge has no concept of author contact info, so we don't add it.
        }

    }

    public static void register(Consumer<PluginContainer> registerPlugin) {
        FabricLoader.getInstance().getAllMods().forEach(container -> registerPlugin.accept(FabricModContainers.create(container)));
    }

    private static PluginContainer create(ModContainer modContainer) {
        return new FabricModContainers(modContainer.getMetadata().getId(), modContainer);
    }

    @Override
    public String getId() {
        return this.modid; // This will always be constant.
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
}
