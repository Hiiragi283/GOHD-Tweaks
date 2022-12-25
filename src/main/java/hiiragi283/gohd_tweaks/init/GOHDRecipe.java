package hiiragi283.gohd_tweaks.init;

import hiiragi283.gohd_tweaks.util.RagiList;
import hiiragi283.gohd_tweaks.util.RagiRecipe;
import net.minecraft.item.ItemStack;

public class GOHDRecipe {

    //Recipeを登録するメソッド
    public static void registerRecipes() {
        RagiRecipe.addShaped("gohd_tweaks:sandpaper", new ItemStack(GOHDRegistry.ItemSandPaper), " A ", "ABA", " A ", 'A', "dustGarnet", 'B', "paper");
    }

    //Recipeを削除するメソッド
    public static void removeRecipes() {
        //LIST_CRAFTING_REMOVE内のレシピを削除する
        for (String registryName : RagiList.LIST_CRAFTING_REMOVE) {
            RagiRecipe.remove(registryName);
        }
        //BotaniaのAzulejoのレシピを削除する
        for (int i = 1; i < 15; i++) {
            RagiRecipe.remove("botania:custombrick_" + i);
        }
        //HaCのDesktop Accessoryのレシピを削除する
        for (int i = 1; i < 9; i++) {
            RagiRecipe.remove("dcs_climate:main_build/dcs_desktop_accessories_" + i);
        }
        //Railcraftの金属素材のレシピを削除する
        for (int i = 0; i < 10; i++) {
            RagiRecipe.remove("railcraft:metal#" + i + "$1");
            RagiRecipe.remove("railcraft:ingot#" + i + "$1");
            RagiRecipe.remove("railcraft:ingot#" + i + "$2");
            RagiRecipe.remove("railcraft:nugget#" + i + "$1");
        }
        //Railcraftの建材のレシピを削除する
        for (String decoration : RagiList.LIST_RC_DECORATION) {
            for (String meta : RagiList.LIST_RC_META) {
                RagiRecipe.remove("railcraft:" + decoration + meta);
            }
        }
        //Thermal Foundationのブロックのレシピを削除する
        for (int i = 1; i < 9; i++) {
            RagiRecipe.remove("thermalfoundation:storage_" + i);
            RagiRecipe.remove("thermalfoundation:storage_alloy_" + i);
        }
        //Thermal Foundationの素材のレシピを削除する
        for (int i = 8; i < 80; i++) {
            RagiRecipe.remove("thermalfoundation:material_" + i);
        }
    }
}