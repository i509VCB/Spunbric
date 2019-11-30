package org.spongepowered.spunbric.mod.asset;

import org.spongepowered.api.asset.Asset;
import org.spongepowered.api.plugin.PluginContainer;

import java.net.URL;

public class FabricAsset implements Asset {

	private final PluginContainer plugin;
	private final URL url;

	public FabricAsset(PluginContainer plugin, URL url) {
		this.plugin = plugin;
		this.url = url;
	}

	@Override
	public PluginContainer getOwner() {
		return this.plugin;
	}

	@Override
	public URL getUrl() {
		return this.url;
	}
}
