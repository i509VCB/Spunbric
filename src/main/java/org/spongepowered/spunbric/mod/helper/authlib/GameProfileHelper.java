package org.spongepowered.spunbric.mod.helper.authlib;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import org.spongepowered.api.profile.property.ProfileProperty;
import org.spongepowered.spunbric.mod.core.profile.FabricProfileProperty;

import java.util.Collection;
import java.util.Map;

/**
 * Due to Fabric's Mixin Context not allowing Mixins to be applied to libraries, we have to figure out another way to convert AuthLib GameProfiles to Sponge's GameProfiles
 */
public class GameProfileHelper {
	public static Multimap<String, ProfileProperty> adapt(PropertyMap map) {
		Multimap<String, ProfileProperty> spongeMap = HashMultimap.create();

		Map<String, Collection<Property>> propertyMap = map.asMap();

		for (Map.Entry<String, Collection<Property>> profileEntry : propertyMap.entrySet()) {
			String key = profileEntry.getKey();
			Collection<Property> properties = profileEntry.getValue();
			for (Property property : properties) {
				spongeMap.put(key, FabricProfileProperty.toSponge(property));
			}
		}

		return spongeMap;
	}
}
