package org.spongepowered.spunbric.mod.util;

import com.google.common.base.MoreObjects;

public final class ThreadUtil {

	private ThreadUtil() {
	}

	public static String getDescription(final Thread thread) {
		return MoreObjects.toStringHelper(thread)
			.add("class", thread.getClass())
			.add("name", thread.getName())
			.add("priority", thread.getPriority())
			.add("group", thread.getThreadGroup())
			.toString();
	}
}
