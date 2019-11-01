package org.spongepowered.mod.common;

import com.google.inject.Inject;
import net.fabricmc.loader.api.FabricLoader;
import org.spongepowered.api.Game;
import org.spongepowered.api.GameState;
import org.spongepowered.api.SystemSubject;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.server.Server;

import java.nio.file.Path;

public abstract class FabricCommonGame implements Game {
    protected final FabricLoader fabricLoader = FabricLoader.getInstance();
    private GameState state = GameState.CONSTRUCTION;
    private Server server;

    @Inject
    public FabricCommonGame(Server server) {
        this.server = server;
    }

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
        return this.fabricLoader.getGameDirectory().toPath();
    }

    @Override
    public Server getServer() {
        return this.server;
    }

    @Override
    public SystemSubject getSystemSubject() {
        return null;
    }
}
