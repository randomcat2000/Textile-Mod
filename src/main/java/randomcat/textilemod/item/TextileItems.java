package randomcat.textilemod.item;

import turniplabs.halplibe.helper.*;
import net.minecraft.core.item.Item;

public class TextileItems {
	private final String MOD_ID = "textilemod";
	public static Item cotton;

	public void itemsInit(){

		cotton = ItemHelper.createItem(MOD_ID, new ItemCotton("cotton",32000), "cotton", "cotton.png");
	}
}
