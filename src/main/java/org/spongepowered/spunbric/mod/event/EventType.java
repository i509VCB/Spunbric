package org.spongepowered.spunbric.mod.event;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.event.Event;

import javax.annotation.Nullable;
import java.util.Objects;

public final class EventType<T extends Event> {

	private final Class<T> eventType;
	@Nullable private final TypeToken<?> genericType;

	private int hashCode;

	EventType(Class<T> eventType, @Nullable TypeToken<?> genericType) {
		this.genericType = genericType;
		this.eventType = eventType;
	}

	public EventType(Class<T> eventType) {
		this(eventType, null);
	}

	public Class<T> getType() {
		return this.eventType;
	}

	@Nullable
	public TypeToken<?> getGenericType() {
		return this.genericType;
	}

	@Override
	public String toString() {
		String value = this.eventType.getName();
		if (this.genericType != null) {
			value += "<" + this.genericType.toString() + ">";
		}
		return value;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(@Nullable Object o) {
		if (!(o instanceof EventType)) {
			return false;
		}
		final EventType that = (EventType) o;
		return that.eventType.equals(this.eventType) &&
			Objects.equals(that.genericType, this.genericType);
	}

	@Override
	public int hashCode() {
		if (this.hashCode == 0) {
			this.hashCode = Objects.hash(this.eventType, this.genericType);
		}
		return this.hashCode;
	}
}