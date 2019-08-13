package WGHxPERNAxBEAST.BasicallyAnything.world;

import WGHxPERNAxBEAST.BasicallyAnything.config.OreGenConfig;
import WGHxPERNAxBEAST.BasicallyAnything.lists.BlockList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {
	
	public static void setupOreGeneration() {
		for(Biome biome : ForgeRegistries.BIOMES) {
			if (OreGenConfig.gen_tut_overworld.get()) {
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.tut_ore.getDefaultState(), OreGenConfig.tut_overworld_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(6, 20, 0, 60)));
			}
			if (OreGenConfig.gen_carbon_rock.get()) {
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.carbon_rock.getDefaultState(), OreGenConfig.carbon_rock_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(6, 20, 0, 80)));
			}
			if (OreGenConfig.gen_tut_nether.get()) {
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK, BlockList.tut_ore_nether.getDefaultState(), OreGenConfig.tut_nether_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(8, 20, 0, 100)));
			}
			if (OreGenConfig.gen_tut_end.get()) {
				//biome.addFeature(Decoration.UNDERGROUND_ORES, new ConfiguredFeature<OreFeatureConfig>(Feature.ORE, new OreFeatureConfig(FillerBlockType, BlockList.tut_ore.getDefaultState(), OreGenConfig.tut_overworld_chance.get())));
				}
		}
	}
}
