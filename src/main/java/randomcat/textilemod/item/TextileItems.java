package randomcat.textilemod.item;

import net.minecraft.core.item.ItemSeeds;
import randomcat.textilemod.item.ItemCottonSeeds;
import randomcat.textilemod.block.TextileBlocks;
import turniplabs.halplibe.helper.*;
import net.minecraft.core.item.Item;

public class TextileItems {

	private final String MOD_ID = "textilemod";

	public static Item cotton;
	public static Item cottonSeeds;
	public static Item cottonFiber;

	public void itemsInit(){

		cotton = ItemHelper.createItem(MOD_ID, new ItemCotton("cotton",32000), "cotton", "cotton.png");
		cottonSeeds = ItemHelper.createItem(MOD_ID, new ItemCottonSeeds("cottonSeeds",32001, TextileBlocks.cottonCrop), "cottonSeeds", "cottonseeds.png");
		cottonFiber = ItemHelper.createItem(MOD_ID, new Item("cottonFiber",32002), "cottonFiber", "cottonfiber.png");
	}
}
