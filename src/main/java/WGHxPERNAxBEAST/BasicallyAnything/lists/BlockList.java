package WGHxPERNAxBEAST.BasicallyAnything.lists;

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
	
	@ObjectHolder("main.generator")
    public static GeneratorBlock GENERATORBLOCK;

    @ObjectHolder("main.generator")
    public static TileEntityType<GeneratorBlockTile> GENERATORBLOCK_TILE;

    @ObjectHolder("main.generator")
    public static ContainerType<GeneratorBlockContainer> GENERATORBLOCK_CONTAINER;
}
