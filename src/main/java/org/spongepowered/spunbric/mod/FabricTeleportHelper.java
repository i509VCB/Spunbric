package org.spongepowered.spunbric.mod;

import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.TeleportHelper;
import org.spongepowered.api.world.teleport.TeleportHelperFilter;

import java.util.Optional;

// TODO Dummy Impl
public class FabricTeleportHelper implements TeleportHelper {
    @Override
    public Optional<Location> getSafeLocation(Location location, int height, int width, int floorDistance, TeleportHelperFilter filter, TeleportHelperFilter... additionalFilters) {
        return Optional.empty();
    }
}
