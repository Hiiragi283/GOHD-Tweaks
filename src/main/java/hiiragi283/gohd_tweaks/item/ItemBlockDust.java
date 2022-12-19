package hiiragi283.gohd_tweaks.item;

import hiiragi283.gohd_tweaks.GOHDInit;
import hiiragi283.gohd_tweaks.base.ItemBlockBase;
import hiiragi283.gohd_tweaks.util.RagiColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.awt.*;

public class ItemBlockDust extends ItemBlockBase {

    //コンストラクタの宣言
    public ItemBlockDust() {
        super(GOHDInit.BlockDust, 5);
    }

    public static class ColorBlockDust implements IItemColor {

        //着色の仕方を定義するメソッド
        @Override
        public int colorMultiplier(@Nonnull ItemStack stack, int tintindex) {
            int meta = stack.getMetadata();
            if (tintindex == 0) {
                if (meta == 0) return new Color(0xC2D0D8).getRGB();
                else if (meta == 1) return new Color(0xC6C4E2).getRGB();
                else if (meta == 2) return new Color(255, 0, 31).getRGB();
                else if (meta == 3) return new Color(0xBE9A45).getRGB();
                else if (meta == 4) return new Color(0x818D88).getRGB();
                else if (meta == 5) return new Color(0xD1A35B).getRGB();
                else return RagiColor.RagiRed.getRGB();
            } else return RagiColor.RagiRed.getRGB();
        }
    }
}
