package hiiragi283.gohd_tweaks.integration;

import hellfirepvp.astralsorcery.common.base.WellLiquefaction;
import hellfirepvp.astralsorcery.common.crafting.helper.CraftingAccessManager;
import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

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

        //祭壇クラフトのレシピマップの定義
        Map<String, Boolean> MapAltarRemove = new HashMap<String, Boolean>() {
            {
                //MapAltarRemoveにレシピを書き込んでいく
                put("block_black_marble_chiseled_wall", true);
                put("block_black_marble_engraved_wall", true);
                put("block_black_marble_runed_wall", true);
                put("block_black_marble_wall", true);
                put("block_infused_wood_fence", true);
                put("block_infused_wood_fence_gate", true);
                put("block_marble_arch_wall", true);
                put("block_marble_brick_wall", true);
                put("block_marble_chiseled_wall", true);
                put("block_marble_engraved_wall", true);
                put("block_marble_runed_wall", true);
                put("block_marble_wall", true);
                put("block_starmetal", true);
                put("infused_wood_arch", true);
                put("infused_wood_column", true);
                put("infused_wood_engraved", true);
                put("infused_wood_planks", false);
                put("ingot_starmetal", true);
                put("internal/altar/black_marble_arch", true);
                put("internal/altar/black_marble_bricks", true);
                put("internal/altar/black_marble_chiseled", true);
                put("internal/altar/black_marble_engraved", true);
                put("internal/altar/black_marble_pillar", true);
                put("internal/altar/black_marble_runed", true);
                put("internal/altar/marble_arch", true);
                put("internal/altar/marble_bricks", true);
                put("internal/altar/marble_chiseled", true);
                put("internal/altar/marble_engraved", true);
                put("internal/altar/marble_pillar", true);
                put("internal/altar/marble_runed", true);
                put("marble_slab", true);
                put("marble_stairs", true);
                put("block_black_marble_arch_wall", true);
                put("block_black_marble_brick_wall", true);
            }
        };

        //MapAltarRemove内の各keyに対して実行
        for (String key : MapAltarRemove.keySet()) {
            //祭壇クラフトのレシピを削除
            RemoveAltarRecipe(key, MapAltarRemove.get(key));
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
