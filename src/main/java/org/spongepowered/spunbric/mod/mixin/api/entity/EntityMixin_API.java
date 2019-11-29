package org.spongepowered.spunbric.mod.mixin.api.entity;

import net.minecraft.entity.Entity;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.property.Property;
import org.spongepowered.api.data.value.CollectionValue;
import org.spongepowered.api.data.value.MapValue;
import org.spongepowered.api.data.value.MergeFunction;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.entity.EntityArchetype;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.AABB;
import org.spongepowered.api.util.RelativePositions;
import org.spongepowered.api.util.Transform;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.math.vector.Vector3d;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;

@Mixin(Entity.class)
@Implements(@Interface(iface = org.spongepowered.api.entity.Entity.class, prefix = "entity$"))
public abstract class EntityMixin_API implements org.spongepowered.api.entity.Entity {
	@Shadow public long trackedX;

	@Shadow public abstract UUID getUuid();

	@Shadow @Final protected Random random;

	@Override
	public EntityType<?> getType() {
		return null;
	}

	@Override
	public EntitySnapshot createSnapshot() {
		return null; // TODO Impl.
	}

	@Override
	public boolean validateRawData(DataView container) {
		return false;
	}

	@Override
	public void setRawData(DataView container) throws InvalidDataException {

	}

	@Override
	public <E> Optional<E> get(Key<? extends Value<E>> key) {
		return Optional.empty(); // TODO: Keys
	}

	@Override
	public OptionalInt getInt(Key<? extends Value<Integer>> key) {
		return null;
	}

	@Override
	public OptionalDouble getDouble(Key<? extends Value<Double>> key) {
		return null;
	}

	@Override
	public OptionalLong getLong(Key<? extends Value<Long>> key) {
		return null;
	}

	@Override
	public <E, V extends Value<E>> Optional<V> getValue(Key<V> key) {
		return Optional.empty();
	}

	@Override
	public boolean supports(Key<?> key) {
		return false;
	}

	@Override
	public EntityArchetype copy() {
		return null;
	}

	@Override
	public Set<Key<?>> getKeys() {
		return null;
	}

	@Override
	public Set<Value.Immutable<?>> getValues() {
		return null;
	}

	@Override
	public <E> DataTransactionResult offer(Key<? extends Value<E>> key, E value) {
		return null;
	}

	@Override
	public <E> DataTransactionResult offerSingle(Key<? extends CollectionValue<E, ?>> key, E element) {
		return null;
	}

	@Override
	public <K, V> DataTransactionResult offerSingle(Key<? extends MapValue<K, V>> key, K valueKey, V value) {
		return null;
	}

	@Override
	public <K, V> DataTransactionResult offerAll(Key<? extends MapValue<K, V>> key, Map<? extends K, ? extends V> map) {
		return null;
	}

	@Override
	public DataTransactionResult offerAll(MapValue<?, ?> value) {
		return null;
	}

	@Override
	public DataTransactionResult offerAll(CollectionValue<?, ?> value) {
		return null;
	}

	@Override
	public <E> DataTransactionResult offerAll(Key<? extends CollectionValue<E, ?>> key, Collection<? extends E> elements) {
		return null;
	}

	@Override
	public <E> DataTransactionResult removeSingle(Key<? extends CollectionValue<E, ?>> key, E element) {
		return null;
	}

	@Override
	public <K> DataTransactionResult removeKey(Key<? extends MapValue<K, ?>> key, K mapKey) {
		return null;
	}

	@Override
	public DataTransactionResult removeAll(CollectionValue<?, ?> value) {
		return null;
	}

	@Override
	public <E> DataTransactionResult removeAll(Key<? extends CollectionValue<E, ?>> key, Collection<? extends E> elements) {
		return null;
	}

	@Override
	public DataTransactionResult removeAll(MapValue<?, ?> value) {
		return null;
	}

	@Override
	public <K, V> DataTransactionResult removeAll(Key<? extends MapValue<K, V>> key, Map<? extends K, ? extends V> map) {
		return null;
	}

	@Override
	public <E> DataTransactionResult tryOffer(Key<? extends Value<E>> key, E value) {
		return null;
	}

	@Override
	public DataTransactionResult remove(Key<?> key) {
		return null;
	}

	@Override
	public DataTransactionResult undo(DataTransactionResult result) {
		return null;
	}

	@Override
	public DataTransactionResult copyFrom(ValueContainer that, MergeFunction function) {
		return null;
	}

	@Override
	public EntityArchetype createArchetype() {
		return null;
	}

	@Override
	public boolean setLocation(Location location) {
		checkNotNull(location, "Location was null");
		if (isRemoved()) {
			return false;
		}

		// TODO Finish Impl

		return false;
	}

	@Override
	public Vector3d getRotation() {
		return null;
	}

	@Override
	public void setRotation(Vector3d rotation) {

	}

	@Override
	public boolean setLocationAndRotation(Location location, Vector3d rotation) {
		return false;
	}

	@Override
	public boolean setLocationAndRotation(Location location, Vector3d rotation, EnumSet<RelativePositions> relativePositions) {
		return false;
	}

	@Override
	public Vector3d getScale() {
		return Vector3d.ONE;
	}

	@Override
	public void setScale(Vector3d scale) {
		// No proper support for this in Minecraft.
	}

	@Override
	public Transform getTransform() {
		return null;
	}

	@Override
	public boolean setTransform(Transform transform) {
		checkNotNull(transform, "The transform cannot be null!");
		final boolean result = setLocation(Location.of((World) null, transform.getPosition())); // TODO Implement completely
		return false;
	}

	@Override
	public boolean transferToWorld(World world, Vector3d position) {
		checkNotNull(world, "World was null");
		checkNotNull(position, "Position was null");
		return setLocation(Location.of(world, position));
	}

	@Override
	public Optional<AABB> getBoundingBox() {
		return Optional.empty();
	}

	@Override
	public boolean isRemoved() {
		return false;
	}

	@Override
	public boolean isLoaded() {
		return !isRemoved();
	}

	@Override
	public void remove() {
		// TODO Implement completely
	}

	@Override
	public boolean damage(double damage, DamageSource damageSource) {
		return false;
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
	public <V> Optional<V> getProperty(Property<V> property) {
		return Optional.empty();
	}

	@Override
	public Map<Property<?>, ?> getProperties() {
		return null;
	}

	@Override
	public Translation getTranslation() {
		return null;
	}

	@Override
	public UUID getUniqueId() {
		return this.getUuid();
	}

	@Override
	public Random getRandom() {
		return this.random;
	}

	@Override
	public Location getLocation() {
		return null;
	}
}
