package hiiragi283.gohd_tweaks.item;

import hiiragi283.gohd_tweaks.base.ItemBase;
import hiiragi283.gohd_tweaks.util.RagiColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemDust extends ItemBase implements IItemColor{

    //コンストラクタの宣言
    public ItemDust() {
        super("dust", 5); //IDの設定
    }

    //着色の仕方を定義するメソッド
    @Override
    public int colorMultiplier(@Nonnull ItemStack stack, int tintindex) {
        int meta = stack.getMetadata();
        return RagiColor.setColorDust(meta, tintindex);
    }
}
