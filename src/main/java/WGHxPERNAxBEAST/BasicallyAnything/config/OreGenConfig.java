package WGHxPERNAxBEAST.BasicallyAnything.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenConfig {
	public static ForgeConfigSpec.BooleanValue gen_tut_overworld;
	public static ForgeConfigSpec.IntValue tut_overworld_chance;

	public static ForgeConfigSpec.BooleanValue gen_carbon_rock;
	public static ForgeConfigSpec.IntValue carbon_rock_chance;
	
	public static ForgeConfigSpec.BooleanValue gen_tut_nether;
	public static ForgeConfigSpec.IntValue tut_nether_chance;
	
	public static ForgeConfigSpec.BooleanValue gen_tut_end;
	public static ForgeConfigSpec.IntValue tut_end_chance;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
		server.comment("Ore-Gen Config");
		gen_tut_overworld = server
				.comment("If false, useless ore will not spawn in the overworld.")
				.define("OreGenConfig.gen_tut_overworld", true);
		tut_overworld_chance = server
				.comment("Max number of ore veins of useless ore which can spawn per chunk in the overworld.")
				.defineInRange("OreGenConfig.tut_overworld_chance", 100, 1, 100000);
		gen_carbon_rock = server
				.comment("If false, Rich Carbonic Rock will not spawn.")
				.define("OreGenConfig.gen_carbon_rock", true);
		carbon_rock_chance = server
				.comment("Max number of ore veins of Rich Carbonic Rock which can spawn per chunk in the overworld.")
				.defineInRange("OreGenConfig.carbon_rock_chance", 100, 1, 100000);
		gen_tut_nether = server
				.comment("If false, useless ore will not spawn in the nether.")
				.define("OreGenConfig.gen_tut_nether", true);
		tut_nether_chance = server
				.comment("Max number of ore veins of useless ore which can spawn per chunk in the nether.")
				.defineInRange("OreGenConfig.tut_nether_chance", 100, 1, 100000);
		gen_tut_end = server
				.comment("If false, useless ore will not spawn in the end.")
				.define("OreGenConfig.gen_tut_end", true);
		tut_end_chance = server
				.comment("Max number of ore veins of useless ore which can spawn per chunk in the end.")
				.defineInRange("OreGenConfig.tut_end_chance", 100, 1, 100000);
	}
}
