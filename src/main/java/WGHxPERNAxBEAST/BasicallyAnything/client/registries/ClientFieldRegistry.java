package WGHxPERNAxBEAST.BasicallyAnything.client.registries;

import java.util.ArrayList;

import WGHxPERNAxBEAST.BasicallyAnything.registries.IFieldDistanceLogic;
import net.minecraft.util.math.BlockPos;

public class ClientFieldRegistry {
	private ArrayList<BlockPos> fieldes = new ArrayList<>();

    private IFieldDistanceLogic distanceLogic;

    public ClientFieldRegistry(IFieldDistanceLogic distanceLogic)
    {
        this.distanceLogic = distanceLogic;
    }

    public void addfield(BlockPos pos)
    {
        if(!fieldes.contains(pos))
        {
            fieldes.add(pos);
        }
    }

    public void removefield(BlockPos pos)
    {
    	fieldes.remove(pos);
    }

    public boolean isPositionInRange(double posX, double posY, double posZ)
    {
        int fieldRange = 75;

        for(BlockPos field : fieldes)
        {
            if(distanceLogic.isPositionInRange(posX, posY, posZ, field, fieldRange))
                return true;
        }
        return false;
    }
}
