package randomcat.textilemod.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import randomcat.textilemod.item.ItemCotton;

public class BlockCottonGin extends Block {
	private int timesused = 1;
	public BlockCottonGin(String key, int id, Material material) {
		super(key, id, Material.wood);
	}
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		if (!player.isSneaking()) {
			this.blockActivated(world, x, y, z, player);
		}
	}
	@Override
	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ItemCotton) {
			System.out.println("cotton found" + timesused);
			EntityItem item = world.dropItem(x, y, z, new ItemStack(this));
			timesused++;
		}
		else {
			System.out.println("no cotton found");
		} return super.blockActivated(world, x, y, z, player);
	}
}
