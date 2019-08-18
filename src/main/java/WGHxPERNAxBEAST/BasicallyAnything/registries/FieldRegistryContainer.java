package WGHxPERNAxBEAST.BasicallyAnything.registries;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.Constants;

public class FieldRegistryContainer implements IFieldRegistryContainer
{
    private IFieldRegistry FieldRegistry = new FieldRegistry(FieldDistanceLogic.Cylinder)
    {
        @Override
        protected int getFieldRange()
        {
            return 75;
        }
    };

    @Override
    public IFieldRegistry getFieldRegistry()
    {
        return FieldRegistry;
    }

    @Override
    public boolean shouldEntityBeBlocked(Entity entity)
    {
        return FieldRegistry.shouldEntityBeBlocked(entity);
    }

    @Override
    public CompoundNBT serializeNBT()
    {
    	CompoundNBT nbt = new CompoundNBT();
    	nbt.put("field_maker", FieldRegistry.serializeNBT());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt)
    {
        if(nbt.contains("field_maker"))
            FieldRegistry.deserializeNBT(nbt.getList("field_maker", Constants.NBT.TAG_COMPOUND));
    }
}