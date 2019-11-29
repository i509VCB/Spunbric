package org.spongepowered.spunbric.mod.mixin.api.item;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.property.Property;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.asm.mixin.*;

import java.util.Map;
import java.util.Optional;

@Mixin(Item.class)
@Implements(@Interface(iface = org.spongepowered.api.item.ItemType.class, prefix = "sponge$"))
public abstract class ItemMixin_API {

	@Shadow public abstract String getTranslationKey();

	@Shadow @Final private int maxCount;

	public Optional<BlockType> sponge$getBlock() {
		if ((((Item)(Object)this) instanceof BlockItem)) {
			return Optional.of((BlockType) ((BlockItem)(Object)this).getBlock());
		}
		return Optional.empty();
	}

	public int sponge$getMaxStackQuantity() {
		return this.maxCount;
	}

	public CatalogKey sponge$getKey() {
		Identifier id = Registry.ITEM.getId((Item)(Object)this);
		return CatalogKey.of(id.getNamespace(), id.getPath());
	}

	//TODO: properties on items
	public <V> Optional<V> sponge$getProperty(Property<V> property) {
		return Optional.empty();
	}

	public Map<Property<?>, ?> sponge$getProperties() {
		return null;
	}

	public Translation sponge$getTranslation() {
		return null;
	}
}
