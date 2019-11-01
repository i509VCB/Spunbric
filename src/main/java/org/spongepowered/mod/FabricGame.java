package org.spongepowered.mod;

import org.spongepowered.api.Game;
import org.spongepowered.api.GameState;
import org.spongepowered.api.SystemSubject;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.server.Server;

import java.nio.file.Path;

public class FabricGame implements Game {
    @Override
    public GameState getState() {
        return null;
    }

    @Override
    public Scheduler getAsyncScheduler() {
        return null;
    }

    @Override
    public Path getGameDirectory() {
        return null;
    }

    @Override
    public boolean isServerAvailable() {
        return false;
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
