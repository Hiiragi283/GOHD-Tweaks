package hiiragi283.gohd_tweaks.item;

import hiiragi283.gohd_tweaks.GOHDInit;
import hiiragi283.gohd_tweaks.base.ItemBlockBase;
import hiiragi283.gohd_tweaks.util.RagiColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

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
            return RagiColor.setColorDustblock(meta, tintindex);
        }
    }
}
