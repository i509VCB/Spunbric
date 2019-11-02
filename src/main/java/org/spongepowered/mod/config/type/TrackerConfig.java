package org.spongepowered.mod.config.type;

import ninja.leaping.configurate.objectmapping.Setting;
import org.spongepowered.mod.config.category.BlockTrackerCategory;
import org.spongepowered.mod.config.category.EntityTrackerCategory;
import org.spongepowered.mod.config.category.TileEntityTrackerCategory;

public class TrackerConfig extends ConfigBase {

    /**
     * Used to determine whether block changes will be "captured" until
     * a {@link IPhaseState#unwind(PhaseContext)} is called. Specifically
     * used for certain entities and tile entities where we can expect
     * multiple block changes to take place without negatively affecting
     * expected mechanics, functionality, or performance.
     *
     */
    public static final String BLOCK_BULK_CAPTURE = "block-bulk-capture";
    public static final String ENTITY_BULK_CAPTURE = "entity-bulk-capture";
    /**
     * Used to determine whether block changes will throw an event. This is
     * second priority to {@link #BLOCK_BULK_CAPTURE} as bulk captures take
     * priority. Likewise, some phase states are already strictly performing
     * singular events regardless of whether bulk captures are enabled or not.
     */
    public static final String BLOCK_EVENT_CREATION = "block-event-creation";
    public static final String ENTITY_EVENT_CREATION = "entity-block-creation";

    @Setting("block")
    private BlockTrackerCategory blockTracker = new BlockTrackerCategory();

    @Setting("entity")
    private EntityTrackerCategory entityTracker = new EntityTrackerCategory();

    @Setting("tileentity")
    private TileEntityTrackerCategory tileEntityTracker = new TileEntityTrackerCategory();

    public BlockTrackerCategory getBlockTracker() {
        return this.blockTracker;
    }

    public EntityTrackerCategory getEntityTracker() {
        return this.entityTracker;
    }

    public TileEntityTrackerCategory getTileEntityTracker() {
        return this.tileEntityTracker;
    }
}
