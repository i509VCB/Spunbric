package org.spongepowered.spunbric.mod.mixin.api.block;

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.property.Property;
import org.spongepowered.api.data.value.MergeFunction;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.state.StateProperty;
import org.spongepowered.api.util.Cycleable;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;

import java.util.*;
import java.util.function.Function;

@Mixin(BlockState.class)
@Implements(@Interface(iface = org.spongepowered.api.block.BlockState.class, prefix = "sponge$"))
public class BlockStateMixin_API {

	public BlockType sponge$getType() {
		return null;
	}

	public FluidState sponge$getFluidState() {
		return null;
	}

	public BlockSnapshot sponge$snapshotFor(Location location) {
		return null;
	}

	public <V> Optional<V> sponge$getProperty(Direction direction, Property<V> property) {
		return Optional.empty();
	}

	public <T extends Comparable<T>> Optional<T> sponge$getStateProperty(StateProperty<T> stateProperty) {
		return Optional.empty();
	}

	public Optional<StateProperty<?>> sponge$getStatePropertyByName(String name) {
		return Optional.empty();
	}

	public <T extends Comparable<T>, V extends T> Optional<BlockState> sponge$withStateProperty(StateProperty<T> stateProperty, V value) {
		return Optional.empty();
	}

	public <T extends Comparable<T>> Optional<BlockState> sponge$cycleStateProperty(StateProperty<T> stateProperty) {
		return Optional.empty();
	}

	public <T extends Cycleable<T>> Optional<BlockState> sponge$cycleValue(Key<? extends Value<T>> key) {
		return Optional.empty();
	}

	public Collection<StateProperty<?>> sponge$getStateProperties() {
		return null;
	}

	public Collection<?> sponge$getStatePropertyValues() {
		return null;
	}

	public Map<StateProperty<?>, ?> sponge$getStatePropertyMap() {
		return null;
	}

	public CatalogKey sponge$getKey() {
		return null;
	}

	public <E> Optional<BlockState> sponge$transform(Key<? extends Value<E>> key, Function<E, E> function) {
		return Optional.empty();
	}

	public <E> Optional<BlockState> sponge$with(Key<? extends Value<E>> key, E value) {
		return Optional.empty();
	}

	public Optional<BlockState> sponge$with(Value<?> value) {
		return Optional.empty();
	}

	public Optional<BlockState> sponge$without(Key<?> key) {
		return Optional.empty();
	}

	public BlockState sponge$merge(BlockState that, MergeFunction function) { //will work, MCDev doesn't like synthetic members from generics
		return null;
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

	public BlockState sponge$copy() { //will work, MCDev doesn't like synthetic members from generics
		return null;
	}

	public Set<Key<?>> sponge$getKeys() {
		return null;
	}

	public Set<Value.Immutable<?>> sponge$getValues() {
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
}
