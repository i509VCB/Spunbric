package org.spongepowered.spunbric.launch;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.spunbric.SpunbricImpl;

import java.nio.file.Path;

public class FabricLaunch {
    private static final Logger logger = LogManager.getLogger(SpunbricImpl.ECOSYSTEM_NAME);
    private static final FabricLoader FABRIC_LOADER = FabricLoader.getInstance();

    public static Logger getLogger() {
        return logger;
    }

    public static boolean isDevelopment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    public static EnvType getEnvironmentType() {
        return FABRIC_LOADER.getEnvironmentType();
    }

    public static Path getPluginsDir() {
        return getGameDir().resolve("plugins"); // TODO
    }

    public static Path getAdditionalPluginsDir() {
        return getGameDir().resolve("plugins_other"); // TODO
    }

    public static Path getPluginConfigDir() {
        return getGameDir().resolve("config").resolve("plugins"); // TODO
    }

    public static Path getGameDir() {
        return FABRIC_LOADER.getGameDirectory().toPath();
    }

    public static Path getSpongeConfigDir() {
        return getGameDir().resolve("config").resolve("sponge"); //TODO
    }
}
