package org.spongepowered.mod;

import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.service.ProviderRegistration;
import org.spongepowered.api.service.ProvisioningException;
import org.spongepowered.api.service.ServiceManager;

import java.util.Optional;

public class FabricServiceManager implements ServiceManager {
    @Override
    public <T> void setProvider(PluginContainer plugin, Class<T> service, T provider) {

    }

    @Override
    public <T> Optional<T> provide(Class<T> service) {
        return Optional.empty();
    }

    @Override
    public <T> Optional<ProviderRegistration<T>> getRegistration(Class<T> service) {
        return Optional.empty();
    }

    @Override
    public <T> T provideUnchecked(Class<T> service) throws ProvisioningException {
        return null;
    }
}
