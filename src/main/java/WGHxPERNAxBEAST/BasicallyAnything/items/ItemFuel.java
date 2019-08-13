package WGHxPERNAxBEAST.BasicallyAnything.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemFuel extends Item{
	
	public static int BurnTime;

	public ItemFuel(int burnTime, Properties properties) {
		super(properties);
		BurnTime = burnTime;
	}
	@Override
	public int getBurnTime(ItemStack itemStack) {
		return BurnTime;
	}

}
