package WGHxPERNAxBEAST.BasicallyAnything.lists;

import WGHxPERNAxBEAST.BasicallyAnything.main;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMatList implements IArmorMaterial {
	tut_mat("tut", 400, new int[] {8, 10, 9, 7}, 25, ItemList.tut_item, "entity.ender_dragon.growl", 1.5F),
	bs_mat("bs", 800, new int[] {16, 20, 18, 14}, 25, ItemList.blue_steel_ingot, "entity.ender_dragon.growl", 3.0F);
	
	private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
	private String name, equipSound;
	private int durability, enchantability;
	private int[] damageReductionAmounts;
	private Item repairItem;
	private float toughness;
	
	private ArmorMatList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness) {
		this.name = name;
		this.durability = durability;
		this.damageReductionAmounts = damageReductionAmounts;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.repairItem = repairItem;
		this.toughness = toughness;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) {
		return this.damageReductionAmounts[slot.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slot) {
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public String getName() {
		return main.modid + ":" + this.name;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public SoundEvent getSoundEvent() {
		return new SoundEvent(new ResourceLocation(this.equipSound));
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}
}
