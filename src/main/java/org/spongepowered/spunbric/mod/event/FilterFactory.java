package org.spongepowered.spunbric.mod.event;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class FilterFactory {

	private final AtomicInteger id = new AtomicInteger();
	private final DefineableClassLoader classLoader;
	private final LoadingCache<Method, Class<? extends EventFilter>> cache = CacheBuilder.newBuilder()
		.concurrencyLevel(1).weakValues().build(new CacheLoader<Method, Class<? extends EventFilter>>() {

			@Override
			public Class<? extends EventFilter> load(Method method) throws Exception {
				return createClass(method);
			}
		});
	private final String targetPackage;

	public FilterFactory(String targetPackage, DefineableClassLoader classLoader) {
		checkNotNull(targetPackage, "targetPackage");
		checkArgument(!targetPackage.isEmpty(), "targetPackage cannot be empty");
		this.targetPackage = targetPackage + '.';
		this.classLoader = checkNotNull(classLoader, "classLoader");
	}

	public Class<? extends EventFilter> createFilter(Method method) throws Exception {
		return this.cache.get(method);
	}

	Class<? extends EventFilter> createClass(Method method) {
		Class<?> handle = method.getDeclaringClass();
		Class<?> eventClass = method.getParameterTypes()[0];
		String name = this.targetPackage + eventClass.getSimpleName() + "Filter_" + handle.getSimpleName() + '_'
			+ method.getName() + this.id.incrementAndGet();
		byte[] cls = FilterGenerator.getInstance().generateClass(name, method);
		return this.classLoader.defineClass(name, cls);
	}

}
