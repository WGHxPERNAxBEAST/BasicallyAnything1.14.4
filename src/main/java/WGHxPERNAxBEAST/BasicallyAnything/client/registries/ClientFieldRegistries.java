package WGHxPERNAxBEAST.BasicallyAnything.client.registries;

import java.util.HashMap;

import WGHxPERNAxBEAST.BasicallyAnything.registries.FieldDistanceLogic;

public class ClientFieldRegistries {
	 	private static HashMap<Integer, ClientFieldRegistry> fieldRegistries = new HashMap<>();

	    public static ClientFieldRegistry getRegistryForDimension(int dimensionId)
	    {
	        return fieldRegistries.getOrDefault(dimensionId, new ClientFieldRegistry(FieldDistanceLogic.Cylinder));
	    }

	    public static void clearAll()
	    {
	        fieldRegistries.clear();
	    }
}
