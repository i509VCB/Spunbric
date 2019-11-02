package org.spongepowered.mod.inject;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import com.google.inject.PrivateModule;
import com.google.inject.binder.AnnotatedBindingBuilder;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.Game;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.MinecraftVersion;
import org.spongepowered.api.Platform;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.asset.AssetManager;
import org.spongepowered.api.command.manager.CommandManager;
import org.spongepowered.api.config.ConfigManager;
import org.spongepowered.api.data.DataManager;
import org.spongepowered.api.data.property.PropertyRegistry;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.network.ChannelRegistrar;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.service.ServiceManager;
import org.spongepowered.api.util.metric.MetricsConfigManager;
import org.spongepowered.api.world.TeleportHelper;
import org.spongepowered.mod.FabricAssetManager;
import org.spongepowered.mod.FabricBootstrap;
import org.spongepowered.mod.config.FabricConfigManager;
import org.spongepowered.mod.FabricMetricsConfigManager;
import org.spongepowered.mod.FabricPropertyRegistry;
import org.spongepowered.mod.FabricServiceManager;
import org.spongepowered.mod.FabricTeleportHelper;
import org.spongepowered.mod.SpongeImpl;
import org.spongepowered.mod.command.FabricCommandManager;
import org.spongepowered.mod.common.FabricCommonGame;
import org.spongepowered.mod.data.FabricDataManager;
import org.spongepowered.mod.event.FabricCauseStackManager;
import org.spongepowered.mod.registry.FabricGameRegistry;
import org.spongepowered.mod.scheduler.FabricScheduler;

public class FabricImplementationModule extends PrivateModule {
    @Override
    @OverridingMethodsMustInvokeSuper
    protected void configure() {
        //noinspection UninstantiableBinding
        this.bindAndExpose(Game.class).to(FabricCommonGame.class); // Both Client and Server will overwrite this entry during their own startups.
        this.bindAndExpose(MinecraftVersion.class).toInstance(SpongeImpl.MINECRAFT_VERSION);
        this.bindAndExpose(ServiceManager.class).to(FabricServiceManager.class);
        this.bindAndExpose(AssetManager.class).to(FabricAssetManager.class);
        this.bindAndExpose(GameRegistry.class).to(FabricGameRegistry.class);
        this.bindAndExpose(TeleportHelper.class).to(FabricTeleportHelper.class);
        this.bindAndExpose(Scheduler.class).to(FabricScheduler.class);
        this.bindAndExpose(CommandManager.class).to(FabricCommandManager.class);
        this.bindAndExpose(DataManager.class).to(FabricDataManager.class);
        this.bindAndExpose(ConfigManager.class).to(FabricConfigManager.class);
        this.bindAndExpose(PropertyRegistry.class).to(FabricPropertyRegistry.class);
        this.bindAndExpose(CauseStackManager.class).to(FabricCauseStackManager.class);
        this.bindAndExpose(MetricsConfigManager.class).to(FabricMetricsConfigManager.class);

        // These are bound in implementation-specific modules
        this.expose(Platform.class);
        this.expose(PluginManager.class);
        this.expose(EventManager.class);
        this.expose(ChannelRegistrar.class);

        this.bind(Logger.class).toInstance(SpongeImpl.getLogger());
        this.bind(org.slf4j.Logger.class).toInstance(LoggerFactory.getLogger(SpongeImpl.getLogger().getName()));

        this.requestStaticInjection(SpongeImpl.class);
        this.requestStaticInjection(Sponge.class);
        this.requestStaticInjection(FabricBootstrap.class);
    }

    protected <T> AnnotatedBindingBuilder<T> bindAndExpose(final Class<T> type) {
        this.expose(type);
        return this.bind(type);
    }
}
