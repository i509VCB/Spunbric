package org.spongepowered.spunbric.mod.data.value.mutable;

import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.spunbric.mod.data.value.AbstractBaseValue;
import org.spongepowered.spunbric.mod.data.value.immutable.ImmutableFabricValue;

import java.util.function.Function;

public class MutableFabricValue<E> extends AbstractBaseValue<E> implements Value.Mutable<E> {

	public MutableFabricValue(Key<? extends Value<E>> key, E defaultValue) {
		super(key, defaultValue, defaultValue);
	}

	public MutableFabricValue(Key<? extends Value<E>> key, E defaultValue, E actualValue) {
		super(key, defaultValue, actualValue);
	}

	@Override
	public Mutable<E> set(E value) {
		this.actualValue = value;
		return this;
	}

	@Override
	public Mutable<E> transform(Function<E, E> function) {
		this.actualValue = function.apply(this.actualValue);
		return this;
	}

	@Override
	public Immutable<E> asImmutable() {
		return new ImmutableFabricValue(this.getKey(), this.defaultValue, this.actualValue); // This really should be cached in the future
		//return ImmutableFabricValue.cachedOf(this.getKey(), this.defaultValue, this.actualValue);
	}

	@Override
	public Mutable<E> copy() {
		return new MutableFabricValue<>(this.getKey(), this.defaultValue, this.actualValue);
	}
}
