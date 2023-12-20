package randomcat.textilemod.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class ItemCottonSeeds extends Item {
	private int cropsId;

	public ItemCottonSeeds(String name, int id, Block cropsBlock) {
		super(name, id);
		this.cropsId = 3202;
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		if (!world.canPlaceInsideBlock(blockX, blockY, blockZ)) {
			blockX += side.getOffsetX();
			blockY += side.getOffsetY();
			blockZ += side.getOffsetZ();
		}
		if (world.getBlockId(blockX, blockY - 1, blockZ) == Block.farmlandDirt.id && world.canPlaceInsideBlock(blockX, blockY, blockZ)) {
			world.setBlockWithNotify(blockX, blockY, blockZ, this.cropsId);
			world.playBlockSoundEffect((float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, Block.blocksList[this.cropsId], EnumBlockSoundEffectType.PLACE);
			itemstack.consumeItem(entityplayer);
			return true;
		}
		return false;
	}
}
