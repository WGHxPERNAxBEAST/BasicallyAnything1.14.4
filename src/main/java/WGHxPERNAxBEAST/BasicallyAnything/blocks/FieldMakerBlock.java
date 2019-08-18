package WGHxPERNAxBEAST.BasicallyAnything.blocks;

import javax.annotation.Nullable;

import WGHxPERNAxBEAST.BasicallyAnything.registries.IFieldRegistryContainer;
import WGHxPERNAxBEAST.BasicallyAnything.utils.ModCaps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;

public class FieldMakerBlock extends Block {

    public FieldMakerBlock(Properties properties) {
        super(properties);
    }
	
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        if (entity != null) {
            world.setBlockState(pos, state.with(BlockStateProperties.FACING, getFacingFromEntity(pos, entity)), 2);
        }
        LazyOptional<IFieldRegistryContainer> container = world.getCapability(ModCaps.FIELD_REGISTRY_CONTAINER, null);
		if(container != null)
			((IFieldRegistryContainer) container).getFieldRegistry().registerField(pos);
    }

    public static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity) {
        return Direction.getFacingFromVector((float) (entity.posX - clickedBlock.getX()), (float) (entity.posY - clickedBlock.getY()), (float) (entity.posZ - clickedBlock.getZ()));
    }
    
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
    }
    
    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
    	super.onBlockHarvested(worldIn, pos, state, player);
    	LazyOptional<IFieldRegistryContainer> container = worldIn.getCapability(ModCaps.FIELD_REGISTRY_CONTAINER, null);
		if(container != null)
			((IFieldRegistryContainer) container).getFieldRegistry().unregisterField(pos);
    }
    
}
