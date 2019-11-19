package org.spongepowered.spunbric.mod;

import org.spongepowered.spunbric.launch.FabricLaunch;
import org.spongepowered.spunbric.launch.FabricLaunchPluginManager;
import org.spongepowered.spunbric.launch.LaunchException;

import java.io.IOException;

public abstract class AbstractSpunbricMod {
    public void handlePlugins() {
        FabricLaunch.getLogger().debug("Searching for plugins...");

        try {
            // Search for plugins (and apply access transformers if available)
            FabricLaunchPluginManager.findPlugins(/*FabricLaunch.isDevelopment()*/ true, false); // TODO Should this be configurable? -- Classloader loading should work.
        } catch (IOException e) {
            throw new LaunchException("Failed to search for plugins", e);
        }
    }
}
