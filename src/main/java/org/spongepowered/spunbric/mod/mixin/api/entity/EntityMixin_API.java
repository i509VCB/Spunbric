package org.spongepowered.spunbric.mod.mixin.api.entity;

import net.minecraft.entity.Entity;
import org.spongepowered.api.entity.EntityArchetype;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.AABB;
import org.spongepowered.api.util.RelativePositions;
import org.spongepowered.api.util.Transform;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.math.vector.Vector3d;

import java.util.EnumSet;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Mixin(Entity.class)
@Implements(@Interface(iface = org.spongepowered.api.entity.Entity.class, prefix = "sponge$"))
public abstract class EntityMixin_API implements org.spongepowered.api.entity.Entity {

	@Shadow protected abstract UUID shadow$getUuid();

	@Shadow protected Random random;

	@Override
	public EntityType<?> getType() {
		return null;
	}

	@Override
	public EntitySnapshot createSnapshot() {
		return null;
	}

	// Conflict
	public EntityArchetype sponge$copy() {
		return null;
	}

	@Override
	public EntityArchetype createArchetype() {
		return null;
	}

	@Override
	public boolean setLocation(Location location) {
		return false;
	}

	@Override
	public Vector3d getRotation() {
		return null;
	}

	@Override
	public void setRotation(Vector3d rotation) {

	}

	@Override
	public boolean setLocationAndRotation(Location location, Vector3d rotation) {
		return false;
	}

	@Override
	public boolean setLocationAndRotation(Location location, Vector3d rotation, EnumSet<RelativePositions> relativePositions) {
		return false;
	}

	@Override
	public Vector3d getScale() {
		return null;
	}

	@Override
	public void setScale(Vector3d scale) {

	}

	@Override
	public Transform getTransform() {
		return null;
	}

	@Override
	public boolean setTransform(Transform transform) {
		return false;
	}

	@Override
	public boolean transferToWorld(World world, Vector3d position) {
		return false;
	}

	@Override
	public Optional<AABB> getBoundingBox() {
		return Optional.empty();
	}

	@Override
	public boolean isRemoved() {
		return false;
	}

	@Override
	public boolean isLoaded() {
		return false;
	}

	@Override
	public void remove() {

	}

	@Override
	public boolean damage(double damage, DamageSource damageSource) {
		return false;
	}

	@Override
	public Translation getTranslation() {
		return null;
	}

	@Override
	public UUID getUniqueId() {
		return this.shadow$getUuid();
	}

	@Override
	public Random getRandom() {
		return this.random;
	}

	@Override
	public Location getLocation() {
		return null;
	}
}
