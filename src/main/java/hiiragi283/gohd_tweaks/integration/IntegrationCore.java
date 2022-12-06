package hiiragi283.gohd_tweaks.integration;

import hiiragi283.gohd_tweaks.GOHDTweaks;
import net.minecraftforge.fml.common.Loader;

public class IntegrationCore {
    public static void Init() {
        //Astral Sorceryが読み込まれている場合
        if (Loader.isModLoaded("astralsorcery")) {
            try {
                //ASとの連携レシピの登録
                AstralSorcery.Init();
            } catch (Exception e) {
                //失敗した場合、エラーをログに吐く
                GOHDTweaks.LoggerGOHD.info("Loading AstralSorcery is failed!");
            }
        }
        //Heat And Climateが読み込まれている場合
        if (Loader.isModLoaded("dcs_climate")) {
            try {
                //HaCとの連携レシピの登録
                HeatAndClimate.Init();
            } catch (Exception e) {
                //失敗した場合、エラーをログに吐く
                GOHDTweaks.LoggerGOHD.info("Loading HeatAndClimate is failed!");
            }
        }
        //Thermal Expansionが読み込まれている場合
        if (Loader.isModLoaded("thermal_expansion")) {
            try {
                //Thermalとの連携レシピの登録
                ThermalSeries.Init();
            } catch (Exception e) {
                //失敗した場合、エラーをログに吐く
                GOHDTweaks.LoggerGOHD.info("Loading ThermalSeries is failed!");
            }
        }
    }
}