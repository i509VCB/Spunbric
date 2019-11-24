package org.spongepowered.spunbric.mod;

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.data.property.Property;
import org.spongepowered.api.data.property.PropertyRegistry;
import org.spongepowered.api.data.property.provider.DoublePropertyProvider;
import org.spongepowered.api.data.property.provider.IntPropertyProvider;
import org.spongepowered.api.data.property.provider.PropertyProvider;

import java.util.Collection;
import java.util.Optional;

// TODO Dummy Impl
public class FabricPropertyRegistry implements PropertyRegistry {
    @Override
    public <V> void register(Property<V> property, PropertyProvider<V> propertyProvider) {

    }

    @Override
    public <V> PropertyProvider<V> getProvider(Property<V> property) {
        return null;
    }

    @Override
    public IntPropertyProvider getIntProvider(Property<Integer> property) {
        return null;
    }

    @Override
    public DoublePropertyProvider getDoubleProvider(Property<Double> property) {
        return null;
    }

    @Override
    public Optional<Property<?>> get(CatalogKey key) {
        return Optional.empty();
    }

    @Override
    public Collection<Property<?>> getAll() {
        return null;
    }
}
