package org.spongepowered.spunbric.mod.asset;

import com.google.inject.Singleton;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.asset.Asset;
import org.spongepowered.api.asset.AssetManager;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.spunbric.SpunbricImpl;

import java.net.URL;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Singleton
public class FabricAssetManager implements AssetManager {
    public static final String DEFAULT_ASSET_DIR = "assets/";
    public static final ClassLoader CLASS_LOADER = Sponge.class.getClassLoader();

    @Override
    public Optional<Asset> getAsset(PluginContainer plugin, String name) {
        checkNotNull(plugin, "plugin instance");
        checkNotNull(name, "name");
        checkArgument(!name.isEmpty(), "name cannot be empty");

        URL url = CLASS_LOADER.getResource(DEFAULT_ASSET_DIR + plugin.getId() + '/' + name);
        if (url == null) {
            return Optional.empty();
        }
        return Optional.of(new FabricAsset(plugin, url));
    }

    @Override
    public Optional<Asset> getAsset(String name) {
        return getAsset(SpunbricImpl.getPlugin(), name);
    }
}
