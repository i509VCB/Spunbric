package org.spongepowered.spunbric.mod.mixin.core.entity;

import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.spunbric.mod.entity.player.FabricUser;

import java.util.Optional;
import java.util.UUID;

/**
 * ArmorEquipable, DataSerializable, Equipable, Carrier are implemented in FabricUser.
 *
 * getName from user is implemented inside of ServerPlayerEntityMixin_API (Grabbing username off the ServerPlayerEntity) and FabricUser's gameprofile impl.
 */
@Mixin(value = FabricUser.class, remap = false)
public abstract class FabricUserMixin_API implements User {
	@Override
	public GameProfile getProfile() {
		return null;
	}

	@Override
	public boolean isOnline() {
		return this.getPlayer().isPresent();
	}

	@Override
	public Optional<Player> getPlayer() {
		return Optional.empty();
	}

	@Override
	public boolean validateRawData(final DataView container) {
		return false;
	}

	@Override
	public void setRawData(final DataView container) throws InvalidDataException {

	}

	@Override
	public Vector3d getPosition() {
		return null;
	}

	@Override
	public Optional<UUID> getWorldUniqueId() {
		return Optional.empty();
	}

	@Override
	public boolean setLocation(final Vector3d position, final UUID world) {
		return false;
	}

	@Override
	public Vector3d getRotation() {
		return null;
	}

	@Override
	public void setRotation(final Vector3d rotation) {

	}

	@Override
	public Inventory getEnderChestInventory() {
		return null;
	}


	@Override
	public String getIdentifier() {
		return null;
	}
}
