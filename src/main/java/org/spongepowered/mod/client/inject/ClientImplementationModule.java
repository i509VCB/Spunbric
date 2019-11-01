package org.spongepowered.mod.client.inject;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import org.spongepowered.api.server.Server;
import org.spongepowered.mod.common.FabricCommonGame;
import org.spongepowered.mod.client.ClientFabricGame;
import org.spongepowered.mod.inject.FabricImplementationModule;

@Environment(EnvType.CLIENT)
public class ClientImplementationModule extends FabricImplementationModule {
    private final MinecraftServer server;
    private final MetadataContainer metadata;

    public ClientImplementationModule(MinecraftServer server, MetadataContainer metadata) {
        this.server = server;
        this.metadata = metadata;
    }

    @Override
    @SuppressWarnings("UnnecessaryStaticInjection") // we're injecting into mixins >:)
    protected void configure() {
        super.configure();
        this.bind(FabricCommonGame.class).to(ClientFabricGame.class);
        this.bind(Server.class).toInstance((Server) this.server);
        this.requestStaticInjection(IntegratedServer.class);
    }
}
