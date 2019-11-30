package org.spongepowered.spunbric.mod.data.value;

import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.spunbric.mod.data.value.mutable.MutableFabricBoundedValue;

import java.util.Comparator;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class FabricValueFactory implements Value.Factory {
	private static Value.Factory instance = new FabricValueFactory();

	public static Value.Factory getInstance() {
		return instance;
	}

	@Override
	public <V extends Value<E>, E> V mutableOf(Key<V> key, E element) {
		return null;
	}

	@Override
	public <V extends Value<E>, E> V immutableOf(Key<V> key, E element) {
		return null;
	}
}
