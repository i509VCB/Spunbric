package org.spongepowered.spunbric.mod;

import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.Tristate;
import org.spongepowered.api.util.metric.MetricsConfigManager;

// TODO Dummy Impl
public class FabricMetricsConfigManager implements MetricsConfigManager {
    @Override
    public Tristate getGlobalCollectionState() {
        return null;
    }

    @Override
    public Tristate getCollectionState(PluginContainer container) {
        return null;
    }
}
