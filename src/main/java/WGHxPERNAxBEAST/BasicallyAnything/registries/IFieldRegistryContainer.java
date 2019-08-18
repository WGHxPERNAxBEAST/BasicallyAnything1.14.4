package WGHxPERNAxBEAST.BasicallyAnything.registries;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface IFieldRegistryContainer extends INBTSerializable<CompoundNBT>  {
	IFieldRegistry getFieldRegistry();
    boolean shouldEntityBeBlocked(Entity entity);
}