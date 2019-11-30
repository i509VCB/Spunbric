package org.spongepowered.spunbric.mod.mixin.api.entity.player;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.property.Property;
import org.spongepowered.api.data.type.HandType;
import org.spongepowered.api.data.value.*;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.inventory.type.CarriedInventory;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.permission.SubjectCollection;
import org.spongepowered.api.service.permission.SubjectData;
import org.spongepowered.api.service.permission.SubjectReference;
import org.spongepowered.api.util.Tristate;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.spunbric.mod.mixin.api.entity.living.LivingEntityMixin_API;

import java.util.*;

@Mixin(PlayerEntity.class)
@Implements(@Interface(iface = User.class, prefix = "sponge$"))
// TODO: do we just want User on PlayerEntity or should it be Player?
// TODO: i509VCB: In the User javadoc, it specifies that User is the data representation and not the entity. Yes a player would contain
public abstract class PlayerEntityMixin_API extends LivingEntityMixin_API implements User {

	public abstract String shadow$getName();

	public String sponge$getName() {
		return shadow$getName();
	}


}
