package org.spongepowered.spunbric.mod.mixin.api.block;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.block.BlockSoundGroup;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
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

@Mixin(value = Block.class, priority = 999)
@Implements(@Interface(iface = org.spongepowered.api.block.BlockType.class, prefix = "sponge$"))
public abstract class BlockMixin_API implements BlockType {

	public Optional<ItemType> sponge$getItem() {
		return Optional.empty();
	}

	@Override
	public boolean doesUpdateRandomly() {
		return false;
	}

	@Override
	public void setUpdateRandomly(boolean updateRandomly) {

	}

	public BlockSoundGroup getSoundGroup() {
		return null;
	}

	@Override
	public CatalogKey getKey() {
		return null;
	}

	@Override
	public <V> Optional<V> getProperty(Property<V> property) {
		return Optional.empty();
	}

	@Override
	public Map<Property<?>, ?> getProperties() {
		return null;
	}

	@Override
	public ImmutableList<BlockState> getValidStates() {
		return null;
	}

	// This will work, MCDev plugin doesn't think it exists due to synthetic methods from generics
	// i509VCB: Seems to throw a Mixin Error, this needs more investigation.
	@Override
	public BlockState getDefaultState() {
		return null;
	}

	@Override
	public Collection<StateProperty<?>> getStateProperties() {
		return null;
	}

	@Override
	public Optional<StateProperty<?>> getStatePropertyByName(String name) {
		return Optional.empty();
	}

	@Override
	public Translation getTranslation() {
		return null;
	}
}
