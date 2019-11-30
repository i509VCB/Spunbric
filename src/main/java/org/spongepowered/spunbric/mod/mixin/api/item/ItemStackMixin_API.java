package org.spongepowered.spunbric.mod.mixin.api.item;

import net.minecraft.item.ItemStack;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.property.Property;
import org.spongepowered.api.data.value.*;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.spunbric.mod.util.FabricTranslation;

import java.util.*;

@Mixin(ItemStack.class)
@Implements(@Interface(iface = org.spongepowered.api.item.inventory.ItemStack.class, prefix = "sponge$"))
public class ItemStackMixin_API implements DataHolder {

	public ItemType sponge$getType() {
		return (ItemType) ((ItemStack)(Object)this).getItem();
	}

	public int sponge$getQuantity() {
		return ((ItemStack) (Object)this).getCount();
	}

	public void sponge$setQuantity(int quantity) throws IllegalArgumentException {
		((ItemStack)(Object)this).setCount(quantity);
	}

	public int sponge$getMaxStackQuantity() {
		return 0;
	}

	public ItemStackSnapshot sponge$createSnapshot() {
		return null;
	}

	public boolean sponge$equalTo(org.spongepowered.api.item.inventory.ItemStack that) {
		return ItemStack.areEqualIgnoreDamage((ItemStack)(Object)this, (ItemStack)(Object)that);
	}

	@Intrinsic // Make this Intrinsic to fix the StackOverflow Error.
	public boolean sponge$isEmpty() {
		return ((ItemStack)(Object)this).isEmpty();
	}

	public boolean sponge$validateRawData(DataView container) {
		return false;
	}

	public void sponge$setRawData(DataView container) throws InvalidDataException {

	}

	public <E> Optional<E> sponge$get(Key<? extends Value<E>> key) {
		return Optional.empty();
	}

	public OptionalInt sponge$getInt(Key<? extends Value<Integer>> key) {
		return null;
	}

	public OptionalDouble sponge$getDouble(Key<? extends Value<Double>> key) {
		return null;
	}

	public OptionalLong sponge$getLong(Key<? extends Value<Long>> key) {
		return null;
	}

	public <E, V extends Value<E>> Optional<V> sponge$getValue(Key<V> key) {
		return Optional.empty();
	}

	public boolean sponge$supports(Key<?> key) {
		return false;
	}

	public org.spongepowered.api.item.inventory.ItemStack sponge$copy() {
		return null;
	}

	public Set<Key<?>> sponge$getKeys() {
		return null;
	}

	public Set<Value.Immutable<?>> sponge$getValues() {
		return null;
	}

	public <E> DataTransactionResult sponge$offer(Key<? extends Value<E>> key, E value) {
		return null;
	}

	public <E> DataTransactionResult sponge$offerSingle(Key<? extends CollectionValue<E, ?>> key, E element) {
		return null;
	}

	public <K, V> DataTransactionResult sponge$offerSingle(Key<? extends MapValue<K, V>> key, K valueKey, V value) {
		return null;
	}

	public <K, V> DataTransactionResult sponge$offerAll(Key<? extends MapValue<K, V>> key, Map<? extends K, ? extends V> map) {
		return null;
	}

	public DataTransactionResult sponge$offerAll(MapValue<?, ?> value) {
		return null;
	}

	public DataTransactionResult sponge$offerAll(CollectionValue<?, ?> value) {
		return null;
	}

	public <E> DataTransactionResult sponge$offerAll(Key<? extends CollectionValue<E, ?>> key, Collection<? extends E> elements) {
		return null;
	}

	public <E> DataTransactionResult sponge$removeSingle(Key<? extends CollectionValue<E, ?>> key, E element) {
		return null;
	}

	public <K> DataTransactionResult sponge$removeKey(Key<? extends MapValue<K, ?>> key, K mapKey) {
		return null;
	}

	public DataTransactionResult sponge$removeAll(CollectionValue<?, ?> value) {
		return null;
	}

	public <E> DataTransactionResult sponge$removeAll(Key<? extends CollectionValue<E, ?>> key, Collection<? extends E> elements) {
		return null;
	}

	public DataTransactionResult sponge$removeAll(MapValue<?, ?> value) {
		return null;
	}

	public <K, V> DataTransactionResult sponge$removeAll(Key<? extends MapValue<K, V>> key, Map<? extends K, ? extends V> map) {
		return null;
	}

	public <E> DataTransactionResult sponge$tryOffer(Key<? extends Value<E>> key, E value) {
		return null;
	}

	public DataTransactionResult sponge$remove(Key<?> key) {
		return null;
	}

	public DataTransactionResult sponge$undo(DataTransactionResult result) {
		return null;
	}

	public DataTransactionResult sponge$copyFrom(ValueContainer that, MergeFunction function) {
		return null;
	}

	public int sponge$getContentVersion() {
		return 0;
	}

	public DataContainer sponge$toContainer() {
		return null;
	}

	public <V> Optional<V> sponge$getProperty(Property<V> property) {
		return Optional.empty();
	}

	public Map<Property<?>, ?> sponge$getProperties() {
		return null;
	}

	public Translation sponge$getTranslation() {
		return new FabricTranslation(((ItemStack) (Object)this).getTranslationKey());
	}

	@Override
	public int getContentVersion() {
		return 0;
	}

	@Override
	public DataContainer toContainer() {
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
	public <E> Optional<E> get(Key<? extends Value<E>> key) {
		return Optional.empty();
	}

	@Override
	public OptionalInt getInt(Key<? extends Value<Integer>> key) {
		return null;
	}

	@Override
	public OptionalDouble getDouble(Key<? extends Value<Double>> key) {
		return null;
	}

	@Override
	public OptionalLong getLong(Key<? extends Value<Long>> key) {
		return null;
	}

	@Override
	public <E, V extends Value<E>> Optional<V> getValue(Key<V> key) {
		return Optional.empty();
	}

	@Override
	public boolean supports(Key<?> key) {
		return false;
	}

	@Override
	public ValueContainer copy() {
		return null;
	}

	@Override
	public Set<Key<?>> getKeys() {
		return null;
	}

	@Override
	public Set<Value.Immutable<?>> getValues() {
		return null;
	}
}
