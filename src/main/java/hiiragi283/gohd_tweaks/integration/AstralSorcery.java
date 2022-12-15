package hiiragi283.gohd_tweaks.integration;

import hellfirepvp.astralsorcery.common.base.WellLiquefaction;
import hellfirepvp.astralsorcery.common.crafting.helper.CraftingAccessManager;
import hiiragi283.gohd_tweaks.util.RagiMap;
import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.awt.*;

public class AstralSorcery {

    static ResourceLocation recipeName;

    //ASとの連携レシピをまとめて登録するメソッド
    public static void Init() {
        RemoveAltarRecipes();
        RegisterLiquefaction();
    }

    //Starlight WellのレシピをWellLiquefaction経由で登録するメソッド
    public static void RegisterLiquefaction() {
        WellLiquefaction(RagiUtils.getStack("tconstruct", "edible", 1, 1), "blueslime", 1.0F, 20);
    }

    //祭壇クラフトのレシピをまとめたメソッド
    public static void RemoveAltarRecipes() {
        //MapAltarRemove内の各keyに対して実行
        for (String key: RagiMap.MapAltarRemove.keySet()) {
            //祭壇クラフトのレシピを削除
            RemoveAltarRecipe(key, RagiMap.MapAltarRemove.get(key));
        }
    }

    //祭壇クラフトのレシピを削除するメソッド
    public static void RemoveAltarRecipe(String name, boolean isShaped) {
        //定形レシピの場合
        if (isShaped) {
            //レシピ名を生成する
            recipeName = new ResourceLocation("astralsorcery", "shaped/" + name);
        } else {
            //不定形レシピのレシピ名を生成する
            recipeName = new ResourceLocation("astralsorcery", "shapeless/" + name);
        }
        //recipeNameから指定したレシピを消す
        CraftingAccessManager.tryRemoveAltarRecipe(recipeName);
    }

    //Starlight Wellのレシピをより簡単に登録するメソッド
    public static void WellLiquefaction(ItemStack stack, String name, float produce, int shatter) {
        WellLiquefaction.registerLiquefaction(stack, RagiUtils.getFluid(name), produce, shatter, new Color(RagiUtils.getFluid(name).getColor()));
    }
}
