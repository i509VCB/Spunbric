package org.spongepowered.spunbric.mod.data.value.mutable;

import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.data.value.OptionalValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.spunbric.mod.data.value.immutable.ImmutableFabricBoundedValue;

import java.util.Comparator;
import java.util.function.Function;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class MutableFabricBoundedValue<E> extends MutableFabricValue<E> implements BoundedValue.Mutable<E> {
	private final Comparator<E> comparator;
	private final E minimum;
	private final E maximum;

	public MutableFabricBoundedValue(Key<? extends Value<E>> key, E defaultValue, Comparator<E> comparator, E minimum, E maximum) {
		this(key, defaultValue, comparator, minimum, maximum, defaultValue);
	}

	public MutableFabricBoundedValue(Key<? extends Value<E>> key, E defaultValue, Comparator<E> comparator, E minimum, E maximum, E actualValue) {
		super(key, defaultValue, actualValue);
		this.comparator = checkNotNull(comparator);
		this.minimum = checkNotNull(minimum);
		this.maximum = checkNotNull(maximum);
		checkState(comparator.compare(maximum, minimum) >= 0);
	}

	@Override
	public Key<? extends BoundedValue<E>> getKey() {
		return (Key<? extends BoundedValue<E>>) this.key;
	}

	@Override
	public E getMinValue() {
		return this.minimum;
	}

	@Override
	public E getMaxValue() {
		return this.maximum;
	}

	@Override
	public Comparator<E> getComparator() {
		return this.comparator;
	}

	@Override
	public BoundedValue.Mutable<E> set(E value) {
		if (this.comparator.compare(value, this.minimum) >= 0 && this.comparator.compare(value, this.maximum) <= 0) {
			this.actualValue = checkNotNull(value);
		}
		return this;
	}

	@Override
	public BoundedValue.Mutable<E> transform(Function<E, E> function) {
		return set(checkNotNull(checkNotNull(function).apply(get())));
	}

	@Override
	public BoundedValue.Immutable<E> asImmutable() {
		return new ImmutableFabricBoundedValue<>(getKey(), this.defaultValue, this.actualValue, this.comparator, this.minimum, this.maximum);
	}

	@Override
	public BoundedValue.Mutable<E> copy() {
		return new MutableFabricBoundedValue<>(this.getKey(), this.defaultValue, this.comparator, this.minimum, this.maximum, this.actualValue);
	}
}
