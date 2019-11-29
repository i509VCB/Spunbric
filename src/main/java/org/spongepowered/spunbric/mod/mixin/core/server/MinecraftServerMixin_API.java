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
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;

// TODO Finish Implementation
@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin_API implements Server {
	@Shadow @Final protected Thread serverThread;
	@Shadow private PlayerManager playerManager;
	@Shadow private int ticks;
	@Shadow private int playerIdleTimeout;

	@Shadow public abstract boolean isOnlineMode();
	@Shadow public abstract boolean isDedicated();


	// private MessageChannel broadcastChannel = MessageChannel.toPlayersAndServer(); // TODO MessageFactorys

	@Override
	public WorldManager getWorldManager() {
		return null;
	}

	@Override
	public Collection<Player> getOnlinePlayers() {
		return null;
	}

	@Override
	public int getMaxPlayers() {
		return this.playerManager.getMaxPlayerCount();
	}

	@Override
	public Optional<? extends Player> getPlayer(UUID uniqueId) {
		return Optional.empty();
	}

	@Override
	public Optional<? extends Player> getPlayer(String name) {
		return Optional.empty();
	}

	@Override
	public Optional<? extends Scoreboard> getServerScoreboard() {
		return Optional.empty();
	}

	@Override
	public ChunkLayout getChunkLayout() {
		return null;
	}

	@Override
	public int getRunningTimeTicks() {
		return this.ticks;
	}

	@Override
	public MessageChannel getBroadcastChannel() {
		return null; //return this.broadcastChannel;  // TODO MessageFactorys
	}

	@Override
	public void setBroadcastChannel(MessageChannel channel) {
		// this.broadcastChannel = checkNotNull(channel);  // TODO MessageFactorys
	}

	@Override
	public Optional<InetSocketAddress> getBoundAddress() {
		return Optional.empty();
	}

	@Override
	public boolean hasWhitelist() {
		return this.playerManager.isWhitelistEnabled();
	}

	@Override
	public void setHasWhitelist(boolean enabled) {
		this.playerManager.setWhitelistEnabled(enabled);
	}

	@Override
	public boolean getOnlineMode() {
		return this.isOnlineMode();
	}

	@Override
	public Text getMotd() {
		return null; //Text.of;
	}

	@Override
	public void shutdown() {

	}

	@Override
	public void shutdown(Text kickMessage) {
		for (final Player player : getOnlinePlayers()) {
			player.kick(kickMessage);
		}

	}

	@Override
	public ChunkTicketManager getChunkTicketManager() {
		return null;
	}

	@Override
	public GameProfileManager getGameProfileManager() {
		return null;
	}

	@Override
	public double getTicksPerSecond() {
		return 0;
	}

	@Override
	public Optional<ResourcePack> getDefaultResourcePack() {
		return Optional.empty();
	}

	@Override
	public int getPlayerIdleTimeout() {
		return this.playerIdleTimeout;
	}

	@Override
	public void setPlayerIdleTimeout(int timeout) {
		this.playerIdleTimeout = timeout;
	}

	@Override
	public boolean isDedicatedServer() {
		return this.isDedicated();
	}

	@Override
	public Scheduler getScheduler() {
		return null;
	}

	@Override
	public boolean onMainThread() {
		return this.serverThread == Thread.currentThread();
	}

	@Override
	public void sendMessage(Text message) {

	}

	@Override
	public MessageChannel getMessageChannel() {
		return null;
		// return broadcastChannel;
	}

	@Override
	public void setMessageChannel(MessageChannel channel) {
		// this.broadcastChannel = checkNotNull(channel, "Message channel was null!"); // TODO MessageFactorys
	}
}
