package WGHxPERNAxBEAST.BasicallyAnything.registries;

public class FieldDistanceLogic {
	 public static IFieldDistanceLogic Cylinder = (posX, posY, posZ, fieldMaker, range) ->
	    {
	        double dx = fieldMaker.getX() + 0.5 - posX;
	        double dz = fieldMaker.getZ() + 0.5 - posZ;
	        return (dx * dx + dz * dz) <= range;
	    };
}
