package org.spongepowered.spunbric.mod.entry;

import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.Stage;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.spunbric.SpunbricGuice;
import org.spongepowered.spunbric.SpunbricImpl;
import org.spongepowered.spunbric.launch.FabricLaunch;

import javax.annotation.Nullable;

public abstract class AbstractSpunbricMod {
    private static AbstractSpunbricMod instance;

    protected AbstractSpunbricMod() {
        instance = this;
    }

    public static AbstractSpunbricMod getInstance() {
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
}
