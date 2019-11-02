package org.spongepowered.mod.config.type;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import ninja.leaping.configurate.objectmapping.Setting;
import org.spongepowered.mod.config.category.BrokenModCategory;
import org.spongepowered.mod.config.category.BungeeCordCategory;
import org.spongepowered.mod.config.category.CommandsCategory;
import org.spongepowered.mod.config.category.ExploitCategory;
import org.spongepowered.mod.config.category.GlobalGeneralCategory;
import org.spongepowered.mod.config.category.GlobalWorldCategory;
import org.spongepowered.mod.config.category.MetricsCategory;
import org.spongepowered.mod.config.category.ModuleCategory;
import org.spongepowered.mod.config.category.MovementChecksCategory;
import org.spongepowered.mod.config.category.OptimizationCategory;
import org.spongepowered.mod.config.category.PermissionCategory;
import org.spongepowered.mod.config.category.PhaseTrackerCategory;
import org.spongepowered.mod.config.category.SqlCategory;
import org.spongepowered.mod.config.category.TeleportHelperCategory;
import org.spongepowered.mod.util.IpSet;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

public class GlobalConfig extends GeneralConfigBase {

    @Setting(comment = "Configuration options related to the Sql service, including connection aliases etc")
    private SqlCategory sql = new SqlCategory();

    @Setting
    private CommandsCategory commands = new CommandsCategory();

    @Setting
    private PermissionCategory permission = new PermissionCategory();

    @Setting(value = "modules")
    private ModuleCategory mixins = new ModuleCategory();

    @Setting("ip-sets")
    private Map<String, List<IpSet>> ipSets = new HashMap<>();

    @Setting(value = "bungeecord")
    private BungeeCordCategory bungeeCord = new BungeeCordCategory();

    @Setting
    private ExploitCategory exploits = new ExploitCategory();

    @Setting(value = "optimizations")
    private OptimizationCategory optimizations = new OptimizationCategory();

    @Setting
    protected GlobalGeneralCategory general = new GlobalGeneralCategory();

    @Setting
    protected GlobalWorldCategory world = new GlobalWorldCategory();

    @Setting(value = "cause-tracker")
    private PhaseTrackerCategory causeTracker = new PhaseTrackerCategory();

    @Setting(value = "teleport-helper", comment = "Blocks to blacklist for safe teleportation.")
    private TeleportHelperCategory teleportHelper = new TeleportHelperCategory();

    @Setting("movement-checks")
    private MovementChecksCategory movementChecks = new MovementChecksCategory();

    @Setting(value = "broken-mods", comment = "Stopgap measures for dealing with broken mods")
    private BrokenModCategory brokenMods = new BrokenModCategory();

    @Setting(value = "metrics")
    private MetricsCategory metricsCategory = new MetricsCategory();

    public GlobalConfig() {
        super();
    }

    public BrokenModCategory getBrokenMods() {
        return this.brokenMods;
    }

    public BungeeCordCategory getBungeeCord() {
        return this.bungeeCord;
    }

    public SqlCategory getSql() {
        return this.sql;
    }

    public CommandsCategory getCommands() {
        return this.commands;
    }

    public PermissionCategory getPermission() {
        return this.permission;
    }

    public ModuleCategory getModules() {
        return this.mixins;
    }

    public Map<String, Predicate<InetAddress>> getIpSets() {
        return ImmutableMap.copyOf(Maps.transformValues(this.ipSets, new Function<List<IpSet>, Predicate<InetAddress>>() {
            @Nullable
            @Override
            public Predicate<InetAddress> apply(List<IpSet> input) {
                return Predicates.and(input);
            }
        }));
    }


    public ExploitCategory getExploits() {
        return this.exploits;
    }

    public OptimizationCategory getOptimizations() {
        return this.optimizations;
    }

    public Predicate<InetAddress> getIpSet(String name) {
        return this.ipSets.containsKey(name) ? Predicates.and(this.ipSets.get(name)) : null;
    }

    @Override
    public GlobalGeneralCategory getGeneral() {
        return this.general;
    }

    @Override
    public GlobalWorldCategory getWorld() {
        return this.world;
    }

    public PhaseTrackerCategory getPhaseTracker() {
        return this.causeTracker;
    }

    public TeleportHelperCategory getTeleportHelper() {
        return this.teleportHelper;
    }

    public MovementChecksCategory getMovementChecks() {
        return this.movementChecks;
    }

    public MetricsCategory getMetricsCategory() {
        return this.metricsCategory;
    }
}
