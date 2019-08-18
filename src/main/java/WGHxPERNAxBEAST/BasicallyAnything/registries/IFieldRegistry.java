package WGHxPERNAxBEAST.BasicallyAnything.registries;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraft.nbt.ListNBT;

public interface IFieldRegistry extends INBTSerializable<ListNBT>
{
    void registerField(BlockPos pos);
    void unregisterField(BlockPos pos);
    boolean shouldEntityBeBlocked(Entity entity);
}