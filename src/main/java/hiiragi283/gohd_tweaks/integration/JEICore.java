package hiiragi283.gohd_tweaks.integration;

import hiiragi283.gohd_tweaks.GOHDInit;
import hiiragi283.gohd_tweaks.integration.jei.SandpaperCategory;
import hiiragi283.gohd_tweaks.integration.jei.SandpaperMaker;
import hiiragi283.gohd_tweaks.integration.jei.SandpaperRecipe;
import hiiragi283.gohd_tweaks.integration.jei.SandpaperWrapper;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JEICore implements IModPlugin {

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        final IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        registry.addRecipeCategories(new SandpaperCategory(guiHelper));
    }

    @Override
    public void register(IModRegistry registry) {
        //JEIタブの実装
        final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        registry.handleRecipes(SandpaperRecipe.class, recipe -> new SandpaperWrapper(recipe), "gohd_tweaks.sandpaper");
        SandpaperMaker.register(registry);
        //catalystの登録
        registry.addRecipeCatalyst(new ItemStack(GOHDInit.ItemSandPaper), "gohd_tweaks.sandpaper");
        registry.addRecipeCatalyst(new ItemStack(GOHDInit.ItemSandPaperDiamond), "gohd_tweaks.sandpaper");
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {
    }

    @Override
    public void registerIngredients(IModIngredientRegistration registry) {
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
    }
}