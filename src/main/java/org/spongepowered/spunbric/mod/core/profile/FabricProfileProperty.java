package org.spongepowered.spunbric.mod.core.profile;

import com.mojang.authlib.properties.Property;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.profile.property.ProfileProperty;

import javax.annotation.Nullable;
import java.util.Optional;

public class FabricProfileProperty implements ProfileProperty {
	private final String name;
	private final String value;
	@Nullable
	private final String signature;

	public FabricProfileProperty(final String name, final String value, final @Nullable String signature) {
		this.name = name;
		this.value = value;
		this.signature = signature;
	}

	public static FabricProfileProperty toSponge(Property profileProperty) {
		return new FabricProfileProperty(profileProperty.getName(), profileProperty.getValue(), profileProperty.getSignature());
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public Optional<String> getSignature() {
		return Optional.ofNullable(signature);
	}

	@Override
	public int getContentVersion() {
		return 0;
	}

	@Override
	public DataContainer toContainer() {
		return null;
	}
}
