package randomcat.textilemod.recipe;

import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.legacy.CraftingManager;
import net.minecraft.core.data.DataLoader;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.*;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.item.ItemStack;
import randomcat.textilemod.block.BlockCottonGin;
import randomcat.textilemod.block.TextileBlocks;
import randomcat.textilemod.item.TextileItems;
import turniplabs.halplibe.helper.RecipeHelper;
import turniplabs.halplibe.util.RecipeEntrypoint;
import java.lang.reflect.*;

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
