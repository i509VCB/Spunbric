package org.spongepowered.mod.dedicated;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.spongepowered.api.server.Server;
import org.spongepowered.mod.FabricCommonGame;

@Environment(EnvType.SERVER)
@Singleton
public class ServerFabricGame extends FabricCommonGame {
    @Inject
    public ServerFabricGame(Server server) {
        super(server);
    }

    @Override
    public boolean isServerAvailable() {
        return true; // Server is always available on server.
    }
}
