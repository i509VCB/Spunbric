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
@Implements(@Interface(iface = org.spongepowered.api.entity.Entity.class, prefix = "sponge$"))
public abstract class EntityMixin_API {
	@Shadow public long trackedX;

	@Shadow public abstract UUID getUuid();

	@Shadow @Final protected Random random;

	@Shadow public abstract void remove();

	public EntityType<?> sponge$getType() {
		return this.sponge$getType();//TODO: Impl.
	}

	public EntitySnapshot sponge$createSnapshot() {
		return null; // TODO Impl.
	}

	public boolean sponge$validateRawData(DataView container) {
		return false; //TODO: Impl.
	}

	public void sponge$setRawData(DataView container) throws InvalidDataException {

	}

	public <E> Optional<E> sponge$get(Key<? extends Value<E>> key) {
		return Optional.empty(); // TODO: Keys
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

	public EntityArchetype sponge$copy() {
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

	public EntityArchetype sponge$createArchetype() {
		return null;
	}

	public boolean sponge$setLocation(Location location) {
		checkNotNull(location, "Location was null");
		if (sponge$isRemoved()) {
			return false;
		}

		// TODO Finish Impl

		return false;
	}

	public Vector3d sponge$getRotation() {
		return null;
	}

	public void sponge$setRotation(Vector3d rotation) {

	}

	public boolean sponge$setLocationAndRotation(Location location, Vector3d rotation) {
		return false;
	}

	public boolean sponge$setLocationAndRotation(Location location, Vector3d rotation, EnumSet<RelativePositions> relativePositions) {
		return false;
	}
	
	public Vector3d sponge$getScale() {
		return Vector3d.ONE;
	}

	public void sponge$setScale(Vector3d scale) {
		// No proper support for this in Minecraft.
	}

	public Transform sponge$getTransform() {
		return null;
	}

	public boolean sponge$setTransform(Transform transform) {
		checkNotNull(transform, "The transform cannot be null!");
		final boolean result = sponge$setLocation(Location.of((World) null, transform.getPosition())); // TODO Implement completely
		return false;
	}

	public boolean sponge$transferToWorld(World world, Vector3d position) {
		checkNotNull(world, "World was null");
		checkNotNull(position, "Position was null");
		return sponge$setLocation(Location.of(world, position));
	}

	public Optional<AABB> sponge$getBoundingBox() {
		return Optional.empty();
	}

	public boolean sponge$isRemoved() {
		return false;
	}

	public boolean sponge$isLoaded() {
		return !sponge$isRemoved();
	}

	public void sponge$remove() {
		this.remove();
	}

	public boolean sponge$damage(double damage, DamageSource damageSource) {
		return false;
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

	public Translation sponge$getTranslation() {
		return null;
	}

	public UUID sponge$getUniqueId() {
		return this.getUuid();
	}

	public Random sponge$getRandom() {
		return this.random;
	}

	public Location sponge$getLocation() {
		return null;
	}
}
