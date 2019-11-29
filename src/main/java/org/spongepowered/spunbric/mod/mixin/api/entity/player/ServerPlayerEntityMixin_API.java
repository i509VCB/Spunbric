package org.spongepowered.spunbric.mod.mixin.api.entity.player;

import net.minecraft.server.network.ServerPlayerEntity;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.advancement.Advancement;
import org.spongepowered.api.advancement.AdvancementProgress;
import org.spongepowered.api.advancement.AdvancementTree;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.type.HandType;
import org.spongepowered.api.data.type.SkinPart;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.sound.SoundCategory;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.effect.sound.music.MusicDisc;
import org.spongepowered.api.entity.living.player.CooldownTracker;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.tab.TabList;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.Container;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.inventory.type.CarriedInventory;
import org.spongepowered.api.network.PlayerConnection;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.permission.SubjectCollection;
import org.spongepowered.api.service.permission.SubjectData;
import org.spongepowered.api.service.permission.SubjectReference;
import org.spongepowered.api.text.BookView;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.chat.ChatType;
import org.spongepowered.api.text.chat.ChatVisibility;
import org.spongepowered.api.text.title.Title;
import org.spongepowered.api.util.Tristate;
import org.spongepowered.api.world.WorldBorder;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Mixin(ServerPlayerEntity.class)
@Implements(@Interface(iface = Player.class, prefix = "api$"))
public abstract class ServerPlayerEntityMixin_API extends PlayerEntityMixin_API implements Player {

	@Override
	public boolean isLocal() {
		return false; // ServerPlayerEntity, obviously not local.
	}

	@Override
	public Optional<Container> getOpenInventory() {
		return Optional.empty();
	}

	@Override
	public Optional<Container> openInventory(Inventory inventory) throws IllegalArgumentException {
		return Optional.empty();
	}

	@Override
	public Optional<Container> openInventory(Inventory inventory, Text displayName) {
		return Optional.empty();
	}

	@Override
	public boolean closeInventory() throws IllegalArgumentException {
		return false;
	}

	@Override
	public int getViewDistance() {
		return 0;
	}

	@Override
	public ChatVisibility getChatVisibility() {
		return null;
	}

	@Override
	public boolean isChatColorsEnabled() {
		return false;
	}

	@Override
	public MessageChannelEvent.Chat simulateChat(Text message, Cause cause) {
		return null;
	}

	@Override
	public Set<SkinPart> getDisplayedSkinParts() {
		return null;
	}

	@Override
	public PlayerConnection getConnection() {
		return null;
	}

	@Override
	public void sendResourcePack(ResourcePack pack) {

	}

	@Override
	public TabList getTabList() {
		return null;
	}

	@Override
	public void kick() {

	}

	@Override
	public void kick(Text reason) {

	}

	@Override
	public Scoreboard getScoreboard() {
		return null;
	}

	@Override
	public void setScoreboard(Scoreboard scoreboard) {

	}

	@Override
	public boolean respawnPlayer() {
		return false;
	}

	@Override
	public Optional<WorldBorder> getWorldBorder() {
		return Optional.empty();
	}

	@Override
	public void setWorldBorder(@Nullable WorldBorder border, Cause cause) {

	}

	@Override
	public CooldownTracker getCooldownTracker() {
		return null;
	}

	@Override
	public AdvancementProgress getProgress(Advancement advancement) {
		return null;
	}

	@Override
	public Collection<AdvancementTree> getUnlockedAdvancementTrees() {
		return null;
	}

	@Override
	public void spawnParticles(ParticleEffect particleEffect, Vector3d position, int radius) {

	}

	@Override
	public void playSound(SoundType sound, SoundCategory category, Vector3d position, double volume, double pitch, double minVolume) {

	}

	@Override
	public void stopSounds() {

	}

	@Override
	public void stopSounds(SoundType sound) {

	}

	@Override
	public void stopSounds(SoundCategory category) {

	}

	@Override
	public void stopSounds(SoundType sound, SoundCategory category) {

	}

	@Override
	public void playMusicDisc(Vector3i position, MusicDisc musicDiscType) {

	}

	@Override
	public void stopMusicDisc(Vector3i position) {

	}

	@Override
	public void sendTitle(Title title) {

	}

	@Override
	public void sendBookView(BookView bookView) {

	}

	@Override
	public void sendBlockChange(int x, int y, int z, BlockState state) {

	}

	@Override
	public void resetBlockChange(int x, int y, int z) {

	}

	@Override
	public GameProfile getProfile() {
		return null;
	}

	@Override
	public boolean isOnline() {
		return false;
	}

	@Override
	public Optional<Player> getPlayer() {
		return Optional.of(this);
	}

	@Override
	public Vector3d getPosition() {
		return null;
	}

	@Override
	public Optional<UUID> getWorldUniqueId() {
		return Optional.empty();
	}

	@Override
	public boolean setLocation(Vector3d position, UUID world) {
		return false;
	}

	@Override
	public Inventory getEnderChestInventory() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public ItemStack getHelmet() {
		return null;
	}

	@Override
	public void setHelmet(ItemStack helmet) {

	}

	@Override
	public ItemStack getChestplate() {
		return null;
	}

	@Override
	public void setChestplate(ItemStack chestplate) {

	}

	@Override
	public ItemStack getLeggings() {
		return null;
	}

	@Override
	public void setLeggings(ItemStack leggings) {

	}

	@Override
	public ItemStack getBoots() {
		return null;
	}

	@Override
	public void setBoots(ItemStack boots) {

	}

	@Override
	public ItemStack getItemInHand(HandType handType) {
		return null;
	}

	@Override
	public void setItemInHand(HandType hand, ItemStack itemInHand) {

	}

	@Override
	public boolean canEquip(EquipmentType type) {
		return false;
	}

	@Override
	public boolean canEquip(EquipmentType type, ItemStack equipment) {
		return false;
	}

	@Override
	public Optional<ItemStack> getEquipped(EquipmentType type) {
		return Optional.empty();
	}

	@Override
	public boolean equip(EquipmentType type, ItemStack equipment) {
		return false;
	}

	@Override
	public CarriedInventory<? extends Carrier> getInventory() {
		return null;
	}

	@Override
	public SubjectCollection getContainingCollection() {
		return null;
	}

	@Override
	public SubjectReference asSubjectReference() {
		return null;
	}

	@Override
	public boolean isSubjectDataPersisted() {
		return false;
	}

	@Override
	public SubjectData getSubjectData() {
		return null;
	}

	@Override
	public SubjectData getTransientSubjectData() {
		return null;
	}

	@Override
	public Tristate getPermissionValue(Set<Context> contexts, String permission) {
		return null;
	}

	@Override
	public boolean isChildOf(Set<Context> contexts, SubjectReference parent) {
		return false;
	}

	@Override
	public List<SubjectReference> getParents(Set<Context> contexts) {
		return null;
	}

	@Override
	public Optional<String> getOption(Set<Context> contexts, String key) {
		return Optional.empty();
	}

	@Override
	public String getIdentifier() {
		return null;
	}

	@Override
	public Set<Context> getActiveContexts() {
		return null;
	}

	@Override
	public void sendMessage(ChatType type, Text message) {

	}

	@Override
	public MessageChannel getMessageChannel() {
		return null;
	}

	@Override
	public void setMessageChannel(MessageChannel channel) {

	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("This is an internal method not intended for use with Players " +
			"as it causes the player to be placed into an undefined state. " +
			"Consider putting them through the normal death process instead.");
	}
}
