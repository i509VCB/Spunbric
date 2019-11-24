package org.spongepowered.spunbric.mod.inject;

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.Platform;
import org.spongepowered.api.network.ChannelBinding;
import org.spongepowered.api.network.ChannelRegistrar;
import org.spongepowered.api.network.ChannelRegistrationException;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.Optional;
import java.util.Set;

public class FabricChannelRegistrar implements ChannelRegistrar {
    @Override
    public ChannelBinding.IndexedMessageChannel createChannel(PluginContainer plugin, CatalogKey channelKey) throws ChannelRegistrationException {
        return null;
    }

    @Override
    public ChannelBinding.RawDataChannel createRawChannel(PluginContainer plugin, CatalogKey channelKey) throws ChannelRegistrationException {
        return null;
    }

    @Override
    public Optional<ChannelBinding> getChannel(CatalogKey channelkey) {
        return Optional.empty();
    }

    @Override
    public void unbindChannel(ChannelBinding channel) {

    }

    @Override
    public Set<CatalogKey> getRegisteredChannels(Platform.Type side) {
        return null;
    }

    @Override
    public boolean isChannelAvailable(CatalogKey channelKey) {
        return false;
    }
}
