package org.spongepowered.spunbric.mod.mixin.api.entity.living;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.text.Text;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.spunbric.mod.mixin.api.entity.EntityMixin_API;

import java.util.Optional;
import java.util.OptionalDouble;

@Mixin(value = LivingEntity.class, priority = 999)
@Implements(@Interface(iface = org.spongepowered.api.entity.living.Living.class, prefix = "sponge$"))
public abstract class LivingEntityMixin_API extends EntityMixin_API implements Living {
	@Override
	public OptionalDouble getLastDamage() {
		return null;
	}

	@Override
	public void lookAt(Vector3d targetPos) {

	}

	@Override
	public <T extends Projectile> Optional<T> launchProjectile(Class<T> projectileClass) {
		return Optional.empty();
	}

	@Override
	public <T extends Projectile> Optional<T> launchProjectile(Class<T> projectileClass, Vector3d velocity) {
		return Optional.empty();
	}

	@Override
	public <T extends Projectile> Optional<T> launchToTarget(Class<T> projectileClass, Entity target) {
		return Optional.empty();
	}

	@Override
	public Text getTeamRepresentation() {
		return null;
	}
}
