package randomcat.textilemod.block;

import net.minecraft.client.sound.block.BlockSound;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.block.ItemBlockLayer;
import randomcat.textilemod.TextileMod;
import randomcat.textilemod.block.BlockCottonGin;
import turniplabs.halplibe.helper.BlockBuilder;


public class TextileBlocks {

	public void blockInit(){
		final Block cottonGin = new BlockBuilder(TextileMod.MOD_ID)
			.setBlockSound(BlockSounds.WOOD)
			.setHardness(2.5f)
			.setTopTexture("gintop.png")
			.setBottomTexture("ginbottom.png")
			.setNorthTexture("ginfront.png")
			.setSouthTexture("ginfront.png")
			.setWestTexture("ginside1.png")
			.setEastTexture("ginside2.png")
			.build(new BlockCottonGin("cottongin", 3200, Material.wood)
			.withTags(BlockTags.MINEABLE_BY_AXE));
	}
}
