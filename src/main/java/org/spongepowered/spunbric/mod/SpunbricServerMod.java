package org.spongepowered.spunbric.mod;

import net.fabricmc.api.DedicatedServerModInitializer;
import org.spongepowered.spunbric.launch.FabricLaunch;

public class SpunbricServerMod extends AbstractSpunbricMod implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        FabricLaunch.getLogger().info("Started Spunbric on server...");
        handlePlugins();
    }
}
