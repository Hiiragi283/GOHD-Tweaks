package hiiragi283.gohd_tweaks.integration.jei;

import com.google.common.collect.Lists;
import hiiragi283.gohd_tweaks.util.RagiMap;
import mezz.jei.api.IModRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

import java.util.List;
import java.util.Objects;

public class SandpaperMaker {

    private SandpaperMaker() {
    }

    //
    public static void register(IModRegistry registry) {
        //listの宣言
        List<SandpaperRecipe> list = Lists.newArrayList();
        //MapSandpaperの各keyに対して実行
        for (IBlockState before : RagiMap.MapSandpaper.keySet()) {
            //beforeがnllでない場合
            if (Objects.nonNull(before)) {
                //レシピを生成
                SandpaperRecipe info = new SandpaperRecipe(before);
                //変化後が空でない場合
                if (!info.stackAfter.isEmpty()) {
                    //listにレシピを追加
                    list.add(info);
                }
            }
        }
        //MapSandpaperBlockの各keyに対して実行
        for (Block before : RagiMap.MapSandpaperBlock.keySet()) {
            //beforeがnllでない場合
            if (Objects.nonNull(before)) {
                //レシピを生成
                SandpaperRecipe info = new SandpaperRecipe(before);
                //変化後が空でない場合
                if (!info.stackAfter.isEmpty()) {
                    //listにレシピを追加
                    list.add(info);
                }
            }
        }
        //リストをレシピ一覧に登録
        registry.addRecipes(list, "gohd_tweaks.sandpaper");
    }
}