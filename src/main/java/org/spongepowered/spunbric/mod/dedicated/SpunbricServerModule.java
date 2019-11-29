package org.spongepowered.spunbric.mod.dedicated;

import org.spongepowered.api.server.Server;
import org.spongepowered.spunbric.mod.AbstractFabricGame;
import org.spongepowered.spunbric.mod.entry.AbstractSpunbricMod;
import org.spongepowered.spunbric.mod.inject.AbstractSpunbricModule;

public class SpunbricServerModule extends AbstractSpunbricModule {
    protected void configure() {
        super.configure();

        this.bind(Server.class).toInstance((Server) AbstractSpunbricMod.getMod().getServer());
        this.bind(AbstractFabricGame.class).to(ServerFabricGame.class);
    }
}
