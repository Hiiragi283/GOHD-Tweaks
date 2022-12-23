package hiiragi283.gohd_tweaks.util;

import hiiragi283.gohd_tweaks.init.GOHDRegistry;
import net.minecraft.item.ItemStack;

public class RagiOreDict {

    public static void registerOreDict() {
        RagiUtils.setOreDict("dustSoulSand", new ItemStack(GOHDRegistry.ItemDust, 1, 0));
        RagiUtils.setOreDict("dustEndstone", new ItemStack(GOHDRegistry.ItemDust, 1, 1));
    }
}