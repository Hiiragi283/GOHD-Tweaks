package hiiragi283.gohd_tweaks.integration.jei;

import com.google.common.collect.Lists;
import defeatedcrow.hac.core.util.DCUtil;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class SandpaperWrapper implements IRecipeWrapper {

    //private変数の宣言
    public final ItemStack before;
    public final ItemStack after;

    //コンストラクタの宣言
    public SandpaperWrapper(SandpaperRecipe info) {
        before = info.stackBefore;
        after = info.stackAfter;
    }

    //スロットにはめるIIngredientsを定義するメソッド
    @Override
    public void getIngredients(IIngredients ing) {
        //各listの宣言
        List<ItemStack> itemsBefore = Lists.newArrayList();
        List<ItemStack> itemsAfter = Lists.newArrayList();
        //各listにアイテムを登録
        itemsBefore.addAll(getBeforeList());
        itemsAfter.addAll(getAfterList());
        //各listをIIngredientsに設定
        ing.setInputs(VanillaTypes.ITEM, itemsBefore);
        ing.setOutputs(VanillaTypes.ITEM, itemsAfter);
    }

    //
    public ItemStack getBeforeStack() {
        return before;
    }

    //
    public ItemStack getAfterStack() {
        return after;
    }

    //変化前のアイテムのリストを取得するメソッド
    public List<ItemStack> getBeforeList() {
        //retの宣言
        List<ItemStack> ret = Lists.newArrayList();
        //beforeがnullでない場合
        if (!DCUtil.isEmpty(before)) {
            //retにbeforeを追加
            ret.add(before);
        }
        //retを返す
        return ret;
    }

    //変化前のアイテムのリストを取得するメソッド
    public List<ItemStack> getAfterList() {
        //retの宣言
        List<ItemStack> ret = Lists.newArrayList();
        //afterがnullでない場合
        if (!DCUtil.isEmpty(after)) {
            //retにafterを追加
            ret.add(after);
        }
        //retを返す
        return ret;
    }

    @Override
    public void drawInfo(@Nonnull Minecraft mc, int wid, int hei, int mouseX, int mouseY) {
        int baseY = 0;
        //テクスチャをGUI上に乗せる
        //ResourceLocation res = new ResourceLocation("dcs_climate", "textures/gui/c_effective_gui.png");
        //mc.getTextureManager().bindTexture(res);
        //文字列をGUI上に描画する
        //mc.fontRenderer.drawString(recipe.nameBefore, 5, baseY, 0x000000, false);
    }

    //
    @Override
    public List<String> getTooltipStrings(int x, int y) {
        List<String> s = new ArrayList<String>();
        return null;
    }

    //
    @Override
    public boolean handleClick(@Nonnull Minecraft minecraft, int mouseX, int mouseY, int mouseButton) {
        return false;
    }

}