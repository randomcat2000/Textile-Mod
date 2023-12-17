package randomcat.textilemod.recipe;

import net.minecraft.core.data.DataLoader;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class TextileRecipes implements RecipeEntrypoint {
	/*private void craftingRecipesBlocks(){
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(TextileBlocks.cottonWool,1),new Object[]{new ItemStack(TextileItems.cottonFiber,1),new ItemStack(TextileItems.cottonFiber,1),new ItemStack(TextileItems.cottonFiber,1),new ItemStack(TextileItems.cottonFiber,1)});
	}*/
	@Override
	public void onRecipesReady() {

		DataLoader.loadRecipes("/assets/textilemod/recipe/workbench.json");
		}
	}
