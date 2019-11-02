package org.spongepowered.mod.config;

import org.spongepowered.api.GameState;
import org.spongepowered.mod.SpongeImpl;
import org.spongepowered.mod.config.SpongeConfig;

import java.util.HashSet;
import java.util.Set;

public class FabricConfigSaveManager {
    private final Set<SpongeConfig<?>> stagedConfigs = new HashSet<>();

    public void save(SpongeConfig<?> spongeConfig) {
        synchronized (this) {
            if (!SpongeImpl.isInitialized() || // if we're not initialised, then we're likely testing and should just pass on through.
                    SpongeImpl.getGame().getState() == GameState.SERVER_STARTED || SpongeImpl.getGame().getState() == GameState.GAME_STOPPED) {
                if (!this.stagedConfigs.isEmpty()) {
                    // We want to save and flush now, but add this into the set in case it is already present.
                    this.stagedConfigs.add(spongeConfig);
                    flush();
                } else {
                    // just save
                    spongeConfig.saveNow();
                }
            } else {
                this.stagedConfigs.add(spongeConfig);
            }
        }
    }

    /**
     * Flush a specific config. Returns true if successful or if the config was
     * not in the set. False if there was an error on save.
     *
     * @param config The config to save now
     * @return {@code true} if successful or unneeded, false otherwise.
     */
    public boolean flush(SpongeConfig<?> config) {
        synchronized (this) {
            if (this.stagedConfigs.remove(config)) {
                return config.saveNow();
            }
        }

        return true;
    }

    public void flush() {
        if (!this.stagedConfigs.isEmpty()) {
            synchronized (this) {
                for (SpongeConfig<?> spongeConfig : this.stagedConfigs) {
                    spongeConfig.saveNow();
                }

                this.stagedConfigs.clear();
            }
        }
    }
}
