package WGHxPERNAxBEAST.BasicallyAnything.lists;

import WGHxPERNAxBEAST.BasicallyAnything.blocks.FieldMakerBlock;
import WGHxPERNAxBEAST.BasicallyAnything.tile_entities.GeneratorBlock;
import WGHxPERNAxBEAST.BasicallyAnything.tile_entities.GeneratorBlockContainer;
import WGHxPERNAxBEAST.BasicallyAnything.tile_entities.GeneratorBlockTile;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class BlockList {
	public static Block tut_block;
	public static Block blue_steel_block;
	
	public static Block carbon_rock;
	public static Block tut_ore, tut_ore_nether, tut_ore_end;
	
	@ObjectHolder("basically_anything_14_beast_mod:field_maker")
    public static FieldMakerBlock field_maker;
	
	@ObjectHolder("basically_anything_14_beast_mod:generator")
    public static GeneratorBlock GENERATORBLOCK;

    @ObjectHolder("basically_anything_14_beast_mod:generator")
    public static TileEntityType<GeneratorBlockTile> GENERATORBLOCK_TILE;

    @ObjectHolder("basically_anything_14_beast_mod:generator")
    public static ContainerType<GeneratorBlockContainer> GENERATORBLOCK_CONTAINER;
}
