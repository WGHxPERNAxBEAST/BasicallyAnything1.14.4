package WGHxPERNAxBEAST.BasicallyAnything.registries;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.math.BlockPos;

abstract class FieldRegistry implements IFieldRegistry
{
    private final List<BlockPos> Fieldes = new ArrayList<>();

    protected abstract int getFieldRange();

    private IFieldDistanceLogic distanceLogic;

    public FieldRegistry(IFieldDistanceLogic distanceLogic)
    {
        this.distanceLogic = distanceLogic;
    }

    @Override
    public final void registerField(BlockPos pos)
    {
        if(!Fieldes.contains(pos))
            Fieldes.add(pos);
    }

    @Override
    public final void unregisterField(BlockPos pos)
    {
        Fieldes.remove(pos);
    }

    @Override
    public final boolean shouldEntityBeBlocked(Entity entity)
    {
        return isPositionInFieldRange(entity.posX, entity.posY, entity.posZ);
    }

    private boolean isPositionInFieldRange(double posX, double posY, double posZ)
    {
        int FieldRange = getFieldRange();

        for(BlockPos Field : Fieldes)
        {
            if(distanceLogic.isPositionInRange(posX, posY, posZ, Field, FieldRange))
                return true;
        }
        return false;
    }
    @Override
    public ListNBT serializeNBT()
    {
    	ListNBT tagList = new ListNBT();
        for(BlockPos loc : this.Fieldes)
            tagList.add(NBTUtil.writeBlockPos(loc));
        return tagList;
    }

    @Override
    public void deserializeNBT(ListNBT list)
    {
        for(int i = 0; i < list.size(); i++)
        {
        	CompoundNBT entry = list.getCompound(i);
            BlockPos loc = NBTUtil.readBlockPos(entry);
            this.registerField(loc);
        }
    }
}