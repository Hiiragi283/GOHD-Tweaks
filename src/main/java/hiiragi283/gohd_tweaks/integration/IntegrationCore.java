package hiiragi283.gohd_tweaks.integration;

import hiiragi283.gohd_tweaks.Reference;
import hiiragi283.gohd_tweaks.util.RagiLogger;
import net.minecraftforge.fml.common.Loader;

public class IntegrationCore {
    public static void loadInit() {
        //Astral Sorceryが読み込まれている場合
        if (Loader.isModLoaded("astralsorcery")) {
            try {
                //ASとの連携レシピの登録
                AstralSorcery.loadInit();
                //ログに完了の報告を流す
                RagiLogger.info("The integration for AstralSorcery has loaded!");
            } catch (Exception e) {
                //失敗した場合、エラーをログに吐く
                RagiLogger.error("Loading the integration for AstralSorcery is failed!");
            }
        }
        //Heat And Climateが読み込まれている場合
        if (Loader.isModLoaded("dcs_climate")) {
            try {
                //HaCとの連携レシピの登録
                HeatAndClimate.loadInit();
                //ログに完了の報告を流す
                RagiLogger.info("The integration for HeatAndClimate has loaded!");
            } catch (Exception e) {
                //失敗した場合、エラーをログに吐く
                RagiLogger.error("Loading the integration for HeatAndClimate is failed...");
            }
        }
        //Thermal Expansionが読み込まれている場合
        if (Loader.isModLoaded("thermal_expansion")) {
            try {
                //Thermalとの連携レシピの登録
                ThermalSeries.loadInit();
                //ログに完了の報告を流す
                RagiLogger.info("The integration for ThermalSeries has loaded!");
            } catch (Exception e) {
                //失敗した場合、エラーをログに吐く
                RagiLogger.error("Loading the integration forThermalSeries is failed...");
            }
        }
    }
}