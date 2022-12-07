package hiiragi283.gohd_tweaks.integration;

import hellfirepvp.astralsorcery.common.base.WellLiquefaction;
import hiiragi283.gohd_tweaks.util.RagiUtils;
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
        WellLiquefaction(RagiUtils.getStack("tconstruct", "edible", 1, 1), "blueslime", 1.0F, 20);
    }

    //Starlight Wellのレシピをより簡単に登録するメソッド
    public static void WellLiquefaction(ItemStack stack, String name, float produce, int shatter) {
        Fluid fluid = RagiUtils.getFluid(name);
        Color color = new Color(fluid.getColor());
        WellLiquefaction.registerLiquefaction(stack, fluid, produce, shatter, color);
    }
}
