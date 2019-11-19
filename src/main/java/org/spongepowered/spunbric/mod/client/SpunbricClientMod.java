package org.spongepowered.spunbric.mod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.spongepowered.spunbric.launch.FabricLaunch;
import org.spongepowered.spunbric.mod.AbstractSpunbricMod;

@Environment(EnvType.CLIENT)
public class SpunbricClientMod extends AbstractSpunbricMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Since the server does not immediately load in a client context, we can setup, just no loading the integrated server yet.
        FabricLaunch.getLogger().info("Started Spunbric on client...");
        handlePlugins();
    }
}
