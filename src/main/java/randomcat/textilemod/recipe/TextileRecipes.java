package randomcat.textilemod.recipe;

import net.minecraft.core.data.DataLoader;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeRegistry;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class TextileRecipes implements RecipeEntrypoint {
	/*private void craftingRecipesBlocks(){
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(TextileBlocks.cottonWool,1),new Object[]{new ItemStack(TextileItems.cottonFiber,1),new ItemStack(TextileItems.cottonFiber,1),new ItemStack(TextileItems.cottonFiber,1),new ItemStack(TextileItems.cottonFiber,1)});
	}*/
	public final RecipeNamespace TEXTILEMOD = new RecipeNamespace();

	@Override
	public void onRecipesReady() {
		TEXTILEMOD.register("workbench", Registries.RECIPES.WORKBENCH);
		Registries.RECIPES.register("textilemod", this.TEXTILEMOD);
		DataLoader.loadRecipes("/assets/textilemod/recipe/workbench.json");
		}
	}
