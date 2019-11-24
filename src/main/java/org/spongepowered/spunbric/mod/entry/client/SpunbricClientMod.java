package org.spongepowered.spunbric.mod.entry.client;

import com.google.inject.Module;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.spunbric.launch.FabricLaunch;
import org.spongepowered.spunbric.mod.client.SpunbricClientModule;
import org.spongepowered.spunbric.mod.entry.AbstractSpunbricMod;

@Environment(EnvType.CLIENT)
public class SpunbricClientMod extends AbstractSpunbricMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Since the server does not immediately load in a client context, we can setup, just no loading the integrated server yet.
        FabricLaunch.getLogger().info("Spunbric is initializing in a client environment...");
        prepare();

    }

    @Override
    protected Module getModule() {
        return new SpunbricClientModule();
    }

    @Override
    public MinecraftServer getServer() { // On a client you can get the IntegratedServer from the Client which is statically accessible.
        return MinecraftClient.getInstance().getServer();
    }
}
