package org.spongepowered.spunbric.mod.event;

import org.spongepowered.api.event.Event;

public interface EventFilter {

	Object[] filter(Event event);

}