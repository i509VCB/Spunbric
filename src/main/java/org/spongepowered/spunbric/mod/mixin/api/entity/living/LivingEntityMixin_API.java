package org.spongepowered.spunbric.mod.mixin.api.entity.living;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.scoreboard.TeamMember;
import org.spongepowered.api.text.Text;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.spunbric.mod.mixin.api.entity.EntityMixin_API;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.UUID;

@Mixin(value = LivingEntity.class, priority = 999)
@Implements(@Interface(iface = org.spongepowered.api.entity.living.Living.class, prefix = "sponge$"))
public class LivingEntityMixin_API {

	public OptionalDouble sponge$getLastDamage() {
		return null;
	}

	public void sponge$lookAt(Vector3d targetPos) {
		// TODO Implement
	}

	public <T extends Projectile> Optional<T> sponge$launchProjectile(Class<T> projectileClass) {
		return Optional.empty();
	}

	public <T extends Projectile> Optional<T> sponge$launchProjectile(Class<T> projectileClass, Vector3d velocity) {
		return Optional.empty();
	}

	public <T extends Projectile> Optional<T> sponge$launchToTarget(Class<T> projectileClass, Entity target) {
		return Optional.empty();
	}

	public Text sponge$getTeamRepresentation() {
		return Text.of(((Entity)this).getUniqueId().toString());
	}
}
