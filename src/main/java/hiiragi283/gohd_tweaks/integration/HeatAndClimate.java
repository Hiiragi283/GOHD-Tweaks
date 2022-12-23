package hiiragi283.gohd_tweaks.integration;

import com.google.common.collect.Lists;
import defeatedcrow.hac.api.climate.*;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import defeatedcrow.hac.main.api.MainAPIManager;
import defeatedcrow.hac.main.recipes.HeatTreatment;
import defeatedcrow.hac.plugin.DCPluginFluid;
import hiiragi283.gohd_tweaks.init.GOHDRegistry;
import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

import java.util.List;

public class HeatAndClimate {

    //HaCとの連携レシピをまとめて登録するメソッド
    public static void loadInit() {
        registerClimateSmelting();
        registerHeatTreatment();
        registerFluidDic();
        registerFluidFuel();
        registerFluidPotion();
    }

    //気候精錬のレシピを登録するメソッド
    public static void registerClimateSmelting() {
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("enderio", "block_alloy", 1, 0), DCHeatTier.SMELTING, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 6));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("enderio", "block_alloy", 1, 1), DCHeatTier.SMELTING, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 7));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("enderio", "block_alloy", 1, 2), DCHeatTier.UHT, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 8));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("enderio", "block_alloy", 1, 3), DCHeatTier.KILN, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 9));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("enderio", "block_alloy", 1, 4), DCHeatTier.KILN, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 10));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("enderio", "block_alloy", 1, 5), DCHeatTier.SMELTING, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 11));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("enderio", "block_alloy", 1, 7), DCHeatTier.UHT, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 13));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("tconstruct", "casting", 1, 0), DCHeatTier.KILN, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "grout_formed", 1, 0));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("tconstruct", "casting", 1, 1), DCHeatTier.KILN, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "grout_formed", 1, 1));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("tconstruct", "channel", 1, 0), DCHeatTier.KILN, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "grout_formed", 1, 2));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("thermalfoundation", "storage", 1, 6), DCHeatTier.UHT, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 0));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("thermalfoundation", "storage", 1, 7), DCHeatTier.UHT, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 1));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("thermalfoundation", "storage", 1, 8), DCHeatTier.UHT, DCHumidity.UNDERWATER, DCAirflow.WIND, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 2));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("thermalfoundation", "storage_alloy", 1, 1), DCHeatTier.SMELTING, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 3));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("thermalfoundation", "storage_alloy", 1, 2), DCHeatTier.SMELTING, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 4));
        RecipeAPI.registerSmelting.addRecipe(RagiUtils.getStack("thermalfoundation", "storage_alloy", 1, 4), DCHeatTier.SMELTING, null, DCAirflow.TIGHT, RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 5));
    }

    //金属熱処理を追加するメソッド
    public static void registerHeatTreatment() {
        //基本となる気候条件の宣言
        IClimate c1 = ClimateAPI.register.getClimateFromParam(DCHeatTier.SMELTING, DCHumidity.NORMAL, DCAirflow.TIGHT);
        IClimate c2 = ClimateAPI.register.getClimateFromParam(DCHeatTier.NORMAL, DCHumidity.UNDERWATER, DCAirflow.TIGHT);
        IClimate c3 = ClimateAPI.register.getClimateFromParam(DCHeatTier.OVEN, DCHumidity.NORMAL, DCAirflow.TIGHT);
        IClimate c4 = ClimateAPI.register.getClimateFromParam(DCHeatTier.UHT, DCHumidity.NORMAL, DCAirflow.TIGHT);

        //Dark Steel Blockの金属熱処理
        //起点となるブロックをリストに追加
        List<ItemStack> l1 = Lists.newArrayList();
        l1.add(RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 12));
        l1.add(new ItemStack(GOHDRegistry.BlockHeating, 1, 2));
        //金属熱処理の宣言
        //HeatTreatment r1 = new HeatTreatment(起点となるブロック, 1回目の気候条件, 1回目の処理ブロック, 2回目の気候条件, 2回目の処理ブロック, 3回目の気候条件, 3回目の処理ブロック, 失敗した際の不良品);
        HeatTreatment r1 = new HeatTreatment(l1, c1, new ItemStack(GOHDRegistry.BlockHeating, 1, 0), c2, new ItemStack(GOHDRegistry.BlockHeating, 1, 1), c1, RagiUtils.getStack("enderio", "block_alloy", 1, 6), new ItemStack(GOHDRegistry.BlockHeating, 1, 2));
        //成功判定になる気候条件を追加
        r1.temp1.add(DCHeatTier.UHT);
        r1.temp2.add(DCHeatTier.COOL);
        r1.hum1.add(DCHumidity.DRY);
        r1.hum2.add(DCHumidity.WET);
        r1.hum3.add(DCHumidity.DRY);
        r1.air1.add(DCAirflow.TIGHT);
        r1.air2.add(DCAirflow.NORMAL);
        r1.air3.add(DCAirflow.NORMAL);
        //金属熱処理の登録
        MainAPIManager.heatTreatmentRegister.registerRecipe(r1);

        //起点となるブロックをリストに追加
        List<ItemStack> l2 = Lists.newArrayList();
        l2.add(RagiUtils.getStack("gohd_tweaks", "dustblock", 1, 14));
        l2.add(new ItemStack(GOHDRegistry.BlockHeating, 1, 5));
        //金属熱処理の宣言
        HeatTreatment r2 = new HeatTreatment(l2, c4, new ItemStack(GOHDRegistry.BlockHeating, 1, 3), c2, new ItemStack(GOHDRegistry.BlockHeating, 1, 4), c1, RagiUtils.getStack("enderio", "block_alloy", 1, 8), new ItemStack(GOHDRegistry.BlockHeating, 1, 5));
        //成功判定になる気候条件を追加
        r2.temp1.add(DCHeatTier.INFERNO);
        r2.temp2.add(DCHeatTier.COOL);
        r2.hum1.add(DCHumidity.DRY);
        r2.hum2.add(DCHumidity.WET);
        r2.hum2.add(DCHumidity.NORMAL);
        r2.hum3.add(DCHumidity.DRY);
        r2.air1.add(DCAirflow.NORMAL);
        r2.air2.add(DCAirflow.NORMAL);
        r2.air2.add(DCAirflow.FLOW);
        r2.air3.add(DCAirflow.FLOW);
        r2.air3.add(DCAirflow.WIND);
        //金属熱処理の登録
        MainAPIManager.heatTreatmentRegister.registerRecipe(r2);
    }

    //HaC独自の液体辞書を登録するメソッド
    public static void registerFluidDic() {
        DCPluginFluid.registerFluidDic("experience", "exp");
        DCPluginFluid.registerFluidDic("xpjuice", "exp");
    }

    //HaCの液体燃料を登録するメソッド
    public static void registerFluidFuel() {
        //DCPluginFluid.registerFuel("dcs.hydrogen", "hydrogen", 100);
    }

    //液体をHaC経由で飲んだ際に特定のポーション効果を付与するメソッド
    public static void registerFluidPotion() {
        DCPluginFluid.registerPotion("astralsorcery.liquidstarlight", Potion.getPotionFromResourceLocation("minecraft:night_vision"));
        DCPluginFluid.registerPotion("beetroot_soup", Potion.getPotionFromResourceLocation("minecraft:instant_health"));
        DCPluginFluid.registerPotion("blueslime", Potion.getPotionFromResourceLocation("minecraft:jump_boost"));
        DCPluginFluid.registerPotion("dcs.mazai", Potion.getPotionFromResourceLocation("minecraft:nausea"));
        DCPluginFluid.registerPotion("potato_soup", Potion.getPotionFromResourceLocation("minecraft:instant_health"));
        DCPluginFluid.registerPotion("purpleslime", Potion.getPotionFromResourceLocation("minecraft:luck"));
        DCPluginFluid.registerPotion("rabbit_stew", Potion.getPotionFromResourceLocation("minecraft:instant_health"));
    }
}