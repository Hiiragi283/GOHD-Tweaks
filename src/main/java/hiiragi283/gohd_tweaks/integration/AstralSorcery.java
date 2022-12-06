package hiiragi283.gohd_tweaks.integration;

import hellfirepvp.astralsorcery.common.base.WellLiquefaction;
import hiiragi283.gohd_tweaks.util.GOHDUtils;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

import java.awt.*;

public class AstralSorcery {

    //ASとの連携レシピをまとめて登録するメソッド
    public static void Init() {
        RegisterLiquefaction();
    }

    //Starlight WellのレシピをWellLiquefaction経由で登録するメソッド
    public static void RegisterLiquefaction() {
        WellLiquefaction(GOHDUtils.getStack("tconstruct", "edible", 1, 1), "blueslime", 1.0F, 20);
    }

    //Starlight Wellのレシピをより簡単に登録するメソッド
    public static void WellLiquefaction(ItemStack stack, String name, float produce, int shatter) {
        Fluid fluid = GOHDUtils.getFluid(name);
        Color color = new Color(fluid.getColor());
        WellLiquefaction.registerLiquefaction(stack, fluid, produce, shatter, color);
    }
}
