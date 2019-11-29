package org.spongepowered.spunbric.mod.mixin.api.entity.player;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
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
@Implements(@Interface(iface = Player.class, prefix = "sponge$"))
public abstract class ServerPlayerEntityMixin_API extends PlayerEntity {

	public ServerPlayerEntityMixin_API(World world, com.mojang.authlib.GameProfile profile) {
		super(world, profile);
	}

	public boolean sponge$isLocal() {
		return false; // ServerPlayerEntity, obviously not local.
	}

	public Optional<Container> sponge$getOpenInventory() {
		return Optional.empty();
	}

	public Optional<Container> sponge$openInventory(Inventory inventory) throws IllegalArgumentException {
		return Optional.empty();
	}

	public Optional<Container> sponge$openInventory(Inventory inventory, Text displayName) {
		return Optional.empty();
	}

	public boolean sponge$closeInventory() throws IllegalArgumentException {
		return false;
	}

	public int sponge$getViewDistance() {
		return 0;
	}

	public ChatVisibility sponge$getChatVisibility() {
		return null;
	}

	public boolean sponge$isChatColorsEnabled() {
		return false;
	}

	public MessageChannelEvent.Chat sponge$simulateChat(Text message, Cause cause) {
		return null;
	}

	public Set<SkinPart> sponge$getDisplayedSkinParts() {
		return null;
	}

	public PlayerConnection sponge$getConnection() {
		return null;
	}

	public void sponge$sendResourcePack(ResourcePack pack) {

	}

	public TabList sponge$getTabList() {
		return null;
	}

	public void sponge$kick() {

	}

	public void sponge$kick(Text reason) {

	}

	public Scoreboard sponge$getScoreboard() {
		return null;
	}

	public void sponge$setScoreboard(Scoreboard scoreboard) {

	}

	public boolean sponge$respawnPlayer() {
		return false;
	}

	public Optional<WorldBorder> sponge$getWorldBorder() {
		return Optional.empty();
	}

	public void sponge$setWorldBorder(@Nullable WorldBorder border, Cause cause) {

	}

	public CooldownTracker sponge$getCooldownTracker() {
		return null;
	}

	public AdvancementProgress sponge$getProgress(Advancement advancement) {
		return null;
	}

	public Collection<AdvancementTree> sponge$getUnlockedAdvancementTrees() {
		return null;
	}

	public void sponge$spawnParticles(ParticleEffect particleEffect, Vector3d position, int radius) {

	}

	public void sponge$playSound(SoundType sound, SoundCategory category, Vector3d position, double volume, double pitch, double minVolume) {

	}

	public void sponge$stopSounds() {

	}

	public void sponge$stopSounds(SoundType sound) {

	}

	public void sponge$stopSounds(SoundCategory category) {

	}

	public void sponge$stopSounds(SoundType sound, SoundCategory category) {

	}

	public void sponge$playMusicDisc(Vector3i position, MusicDisc musicDiscType) {

	}

	public void sponge$stopMusicDisc(Vector3i position) {

	}

	public void sponge$sendTitle(Title title) {

	}

	public void sponge$sendBookView(BookView bookView) {

	}

	public void sponge$sendBlockChange(int x, int y, int z, BlockState state) {

	}

	public void sponge$resetBlockChange(int x, int y, int z) {

	}

	public GameProfile sponge$getProfile() {
		return null;
	}

	public boolean sponge$isOnline() {
		return false;
	}

	public Optional<Player> sponge$getPlayer() {
		return Optional.of((Player)this);
	}

	public Vector3d sponge$getPosition() {
		return null;
	}

	public Optional<UUID> sponge$getWorldUniqueId() {
		return Optional.empty();
	}

	public boolean sponge$setLocation(Vector3d position, UUID world) {
		return false;
	}

	public Inventory sponge$getEnderChestInventory() {
		return null;
	}

	public String sponge$getName() {
		return null;
	}

	public ItemStack sponge$getHelmet() {
		return null;
	}

	public void sponge$setHelmet(ItemStack helmet) {

	}

	public ItemStack sponge$getChestplate() {
		return null;
	}

	public void sponge$setChestplate(ItemStack chestplate) {

	}

	public ItemStack sponge$getLeggings() {
		return null;
	}

	public void sponge$setLeggings(ItemStack leggings) {

	}

	public ItemStack sponge$getBoots() {
		return null;
	}

	public void sponge$setBoots(ItemStack boots) {

	}

	public ItemStack sponge$getItemInHand(HandType handType) {
		return null;
	}

	public void sponge$setItemInHand(HandType hand, ItemStack itemInHand) {

	}

	public boolean sponge$canEquip(EquipmentType type) {
		return false;
	}

	public boolean sponge$canEquip(EquipmentType type, ItemStack equipment) {
		return false;
	}

	public Optional<ItemStack> sponge$getEquipped(EquipmentType type) {
		return Optional.empty();
	}

	public boolean sponge$equip(EquipmentType type, ItemStack equipment) {
		return false;
	}

	public CarriedInventory<? extends Carrier> sponge$getInventory() {
		return null;
	}

	public SubjectCollection sponge$getContainingCollection() {
		return null;
	}

	public SubjectReference sponge$asSubjectReference() {
		return null;
	}

	public boolean sponge$isSubjectDataPersisted() {
		return false;
	}

	public SubjectData sponge$getSubjectData() {
		return null;
	}

	public SubjectData sponge$getTransientSubjectData() {
		return null;
	}

	public Tristate sponge$getPermissionValue(Set<Context> contexts, String permission) {
		return null;
	}

	public boolean sponge$isChildOf(Set<Context> contexts, SubjectReference parent) {
		return false;
	}

	public List<SubjectReference> sponge$getParents(Set<Context> contexts) {
		return null;
	}

	public Optional<String> sponge$getOption(Set<Context> contexts, String key) {
		return Optional.empty();
	}

	public String sponge$getIdentifier() {
		return null;
	}

	public Set<Context> sponge$getActiveContexts() {
		return null;
	}

	public void sponge$sendMessage(ChatType type, Text message) {

	}

	public MessageChannel sponge$getMessageChannel() {
		return null;
	}

	public void sponge$setMessageChannel(MessageChannel channel) {

	}

	public void sponge$remove() {
		throw new UnsupportedOperationException("This is an internal method not intended for use with Players " +
			"as it causes the player to be placed into an undefined state. " +
			"Consider putting them through the normal death process instead.");
	}
}
