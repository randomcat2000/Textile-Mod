package randomcat.textilemod.recipe;

import net.minecraft.core.block.Block;
import net.minecraft.core.data.DataLoader;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.*;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Arrays;

public class TextileRecipes implements RecipeEntrypoint {

	public final RecipeNamespace TEXTILEMOD = new RecipeNamespace();
	public static final RecipeGroup<RecipeEntryCrafting<?,?>> WORKBENCH = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Block.workbench)));

	@Override
	public void onRecipesReady() {
		TEXTILEMOD.register("workbench", WORKBENCH);
		Registries.RECIPES.register("textilemod", this.TEXTILEMOD);
		DataLoader.loadRecipes("/assets/textilemod/recipe/workbench.json");
		}
	}
