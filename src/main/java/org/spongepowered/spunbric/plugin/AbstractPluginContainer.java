package org.spongepowered.spunbric.plugin;

import com.google.common.base.MoreObjects;
import org.spongepowered.api.plugin.PluginContainer;

public abstract class AbstractPluginContainer implements PluginContainer {

    protected AbstractPluginContainer() {
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper("Plugin")
                .omitNullValues()
                .add("id", getId())
                .add("name", getName())
                .add("version", getVersion().orElse(null))
                .add("description", getDescription().orElse(null))
                .add("url", getUrl().orElse(null))
                .add("authors", getAuthors().isEmpty() ? null : getAuthors())
                .add("source", getSource().orElse(null));
    }

    @Override
    public final String toString() {
        return toStringHelper().toString();
    }

}
