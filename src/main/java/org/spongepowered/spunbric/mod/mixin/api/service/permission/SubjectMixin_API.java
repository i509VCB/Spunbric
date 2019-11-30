package org.spongepowered.spunbric.mod.mixin.api.service.permission;

import net.minecraft.block.entity.CommandBlockBlockEntity;
import net.minecraft.entity.vehicle.CommandBlockMinecartEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.ServerCommandOutput;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.rcon.RconBase;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.spunbric.mod.entity.player.FabricUser;

@Mixin(value = {ServerPlayerEntity.class, CommandBlockBlockEntity.class, CommandBlockMinecartEntity.class, MinecraftServer.class, ServerCommandOutput.class, FabricUser.class})
public abstract class SubjectMixin_API implements Subject {
}
