package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.base.ItemCommon;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

public class ItemColorIngot extends ItemCommon {
    public ItemColorIngot() {
        super("ingot");
    }

    public static class ColorHandler implements IItemColor {
        @Override
        public int colorMultiplier(ItemStack stack, int color) {
            return 0xFF0000;
        }
    }
}
