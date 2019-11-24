package org.spongepowered.spunbric.mod.entry;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import org.spongepowered.spunbric.launch.FabricLaunch;
import org.spongepowered.spunbric.launch.FabricLaunchPluginManager;
import org.spongepowered.spunbric.launch.LaunchException;

import java.io.IOException;

/**
 * We do this here and load plugins before the game actually initializes. We should not touch Minecraft Context here at all at this stage.
 */
public class SpunbricPreLaunch implements PreLaunchEntrypoint {
    @Override
    public void onPreLaunch() {
        FabricLaunch.getLogger().debug("Searching for plugins...");

        try {
            // Search for plugins (and apply access transformers if available)
            FabricLaunchPluginManager.findPlugins(/*FabricLaunch.isDevelopment()*/ true, false); // TODO Should this be configurable? -- Classloader loading should work.
        } catch (IOException e) {
            throw new LaunchException("Failed to search for plugins", e);
        }
    }
}
