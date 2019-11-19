package org.spongepowered.spunbric.mod;

import org.spongepowered.api.UnsupportedEngineException;
import org.spongepowered.api.client.Client;

public class ServerFabricGame extends AbstractFabricGame {
    @Override
    public boolean isClientAvailable() {
        return false; // Always false in a dedicated server context.
    }

    @Override
    public Client getClient() {
        throw new UnsupportedEngineException("The client engine is not supported.");
    }

    @Override
    public boolean isServerAvailable() {
        return true; // In a dedicated server context, this will always be true.
    }
}
