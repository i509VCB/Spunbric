package org.spongepowered.mod.client;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.api.server.Server;
import org.spongepowered.mod.FabricCommonGame;

@Environment(EnvType.CLIENT)
@Singleton
public class ClientFabricGame extends FabricCommonGame {
    @Inject
    public ClientFabricGame(Server server) {
        super(server);
    }

    @Override
    public boolean isServerAvailable() {
        if(FabricLoader.getInstance().getEnvironmentType()== EnvType.SERVER) { // You can't assume everything is dandy.
            throw new IllegalStateException("The client game shouldn't be running on a logical server");
        }

        MinecraftClient client = (MinecraftClient) FabricLoader.getInstance().getGameInstance(); // Fabric always guarantees this will return the logical client, if the Client Platform is being ran.

        if(client.getServer() != null) { // If the IntegratedServer is not null, then the client's IntegratedServer is available.
            return true;
        }

        return false;
    }
}
