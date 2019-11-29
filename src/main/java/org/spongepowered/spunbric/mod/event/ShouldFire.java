package org.spongepowered.spunbric.mod.event;

public class ShouldFire {

	public static boolean PLAYER_CHANGE_CLIENT_SETTINGS_EVENT = false;
	public static boolean CONSTRUCT_ENTITY_EVENT_PRE = false;

	// Format is event class name with underscores
	// For example: SpawnEntityEvent.Spawner becomes SPAWN_ENTITY_EVENT_SPAWNER
	// DropItemEvent becomes DROP_ITEM_EVENT

	// Each boolean includes all super-events
	// For example, if no listeners are registed for SpawnEntityEvent,
	// but one is registered for SpawnEntityEvent.SPAWNER, both
	// SPAWN_ENTITY_EVENT and SPAWN_ENTITY_EVENT_SPAWNER will be true
	// However, SPAWN_ENTITY_EVENT_CHUNK_LOAD will be false
	//
	// Guidlines for users of ShouldFire:
	// You must always check a flag that either corresponds directly
	// to the event you're firing, or to a supertype of the event.
	// For example, when firing DropItemEvent.Dispense, you can check
	// ShouldFire.DROP_ITEM_EVENT_DISPENSE or ShouldFire    .SPAWN_ENTITY_EVENT
	// However, you may *not* check ShouldFire.SPAWN_ENTITY_EVENT_CUSTOM,
	// since SpawnEntityEvent.CUSTOM is not in the hierarchy of DropItemEvent.DISPENSE

	public static boolean A_I_TASK_EVENT_ADD = false;
	public static boolean A_I_TASK_EVENT_REMOVE = false;

	public static boolean ANIMATE_HAND_EVENT = false;

	public static boolean SPAWN_ENTITY_EVENT = false;
	public static boolean SPAWN_ENTITY_EVENT_CHUNK_LOAD = false;
	// public static boolean SPAWN_ENTITY_EVENT_SPAWNER = false; TODO: No Longer exists
	public static boolean SPAWN_ENTITY_EVENT_CUSTOM = false;

	public static boolean CHANGE_BLOCK_EVENT = false;
	public static boolean CHANGE_BLOCK_EVENT_PRE = false;
	public static boolean CHANGE_BLOCK_EVENT_MODIFY = false;
	public static boolean CHANGE_BLOCK_EVENT_BREAK = false;
	public static boolean CHANGE_BLOCK_EVENT_PLACE = false;
	public static boolean CHANGE_BLOCK_EVENT_POST = false;
	public static boolean CHANGE_BLOCK_EVENT_GROW = false;

	// public static boolean CLICK_INVENTORY_EVENT = false; TODO: No Longer exists
	// public static boolean CLICK_INVENTORY_EVENT_DOUBLE = false; TODO: No Longer exists

	public static boolean DESTRUCT_ENTITY_EVENT = false;

	public static boolean DROP_ITEM_EVENT = false;
	public static boolean DROP_ITEM_EVENT_DESTRUCT = false;
	public static boolean DROP_ITEM_EVENT_DISPENSE = false;

	public static boolean MOVE_ENTITY_EVENT = false;
	public static boolean MOVE_ENTITY_EVENT_POSITION = false;

	public static boolean RIDE_ENTITY_EVENT = false;
	public static boolean RIDE_ENTITY_EVENT_MOUNT = false;
	public static boolean RIDE_ENTITY_EVENT_DISMOUNT = false;

	public static boolean ROTATE_ENTITY_EVENT = false;

	public static boolean PRIME_EXPLOSIVE_EVENT_PRE = false;
	public static boolean PRIME_EXPLOSIVE_EVENT_POST = false;

	public static boolean DEFUSE_EXPLOSIVE_EVENT_PRE = false;
	public static boolean DEFUSE_EXPLOSIVE_EVENT_POST = false;

	public static boolean SET_A_I_TARGET_EVENT = false;

	// public static boolean CHANGE_INVENTORY_EVENT_TRANSFER_PRE = false; TODO: No Longer exists
	// public static boolean CHANGE_INVENTORY_EVENT_TRANSFER_POST = false; TODO: No Longer exists

	public static boolean UPDATE_ANVIL_EVENT = false;

	public static boolean TICK_BLOCK_EVENT = false;

	public static boolean IGNITE_ENTITY_EVENT = false;
	public static boolean NOTIFY_NEIGHBOR_BLOCK_EVENT = false;
	public static boolean EXPLOSION_EVENT_PRE = false;
	public static boolean EXPLOSION_EVENT_DETONATE = false;
	public static boolean GAME_REGISTRY_EVENT_REGISTER = false;
	// public static boolean LOAD_CHUNK_EVENT = false; TODO: No Longer exists
	public static boolean COLLIDE_ENTITY_EVENT = false;
	// public static boolean SEND_COMMAND_EVENT = false; TODO: No Longer exists

	// public static boolean BREED_ENTITY_EVENT_READY_TO_MATE = false; TODO: No Longer exists
	// public static boolean BREED_ENTITY_EVENT_FIND_MATE = false; TODO: No Longer exists
	// public static boolean BREED_ENTITY_EVENT_BREED = false; TODO: No Longer exists
	// public static boolean CHANGE_GAME_MODE_EVENT_TARGET_PLAYER = false; TODO: No Longer exists

	public static boolean PLAY_SOUND_EVENT_AT_ENTITY = false;
	public static boolean PLAY_SOUND_EVENT_RECORD = false;
	public static boolean PLAY_SOUND_EVENT_BROADCAST = false;
	// public static boolean PLAY_SOUND_EVENT_NOTE_BLOCK = false; TODO: No Longer exists

}
