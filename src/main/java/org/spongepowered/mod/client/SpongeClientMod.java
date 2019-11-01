package org.spongepowered.mod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SpongeClientMod implements ClientModInitializer {
    public SpongeClientMod() {
        System.out.println("[Spunbric] IntegratedServer not supported yet");
    }

    @Override
    public void onInitializeClient() {
    }
}
