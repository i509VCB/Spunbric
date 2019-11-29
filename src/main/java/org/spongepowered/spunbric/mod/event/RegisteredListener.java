package org.spongepowered.spunbric.mod.event;

import co.aikar.timings.Timing;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.EventListener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.EnumMap;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

//import org.spongepowered.common.relocate.co.aikar.timings.SpongeTimings; // TODO: Timings

public final class RegisteredListener<T extends Event> implements FabricEventListener<T>, Comparable<RegisteredListener<?>> {

	private final PluginContainer plugin;

	private final EventType<T> eventType;
	private final Order order;

	private final EventListener<? super T> listener;

	private final boolean beforeModifications;
	private Timing listenerTimer;

	RegisteredListener(PluginContainer plugin, EventType<T> eventType, Order order, EventListener<? super T> listener, boolean beforeModifications) {
		this.plugin = checkNotNull(plugin, "plugin");
		this.eventType = checkNotNull(eventType, "eventType");
		this.order = checkNotNull(order, "order");
		this.listener = checkNotNull(listener, "listener");
		this.beforeModifications = beforeModifications;
	}

	public PluginContainer getPlugin() {
		return this.plugin;
	}

	public EventType<T> getEventType() {
		return this.eventType;
	}

	public Order getOrder() {
		return this.order;
	}

	public boolean isBeforeModifications() {
		return this.beforeModifications;
	}

	public Timing getTimingsHandler() {
		if (this.listenerTimer == null) {
			//this.listenerTimer = SpongeTimings.getPluginTimings(this.plugin, getHandle().getClass().getSimpleName()); // TODO Timings
		}
		return this.listenerTimer;
	}

	@Override
	public Object getHandle() {
		if (this.listener instanceof FabricEventListener) {
			return ((FabricEventListener<?>) this.listener).getHandle();
		}

		return this.listener;
	}

	@Override
	public void handle(T event) throws Exception {
		this.listener.handle(event);
	}

	@Override
	public int compareTo(RegisteredListener<?> handler) {
		return this.order.compareTo(handler.order);
	}

	public static final class Cache {

		private final List<RegisteredListener<?>> listeners;
		private final EnumMap<Order, List<RegisteredListener<?>>> listenersByOrder;

		private static final Order[] ORDERS = Order.values();

		Cache(List<RegisteredListener<?>> listeners) {
			this.listeners = listeners;

			this.listenersByOrder = Maps.newEnumMap(Order.class);
			for (Order order : ORDERS) {
				this.listenersByOrder.put(order, Lists.<RegisteredListener<?>>newArrayList());
			}
			for (RegisteredListener<?> handler : listeners) {
				this.listenersByOrder.get(handler.getOrder()).add(handler);
			}
		}

		public List<RegisteredListener<?>> getListeners() {
			return this.listeners;
		}

		public List<RegisteredListener<?>> getListenersByOrder(Order order) {
			return this.listenersByOrder.get(checkNotNull(order, "order"));
		}

	}

}
