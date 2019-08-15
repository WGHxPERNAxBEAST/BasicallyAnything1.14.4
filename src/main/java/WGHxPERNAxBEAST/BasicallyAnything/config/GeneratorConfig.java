package WGHxPERNAxBEAST.BasicallyAnything.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class GeneratorConfig {
	
    public static ForgeConfigSpec.IntValue GENERATORBLOCK_MAXPOWER;
    public static ForgeConfigSpec.IntValue GENERATORBLOCK_GENERATE;
    public static ForgeConfigSpec.IntValue GENERATORBLOCK_SEND;
    public static ForgeConfigSpec.IntValue GENERATORBLOCK_TICKS;
    
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
		server.comment("Coal Dust Generator Config");
		GENERATORBLOCK_MAXPOWER = server.comment("Maximum power for the Carbon Dust Generator")
	                .defineInRange("maxPower", 100000, 0, Integer.MAX_VALUE);
	    GENERATORBLOCK_GENERATE = server.comment("Power generation per coal dust")
	                .defineInRange("generate", 1000, 0, Integer.MAX_VALUE);
	    GENERATORBLOCK_SEND = server.comment("Power generation to send per tick")
	                .defineInRange("send", 100, 0, Integer.MAX_VALUE);
	    GENERATORBLOCK_TICKS = server.comment("Ticks per coal dust")
	                .defineInRange("ticks", 20, 0, Integer.MAX_VALUE);
	}
}
