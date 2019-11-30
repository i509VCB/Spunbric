package org.spongepowered.spunbric.mod.mixin.api.block;

import net.minecraft.block.BlockState;
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.block.BlockSnapshot;
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

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.function.Function;

@Mixin(BlockState.class)
@Implements(@Interface(iface = org.spongepowered.api.block.BlockState.class, prefix = "sponge$"))
public class BlockStateMixin_API implements org.spongepowered.api.block.BlockState {

	@Override
	public BlockType getType() {
		return null;
	}

	@Override
	public FluidState getFluidState() {
		return null;
	}

	@Override
	public BlockSnapshot snapshotFor(Location location) {
		return null;
	}

	@Override
	public <V> Optional<V> getProperty(Direction direction, Property<V> property) {
		return Optional.empty();
	}

	@Override
	public <T extends Comparable<T>> Optional<T> getStateProperty(StateProperty<T> stateProperty) {
		return Optional.empty();
	}

	@Override
	public Optional<StateProperty<?>> getStatePropertyByName(String name) {
		return Optional.empty();
	}

	@Override
	public <T extends Comparable<T>, V extends T> Optional<org.spongepowered.api.block.BlockState> withStateProperty(StateProperty<T> stateProperty, V value) {
		return Optional.empty();
	}

	@Override
	public <T extends Comparable<T>> Optional<org.spongepowered.api.block.BlockState> cycleStateProperty(StateProperty<T> stateProperty) {
		return Optional.empty();
	}

	@Override
	public <T extends Cycleable<T>> Optional<org.spongepowered.api.block.BlockState> cycleValue(Key<? extends Value<T>> key) {
		return Optional.empty();
	}

	@Override
	public Collection<StateProperty<?>> getStateProperties() {
		return null;
	}

	@Override
	public Collection<?> getStatePropertyValues() {
		return null;
	}

	@Override
	public Map<StateProperty<?>, ?> getStatePropertyMap() {
		return null;
	}

	@Override
	public CatalogKey getKey() {
		return null;
	}

	@Override
	public <E> Optional<org.spongepowered.api.block.BlockState> transform(Key<? extends Value<E>> key, Function<E, E> function) {
		return Optional.empty();
	}

	@Override
	public <E> Optional<org.spongepowered.api.block.BlockState> with(Key<? extends Value<E>> key, E value) {
		return Optional.empty();
	}

	@Override
	public Optional<org.spongepowered.api.block.BlockState> with(Value<?> value) {
		return Optional.empty();
	}

	@Override
	public Optional<org.spongepowered.api.block.BlockState> without(Key<?> key) {
		return Optional.empty();
	}

	@Override
	public org.spongepowered.api.block.BlockState merge(org.spongepowered.api.block.BlockState that, MergeFunction function) {
		return null;
	}

	@Override
	public <E> Optional<E> get(Key<? extends Value<E>> key) {
		return Optional.empty();
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
	public org.spongepowered.api.block.BlockState copy() {
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
}
