package WGHxPERNAxBEAST.BasicallyAnything.lists;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class BiomesList {
	public static Biome tut_biome;
	
	public static void registerBiomes() {
		registerBiome(tut_biome, Type.MAGICAL);
	}
	
	public static void registerBiome(Biome biome, Type types) {
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
}
