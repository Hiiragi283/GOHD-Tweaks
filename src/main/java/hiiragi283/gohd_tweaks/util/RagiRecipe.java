package hiiragi283.gohd_tweaks.util;

import hiiragi283.gohd_tweaks.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Objects;

public class RagiRecipe {

    //定型クラフトレシピを追加するメソッド
    public static void addShaped(String registryName, ItemStack output, Object... inputs) {
        //registryNameからResource Locationを生成
        ResourceLocation location = RagiUtils.getResource(registryName);
        //レシピを追加する
        GameRegistry.addShapedRecipe(location, location, output, inputs);
        Reference.LOGGER_GOHD.info("The recipe <recipe:" + location + "> was added successfully!");
    }

    //不定型クラフトレシピを追加するメソッド
    public static void addShapeless(String registryName, ItemStack output, Ingredient... inputs) {
        //registryNameからResource Locationを生成
        ResourceLocation location = RagiUtils.getResource(registryName);
        //レシピを追加する
        GameRegistry.addShapelessRecipe(location, location, output, inputs);
        Reference.LOGGER_GOHD.info("The recipe <recipe:" + location + "> was added successfully!");
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
            GameRegistry.addShapedRecipe(location, location, recipeBefore.getRecipeOutput(), "   ", " 1 ", "   ", '1', RagiUtils.getStack("minecraft:barrier", 1,0));
            Reference.LOGGER_GOHD.info("The recipe <recipe:" + location + "> was removed successfully!");
        }
        //取得したレシピがnullの場合
        else {
            Reference.LOGGER_GOHD.warn("The recipe <recipe:" + location + "> was not found...");
        }
    }
}