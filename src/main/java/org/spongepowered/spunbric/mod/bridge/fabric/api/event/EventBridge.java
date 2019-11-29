package org.spongepowered.spunbric.mod.bridge.fabric.api.event;

/**
 * Acts as a bridge to an ArrayBackedEvent.
 */
public interface EventBridge {
	/**
	 * Gets the amount of listeners registered to a Fabric Event.
	 * @return The amount of listeners.
	 */
	int getAmountRegistered();
}
