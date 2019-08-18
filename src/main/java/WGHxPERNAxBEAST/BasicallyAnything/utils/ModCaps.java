package WGHxPERNAxBEAST.BasicallyAnything.utils;

import WGHxPERNAxBEAST.BasicallyAnything.registries.FieldRegistryContainer;
import WGHxPERNAxBEAST.BasicallyAnything.registries.IFieldRegistryContainer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class ModCaps {
	 	@CapabilityInject(IFieldRegistryContainer.class)
	    public static Capability<IFieldRegistryContainer> FIELD_REGISTRY_CONTAINER = null;

	    public static void registerModCaps()
	    {
	        CapabilityManager.INSTANCE.register(IFieldRegistryContainer.class, new GenericNBTStorage<>(), FieldRegistryContainer::new);
	    }
}
