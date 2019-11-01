package org.spongepowered.mod.dedicated;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.SERVER)
public class SpongeServerMod implements DedicatedServerModInitializer {
    public SpongeServerMod() {
    }

    @Override
    public void onInitializeServer() {

    }
}
