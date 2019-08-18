package WGHxPERNAxBEAST.BasicallyAnything;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import WGHxPERNAxBEAST.BasicallyAnything.blocks.FieldMakerBlock;
import WGHxPERNAxBEAST.BasicallyAnything.client.render.TutRenderRegistry;
import WGHxPERNAxBEAST.BasicallyAnything.config.Config;
import WGHxPERNAxBEAST.BasicallyAnything.items.ItemCustomAxe;
import WGHxPERNAxBEAST.BasicallyAnything.items.ItemCustomPickaxe;
import WGHxPERNAxBEAST.BasicallyAnything.items.ItemFuel;
import WGHxPERNAxBEAST.BasicallyAnything.lists.ArmorMatList;
import WGHxPERNAxBEAST.BasicallyAnything.lists.BiomesList;
import WGHxPERNAxBEAST.BasicallyAnything.lists.BlockList;
import WGHxPERNAxBEAST.BasicallyAnything.lists.ItemList;
import WGHxPERNAxBEAST.BasicallyAnything.lists.ToolMatList;
import WGHxPERNAxBEAST.BasicallyAnything.lists.TutEntities;
import WGHxPERNAxBEAST.BasicallyAnything.proxies.ClientProxy;
import WGHxPERNAxBEAST.BasicallyAnything.proxies.IProxy;
import WGHxPERNAxBEAST.BasicallyAnything.proxies.ServerProxy;
import WGHxPERNAxBEAST.BasicallyAnything.tile_entities.GeneratorBlock;
import WGHxPERNAxBEAST.BasicallyAnything.tile_entities.GeneratorBlockContainer;
import WGHxPERNAxBEAST.BasicallyAnything.tile_entities.GeneratorBlockTile;
import WGHxPERNAxBEAST.BasicallyAnything.world.OreGeneration;
import WGHxPERNAxBEAST.BasicallyAnything.world.TutWorldType;
import WGHxPERNAxBEAST.BasicallyAnything.world.biomes.TutBiome;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("basically_anything_14_beast_mod")
public class main {
	
	public static main instance;
	public static final String modid = "basically_anything_14_beast_mod";
	public static final Logger logger = LogManager.getLogger(modid);
	
	public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
	
	public static final ItemGroup baItemGroup = new GroupClass("ba_items", ItemList.tut_item);
	public static final ItemGroup baBlockGroup = new GroupClass("ba_blocks", ItemList.tut_block);
	public static final ItemGroup baToolAndCombatGroup = new GroupClass("ba_t_and_c", ItemList.tut_pick);
	public static final ItemGroup baMiscGroup = new GroupClass("ba_misc", ItemList.tut_entity_egg);
	
	public static final WorldType worldType = new TutWorldType();
	
