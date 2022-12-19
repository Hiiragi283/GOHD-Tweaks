package hiiragi283.gohd_tweaks.base;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.awt.*;

public class ItemColorBase extends ItemBase implements IItemColor {

    //コンストラクタの宣言
    public ItemColorBase(String ID, int maxMeta) {
        super(ID, maxMeta);
    }

    //着色の仕方を定義するメソッド
    @Override
    public int colorMultiplier(@Nonnull ItemStack stack, int tintindex) {
        //ひいらぎさんのテーマカラー
        return new Color(255, 0, 31).getRGB();
    }
}