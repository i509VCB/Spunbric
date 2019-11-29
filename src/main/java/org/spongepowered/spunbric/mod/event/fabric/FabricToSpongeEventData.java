package org.spongepowered.spunbric.mod.event.fabric;

import net.fabricmc.fabric.api.event.Event;
import org.spongepowered.spunbric.mod.bridge.fabric.api.event.EventBridge;

public class FabricToSpongeEventData {
	private final EventBridge bridge;

	public <T> FabricToSpongeEventData(Event<T> fabricEvent) {
		if (!(fabricEvent instanceof EventBridge)) {
			throw new RuntimeException("Could not process a Fabric Event. Either Mixin Didn't apply or you are not using an ArrayBackedEvent for this event. Instead Event type was: " + fabricEvent.getClass().getName());
		}

		EventBridge fabricEventBridge = (EventBridge) fabricEvent;

		this.bridge = fabricEventBridge;
	}

	public int getRegisteredCount() {
		return bridge.getAmountRegistered();
	}
}
