package org.spongepowered.spunbric.mod.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.spongepowered.spunbric.mod.AbstractFabricGame;
import org.spongepowered.spunbric.mod.inject.AbstractSpunbricModule;

@Environment(EnvType.CLIENT)
public class SpunbricClientModule extends AbstractSpunbricModule {
    protected void configure() {
        super.configure();

        this.bind(AbstractFabricGame.class).to(ClientFabricGame.class);
    }
}
