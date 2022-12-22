package hiiragi283.gohd_tweaks.item;

import hiiragi283.gohd_tweaks.base.ItemBase;
import hiiragi283.gohd_tweaks.util.RagiColor;
import hiiragi283.gohd_tweaks.util.RagiMaterialEnum;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemDust extends ItemBase implements IItemColor {

    //コンストラクタの宣言
    public ItemDust() {
        super("dust", 1); //IDの設定
    }

    //着色の仕方を定義するメソッド
    @Override
    public int colorMultiplier(@Nonnull ItemStack stack, int tintindex) {
        int meta = stack.getMetadata();
        //tintindexが0の場合
        if (tintindex == 0) {
            //metaが0の場合
            if (meta == 0) return RagiMaterialEnum.SOULARIUM.getColorHex();
            //metaが1の場合
            else if (meta == 1) return RagiMaterialEnum.END_STEEL.getColorHex();
            //それ以外の場合
            else return RagiColor.CLEAR.getRGB();
        }
        //それ以外の場合
        else return RagiColor.CLEAR.getRGB();
    }
}
