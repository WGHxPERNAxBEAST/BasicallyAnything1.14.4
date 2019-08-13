package WGHxPERNAxBEAST.BasicallyAnything.world.biomes;

import WGHxPERNAxBEAST.BasicallyAnything.main;
import WGHxPERNAxBEAST.BasicallyAnything.lists.BlockList;
import WGHxPERNAxBEAST.BasicallyAnything.lists.TutEntities;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class TutBiome extends Biome {

	public TutBiome() {
		super(new Biome.Builder()
			.surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(SurfaceBuilder.SWAMP, new SurfaceBuilderConfig(Blocks.BLUE_CONCRETE.getDefaultState(), BlockList.tut_block.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState())))
			.precipitation(RainType.NONE)
			.category(Category.SWAMP)
			.downfall(0.2f)
			.depth(0.145f)
			.temperature(.86f)
			.scale(0.45f)
			.waterColor(0xbf0b0b)
			.waterFogColor(0x6e0303)
			.parent(null));
		
		DefaultBiomeFeatures.addLakes(this);
		DefaultBiomeFeatures.addSwampVegetation(this);
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
		DefaultBiomeFeatures.addStructures(this);
		
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(TutEntities.TUT_ENTITY, 75, 1, 3));
		
		this.setRegistryName(main.location("tut_biome"));
	}

}
