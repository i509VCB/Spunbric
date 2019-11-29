package org.spongepowered.spunbric.mod.mixin.api.entity.player;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.property.Property;
import org.spongepowered.api.data.type.HandType;
import org.spongepowered.api.data.value.*;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.inventory.type.CarriedInventory;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.permission.SubjectCollection;
import org.spongepowered.api.service.permission.SubjectData;
import org.spongepowered.api.service.permission.SubjectReference;
import org.spongepowered.api.util.Tristate;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.spunbric.mod.mixin.api.entity.living.LivingEntityMixin_API;

import java.util.*;

@Mixin(PlayerEntity.class)
@Implements(@Interface(iface = User.class, prefix = "sponge$")) //TODO: do we just want User on PlayerEntity or should it be Player?
public abstract class PlayerEntityMixin_API extends LivingEntity {
	protected PlayerEntityMixin_API(EntityType<? extends LivingEntity> type, World world) {
		super(type, world);
	}

	@Shadow public abstract Text getName();

	public GameProfile sponge$getProfile() {
		return null;
	}

	public String sponge$getName() {
		return getName().asString();
	}

	public boolean sponge$isOnline() {
		return false;
	}

	public Optional<Player> sponge$getPlayer() {
		return Optional.empty();
	}

	public Vector3d sponge$getPosition() {
		Vec3d mcPos = this.getPos();
		return new Vector3d(mcPos.getX(), mcPos.getY(), mcPos.getZ());
	}

	public Optional<UUID> sponge$getWorldUniqueId() {
		return Optional.empty();
	}

	public boolean sponge$setLocation(Vector3d position, UUID world) {
		return false;
	}

	public void sponge$setRotation(Vector3d rotation) {
	}

	public Vector3d sponge$getRotation() {
		return null;
	}

	public Inventory sponge$getEnderChestInventory() {
		return null;
	}

	public boolean sponge$validateRawData(DataView container) {
		return false;
	}

	public void sponge$setRawData(DataView container) throws InvalidDataException {

	}

	public <E> Optional<E> sponge$get(Key<? extends Value<E>> key) {
		return Optional.empty();
	}

	public OptionalInt sponge$getInt(Key<? extends Value<Integer>> key) {
		return null;
	}

	public OptionalDouble sponge$getDouble(Key<? extends Value<Double>> key) {
		return null;
	}

	public OptionalLong sponge$getLong(Key<? extends Value<Long>> key) {
		return null;
	}

	public <E, V extends Value<E>> Optional<V> sponge$getValue(Key<V> key) {
		return Optional.empty();
	}

	public boolean sponge$supports(Key<?> key) {
		return false;
	}

	public ValueContainer sponge$copy() {
		return null;
	}

	public Set<Key<?>> sponge$getKeys() {
		return null;
	}

	public Set<Value.Immutable<?>> sponge$getValues() {
		return null;
	}

	public <E> DataTransactionResult sponge$offer(Key<? extends Value<E>> key, E value) {
		return null;
	}

	public <E> DataTransactionResult sponge$offerSingle(Key<? extends CollectionValue<E, ?>> key, E element) {
		return null;
	}

	public <K, V> DataTransactionResult sponge$offerSingle(Key<? extends MapValue<K, V>> key, K valueKey, V value) {
		return null;
	}

	public <K, V> DataTransactionResult sponge$offerAll(Key<? extends MapValue<K, V>> key, Map<? extends K, ? extends V> map) {
		return null;
	}

	public DataTransactionResult sponge$offerAll(MapValue<?, ?> value) {
		return null;
	}

	public DataTransactionResult sponge$offerAll(CollectionValue<?, ?> value) {
		return null;
	}

	public <E> DataTransactionResult sponge$offerAll(Key<? extends CollectionValue<E, ?>> key, Collection<? extends E> elements) {
		return null;
	}

	public <E> DataTransactionResult sponge$removeSingle(Key<? extends CollectionValue<E, ?>> key, E element) {
		return null;
	}

	public <K> DataTransactionResult sponge$removeKey(Key<? extends MapValue<K, ?>> key, K mapKey) {
		return null;
	}

	public DataTransactionResult sponge$removeAll(CollectionValue<?, ?> value) {
		return null;
	}

	public <E> DataTransactionResult sponge$removeAll(Key<? extends CollectionValue<E, ?>> key, Collection<? extends E> elements) {
		return null;
	}

	public DataTransactionResult sponge$removeAll(MapValue<?, ?> value) {
		return null;
	}

	public <K, V> DataTransactionResult sponge$removeAll(Key<? extends MapValue<K, V>> key, Map<? extends K, ? extends V> map) {
		return null;
	}

	public <E> DataTransactionResult sponge$tryOffer(Key<? extends Value<E>> key, E value) {
		return null;
	}

	public DataTransactionResult sponge$remove(Key<?> key) {
		return null;
	}

	public DataTransactionResult sponge$undo(DataTransactionResult result) {
		return null;
	}

	public DataTransactionResult sponge$copyFrom(ValueContainer that, MergeFunction function) {
		return null;
	}

	public int sponge$getContentVersion() {
		return 0;
	}

	public DataContainer sponge$toContainer() {
		return null;
	}

	public <V> Optional<V> sponge$getProperty(Property<V> property) {
		return Optional.empty();
	}

	public Map<Property<?>, ?> sponge$getProperties() {
		return null;
	}

	public ItemStack sponge$getHelmet() {
		return null;
	}

	public void sponge$setHelmet(ItemStack helmet) {

	}

	public ItemStack sponge$getChestplate() {
		return null;
	}

	public void sponge$setChestplate(ItemStack chestplate) {

	}

	public ItemStack sponge$getLeggings() {
		return null;
	}

	public void sponge$setLeggings(ItemStack leggings) {

	}

	public ItemStack sponge$getBoots() {
		return null;
	}

	public void sponge$setBoots(ItemStack boots) {

	}

	public ItemStack sponge$getItemInHand(HandType handType) {
		return null;
	}

	public void sponge$setItemInHand(HandType hand, ItemStack itemInHand) {

	}

	public boolean sponge$canEquip(EquipmentType type) {
		return false;
	}

	public boolean sponge$canEquip(EquipmentType type, ItemStack equipment) {
		return false;
	}

	public Optional<ItemStack> sponge$getEquipped(EquipmentType type) {
		return Optional.empty();
	}

	public boolean sponge$equip(EquipmentType type, ItemStack equipment) {
		return false;
	}

	public CarriedInventory<? extends Carrier> sponge$getInventory() {
		return null;
	}

	public SubjectCollection sponge$getContainingCollection() {
		return null;
	}

	public SubjectReference sponge$asSubjectReference() {
		return null;
	}

	public boolean sponge$isSubjectDataPersisted() {
		return false;
	}

	public SubjectData sponge$getSubjectData() {
		return null;
	}

	public SubjectData sponge$getTransientSubjectData() {
		return null;
	}

	public Tristate sponge$getPermissionValue(Set<Context> contexts, String permission) {
		return null;
	}

	public boolean sponge$isChildOf(Set<Context> contexts, SubjectReference parent) {
		return false;
	}

	public List<SubjectReference> sponge$getParents(Set<Context> contexts) {
		return null;
	}

	public Optional<String> sponge$getOption(Set<Context> contexts, String key) {
		return Optional.empty();
	}

	public String sponge$getIdentifier() {
		return null;
	}

	public Set<Context> sponge$getActiveContexts() {
		return null;
	}

	public UUID sponge$getUniqueId() {
		return null;
	}
}
