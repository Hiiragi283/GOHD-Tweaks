package hiiragi283.gohd_tweaks.integration.jei;

import hiiragi283.gohd_tweaks.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.Objects;

public class SandpaperCategory implements IRecipeCategory {

    private final IDrawableStatic background;

    //JEIタブの背景を設定するメソッド
    public SandpaperCategory(IGuiHelper guiHelper) {
        ResourceLocation location = new ResourceLocation("dcs_climate", "textures/gui/c_mill_gui_jei.png");
        background = guiHelper.createDrawable(location, 10, 20, 150, 40);
    }

    //JEiタブのIDを取得するメソッド
    @Nonnull
    @Override
    public String getUid() {
        return "gohd_tweaks.sandpaper";
    }

    //JEiタブの名前を取得するメソッド
    @Nonnull
    @Override
    public String getTitle() {
        return I18n.format(getUid());
    }

    //JEiタブの背景を取得するメソッド
    @Nonnull
    @Override
    public IDrawable getBackground() {
        return background;
    }

    //なんかエクストラするメソッド
    @Override
    public void drawExtras(@Nonnull Minecraft mc) {
    }

    //JEiタブのアイコンを取得するメソッド?
    @Override
    public IDrawable getIcon() {
        return null;
    }

    //JEiタブにレシピを設定するメソッド
    @Override
    public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper, @Nonnull IIngredients ingredients) {
        if (!(recipeWrapper instanceof SandpaperWrapper)) return;
        SandpaperWrapper wrapper = ((SandpaperWrapper) recipeWrapper);

        //変化前と変化後のアイテムをwrapperから取得
        ItemStack input = wrapper.getBeforeStack();
        ItemStack output = wrapper.getAfterStack();
        //inputとoutputがともにnullでない場合
        if (Objects.nonNull(input) && Objects.nonNull(output)) {
            //inputのスロットを登録
            recipeLayout.getItemStacks().init(0, true, 43, 11);
            recipeLayout.getItemStacks().set(0, input);
            //outputのスロットを登録
            recipeLayout.getItemStacks().init(1, false, 95, 11);
            recipeLayout.getItemStacks().set(1, output);
        }
    }

    //JEiタブに紐づいたmod名を取得するメソッド
    @Nonnull
    @Override
    public String getModName() {
        return Reference.MOD_NAME;
    }
}