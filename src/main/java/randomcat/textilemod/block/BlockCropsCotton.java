package randomcat.textilemod.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFlower;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.provider.BiomeProvider;
import org.lwjgl.Sys;
import randomcat.textilemod.TextileMod;
import randomcat.textilemod.item.TextileItems;
import turniplabs.halplibe.helper.TextureHelper;

import java.util.Random;

import static net.minecraft.core.world.season.Seasons.*;

public class BlockCropsCotton extends BlockFlower {

	public BlockCropsCotton(String key, int id) {
		super(key, id);
		this.setTicking(true);
		float f = 0.5f;
		this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
	}
	int[] stage0 = TextureHelper.getOrCreateBlockTexture(TextileMod.MOD_ID, "cotton_stage1ph.png");
	int[] stage1 = TextureHelper.getOrCreateBlockTexture(TextileMod.MOD_ID, "cotton_stage2ph.png");
	int[] stage2 = TextureHelper.getOrCreateBlockTexture(TextileMod.MOD_ID, "cotton_stage3ph.png");
	int[] stage3 = TextureHelper.getOrCreateBlockTexture(TextileMod.MOD_ID, "cotton_stage4ph.png");
	int[] stage4 = TextureHelper.getOrCreateBlockTexture(TextileMod.MOD_ID, "cotton_stage5ph.png");
	int[] stage5 = TextureHelper.getOrCreateBlockTexture(TextileMod.MOD_ID, "cotton_stage6ph.png");
	public final int[] growthStageTextures = new int[]{texCoordToIndex(stage0[0], stage0[1]), texCoordToIndex(stage1[0], stage1[1]), texCoordToIndex(stage2[0], stage2[1]), texCoordToIndex(stage3[0], stage3[1]), texCoordToIndex(stage4[0], stage4[1]), texCoordToIndex(stage5[0], stage5[1])};
	@Override
	public boolean canThisPlantGrowOnThisBlockID(int i) {
		return i == Block.farmlandDirt.id;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		float f;
		int l;
		super.updateTick(world, x, y, z, rand);
		if (world.getBlockLightValue(x, y + 1, z) >= 12 && (l = world.getBlockMetadata(x, y, z)) < 6 && rand.nextInt((int)(100.0f / (f = this.getGrowthRate(world, x, y, z)))) == 0) {
			world.setBlockMetadataWithNotify(x, y, z, ++l);
		}
	}

	private float getGrowthRate(World world, int x, int y, int z) {
		float growthRate = (float) ((world.getBlockTemperature(x, y)) * 10);

		int idNegZ = world.getBlockId(x, y, z - 1);
		int idPosZ = world.getBlockId(x, y, z + 1);
		int idNegX = world.getBlockId(x - 1, y, z);
		int idPosX = world.getBlockId(x + 1, y, z);
		int idNegZNegX = world.getBlockId(x - 1, y, z - 1);
		int idPosZPosX = world.getBlockId(x + 1, y, z + 1);
		int idNegXPosZ = world.getBlockId(x - 1, y, z + 1);
		int idPosXNegZ = world.getBlockId(x + 1, y, z - 1);
		float growthRateMod = 0.0f;
		char alignment = (idNegZ == this.id || idPosZ == this.id) ? 'Z' : 'X';
		if ((!(idNegZ == this.id) && !(idPosZ == this.id) && !(idNegX == this.id) && !(idPosX == this.id)) || (idNegZNegX == this.id || idPosZPosX == this.id || idNegXPosZ == this.id || idPosXNegZ == this.id)) {
            alignment = 'n';
        }
		//check row
		switch (alignment) {
			case 'Z':
				growthRateMod = (idNegZ == this.id && idPosZ == this.id) ? 2.0f : 1.0f;
				break;
			case 'X':
                growthRateMod = (idNegX == this.id && idPosX == this.id) ? 2.0f : 1.0f;
				break;
			default:
				break;
		}
		growthRate += growthRateMod;
		if (world.seasonManager.getCurrentSeason() != null) {
			if (world.seasonManager.getCurrentSeason() != OVERWORLD_SUMMER) {
				growthRate /= 2.0f;
			}
		}
		//grows best in sunlight
		if (!(world.getBlockLightValue(x, y, z) == 15)) {
			growthRate /= 2.0f;
		}
		return growthRate;
	}


	@Override
	public int getBlockTextureFromSideAndMetadata(Side side, int meta) {
		if (meta < 0 || meta > 5) {
			meta = 5;
		}
		return this.growthStageTextures[meta];
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		if (meta != 5) {
			return new ItemStack[]{new ItemStack(TextileItems.cottonSeeds)};
		}
		return new ItemStack[]{new ItemStack(TextileItems.cotton, world.rand.nextInt(2) + 2)};
	}
	//debug option
	/*@Override
	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		int l = world.getBlockMetadata(x, y, z);
		if (player.isSneaking()) {
			if (world.getBlockLightValue(x, y + 1, z) >= 12 && (l = world.getBlockMetadata(x, y, z)) < 5) {
				world.setBlockMetadataWithNotify(x, y, z, ++l);
			}
		}
		System.out.println("growth rate: " + getGrowthRate(world, x, y, z) + " temperature: " + world.getBlockTemperature(x, y));
		return true;
	}*/
}
