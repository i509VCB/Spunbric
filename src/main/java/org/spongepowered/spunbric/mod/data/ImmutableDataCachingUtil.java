package org.spongepowered.spunbric.mod.data;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.spunbric.SpunbricImpl;
import org.spongepowered.spunbric.mod.data.value.immutable.ImmutableFabricValue;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import static org.spongepowered.spunbric.mod.util.ReflectionUtil.createUnsafeInstance;

public class ImmutableDataCachingUtil {

	public static final int CACHE_LIMIT_FOR_INDIVIDUAL_TYPE = 100;
	public static final int MANIPULATOR_CACHE_LIMIT = 100000;
	public static final int VALUE_CACHE_LIMIT = 100000;

	private static final Cache<String, DataManipulator.Immutable> manipulatorCache = CacheBuilder.newBuilder()
		.maximumSize(MANIPULATOR_CACHE_LIMIT)
		.concurrencyLevel(4)
		.build();

	private static final Cache<Key<?>, org.spongepowered.api.data.value.Value.Immutable<?>> valueCache = CacheBuilder.newBuilder()
		.concurrencyLevel(4)
		.maximumSize(VALUE_CACHE_LIMIT)
		.build();

	public static <E> Value.Immutable<E> getValue(Class<ImmutableFabricValue> valueClass, Key<? extends Value<E>> usedKey, E defaultArg, E arg, final Object... extraArgs) {
		//final Key<?> key = getKey(valueClass, usedKey.getElementToken().asString('.'), arg.getClass(), arg);
		try {
			return (Value.Immutable<E>) ImmutableDataCachingUtil.valueCache.get(usedKey, (Callable<Value.Immutable<?>>) () -> {
				try {
					if (extraArgs == null || extraArgs.length == 0) {
						return createUnsafeInstance(valueClass, usedKey, defaultArg, arg);
					}
					return createUnsafeInstance(valueClass, usedKey, defaultArg, arg, extraArgs);
				} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
					SpunbricImpl.getLogger().error("Could not construct an ImmutableValue: " + valueClass.getCanonicalName(), e);
				}
				throw new UnsupportedOperationException("Could not construct the ImmutableValue: " + valueClass.getName());
			});
		} catch (ExecutionException e) {
			throw new UnsupportedOperationException("Could not construct the ImmutableValue: " + valueClass.getName(), e);
		}
	}
}
