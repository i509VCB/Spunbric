package org.spongepowered.spunbric.mod.entry;

import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.Stage;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.spunbric.SpunbricGuice;
import org.spongepowered.spunbric.SpunbricImpl;
import org.spongepowered.spunbric.launch.FabricLaunch;

import javax.annotation.Nullable;
import java.util.Optional;

public abstract class AbstractSpunbricMod implements PluginContainer {
    private static AbstractSpunbricMod instance;

    protected AbstractSpunbricMod() {
        instance = this;
    }

    public static AbstractSpunbricMod getMod() {
        return instance;
    }

    protected void prepare() {
        final Stage stage = SpunbricGuice.getInjectorStage(FabricLaunch.isDevelopment() ? Stage.DEVELOPMENT : Stage.PRODUCTION);
        SpunbricImpl.getLogger().debug("Creating injector in stage '{}'", stage);

        Guice.createInjector(stage, getModule());
    }

    protected abstract Module getModule();

    @Nullable
    /**
     * Depending on the environment, the server may be null when accessed such as on a Client.
     */
    public abstract MinecraftServer getServer();

    // Plugin Container stuff

    @Override
    public String getId() {
        return "spunbric";
    }

    public Optional<String> getVersion() {
        return Optional.of(
                FabricLoader
                        .getInstance()
                        .getModContainer("spunbric")
                        .get()
                        .getMetadata()
                        .getVersion()
                        .getFriendlyString()
        );
    }
}
