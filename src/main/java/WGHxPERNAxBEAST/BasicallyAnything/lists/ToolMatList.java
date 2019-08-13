package WGHxPERNAxBEAST.BasicallyAnything.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMatList implements IItemTier{
	tut_mat(10.0F, 9.0F, 800, 3, 25, ItemList.tut_item),
	bs_mat(20.0F, 18.0F, 1600, 6, 25, ItemList.blue_steel_ingot);
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMat;
	
	private ToolMatList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMat) {
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.enchantability = enchantability;
		this.durability = durability;
		this.repairMat = repairMat;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public float getEfficiency() {
		return this.efficiency;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getMaxUses() {
		return this.durability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(this.repairMat);
	}
}
