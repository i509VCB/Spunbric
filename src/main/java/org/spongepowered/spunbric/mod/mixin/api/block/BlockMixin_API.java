package org.spongepowered.spunbric.mod.mixin.api.block;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.block.BlockSoundGroup;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.property.Property;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.state.StateProperty;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Mixin(Block.class)
@Implements(@Interface(iface = org.spongepowered.api.block.BlockType.class, prefix = "sponge$"))
public class BlockMixin_API {

	public Optional<ItemType> sponge$getItem() {
		return Optional.empty();
	}

	public boolean sponge$doesUpdateRandomly() {
		return false;
	}

	public void sponge$setUpdateRandomly(boolean updateRandomly) {

	}

	public BlockSoundGroup sponge$getSoundGroup() {
		return null;
	}

	public CatalogKey sponge$getKey() {
		return null;
	}

	public <V> Optional<V> sponge$getProperty(Property<V> property) {
		return Optional.empty();
	}

	public Map<Property<?>, ?> sponge$getProperties() {
		return null;
	}

	public ImmutableList<BlockState> sponge$getValidStates() {
		return null;
	}

	public BlockState sponge$getDefaultState() { //will work, MCDev plugin doesn't think it exists due to synthetic methods from generics
		return null;
	}

	public Collection<StateProperty<?>> sponge$getStateProperties() {
		return null;
	}

	public Optional<StateProperty<?>> sponge$getStatePropertyByName(String name) {
		return Optional.empty();
	}

	public Translation sponge$getTranslation() {
		return null;
	}
}
