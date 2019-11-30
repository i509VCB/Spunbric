package org.spongepowered.spunbric.mod.data.value.immutable;

import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.value.OptionalValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.spunbric.mod.data.value.mutable.MutableFabricOptionalValue;

import java.util.Optional;
import java.util.function.Function;

import static com.google.common.base.Preconditions.checkNotNull;

public class ImmutableFabricOptionalValue<E> extends ImmutableFabricValue<Optional<E>> implements OptionalValue.Immutable<E> {

	public ImmutableFabricOptionalValue(Key<? extends Value<Optional<E>>> key) {
		super(key, Optional.<E>empty());
	}

	public ImmutableFabricOptionalValue(Key<? extends Value<Optional<E>>> key, Optional<E> actualValue) {
		super(key, Optional.<E>empty(), actualValue);
	}

	@Override
	public Key<? extends OptionalValue<E>> getKey() {
		return (Key<? extends OptionalValue<E>>) this.key;
	}

	@Override
	public OptionalValue.Immutable<E> transform(Function<Optional<E>, Optional<E>> function) {
		return new ImmutableFabricOptionalValue<>(getKey(), checkNotNull(function.apply(get())));
	}

	@Override
	public OptionalValue.Mutable<E> asMutable() {
		return new MutableFabricOptionalValue<>(getKey(), this.actualValue);
	}

	@Override
	public OptionalValue.Immutable<E> with(Optional<E> value) {
		return new ImmutableFabricOptionalValue<>(getKey(), checkNotNull(value));
	}

	@Override
	public boolean isPresent() {
		return get().isPresent();
	}

	@Override
	public Value.Immutable<E> orElse(E defaultValue) {
		return new ImmutableFabricValue<>(null, get().isPresent() ? get().get() : checkNotNull(defaultValue));
	}
}
