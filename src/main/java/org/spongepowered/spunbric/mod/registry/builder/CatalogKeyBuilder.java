package org.spongepowered.spunbric.mod.registry.builder;

import net.minecraft.util.Identifier;
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.spunbric.mod.registry.FabricCatalogKey;

import static com.google.common.base.Preconditions.checkState;

public class CatalogKeyBuilder implements CatalogKey.Builder {
	private String namespace;
	private String value;

	@Override
	public CatalogKey.Builder namespace(String namespace) {
		this.namespace = namespace;
		return this;
	}

	@Override
	public CatalogKey.Builder namespace(PluginContainer container) {
		this.value = container.getId();
		return this;
	}

	@Override
	public CatalogKey.Builder value(String value) {
		this.value = value;
		return this;
	}

	@Override
	public CatalogKey build() throws IllegalStateException {
		checkState(namespace != null, "Namespace cannot be null!");
		checkState(value != null, "Value cannot be null");

		Identifier test = Identifier.tryParse(namespace + ":" + value);

		if(test == null) {

		}

		return new FabricCatalogKey(namespace, value);
	}

	@Override
	public CatalogKey.Builder reset() {
		this.namespace = null;
		this.value = null;
		return this;
	}
}
