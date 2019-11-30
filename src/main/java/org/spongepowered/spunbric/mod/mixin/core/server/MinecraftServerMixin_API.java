package org.spongepowered.spunbric.mod.mixin.core.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.profile.GameProfileManager;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.server.Server;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.world.WorldManager;
import org.spongepowered.api.world.chunk.ChunkTicketManager;
import org.spongepowered.api.world.storage.ChunkLayout;
import org.spongepowered.asm.mixin.*;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;

// TODO Finish Implementation
@Mixin(MinecraftServer.class)
@Implements(@Interface(iface = Server.class, prefix = "sponge$"))
public abstract class MinecraftServerMixin_API {
	@Shadow @Final protected Thread serverThread;
	@Shadow private PlayerManager playerManager;
	@Shadow private int ticks;
	@Shadow private int playerIdleTimeout;

	@Shadow public abstract boolean isOnlineMode();
	@Shadow public abstract boolean isDedicated();


	// private MessageChannel broadcastChannel = MessageChannel.toPlayersAndServer(); // TODO MessageFactorys

	@Shadow protected abstract void shutdown();

	@Shadow public abstract String getServerMotd();

	public WorldManager sponge$getWorldManager() {
		return null;
	}

	public Collection<Player> sponge$getOnlinePlayers() {
		return null;
	}

	public int sponge$getMaxPlayers() {
		return this.playerManager.getMaxPlayerCount();
	}

	public Optional<? extends Player> sponge$getPlayer(UUID uniqueId) {
		return Optional.empty();
	}

	public Optional<? extends Player> sponge$getPlayer(String name) {
		return Optional.empty();
	}

	public Optional<? extends Scoreboard> sponge$getServerScoreboard() {
		return Optional.empty();
	}

	public ChunkLayout sponge$getChunkLayout() {
		return null;
	}

	public int sponge$getRunningTimeTicks() {
		return this.ticks;
	}

	public MessageChannel sponge$getBroadcastChannel() {
		return null; //return this.broadcastChannel;  // TODO MessageFactorys
	}

	public void sponge$setBroadcastChannel(MessageChannel channel) {
		// this.broadcastChannel = checkNotNull(channel);  // TODO MessageFactorys
	}

	public Optional<InetSocketAddress> sponge$getBoundAddress() {
		return Optional.empty();
	}

	public boolean sponge$hasWhitelist() {
		return this.playerManager.isWhitelistEnabled();
	}

	public void sponge$setHasWhitelist(boolean enabled) {
		this.playerManager.setWhitelistEnabled(enabled);
	}

	public boolean sponge$getOnlineMode() {
		return this.isOnlineMode();
	}

	public Text sponge$getMotd() {
		return Text.of(this.getServerMotd());
	}

	@Intrinsic
	public void sponge$shutdown() {
		this.shutdown();
	}

	public void sponge$shutdown(Text kickMessage) {
		for (final Player player : sponge$getOnlinePlayers()) {
			player.kick(kickMessage);
		}
		this.shutdown();
	}

	public ChunkTicketManager sponge$getChunkTicketManager() {
		return null;
	}

	public GameProfileManager sponge$getGameProfileManager() {
		return null;
	}

	public double sponge$getTicksPerSecond() {
		return 0;
	}

	public Optional<ResourcePack> sponge$getDefaultResourcePack() {
		return Optional.empty();
	}

	public int sponge$getPlayerIdleTimeout() {
		return this.playerIdleTimeout;
	}

	public void sponge$setPlayerIdleTimeout(int timeout) {
		this.playerIdleTimeout = timeout;
	}

	public boolean sponge$isDedicatedServer() {
		return this.isDedicated();
	}

	public Scheduler sponge$getScheduler() {
		return null;
	}

	public boolean sponge$onMainThread() {
		return this.serverThread == Thread.currentThread();
	}

	public void sponge$sendMessage(Text message) {

	}

	public MessageChannel sponge$getMessageChannel() {
		return null;
		// return broadcastChannel;
	}

	public void sponge$setMessageChannel(MessageChannel channel) {
		// this.broadcastChannel = checkNotNull(channel, "Message channel was null!"); // TODO MessageFactorys
	}
}
