package org.spongepowered.spunbric.mod.data.value.mutable;

import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.value.OptionalValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.spunbric.mod.data.value.immutable.ImmutableFabricOptionalValue;

import java.util.Optional;
import java.util.function.Function;

import static com.google.common.base.Preconditions.checkNotNull;

public class MutableFabricOptionalValue<E> extends MutableFabricValue<Optional<E>> implements OptionalValue.Mutable<E> {

	public MutableFabricOptionalValue(Key<? extends Value<Optional<E>>> key) {
		this(key, Optional.<E>empty());
	}

	public MutableFabricOptionalValue(Key<? extends Value<Optional<E>>> key, Optional<E> actualValue) {
		this(key, Optional.<E>empty(), actualValue);
	}

	public MutableFabricOptionalValue(Key<? extends Value<Optional<E>>> key, Optional<E> defaultValue, Optional<E> actualValue) {
		super(key, defaultValue, actualValue);
	}

	@Override
	public Key<? extends OptionalValue<E>> getKey() {
		return (Key<? extends OptionalValue<E>>) this.key;
	}

	@Override
	public OptionalValue.Mutable<E> set(Optional<E> value) {
		this.actualValue = checkNotNull(value);
		return this;
	}

	@Override
	public OptionalValue.Mutable<E> transform(Function<Optional<E>, Optional<E>> function) {
		this.actualValue = checkNotNull(function.apply(this.actualValue));
		return this;
	}

	@Override
	public OptionalValue.Immutable<E> asImmutable() {
		return new ImmutableFabricOptionalValue<>(getKey(), this.actualValue);
	}

	@Override
	public OptionalValue.Mutable<E> copy() {
		return new MutableFabricOptionalValue<>(getKey(), this.actualValue);
	}

	@Override
	public boolean isPresent() {
		return get().isPresent();
	}

	@Override
	public Value.Mutable<E> orElse(E defaultValue) {
		return new MutableFabricValue<>(null, null, get().isPresent() ? get().get() : checkNotNull(defaultValue));
	}
}
