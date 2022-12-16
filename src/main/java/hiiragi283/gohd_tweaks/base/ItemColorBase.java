package hiiragi283.gohd_tweaks.base;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

import java.awt.*;

public class ItemColorBase extends ItemBase {
    public ItemColorBase(String ID, int maxMeta) {
        super(ID, maxMeta);
    }

    public static class ColorHandler implements IItemColor {
        @Override
        public int colorMultiplier(ItemStack stack, int tintindex) {
            return new Color(255, 0, 31).getRGB();
        }
    }
}