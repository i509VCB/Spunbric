package org.spongepowered.spunbric.mod.entity.player;

import com.mojang.authlib.GameProfile;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.type.HandType;
import org.spongepowered.api.entity.Tamer;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.item.inventory.ArmorEquipable;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.inventory.type.CarriedInventory;

import java.util.Optional;
import java.util.UUID;

public class FabricUser implements ArmorEquipable, Tamer, DataSerializable, Carrier {
	private final User self = (User) this; // For more convient access, also this is legal since User is implemented inside of FabricUserMixin_API
	private final GameProfile profile;

	public FabricUser(final GameProfile profile) {
		this.profile = profile;
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
	public String getName() {
		return this.profile.getName();
	}

	@Override
	public ItemStack getHelmet() {
		return null;
	}

	@Override
	public void setHelmet(ItemStack helmet) {

	}

	@Override
	public ItemStack getChestplate() {
		return null;
	}

	@Override
	public void setChestplate(ItemStack chestplate) {

	}

	@Override
	public ItemStack getLeggings() {
		return null;
	}

	@Override
	public void setLeggings(ItemStack leggings) {

	}

	@Override
	public ItemStack getBoots() {
		return null;
	}

	@Override
	public void setBoots(ItemStack boots) {

	}

	@Override
	public ItemStack getItemInHand(HandType handType) {
		return null;
	}

	@Override
	public void setItemInHand(HandType hand, ItemStack itemInHand) {

	}

	@Override
	public boolean canEquip(EquipmentType type) {
		return false;
	}

	@Override
	public boolean canEquip(EquipmentType type, ItemStack equipment) {
		return false;
	}

	@Override
	public Optional<ItemStack> getEquipped(EquipmentType type) {
		return Optional.empty();
	}

	@Override
	public boolean equip(EquipmentType type, ItemStack equipment) {
		return false;
	}

	@Override
	public CarriedInventory<? extends Carrier> getInventory() {
		return null;
	}

	@Override
	public UUID getUniqueId() {
		return this.profile.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final FabricUser other = (FabricUser) obj;
		return this.profile.getId().equals(other.profile.getId());
	}

	@Override
	public int hashCode() {
		return this.profile.getId().hashCode();
	}
}
