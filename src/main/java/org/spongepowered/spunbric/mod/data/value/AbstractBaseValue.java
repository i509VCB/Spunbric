package org.spongepowered.spunbric.mod.data.value;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.value.Value;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class AbstractBaseValue<E> implements Value<E> {

	protected final Key<? extends Value<E>> key;
	protected final E defaultValue;
	protected E actualValue;

	public AbstractBaseValue(Key<? extends Value<E>> key, E defaultValue) {
		this.key = checkNotNull(key);
		this.defaultValue = checkNotNull(defaultValue);
		this.actualValue = defaultValue;
	}

	protected AbstractBaseValue(Key<? extends Value<E>> key, E defaultValue, E actualValue) {
		this.key = checkNotNull(key);
		this.defaultValue = checkNotNull(defaultValue);
		this.actualValue = checkNotNull(actualValue);
	}

	@Override
	public E get() {
		return this.actualValue == null ? this.defaultValue : this.actualValue;
	}

	@Override
	public Key<? extends Value<E>> getKey() {
		return this.key;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.key, this.defaultValue, this.actualValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final AbstractBaseValue other = (AbstractBaseValue) obj;
		return Objects.equal(this.key, other.key)
			&& Objects.equal(this.defaultValue, other.defaultValue)
			&& Objects.equal(this.actualValue, other.actualValue);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("key", this.key)
			.add("defaultValue", this.defaultValue)
			.add("actualValue", this.actualValue)
			.toString();
	}
}
