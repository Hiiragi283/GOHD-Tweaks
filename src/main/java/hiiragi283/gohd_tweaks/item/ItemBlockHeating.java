package hiiragi283.gohd_tweaks.item;

import hiiragi283.gohd_tweaks.init.GOHDRegistry;
import hiiragi283.gohd_tweaks.base.ItemBlockBase;
import hiiragi283.gohd_tweaks.util.RagiColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemBlockHeating extends ItemBlockBase  implements IItemColor {

    //コンストラクタの宣言
    public ItemBlockHeating() {
        super(GOHDRegistry.BlockHeating, 5);
    }

    //着色の仕方を定義するメソッド
    @Override
    public int colorMultiplier(@Nonnull ItemStack stack, int tintindex) {
        int meta = stack.getMetadata();
        return RagiColor.setColorHeating(meta, tintindex);
    }
}