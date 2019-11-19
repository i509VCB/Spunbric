package org.spongepowered.spunbric.mod;

import org.spongepowered.api.Game;
import org.spongepowered.api.GameState;
import org.spongepowered.api.SystemSubject;
import org.spongepowered.api.client.Client;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.server.Server;
import org.spongepowered.spunbric.launch.FabricLaunch;

import java.nio.file.Path;

public abstract class AbstractFabricGame implements Game {
    /*
     *  Fabric can have client instances of the game.
     *  The three abstract method should be overwritten accordingly.
     */
    @Override
    public abstract boolean isClientAvailable();

    @Override
    public abstract Client getClient();

    @Override
    public abstract boolean isServerAvailable();

    @Override
    public GameState getState() {
        return null;
    }

    @Override
    public Scheduler getAsyncScheduler() {
        return null;
    }

    public Path getGameDirectory() {
        return FabricLaunch.getGameDir();
    }

    @Override
    public Server getServer() {
        return null;
    }

    @Override
    public SystemSubject getSystemSubject() {
        return null;
    }
}
