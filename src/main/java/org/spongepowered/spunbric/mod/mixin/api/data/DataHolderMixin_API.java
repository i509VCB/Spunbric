package org.spongepowered.spunbric.mod.mixin.api.data;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.property.Property;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;

@Mixin(value = {BlockEntity.class, Entity.class, ItemStack.class/*, SpongeUser.class*/}, priority = 899)
public abstract class DataHolderMixin_API implements DataHolder {
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
	public ValueContainer copy() {
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
}