	public main() {
		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config, "basically_anything_14_beast_mod-server.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.client_config, "basically_anything_14_beast_mod-client.toml");
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		Config.loadConfig(Config.server_config, "Server", FMLPaths.CONFIGDIR.get().resolve("basically_anything_14_beast_mod-server.toml").toString());
		Config.loadConfig(Config.client_config, "Client", FMLPaths.CONFIGDIR.get().resolve("basically_anything_14_beast_mod-client.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	//pre-init
	private void setup(final FMLCommonSetupEvent event) {
		OreGeneration.setupOreGeneration();
		proxy.init();
		logger.info("Setup method registered.");
	}
	
	//client
	private void clientRegistries(final FMLClientSetupEvent event) {
		TutRenderRegistry.registerEntityRenders();
		logger.info("clientRegistries method registered.");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll (
				ItemList.tut_item = new Item(new Item.Properties().group(baItemGroup)).setRegistryName(location("tut_item")),
				ItemList.tut_nug = new Item(new Item.Properties().group(baItemGroup)).setRegistryName(location("tut_nug")),
				ItemList.tut_dust = new Item(new Item.Properties().group(baItemGroup)).setRegistryName(location("tut_dust")),
				ItemList.blue_steel_ingot = new Item(new Item.Properties().group(baItemGroup)).setRegistryName(location("blue_steel_ingot")),
				ItemList.blue_steel_nug = new Item(new Item.Properties().group(baItemGroup)).setRegistryName(location("blue_steel_nug")),
				ItemList.bs_dust = new Item(new Item.Properties().group(baItemGroup)).setRegistryName(location("bs_dust")),
				
				ItemList.bs_stick = new Item(new Item.Properties().group(baItemGroup)).setRegistryName(location("bs_stick")),
				ItemList.bs_gear = new Item(new Item.Properties().group(baItemGroup)).setRegistryName(location("bs_gear")),
				ItemList.carbon_dust = new ItemFuel(Items.COAL.getBurnTime(new ItemStack(Items.COAL)), new Item.Properties().group(baItemGroup)).setRegistryName(location("carbon_dust")),
				
				ItemList.tut_axe = new ItemCustomAxe(ToolMatList.tut_mat, -1.0F, 6.0F, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("tut_axe")),
				ItemList.tut_hoe = new HoeItem(ToolMatList.tut_mat, 6.0F, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("tut_hoe")),
				ItemList.tut_pick = new ItemCustomPickaxe(ToolMatList.tut_mat, -2, 6.0F, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("tut_pick")),
				ItemList.tut_shovel = new ShovelItem(ToolMatList.tut_mat, -3.0F, 6.0F, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("tut_shovel")),
				ItemList.tut_sword = new SwordItem(ToolMatList.tut_mat, 0, 6.0F, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("tut_sword")),
				
				ItemList.tut_helmet = new ArmorItem(ArmorMatList.tut_mat, EquipmentSlotType.HEAD, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("tut_helmet")),
				ItemList.tut_chestplate = new ArmorItem(ArmorMatList.tut_mat, EquipmentSlotType.CHEST, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("tut_chestplate")),
				ItemList.tut_leggings = new ArmorItem(ArmorMatList.tut_mat, EquipmentSlotType.LEGS, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("tut_leggings")),
				ItemList.tut_boots = new ArmorItem(ArmorMatList.tut_mat, EquipmentSlotType.FEET, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("tut_boots")),
				
				ItemList.bs_axe = new ItemCustomAxe(ToolMatList.bs_mat, -1.0F, 6.0F, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("bs_axe")),
				ItemList.bs_hoe = new HoeItem(ToolMatList.bs_mat, 6.0F, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("bs_hoe")),
				ItemList.bs_pick = new ItemCustomPickaxe(ToolMatList.bs_mat, -2, 6.0F, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("bs_pick")),
				ItemList.bs_shovel = new ShovelItem(ToolMatList.bs_mat, -3.0F, 6.0F, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("bs_shovel")),
				ItemList.bs_sword = new SwordItem(ToolMatList.bs_mat, 0, 6.0F, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("bs_sword")),
				
				ItemList.bs_helmet = new ArmorItem(ArmorMatList.bs_mat, EquipmentSlotType.HEAD, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("bs_helmet")),
				ItemList.bs_chestplate = new ArmorItem(ArmorMatList.bs_mat, EquipmentSlotType.CHEST, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("bs_chestplate")),
				ItemList.bs_leggings = new ArmorItem(ArmorMatList.bs_mat, EquipmentSlotType.LEGS, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("bs_leggings")),
				ItemList.bs_boots = new ArmorItem(ArmorMatList.bs_mat, EquipmentSlotType.FEET, new Item.Properties().group(baToolAndCombatGroup)).setRegistryName(location("bs_boots")),
				
				ItemList.tut_block = new BlockItem(BlockList.tut_block, new Item.Properties().group(baBlockGroup)).setRegistryName(BlockList.tut_block.getRegistryName()),
				ItemList.blue_steel_block = new BlockItem(BlockList.blue_steel_block, new Item.Properties().group(baBlockGroup)).setRegistryName(BlockList.blue_steel_block.getRegistryName()),
				ItemList.carbon_rock = new BlockItem(BlockList.carbon_rock, new Item.Properties().group(baBlockGroup)).setRegistryName(BlockList.carbon_rock.getRegistryName()),
				ItemList.tut_ore = new BlockItem(BlockList.tut_ore, new Item.Properties().group(baBlockGroup)).setRegistryName(BlockList.tut_ore.getRegistryName()),
				ItemList.tut_ore_nether = new BlockItem(BlockList.tut_ore_nether, new Item.Properties().group(baBlockGroup)).setRegistryName(BlockList.tut_ore_nether.getRegistryName()),
				ItemList.tut_ore_end = new BlockItem(BlockList.tut_ore_end, new Item.Properties().group(baBlockGroup)).setRegistryName(BlockList.tut_ore_end.getRegistryName()),
				ItemList.generator = new BlockItem(BlockList.GENERATORBLOCK, new Item.Properties().group(baBlockGroup)).setRegistryName(BlockList.GENERATORBLOCK.getRegistryName()),
				ItemList.field_maker = new BlockItem(BlockList.field_maker, new Item.Properties().group(baBlockGroup)).setRegistryName(BlockList.field_maker.getRegistryName())
			);
			
			TutEntities.registerEntitySpawnEggs(event);
			
			logger.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll (
				BlockList.tut_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F, 3.0F).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("tut_block")),
				BlockList.blue_steel_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 4.0F).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("blue_steel_block")),
				BlockList.carbon_rock = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 3.0F).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("carbon_rock")),
				BlockList.tut_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 3.0F).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("tut_ore")),
				BlockList.tut_ore_nether = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 3.0F).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("tut_ore_nether")),
				BlockList.tut_ore_end = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 3.0F).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("tut_ore_end")),
				BlockList.GENERATORBLOCK = new GeneratorBlock(),
				BlockList.field_maker = new FieldMakerBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 4.0F).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("field_maker"))
			);
			logger.info("Blocks registered.");
		}
		
		@SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().register(TileEntityType.Builder.create(GeneratorBlockTile::new, BlockList.GENERATORBLOCK).build(null).setRegistryName(location("generator")));
        }
		
        @SubscribeEvent
        public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
            event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                return new GeneratorBlockContainer(windowId, main.proxy.getClientWorld(), pos, inv, main.proxy.getClientPlayer());
            }).setRegistryName(location("generator")));
        }
        
		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
			event.getRegistry().registerAll(
					TutEntities.TUT_ENTITY
			);
			TutEntities.registerEntityWorldSpawns();
		}
		
		@SubscribeEvent
		public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
			event.getRegistry().registerAll(
					BiomesList.tut_biome = new TutBiome()
			);
			
			BiomesList.registerBiomes();
		}
		
	}
	
	public static ResourceLocation location(String name) {
		return new ResourceLocation(modid, name);
	}
}
