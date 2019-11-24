package org.spongepowered.spunbric.mod.dedicated;

import org.spongepowered.spunbric.mod.AbstractFabricGame;
import org.spongepowered.spunbric.mod.inject.AbstractSpunbricModule;

public class SpunbricServerModule extends AbstractSpunbricModule {
    protected void configure() {
        super.configure();

        this.bind(AbstractFabricGame.class).to(ServerFabricGame.class);
    }
}
