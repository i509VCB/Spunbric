package org.spongepowered.spunbric.plugin.sponge;

import com.google.gson.JsonElement;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.metadata.*;
import net.fabricmc.loader.util.version.StringVersion;
import org.spongepowered.plugin.meta.PluginMetadata;

import java.util.*;

public class FabricPluginModMetadata implements ModMetadata {
    private final PluginMetadata metadata;
    private final List<Person> authors;

    public FabricPluginModMetadata(PluginMetadata metadata) {
        this.metadata = metadata;
        List<Person> authors = new ArrayList<>();
        for(String author : metadata.getAuthors()) {
            authors.add(new FabricPerson(author));
        }

        this.authors = authors;
    }

    @Override
    public String getType() {
        return "sponge";
    }

    @Override
    public String getId() {
        return metadata.getId();
    }

    @Override
    public Version getVersion() {
        return new StringVersion(metadata.getVersion());
    }

    @Override
    public Collection<ModDependency> getDepends() {
        return null;
    }

    @Override
    public Collection<ModDependency> getRecommends() {
        return null;
    }

    @Override
    public Collection<ModDependency> getSuggests() {
        return null;
    }

    @Override
    public Collection<ModDependency> getConflicts() {
        return null;
    }

    @Override
    public Collection<ModDependency> getBreaks() {
        return null;
    }

    @Override
    public String getName() {
        return metadata.getName();
    }

    @Override
    public String getDescription() {
        return metadata.getDescription();
    }

    @Override
    public Collection<Person> getAuthors() {
        return authors;
    }

    @Override
    public Collection<Person> getContributors() {
        return Collections.emptyList(); // Sponge has no concept of Contributors.
    }

    @Override
    public ContactInformation getContact() {
        return null;
    }

    @Override
    public Collection<String> getLicense() {
        return Collections.emptyList(); // Sponge has no concept of licenses in plugins
    }

    @Override
    public Optional<String> getIconPath(int i) {
        return Optional.empty();
    }

    @Override
    public boolean containsCustomValue(String s) {
        return false; // Sponge has no concept of custom values.
    }

    @Override
    public CustomValue getCustomValue(String s) {
        throw new UnsupportedOperationException("Sponge has no concept of CustomValues");
    }

    @Override
    public boolean containsCustomElement(String s) {
        return false; // Sponge has no concept of custom elements.
    }

    @Override
    public JsonElement getCustomElement(String s) {
        throw new UnsupportedOperationException("Sponge has no concept of CustomElements");
    }
}
