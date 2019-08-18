package WGHxPERNAxBEAST.BasicallyAnything.registries;

import net.minecraft.util.math.BlockPos;

public interface IFieldDistanceLogic {
	 boolean isPositionInRange(double posX, double posY, double posZ, BlockPos fieldMakerPos, int range);
}
