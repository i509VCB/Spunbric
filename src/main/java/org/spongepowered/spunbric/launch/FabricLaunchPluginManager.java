package org.spongepowered.spunbric.launch;

import javax.annotation.Nullable;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static com.google.common.base.Preconditions.checkState;

public final class FabricLaunchPluginManager {
    private FabricLaunchPluginManager() {
    }

    @Nullable
    private static Map<String, PluginCandidate> plugins;

    public static void findPlugins(boolean scanClasspath, boolean scanFullClasspath) throws IOException {
        FabricLaunch.getLogger().info("Searching for plugins");

        // Classloader -- For mods which potentially Jar in Jar (JIJ) their sponge plugin with them.
        FabricPluginScanner scanner = new FabricPluginScanner();

        if (scanClasspath || scanFullClasspath) {
            FabricLaunch.getLogger().info("Scanning classpath for plugins...");

            // Two possible contexts:
            // KnotClassLoader in a dev environment
            //
            // LaunchClassLoader in a real game environment
            //

            ClassLoader loader = FabricLaunch.class.getClassLoader();

            // KnotClassLoader's parent is a URLClassLoader, however this does not apply in real environment and real testing is needed.
            // TODO Test this to make sure it actually works in practice.
            if(loader.getParent() != null) {
                FabricLaunch.getLogger().warn(loader.getParent().getClass());
            }

            if (loader.getParent() instanceof URLClassLoader) {
                scanner.scanClassPath((URLClassLoader) loader.getParent(), scanFullClasspath);
            } else {
                FabricLaunch.getLogger().error("Failed to load on classpath");
                FabricLaunch.getLogger().error("Cannot search for plugins on classpath: Unsupported class loader: {}", loader.getParent().getClass());
            }
        }

        // Directory based Plugins
        Path pluginsDir = FabricLaunch.getPluginsDir();
        if (Files.isDirectory(pluginsDir)) {
            scanner.scanDirectory(pluginsDir);
        } else {
            // Create plugin folder
            Files.createDirectories(pluginsDir);
        }

        // Scan additional plugin directory
        pluginsDir = FabricLaunch.getAdditionalPluginsDir();
        if (Files.isDirectory(pluginsDir)) {
            scanner.scanDirectory(pluginsDir);
        }

        plugins = scanner.getPlugins();
        FabricLaunch.getLogger().info("{} plugin(s) found", plugins.size());
    }

    public static Map<String, PluginCandidate> getPlugins() {
        checkState(plugins != null, "Plugin folder was not scanned yet");
        Map<String, PluginCandidate> result = plugins;
        plugins = null;
        return result;
    }
}
