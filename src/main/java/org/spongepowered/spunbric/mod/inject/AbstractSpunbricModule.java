package org.spongepowered.spunbric.mod.inject;

import com.google.inject.PrivateModule;
import com.google.inject.binder.AnnotatedBindingBuilder;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.*;
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
import org.spongepowered.api.server.Server;
import org.spongepowered.api.service.ServiceManager;
import org.spongepowered.api.util.metric.MetricsConfigManager;
import org.spongepowered.api.world.TeleportHelper;
import org.spongepowered.spunbric.SpunbricBootstrap;
import org.spongepowered.spunbric.SpunbricImpl;
import org.spongepowered.spunbric.mod.*;
import org.spongepowered.spunbric.mod.entry.AbstractSpunbricMod;
import org.spongepowered.spunbric.mod.event.FabricEventManager;
import org.spongepowered.spunbric.plugin.FabricPluginManager;

public class AbstractSpunbricModule extends PrivateModule {
    @Override
    protected void configure() {
        this.bindAndExpose(Game.class).to(AbstractFabricGame.class);
        this.bindAndExpose(MinecraftVersion.class).toInstance(SpunbricImpl.MINECRAFT_VERSION);

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

        this.bindAndExpose(Platform.class).to(FabricPlatform.class);
        this.bindAndExpose(PluginManager.class).to(FabricPluginManager.class);
        this.bindAndExpose(EventManager.class).to(FabricEventManager.class);
        this.bindAndExpose(ChannelRegistrar.class).to(FabricChannelRegistrar.class);

        this.bind(AbstractSpunbricMod.class).toInstance(AbstractSpunbricMod.getMod());
        //this.bind(MetadataContainer.class).toInstance(this.metadata);

        this.bind(Logger.class).toInstance(SpunbricImpl.getLogger());
        this.bind(org.slf4j.Logger.class).toInstance(LoggerFactory.getLogger(SpunbricImpl.getLogger().getName()));


        this.requestStaticInjection(SpunbricImpl.class);
        this.requestStaticInjection(Sponge.class);
        this.requestStaticInjection(SpunbricBootstrap.class);
        this.requestInjection(AbstractSpunbricMod.getMod());
    }

    protected <T> AnnotatedBindingBuilder<T> bindAndExpose(final Class<T> type) {
        this.expose(type);
        return this.bind(type);
    }

}
