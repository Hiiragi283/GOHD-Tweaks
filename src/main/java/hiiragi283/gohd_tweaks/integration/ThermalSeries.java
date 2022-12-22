package hiiragi283.gohd_tweaks.integration;

import cofh.thermalexpansion.util.managers.machine.CentrifugeManager;
import hiiragi283.gohd_tweaks.GOHDInit;
import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.item.ItemStack;

import java.util.Collections;

import static java.util.Arrays.asList;

public class ThermalSeries {

    //Thermalとの連携レシピをまとめて登録するメソッド
    public static void Init() {
        registerCentrifuge();
    }

    //遠心分離機のレシピの登録をするメソッド
    public static void registerCentrifuge() {
        //Mobの処理レシピの登録
        CentrifugeManager.addDefaultMobRecipe("artifacts:mimic", Collections.singletonList(new ItemStack(GOHDInit.ItemRagiTicket, 1, 0)), Collections.singletonList(100), 8);
        CentrifugeManager.addDefaultMobRecipe("tconstruct:blueslime", Collections.singletonList(RagiUtils.getStack("tconstruct", "edible", 2, 1)), Collections.singletonList(50), 4);
        CentrifugeManager.addDefaultMobRecipe("twilightforest:adherent", Collections.singletonList(RagiUtils.getStack("dcs_climate", "dcs_cube_ice", 1, 0)), Collections.singletonList(25), 10);
        CentrifugeManager.addDefaultMobRecipe("twilightforest:maze_slime", asList(RagiUtils.getStack("twilightforest", "maze_stone", 1, 1), RagiUtils.getStack("twilightforest", "maze_wafer", 1, 0)), asList(100, 25), 4);
        CentrifugeManager.addDefaultMobRecipe("twilightforest:harbinger_cube", Collections.singletonList(RagiUtils.getStack("dcs_climate", "dcs_cube_flame", 1, 0)), Collections.singletonList(25), 10);
    }
}
