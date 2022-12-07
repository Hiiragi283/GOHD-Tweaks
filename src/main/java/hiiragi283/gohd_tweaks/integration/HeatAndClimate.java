package hiiragi283.gohd_tweaks.integration;

import defeatedcrow.hac.api.climate.DCAirflow;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.api.climate.DCHumidity;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import defeatedcrow.hac.plugin.DCPluginFluid;
import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.potion.Potion;

public class HeatAndClimate {

    //HaCとの連携レシピをまとめて登録するメソッド
    public static void Init() {
        ClimateSmelting();
        FluidDic();
        FluidFuel();
        FluidPotion();
    }

    //気候精錬のレシピを登録するメソッド
    public static void ClimateSmelting() {
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("thermalfoundation", "storage", 1, 6), DCHeatTier.UHT, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 0));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("thermalfoundation", "storage", 1, 7), DCHeatTier.UHT, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 1));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("thermalfoundation", "storage", 1, 8), DCHeatTier.UHT, DCHumidity.UNDERWATER, DCAirflow.WIND, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 2));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("thermalfoundation", "storage_alloy", 1, 1), DCHeatTier.SMELTING, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 3));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("thermalfoundation", "storage_alloy", 1, 2), DCHeatTier.SMELTING, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 4));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("thermalfoundation", "storage_alloy", 1, 4), DCHeatTier.SMELTING, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 5));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("tconstruct", "casting", 1, 0), DCHeatTier.KILN, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "grout_formed", 1, 0));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("tconstruct", "casting", 1, 1), DCHeatTier.KILN, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "grout_formed", 1, 1));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("tconstruct", "channel", 1, 0), DCHeatTier.KILN, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "grout_formed", 1, 2));
    }

    //HaC独自の液体辞書を登録するメソッド
    public static void FluidDic() {
        DCPluginFluid.registerFluidDic("experience", "exp");
        DCPluginFluid.registerFluidDic("xpjuice", "exp");
    }

    //HaCの液体燃料を登録するメソッド
    public static void FluidFuel() {
        //DCPluginFluid.registerFuel("dcs.hydrogen", "hydrogen", 100);
    }

    //液体をHaC経由で飲んだ際に特定のポーション効果を付与するメソッド
    public static void FluidPotion() {
        DCPluginFluid.registerPotion("astralsorcery.liquidstarlight", Potion.getPotionFromResourceLocation("minecraft:night_vision"));
        DCPluginFluid.registerPotion("beetroot_soup", Potion.getPotionFromResourceLocation("minecraft:instant_health"));
        DCPluginFluid.registerPotion("blueslime", Potion.getPotionFromResourceLocation("minecraft:jump_boost"));
        DCPluginFluid.registerPotion("dcs.mazai", Potion.getPotionFromResourceLocation("minecraft:nausea"));
        DCPluginFluid.registerPotion("potato_soup", Potion.getPotionFromResourceLocation("minecraft:instant_health"));
        DCPluginFluid.registerPotion("purpleslime", Potion.getPotionFromResourceLocation("minecraft:luck"));
        DCPluginFluid.registerPotion("rabbit_stew", Potion.getPotionFromResourceLocation("minecraft:instant_health"));
    }
}
