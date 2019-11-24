package org.spongepowered.spunbric.mod;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.EventListener;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.plugin.PluginContainer;

// TODO Dummy Impl
public class FabricEventManager implements EventManager {
    @Override
    public void registerListeners(PluginContainer plugin, Object obj) {

    }

    @Override
    public <T extends Event> void registerListener(PluginContainer plugin, Class<T> eventClass, EventListener<? super T> listener) {

    }

    @Override
    public <T extends Event> void registerListener(PluginContainer plugin, TypeToken<T> eventType, EventListener<? super T> listener) {

    }

    @Override
    public <T extends Event> void registerListener(PluginContainer plugin, Class<T> eventClass, Order order, EventListener<? super T> listener) {

    }

    @Override
    public <T extends Event> void registerListener(PluginContainer plugin, TypeToken<T> eventType, Order order, EventListener<? super T> listener) {

    }

    @Override
    public <T extends Event> void registerListener(PluginContainer plugin, Class<T> eventClass, Order order, boolean beforeModifications, EventListener<? super T> listener) {

    }

    @Override
    public <T extends Event> void registerListener(PluginContainer plugin, TypeToken<T> eventType, Order order, boolean beforeModifications, EventListener<? super T> listener) {

    }

    @Override
    public void unregisterListeners(Object obj) {

    }

    @Override
    public void unregisterPluginListeners(PluginContainer plugin) {

    }

    @Override
    public boolean post(Event event) {
        return false;
    }
}
