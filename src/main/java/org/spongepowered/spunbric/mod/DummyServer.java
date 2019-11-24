package org.spongepowered.spunbric.mod;

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

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class DummyServer implements Server {
    public static final DummyServer DUMMY = new DummyServer();

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
        return 0;
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
        return 0;
    }

    @Override
    public MessageChannel getBroadcastChannel() {
        return null;
    }

    @Override
    public void setBroadcastChannel(MessageChannel channel) {

    }

    @Override
    public Optional<InetSocketAddress> getBoundAddress() {
        return Optional.empty();
    }

    @Override
    public boolean hasWhitelist() {
        return false;
    }

    @Override
    public void setHasWhitelist(boolean enabled) {

    }

    @Override
    public boolean getOnlineMode() {
        return false;
    }

    @Override
    public Text getMotd() {
        return null;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public void shutdown(Text kickMessage) {

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
        return 0;
    }

    @Override
    public void setPlayerIdleTimeout(int timeout) {

    }

    @Override
    public boolean isDedicatedServer() {
        return false;
    }

    @Override
    public Scheduler getScheduler() {
        return null;
    }

    @Override
    public boolean onMainThread() {
        return false;
    }

    @Override
    public void sendMessage(Text message) {

    }

    @Override
    public MessageChannel getMessageChannel() {
        return null;
    }

    @Override
    public void setMessageChannel(MessageChannel channel) {

    }
}
