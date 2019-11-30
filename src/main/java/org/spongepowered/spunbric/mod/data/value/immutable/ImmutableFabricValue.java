package org.spongepowered.spunbric.mod.data.value.immutable;

import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.spunbric.mod.data.ImmutableDataCachingUtil;
import org.spongepowered.spunbric.mod.data.value.AbstractBaseValue;
import org.spongepowered.spunbric.mod.data.value.mutable.MutableFabricValue;

import java.util.function.Function;

import static com.google.common.base.Preconditions.checkNotNull;

public class ImmutableFabricValue<E> extends AbstractBaseValue<E> implements Value.Immutable<E> {
	public ImmutableFabricValue(Key<? extends Value<E>> key, E defaultValue) {
		super(key, defaultValue, defaultValue);
	}

	public ImmutableFabricValue(Key<? extends Value<E>> key, E defaultValue, E actualValue) {
		super(key, defaultValue, actualValue);
	}

	public static <E> Immutable<E> cachedOf(Key<? extends Value<E>> key, E defaultValue, E actualValue) {
		return ImmutableDataCachingUtil.getValue(ImmutableFabricValue.class, key, defaultValue, actualValue);
	}

	@Override
	public Immutable<E> with(E value) {
		return new ImmutableFabricValue<>(this.getKey(), this.defaultValue, value);
	}

	@Override
	public Immutable<E> transform(Function<E, E> function) {
		final E value = checkNotNull(function).apply(get());
		return new ImmutableFabricValue<>(this.getKey(), this.defaultValue, value);
	}

	@Override
	public Mutable<E> asMutable() {
		return new MutableFabricValue<>(getKey(), this.defaultValue, get());
	}
}
