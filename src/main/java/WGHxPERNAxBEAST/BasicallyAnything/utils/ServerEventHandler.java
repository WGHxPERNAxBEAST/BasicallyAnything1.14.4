package WGHxPERNAxBEAST.BasicallyAnything.utils;

import WGHxPERNAxBEAST.BasicallyAnything.registries.IFieldRegistryContainer;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ServerEventHandler {
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onEntityCheckSpawn(LivingSpawnEvent.CheckSpawn event)
	{		
		if(event.isSpawner()) return;
		
		Entity entity = event.getEntity();
		World world = entity.getEntityWorld();
		
		IFieldRegistryContainer container = (IFieldRegistryContainer) world.getCapability(ModCaps.FIELD_REGISTRY_CONTAINER, null);
		if(container != null && container.shouldEntityBeBlocked(entity))
            event.setResult(Event.Result.DENY);
	}
}