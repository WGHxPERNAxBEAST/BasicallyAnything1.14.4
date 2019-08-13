package WGHxPERNAxBEAST.BasicallyAnything.world;

import WGHxPERNAxBEAST.BasicallyAnything.lists.BiomesList;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

public class TutWorldType extends WorldType {

	public TutWorldType() {
		super("tut_type");
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator(World world) {
		OverworldGenSettings settings = new OverworldGenSettings();
		SingleBiomeProviderSettings single = new SingleBiomeProviderSettings();
		single.setBiome(BiomesList.tut_biome);
		return new OverworldChunkGenerator(world, new SingleBiomeProvider(single), settings);
	}

}
