package org.spongepowered.spunbric.mod.core.profile;

import com.google.common.collect.Multimap;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.profile.property.ProfileProperty;
import org.spongepowered.spunbric.mod.helper.authlib.GameProfileHelper;

import java.util.Optional;
import java.util.UUID;

public class FabricGameProfile implements GameProfile {
	private final com.mojang.authlib.GameProfile profile;

	public FabricGameProfile(com.mojang.authlib.GameProfile mojangProfile) {
		this.profile = mojangProfile;
	}

	@Override
	public Optional<String> getName() {
		return Optional.ofNullable(profile.getName());
	}

	@Override
	public Multimap<String, ProfileProperty> getPropertyMap() {
		return GameProfileHelper.adapt(profile.getProperties());
	}

	@Override
	public boolean isFilled() {
		return profile.isComplete();
	}

	@Override
	public int getContentVersion() {
		return 0;
	}

	@Override
	public DataContainer toContainer() {
		return null;
	}

	@Override
	public UUID getUniqueId() {
		return profile.getId();
	}
}
