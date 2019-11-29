package org.spongepowered.spunbric.mod.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.spongepowered.spunbric.mod.AbstractFabricGame;
import org.spongepowered.spunbric.mod.entry.AbstractSpunbricMod;
import org.spongepowered.spunbric.mod.inject.AbstractSpunbricModule;

@Environment(EnvType.CLIENT)
public class SpunbricClientModule extends AbstractSpunbricModule {
    protected void configure() {
        super.configure();

        // TODO Figure out where the server goes in this equation.
        this.bind(AbstractFabricGame.class).to(ClientFabricGame.class);
    }
}
