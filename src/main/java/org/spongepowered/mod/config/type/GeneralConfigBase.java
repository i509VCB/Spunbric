package org.spongepowered.mod.config.type;

import ninja.leaping.configurate.objectmapping.Setting;
import org.spongepowered.mod.config.category.DebugCategory;
import org.spongepowered.mod.config.category.EntityActivationRangeCategory;
import org.spongepowered.mod.config.category.EntityCategory;
import org.spongepowered.mod.config.category.EntityCollisionCategory;
import org.spongepowered.mod.config.category.GeneralCategory;
import org.spongepowered.mod.config.category.LoggingCategory;
import org.spongepowered.mod.config.category.PlayerBlockTracker;
import org.spongepowered.mod.config.category.SpawnerCategory;
import org.spongepowered.mod.config.category.TileEntityActivationCategory;
import org.spongepowered.mod.config.category.TimingsCategory;
import org.spongepowered.mod.config.category.WorldCategory;

import java.util.ArrayList;
import java.util.List;

public class GeneralConfigBase extends ConfigBase {

    @Setting
    protected WorldCategory world = new WorldCategory();
    @Setting(value = "player-block-tracker")
    private PlayerBlockTracker playerBlockTracker = new PlayerBlockTracker();
    @Setting
    private DebugCategory debug = new DebugCategory();
    @Setting(value = "entity")
    private EntityCategory entity = new EntityCategory();
    @Setting(value = "entity-activation-range")
    private EntityActivationRangeCategory entityActivationRange = new EntityActivationRangeCategory();
    @Setting(value = "entity-collisions")
    private EntityCollisionCategory entityCollisionCategory = new EntityCollisionCategory();
    @Setting
    private GeneralCategory general = new GeneralCategory();
    @Setting
    private LoggingCategory logging = new LoggingCategory();
    @Setting(value = "spawner", comment = "Used to control spawn limits around players. \n"
            + "Note: The radius uses the lower value of mob spawn range and server's view distance.")
    private SpawnerCategory spawner = new SpawnerCategory();
    @Setting(value = "tileentity-activation")
    private TileEntityActivationCategory tileEntityActivationCategory = new TileEntityActivationCategory();
    @Setting
    private TimingsCategory timings = new TimingsCategory();
    @Setting(value = "world-generation-modifiers", comment = "World Generation Modifiers to apply to the world")
    private final List<String> worldModifiers = new ArrayList<>();

    public PlayerBlockTracker getBlockTracking() {
        return this.playerBlockTracker;
    }

    public DebugCategory getDebug() {
        return this.debug;
    }

    public EntityCategory getEntity() {
        return this.entity;
    }

    public EntityActivationRangeCategory getEntityActivationRange() {
        return this.entityActivationRange;
    }

    public EntityCollisionCategory getEntityCollisionCategory() {
        return this.entityCollisionCategory;
    }

    public GeneralCategory getGeneral() {
        return this.general;
    }

    public LoggingCategory getLogging() {
        return this.logging;
    }

    public SpawnerCategory getSpawner() {
        return this.spawner;
    }

    public WorldCategory getWorld() {
        return this.world;
    }

    public TileEntityActivationCategory getTileEntityActivationRange() {
        return this.tileEntityActivationCategory;
    }

    public TimingsCategory getTimings() {
        return this.timings;
    }

    public List<String> getWorldGenModifiers() {
        return this.worldModifiers;
    }
}
