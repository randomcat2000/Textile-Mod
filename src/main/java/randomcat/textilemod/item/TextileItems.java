package randomcat.textilemod.item;

import turniplabs.halplibe.helper.*;
import net.minecraft.core.item.Item;

public class TextileItems {

	private final String MOD_ID = "textilemod";

	public static Item cotton;
	public static Item cottonSeeds;
	public static Item cottonFiber;

	public void itemsInit(){

		cotton = ItemHelper.createItem(MOD_ID, new ItemCotton("cotton",32000), "cotton", "cotton.png");
		cottonSeeds = ItemHelper.createItem(MOD_ID, new ItemCotton("cottonSeeds",32001), "cottonSeeds", "cottonseeds.png");
		cottonFiber = ItemHelper.createItem(MOD_ID, new ItemCotton("cottonFiber",32002), "cottonFiber", "cottonfiber.png");
	}
}
