package org.spongepowered.spunbric;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.GameState;
import org.spongepowered.api.Platform;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.game.state.GameStateEvent;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.spunbric.launch.FabricLaunch;

import javax.annotation.Nullable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.google.common.base.Preconditions.checkState;
import static org.spongepowered.api.Platform.Component.IMPLEMENTATION;

@Singleton
public class SpunbricImpl {
    private static PluginContainer fabricLoader;

    private SpunbricImpl() {
    }

    public static final String GAME_ID = "fabric";
    public static final String GAME_NAME = "fabric";

    public static final String API_NAME = "SpongeAPI";

    public static final String ECOSYSTEM_ID = "sponge"; // This is different from the id used by the actual implementation
    public static final String ECOSYSTEM_NAME = "Sponge";

    private static final Logger logger = LogManager.getLogger(ECOSYSTEM_NAME);
    public static final Random random  = new Random();

    // TODO Automate this
    public static final SpongeMinecraftVersion MINECRAFT_VERSION = new SpongeMinecraftVersion("1.14.4", 498);

    private static final List<PluginContainer> internalPlugins = new ArrayList<>();

    @Inject
    private static void initialize(Platform platform) {

    }

    private static <T> T check(@Nullable T instance) {
        checkState(instance != null, "SpongeImpl has not been initialized!");
        return instance;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static boolean isInitialized() {
        return false;
        //return game != null;
    }
    /*
    public static SpongeGame getGame() {
        return check(game);
    }
    */
    public static MinecraftServer getServer() {
        return (MinecraftServer) Sponge.getServer();
    }
    /*
    public static SpongeGameRegistry getRegistry() {
        return check(registry);
    }

    public static SpongeDataManager getDataManager() {
        return check(dataManager);
    }

    public static SpongePropertyRegistry getPropertyRegistry() {
        return check(propertyRegistry);
    }

    public static SpongeScheduler getScheduler() {
        return check(scheduler);
    }

    public static SpongeCommandManager getCommandManager() {
        return check(commandManager);
    }

    public static SpongeCauseStackManager getCauseStackManager() {
        return check(causeStackManager);
    }
    */
    public static PluginContainer getPlugin() {
        return Sponge.getPlatform().getContainer(IMPLEMENTATION);
    }


    public static Path getGameDir() {
        return FabricLaunch.getGameDir();
    }

    public static Path getPluginConfigDir() {
        return FabricLaunch.getPluginConfigDir();
    }

    public static Path getPluginsDir() {
        return FabricLaunch.getPluginsDir();
    }

    public static Path getSpongeConfigDir() {
        return FabricLaunch.getSpongeConfigDir();
    }
    /*
    public static SpongeConfigSaveManager getConfigSaveManager() {
        if (configSaveManager == null) {
            configSaveManager = new SpongeConfigSaveManager();
        }

        return configSaveManager;
    }

    public static SpongeConfig<GlobalConfig> getGlobalConfigAdapter() {
        if (globalConfigAdapter == null) {
            globalConfigAdapter = new SpongeConfig<>(GLOBAL, getSpongeConfigDir().resolve("global.conf"), ECOSYSTEM_ID, null, false);
        }

        return globalConfigAdapter;
    }

    public static SpongeConfig<CustomDataConfig> getCustomDataConfigAdapter() {
        if (customDataConfigAdapter == null) {
            customDataConfigAdapter = new SpongeConfig<>(CUSTOM_DATA, getSpongeConfigDir().resolve("custom_data.conf"), ECOSYSTEM_ID, null, true);
        }
        return customDataConfigAdapter;
    }

    public static SpongeConfig<TrackerConfig> getTrackerConfigAdapter() {
        if (trackerConfigAdapter == null) {
            trackerConfigAdapter = new SpongeConfig<>(TRACKER, getSpongeConfigDir().resolve("tracker.conf"), ECOSYSTEM_ID, null, true);
        }
        return trackerConfigAdapter;
    }
    */

    public static List<PluginContainer> getInternalPlugins() {
        return internalPlugins;
    }

    /**
     * Throws the given event.
     *
     * @param event The event
     * @return True if the event is cancellable and is cancelled, false if not cancelled
     */
    public static boolean postEvent(Event event) {
        return Sponge.getEventManager().post(event);
    }

    // TODO this code is used a BUNCH of times
    /**
     * Gets the {@link PluginContainer} for given plugin object.
     *
     * @param plugin The Plugin Object
     * @return The associated plugin container
     * @throws IllegalArgumentException when the argument has no associated plugin container (usually because it is not a plugin)
     */
    public static PluginContainer getPluginContainer(Object plugin) throws IllegalArgumentException {
        Optional<PluginContainer> containerOptional = Sponge.getGame().getPluginManager().fromInstance(plugin);
        if (!containerOptional.isPresent()) {
            throw new IllegalArgumentException(
                    "The provided plugin object does not have an associated plugin container "
                            + "(in other words, is 'plugin' actually your plugin object?");
        }

        return containerOptional.get();
    }
}
