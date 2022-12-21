package hiiragi283.gohd_tweaks.item;

import hiiragi283.gohd_tweaks.GOHDInit;
import hiiragi283.gohd_tweaks.base.ItemBlockBase;
import hiiragi283.gohd_tweaks.util.RagiColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemBlockDust extends ItemBlockBase implements IItemColor {

    //コンストラクタの宣言
    public ItemBlockDust() {
        super(GOHDInit.BlockDust, 14);
    }

    //着色の仕方を定義するメソッド
    @Override
    public int colorMultiplier(@Nonnull ItemStack stack, int tintindex) {
        int meta = stack.getMetadata();
        return RagiColor.setColorDust(meta, tintindex);
    }
}
