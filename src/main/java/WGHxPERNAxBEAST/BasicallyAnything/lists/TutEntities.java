package WGHxPERNAxBEAST.BasicallyAnything.lists;

import WGHxPERNAxBEAST.BasicallyAnything.main;
import WGHxPERNAxBEAST.BasicallyAnything.entities.TutEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

public class TutEntities {
	
	public static EntityType<?> TUT_ENTITY = EntityType.Builder.create(TutEntity::new, EntityClassification.CREATURE).build(main.modid + ":tut_entity").setRegistryName(main.location("tut_entity"));
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				ItemList.tut_entity_egg = registerEntitySpawnEgg(TUT_ENTITY, 0x0400f7, 0xcf0000, main.baMiscGroup, "tut_entity_egg")
		);
	}
	
	public static void registerEntityWorldSpawns() {
		registerEntityWorldSpawn(TUT_ENTITY, Biomes.PLAINS, Biomes.BEACH, Biomes.MOUNTAINS, BiomesList.tut_biome);
	}
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, ItemGroup itemGroup, String name) {
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(itemGroup));
		item.setRegistryName(main.location(name));
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome...biomes) {
		for (Biome biome : biomes) {
			if (biome != null) {
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 10, 1, 7));
			}
		}
	}
	
}
