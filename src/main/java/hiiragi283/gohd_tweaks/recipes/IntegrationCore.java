package hiiragi283.gohd_tweaks.recipes;

import hiiragi283.gohd_tweaks.GOHDTweaks;
import net.minecraftforge.fml.common.Loader;

public class IntegrationCore {
    public static void Init() {
        //Astral Sorceryが読み込まれている場合
        if (Loader.isModLoaded("astralsorcery")) {
            try {
                //ASとの連携レシピの登録
                AstralRecipe.Init();
            } catch (Exception e) {
                //失敗した場合、エラーをログに吐く
                GOHDTweaks.LoggerGOHD.info("Loading AstralRecipe is failed!");
            }
        }
        //Heat And Climateが読み込まれている場合
        if (Loader.isModLoaded("dcs_climate")) {
            try {
                //HaCとの連携レシピの登録
                ClimateRecipe.Init();
            } catch (Exception e) {
                //失敗した場合、エラーをログに吐く
                GOHDTweaks.LoggerGOHD.info("Loading ClimateRecipe is failed!");
            }
        }
        //Thermal Expansionが読み込まれている場合
        if (Loader.isModLoaded("thermal_expansion")) {
            try {
                //Thermalとの連携レシピの登録
                ThermalRecipe.Init();
            } catch (Exception e) {
                //失敗した場合、エラーをログに吐く
                GOHDTweaks.LoggerGOHD.info("Loading ThermalRecipe is failed!");
            }
        }
    }
}
