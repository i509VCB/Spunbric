package org.spongepowered.spunbric.mod;

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataHolderBuilder;
import org.spongepowered.api.data.DataManager;
import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.persistence.*;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.Collection;
import java.util.Optional;

// TODO Dummy Impl
public class FabricDataManager implements DataManager {
    @Override
    public <T extends DataSerializable> void registerBuilder(Class<T> clazz, DataBuilder<T> builder) {

    }

    @Override
    public <T extends DataSerializable> void registerContentUpdater(Class<T> clazz, DataContentUpdater updater) {

    }

    @Override
    public <T extends DataSerializable> Optional<DataContentUpdater> getWrappedContentUpdater(Class<T> clazz, int fromVersion, int toVersion) {
        return Optional.empty();
    }

    @Override
    public <T extends DataSerializable> Optional<DataBuilder<T>> getBuilder(Class<T> clazz) {
        return Optional.empty();
    }

    @Override
    public <T extends DataSerializable> Optional<T> deserialize(Class<T> clazz, DataView dataView) {
        return Optional.empty();
    }

    @Override
    public <T extends DataHolder.Immutable<T>, B extends DataHolderBuilder.Immutable<T, B>> void register(Class<T> holderClass, B builder) {

    }

    @Override
    public void registerLegacyManipulatorIds(String legacyId, DataRegistration registration) {

    }

    @Override
    public <T extends DataHolder.Immutable<T>, B extends DataHolderBuilder.Immutable<T, B>> Optional<B> getImmutableBuilder(Class<T> holderClass) {
        return Optional.empty();
    }

    @Override
    public <T> Optional<DataTranslator<T>> getTranslator(Class<T> objectClass) {
        return Optional.empty();
    }

    @Override
    public Collection<DataRegistration> getAllRegistrationsFor(PluginContainer container) {
        return null;
    }

    @Override
    public DataContainer createContainer() {
        return null;
    }

    @Override
    public DataContainer createContainer(DataView.SafetyMode safety) {
        return null;
    }
}
