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
import org.spongepowered.spunbric.mod.AbstractFabricGame;
import org.spongepowered.spunbric.mod.FabricCommandManager;
import org.spongepowered.spunbric.mod.FabricDataManager;
import org.spongepowered.spunbric.mod.FabricPropertyRegistry;
import org.spongepowered.spunbric.mod.FabricScheduler;
import org.spongepowered.spunbric.mod.event.FabricCauseStackManager;
import org.spongepowered.spunbric.mod.registry.FabricGameRegistry;

import javax.annotation.Nullable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.google.common.base.Preconditions.checkState;
import static org.spongepowered.api.Platform.Component.IMPLEMENTATION;

/**
 * The main Singleton of Spunbric.
 *
 * <p><h1>Now some information about the Fabric Context:</h1>
 *
 * <p>Fabric runs on either the Client or Server.
 *
 * <p>Fabric comes included with Mixin 0.8 out of the box with loader version 0.7+
 *
 * <p><h2>Fabric Loader currently does not allow registration of mods after all mods have been loaded. I am working on this so Sponge Plugins can be recognized as mods to the game.
 *
 * <p><h2>Mixins have some limitations...</h2>
 *
 * <p><h3>Mixins cannot be applied to ANY libraries on the classpath. Sorry no Mixins targetting Brigadier or AuthLib, it's going to be a lot of reflection hacks.
 *
 * <p><h3>Fabric Loader is the only mod in which a Mixin CANNOT be applied to. However they do not protect their own packages from the Mixin Class Transformer so beware.
 *
 * <p><h3>All other mods are fair game to target your Mixins to. Yes even Fabric's (Non-Loader) API.
 *
 * <p><h3>Fabric has an Event API. Though it is quite minimal, no priority settings, however it's an invoker, callback system.
 *
 * <p><h3>Fabric has a hook into the CommandManager, and the API hook is a consumer, so you can always recreate command instances which other mods add [Unless they roguely don't use fabric api].
 *
 * <p><h3>Fabric has a Networking API for both the client and server, including registration. However this only covers PLAY level packets for now.
 *
 * <p><h3>Fabric's API has a Dimension API. This also has to battle it out with the normal WorldManager Sponge will have to implement. This will be fun.
 *
 * <p><h3>Fabric changes the server brand. Actually in quite an invasive way where the only way around it is an @Overwrite
 *
 * <p><h3>Fabric has FOUR different possible ways it can load. Two for the Client and Two for the server. In a development environment, Knot is the Launcher type. Otherwise in a real client/server LaunchWrapper is used. FabricLoader abstracts most of this worry away atleast.
 *
 * <p><h3>Particle API anyone?
 *
 * <p><h3>Fabric has a Registry Sync to verify the client has a matching registry to the server.
 *
 * <p><h3>A little Biome Helper
 *
 * <p><h3>Fabric has a resource loader.
 *
 * <p><h3>Fabric has no real fluid API for say, though custom fluids can be registered.
 *
 * <p><h3>Fabric uses the straight to the metal Registries that Vanilla uses. Nothing really complex about that.
 */
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

    @Inject @Nullable private static AbstractFabricGame game;
    @Inject @Nullable private static FabricGameRegistry registry;
    @Inject @Nullable private static FabricDataManager dataManager;
    @Inject @Nullable private static FabricPropertyRegistry propertyRegistry;
    @Inject @Nullable private static FabricScheduler scheduler;
    @Inject @Nullable private static FabricCommandManager commandManager;
    @Inject @Nullable private static FabricCauseStackManager causeStackManager;

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

    public static AbstractFabricGame getGame() {
        return check(game);
    }

    public static MinecraftServer getServer() {
        return (MinecraftServer) Sponge.getServer();
    }

    public static FabricGameRegistry getRegistry() {
        return check(registry);
    }

    public static FabricDataManager getDataManager() {
        return check(dataManager);
    }

    public static FabricPropertyRegistry getPropertyRegistry() {
        return check(propertyRegistry);
    }

    public static FabricScheduler getScheduler() {
        return check(scheduler);
    }

    public static FabricCommandManager getCommandManager() {
        return check(commandManager);
    }

    public static FabricCauseStackManager getCauseStackManager() {
        return check(causeStackManager);
    }

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
    public static FabricConfigSaveManager getConfigSaveManager() {
        if (configSaveManager == null) {
            configSaveManager = new SpongeConfigSaveManager();
        }

        return configSaveManager;
    }

    public static FabricConfig<GlobalConfig> getGlobalConfigAdapter() {
        if (globalConfigAdapter == null) {
            globalConfigAdapter = new SpongeConfig<>(GLOBAL, getSpongeConfigDir().resolve("global.conf"), ECOSYSTEM_ID, null, false);
        }

        return globalConfigAdapter;
    }

    public static FabricConfig<CustomDataConfig> getCustomDataConfigAdapter() {
        if (customDataConfigAdapter == null) {
            customDataConfigAdapter = new SpongeConfig<>(CUSTOM_DATA, getSpongeConfigDir().resolve("custom_data.conf"), ECOSYSTEM_ID, null, true);
        }
        return customDataConfigAdapter;
    }

    public static FabricConfig<TrackerConfig> getTrackerConfigAdapter() {
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

    /**
     * Sets the plugin which represents FabricLoader.
     * @param pluginContainer
     */
    public static void setLoaderPlugin(PluginContainer pluginContainer) {
    }
}
