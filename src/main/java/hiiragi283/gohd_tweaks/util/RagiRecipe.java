package hiiragi283.gohd_tweaks.util;

import defeatedcrow.hac.core.util.DCUtil;
import hiiragi283.gohd_tweaks.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

public class RagiRecipe {

    //不定形レシピに鉱石辞書をねじ込むメソッド
    public static Ingredient setOreDict(String oreDict) {
        //鉱石辞書からItemStackのリストを取得
        NonNullList<ItemStack> stacks = OreDictionary.getOres(oreDict);
        //結合用のリストを宣言
        Collection<Ingredient> listIngredients = new ArrayList<Ingredient>();
        //stacks内の各keyに対して実行
        for (ItemStack stack : stacks) {
            //listIngredientsにItemStackを足していく
            listIngredients.add(Ingredient.fromStacks(stack));
        }
        //listIngredientを1つのIngredientにまとめる
        return Ingredient.merge(listIngredients);
    }

    //かまどレシピを追加するメソッド
    public static void addFurnace(ItemStack output, ItemStack input) {
        GameRegistry.addSmelting(input, output, 0);
        RagiLogger.infoDebug("The smelting recipe " + RagiUtils.stackToBracket(input) + " -> " + RagiUtils.stackToBracket(output) + " was added successfully!");
    }

    //かまどレシピを削除するメソッド
    public static void removeFurnace(ItemStack output) {
        //かまどレシピのマップを取得する
        Map<ItemStack, ItemStack> mapFurnace = FurnaceRecipes.instance().getSmeltingList();
        //インプットのイテレータを取得する
        Iterator<ItemStack> iteratorFurnace = mapFurnace.keySet().iterator();
        //イテレータの各要素について実行する
        while(iteratorFurnace.hasNext()) {
            //完成品が一致する場合
            if(DCUtil.isSameItem(mapFurnace.get(iteratorFurnace.next()), output, false)) {
                //レシピを削除する
                iteratorFurnace.remove();
                RagiLogger.infoDebug("The smelting output " + RagiUtils.stackToBracket(output) + " was removed successfully!");
            }
        }
    }

    //定型クラフトレシピを追加するメソッド
    public static void addShaped(ItemStack output, Object... inputs) {
        //registryNameからResource Locationを生成
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, output.getItem().getRegistryName().getResourcePath() + "_" + output.getMetadata());
        //レシピを追加する
        GameRegistry.addShapedRecipe(location, location, output, inputs);
        RagiLogger.infoDebug("The recipe <recipe:" + location + "> was added successfully!");
    }

    public static void addShaped(String alt, ItemStack output, Object... inputs) {
        //registryNameからResource Locationを生成
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, output.getItem().getRegistryName().getResourcePath() + "_" + output.getMetadata() + "_" + alt);
        //レシピを追加する
        GameRegistry.addShapedRecipe(location, location, output, inputs);
        RagiLogger.infoDebug("The recipe <recipe:" + location + "> was added successfully!");
    }

    //不定型クラフトレシピを追加するメソッド
    public static void addShapeless(ItemStack output, Ingredient... inputs) {
        //registryNameからResource Locationを生成
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, output.getItem().getRegistryName().getResourcePath() + "_" + output.getMetadata());
        //レシピを追加する
        GameRegistry.addShapelessRecipe(location, location, output, inputs);
        RagiLogger.infoDebug("The recipe <recipe:" + location + "> was added successfully!");
    }

    public static void addShapeless(String alt, ItemStack output, Ingredient... inputs) {
        //registryNameからResource Locationを生成
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, output.getItem().getRegistryName().getResourcePath() + "_" + output.getMetadata() + "_" + alt);
        //レシピを追加する
        GameRegistry.addShapelessRecipe(location, location, output, inputs);
        RagiLogger.infoDebug("The recipe <recipe:" + location + "> was added successfully!");
    }

    //クラフトレシピを削除するメソッド
    public static void remove(String registryName) {
        //registryNameからResource Locationを生成
        ResourceLocation location = RagiUtils.getResource(registryName);
        //locationからレシピを取得
        IRecipe recipeBefore = CraftingManager.getRecipe(location);
        //取得したレシピがnullでない場合
        if (Objects.nonNull(recipeBefore)) {
            //レシピを置き換える
            GameRegistry.addShapedRecipe(location, location, recipeBefore.getRecipeOutput(), "   ", " 1 ", "   ", '1', RagiUtils.getStack("minecraft:barrier", 1, 0));
            RagiLogger.infoDebug("The recipe <recipe:" + location + "> was removed successfully!");
        }
        //取得したレシピがnullの場合
        else {
            RagiLogger.warnDebug("The recipe <recipe:" + location + "> was not found...");
        }
    }
}