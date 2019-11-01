package org.spongepowered.mod.dedicated.inject;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.MinecraftDedicatedServer;
import org.spongepowered.api.server.Server;
import org.spongepowered.mod.common.FabricCommonGame;
import org.spongepowered.mod.client.ClientFabricGame;
import org.spongepowered.mod.inject.FabricImplementationModule;

@Environment(EnvType.SERVER)
public class ServerImplementationModule extends FabricImplementationModule {
    private final MinecraftServer server;
    private final MetadataContainer metadata;

    public ServerImplementationModule(MinecraftServer server, MetadataContainer metadata) {
        this.server = server;
        this.metadata = metadata;
    }

    @Override
    @SuppressWarnings("UnnecessaryStaticInjection") // we're injecting into mixins >:)
    protected void configure() {
        super.configure();

        this.bind(FabricCommonGame.class).to(ClientFabricGame.class);
        this.bind(Server.class).toInstance((Server) this.server);
        this.requestStaticInjection(MinecraftDedicatedServer.class);
    }
}
