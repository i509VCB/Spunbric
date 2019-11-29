package org.spongepowered.spunbric.mod.event;

import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.EventListener;

public interface FabricEventListener<T extends Event> extends EventListener<T> {

	Object getHandle();

}