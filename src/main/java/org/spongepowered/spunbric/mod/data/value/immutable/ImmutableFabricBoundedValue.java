package org.spongepowered.spunbric.mod.data.value.immutable;

import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.data.value.Value;

import java.util.Comparator;
import java.util.function.Function;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class ImmutableFabricBoundedValue<E> extends ImmutableFabricValue<E> implements BoundedValue.Immutable<E> {

	private final Comparator<E> comparator;
	private final E minimum;
	private final E maximum;

	public ImmutableFabricBoundedValue(Key<? extends Value<E>> key, E defaultValue, Comparator<E> comparator, E minimum, E maximum) {
		super(key, defaultValue);
		this.comparator = checkNotNull(comparator);
		this.minimum = checkNotNull(minimum);
		this.maximum = checkNotNull(maximum);
		checkState(comparator.compare(maximum, minimum) >= 0);
	}

	public ImmutableFabricBoundedValue(Key<? extends Value<E>> key, E defaultValue, E actualValue, Comparator<E> comparator, E minimum, E maximum) {
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
	public BoundedValue.Immutable<E> with(E value) {
		if (this.comparator.compare(value, this.minimum) >= 0 && this.comparator.compare(value, this.maximum) <= 0) {
			return new ImmutableFabricBoundedValue<>(getKey(), this.defaultValue, value,  getComparator(), getMinValue(), getMaxValue());
		}
		return new ImmutableFabricBoundedValue<>(getKey(), this.defaultValue, getComparator(), getMinValue(), getMaxValue());
	}

	@Override
	public BoundedValue.Immutable<E> transform(Function<E, E> function) {
		return with(checkNotNull(checkNotNull(function).apply(get())));
	}

	@SuppressWarnings("unchecked")
	@Override
	public BoundedValue.Mutable<E> asMutable() {
		return null; // TODO: Implement
	}

	@Override
	public BoundedValue.Mutable<E> asMutableCopy() {
		return null;
	}

	@Override
	public BoundedValue.Immutable<E> asImmutable() {
		return null;
	}
}
