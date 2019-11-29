package org.spongepowered.spunbric.mod.event;

import org.spongepowered.api.event.Event;

import java.lang.reflect.Method;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class AnnotatedEventListener implements FabricEventListener<Event> {

	protected final Object handle;

	protected AnnotatedEventListener(Object handle) {
		this.handle = checkNotNull(handle, "handle");
	}

	@Override
	public final Object getHandle() {
		return this.handle;
	}

	interface Factory {

		AnnotatedEventListener create(Object handle, Method method) throws Exception;

	}

}
