package randomcat.textilemod.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import randomcat.textilemod.item.ItemCotton;

import static randomcat.textilemod.item.TextileItems.*;

public class BlockCottonGin extends Block {
	//Debug variable
	private int timesused = 1;
	//"a" for "again"
	private byte a = 1;
	public BlockCottonGin(String key, int id, Material material) {
		super(key, id, Material.wood);
	}

	//Spit out 4 seeds and 4 fibers for each cotton item. TODO: control direction
	@Override
	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ItemCotton) {
			//debug stuff
			System.out.println("cotton found" + timesused);
			timesused++;
			EntityItem item = world.dropItem(x, y, z, new ItemStack(cottonSeeds));
			//Do 4 times
			for (a = 1; a < 5; a++){
				item = world.dropItem(x, y, z, new ItemStack(cottonFiber));
			}
		}
		else {
			System.out.println("no cotton found");
		} return super.blockActivated(world, x, y, z, player);
	}
}
