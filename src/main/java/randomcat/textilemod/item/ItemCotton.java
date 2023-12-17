package randomcat.textilemod.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import randomcat.textilemod.block.BlockCottonGin;

public class ItemCotton extends Item {
		ItemCotton(String name, int id) {
			super(name, id);
			this.maxStackSize = 64;
		}
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		if (world.getBlockId(blockX, blockY, blockZ) == 3200) {
			itemstack.consumeItem(entityplayer);
		} return true;
	}
}
