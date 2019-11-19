package org.spongepowered.spunbric.mod.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.spongepowered.api.client.Client;
import org.spongepowered.spunbric.mod.AbstractFabricGame;

@Environment(EnvType.CLIENT)
public class ClientFabricGame extends AbstractFabricGame {
    @Override
    public boolean isClientAvailable() {
        return true; // This should always be true
    }

    @Override
    public Client getClient() {
        return null; // TODO Impl.
    }

    @Override
    public boolean isServerAvailable() {
        return false; // TODO When implementing, check the if the client's integrated server is not null.
    }
}
