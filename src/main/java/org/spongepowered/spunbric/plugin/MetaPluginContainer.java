package org.spongepowered.spunbric.plugin;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import org.spongepowered.plugin.meta.PluginDependency;
import org.spongepowered.plugin.meta.PluginMetadata;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class MetaPluginContainer extends AbstractPluginContainer {

    private final String id;

    private final String name;
    private final Optional<String> version;
    private final Optional<String> description;
    private final Optional<String> url;
    private final ImmutableList<String> authors;

    private final ImmutableBiMap<String, PluginDependency> dependencies;

    private final Optional<Path> source;

    public MetaPluginContainer(PluginMetadata metadata, Optional<Path> source) {
        checkNotNull(metadata, "metadata");

        this.id = metadata.getId();

        this.name = MoreObjects.firstNonNull(metadata.getName(), this.id);
        this.version = Optional.ofNullable(metadata.getVersion());
        this.description = Optional.ofNullable(metadata.getDescription());
        this.url = Optional.ofNullable(metadata.getUrl());
        this.authors = ImmutableList.copyOf(metadata.getAuthors());

        this.dependencies = ImmutableBiMap.copyOf(metadata.getDependenciesById());

        this.source = checkNotNull(source, "source");
    }

    @Override
    public final String getId() {
        return this.id;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final Optional<String> getVersion() {
        return this.version;
    }

    @Override
    public final Optional<String> getDescription() {
        return this.description;
    }

    @Override
    public final Optional<String> getUrl() {
        return this.url;
    }

    @Override
    public final List<String> getAuthors() {
        return this.authors;
    }

    @Override
    public final Set<PluginDependency> getDependencies() {
        return this.dependencies.values();
    }

    @Override
    public final Optional<PluginDependency> getDependency(String id) {
        return Optional.ofNullable(this.dependencies.get(id));
    }

    @Override
    public Optional<Path> getSource() {
        return this.source;
    }

}
