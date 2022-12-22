package hiiragi283.gohd_tweaks.util;

import hiiragi283.gohd_tweaks.GOHDInit;
import net.minecraft.item.ItemStack;

public class RagiOreDict {

    public static void registerOreDict() {
        RagiUtils.addOreDict("dustSoulSand", new ItemStack(GOHDInit.ItemDust, 1, 0));
        RagiUtils.addOreDict("dustEndstone", new ItemStack(GOHDInit.ItemDust, 1, 1));
    }
}