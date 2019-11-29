package org.spongepowered.spunbric.plugin;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.launch.common.FabricLauncherBase;
import net.minecraft.util.SystemUtil;
import org.spongepowered.api.Platform;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.plugin.meta.PluginMetadata;
import org.spongepowered.spunbric.SpunbricImpl;
import org.spongepowered.spunbric.launch.FabricLaunchPluginManager;
import org.spongepowered.spunbric.launch.PluginCandidate;
import org.spongepowered.spunbric.launch.PluginSorter;
import org.spongepowered.spunbric.launch.PluginSource;
import org.spongepowered.spunbric.mod.entry.AbstractSpunbricMod;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

import static com.google.common.base.MoreObjects.firstNonNull;

/**
 * Until the fabric loader has ability to load other mods after discovery, we will just wrap the mods into a system.
 */
@Singleton
public class FabricPluginManager implements PluginManager {

    private final Injector rootInjector;

    private final Map<String, PluginContainer> plugins = new HashMap<>();
    private final Map<Object, PluginContainer> pluginInstances = new IdentityHashMap<>();

    // Fabric - temporary till an official system is in place.
    private final Map<String, ModContainer> mods = SystemUtil.consume(new HashMap<>(), map -> {
        FabricLoader.getInstance().getAllMods().forEach(container -> {
           map.put(container.getMetadata().getId(), container);
        });
    });

    @Inject
    public FabricPluginManager(Injector injector, AbstractSpunbricMod mod/*, MetadataContainer metadata*/) {
        this.rootInjector = injector.getParent();

        //this.registerPlugin(SpunbricImpl.getMinecraftPlugin());
        //this.registerPlugin(SpunbricImpl.getSpongePlugin());
        //this.registerPlugin(metadata.createContainer(Platform.API_ID, SpunbricImpl.API_NAME, mod.getSource()));
        this.registerPlugin(mod);
        // Illegal
        FabricModContainers.register(this::registerPlugin);
    }

    @Override
    public Optional<PluginContainer> fromInstance(Object instance) {
        return Optional.empty();
    }

    @Override
    public Optional<PluginContainer> getPlugin(String id) {
        return Optional.empty();
    }

    @Override
    public Collection<PluginContainer> getPlugins() {
        FabricLauncherBase.getLauncher().getTargetClassLoader();
        return null;
    }

    @Override
    public boolean isLoaded(String id) {
        return false;
    }

    private void registerPlugin(PluginContainer plugin) {
        this.plugins.put(plugin.getId(), plugin);
        plugin.getInstance().ifPresent(instance -> this.pluginInstances.put(instance, plugin));
    }

    public void loadPlugins() throws IOException {
        Map<String, PluginCandidate> candidateMap = FabricLaunchPluginManager.getPlugins();
        if (candidateMap.isEmpty()) {
            return; // Nothing to do
        }

        try {
            PluginSorter.sort(checkRequirements(candidateMap)).forEach(this::loadPlugin);
        } catch (Throwable e) {
            throw PluginReporter.crash(e, candidateMap.values());
        }
    }

    private Set<PluginCandidate> checkRequirements(Map<String, PluginCandidate> candidates) {
        // Collect all versions of already loaded plugins
        Map<String, String> loadedPlugins = new HashMap<>();
        for (PluginContainer container : this.plugins.values()) {
            loadedPlugins.put(container.getId(), container.getVersion().orElse(null));
        }


        Set<PluginCandidate> successfulCandidates = new HashSet<>(candidates.size());
        List<PluginCandidate> failedCandidates = new ArrayList<>();

        for (PluginCandidate candidate : candidates.values()) {
            if (candidate.collectDependencies(loadedPlugins, candidates)) {
                successfulCandidates.add(candidate);
            } else {
                failedCandidates.add(candidate);
            }
        }

        if (failedCandidates.isEmpty()) {
            return successfulCandidates; // Nothing to do, all requirements satisfied
        }

        PluginCandidate candidate;
        boolean updated;
        while (true) {
            updated = false;
            Iterator<PluginCandidate> itr = successfulCandidates.iterator();
            while (itr.hasNext()) {
                candidate = itr.next();
                if (candidate.updateRequirements()) {
                    updated = true;
                    itr.remove();
                    failedCandidates.add(candidate);
                }
            }

            if (updated) {
                // Update failed candidates as well
                failedCandidates.forEach(PluginCandidate::updateRequirements);
            } else {
                break;
            }
        }

        for (PluginCandidate failed : failedCandidates) {
            if (failed.isInvalid()) {
                SpunbricImpl.getLogger().error("Plugin '{}' from {} cannot be loaded because it is invalid", failed.getId(), failed.getSource());
            } else {
                SpunbricImpl.getLogger().error("Cannot load plugin '{}' from {} because it is missing the required dependencies {}",
                        failed.getId(), failed.getSource(), PluginReporter.formatRequirements(failed.getMissingRequirements()));
            }
        }

        return successfulCandidates;
    }

    private void loadPlugin(PluginCandidate candidate) {
        final String id = candidate.getId();
        candidate.getSource().addToClasspath();

        final PluginMetadata metadata = candidate.getMetadata();
        final String name = firstNonNull(metadata.getName(), id);
        final String version = firstNonNull(metadata.getVersion(), "unknown");

        try {
            Class<?> pluginClass = Class.forName(candidate.getPluginClass());
            Optional<Path> source = candidate.getSource().getPath();
            if (!source.isPresent()) {
                source = PluginSource.find(pluginClass);
            }
            //PluginContainer container = new FabricPluginContainer(this.rootInjector, pluginClass, metadata, source);

            //registerPlugin(container);
            //Sponge.getEventManager().registerListeners(container, container.getInstance().get()); // TODO: PluginManager TODO

            SpunbricImpl.getLogger().info("Loaded plugin: {} {} (from {})", name, version, candidate.getSource());
        } catch (Throwable e) {
            SpunbricImpl.getLogger().error("Failed to load plugin: {} {} (from {})", name, version, candidate.getSource(), e);
        }
    }
}
