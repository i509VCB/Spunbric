package org.spongepowered.spunbric.mod.mixin.api.entity.player;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.spunbric.mod.mixin.api.entity.living.LivingEntityMixin_API;

@Mixin(PlayerEntity.class)
@Implements(@Interface(iface = User.class, prefix = "api$"))
public abstract class PlayerEntityMixin_API extends LivingEntityMixin_API {
}
