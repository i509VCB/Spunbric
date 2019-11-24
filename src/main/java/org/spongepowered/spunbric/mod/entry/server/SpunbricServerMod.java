package org.spongepowered.spunbric.mod.entry.server;

import com.google.inject.Module;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.spunbric.launch.FabricLaunch;
import org.spongepowered.spunbric.mod.dedicated.SpunbricServerModule;
import org.spongepowered.spunbric.mod.entry.AbstractSpunbricMod;

public class SpunbricServerMod extends AbstractSpunbricMod implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        FabricLaunch.getLogger().info("Spunbric is initializing in a server environment...");
        prepare();
    }

    @Override
    protected Module getModule() {
        return new SpunbricServerModule();
    }

    @Override
    public MinecraftServer getServer() {
        return (MinecraftServer) FabricLoader.getInstance().getGameInstance(); // On a server environment, this is a MinecraftDedicatedServer and will return the instance of the Server.
    }
}
