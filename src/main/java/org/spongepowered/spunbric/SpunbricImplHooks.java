package org.spongepowered.spunbric;

import net.minecraft.entity.Entity;

public class SpunbricImplHooks {
	public static boolean isFakePlayer(final Entity entity) {
		return false;
	}
}
