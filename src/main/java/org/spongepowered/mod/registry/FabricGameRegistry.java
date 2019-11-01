package org.spongepowered.mod.registry;

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.entity.ai.task.AITaskType;
import org.spongepowered.api.entity.ai.task.AbstractAITask;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.item.merchant.VillagerRegistry;
import org.spongepowered.api.item.recipe.crafting.CraftingRecipeRegistry;
import org.spongepowered.api.item.recipe.smelting.SmeltingRecipeRegistry;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.RegistryModule;
import org.spongepowered.api.registry.RegistryModuleAlreadyRegisteredException;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.rotation.Rotation;

import java.util.Collection;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Supplier;

public class FabricGameRegistry implements GameRegistry {
    @Override
    public CatalogKey resolveKey(String value) {
        return null;
    }

    @Override
    public <T extends CatalogType> Optional<T> getType(Class<T> typeClass, CatalogKey key) {
        return Optional.empty();
    }

    @Override
    public <T extends CatalogType> Collection<T> getAllOf(Class<T> typeClass) {
        return null;
    }

    @Override
    public <T extends CatalogType> Collection<T> getAllFor(String pluginId, Class<T> typeClass) {
        return null;
    }

    @Override
    public <T extends CatalogType> GameRegistry registerModule(Class<T> catalogClass, CatalogRegistryModule<T> registryModule) throws IllegalArgumentException, RegistryModuleAlreadyRegisteredException {
        return null;
    }

    @Override
    public GameRegistry registerModule(RegistryModule module) throws RegistryModuleAlreadyRegisteredException {
        return null;
    }

    @Override
    public <T> GameRegistry registerBuilderSupplier(Class<T> builderClass, Supplier<? extends T> supplier) {
        return null;
    }

    @Override
    public <T extends ResettableBuilder<?, ? super T>> T createBuilder(Class<T> builderClass) throws IllegalArgumentException {
        return null;
    }

    @Override
    public <T> T requireFactory(Class<T> clazz) {
        return null;
    }

    @Override
    public Optional<Rotation> getRotationFromDegree(int degrees) {
        return Optional.empty();
    }

    @Override
    public CraftingRecipeRegistry getCraftingRecipeRegistry() {
        return null;
    }

    @Override
    public SmeltingRecipeRegistry getSmeltingRecipeRegistry() {
        return null;
    }

    @Override
    public Optional<ResourcePack> getResourcePackById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<DisplaySlot> getDisplaySlotForColor(TextColor color) {
        return Optional.empty();
    }

    @Override
    public AITaskType registerAITaskType(PluginContainer plugin, String id, String name, Class<? extends AbstractAITask<? extends Agent>> aiClass) {
        return null;
    }

    @Override
    public VillagerRegistry getVillagerRegistry() {
        return null;
    }

    @Override
    public Locale getLocale(String locale) {
        return null;
    }

    @Override
    public Optional<Translation> getTranslationById(String id) {
        return Optional.empty();
    }
}
