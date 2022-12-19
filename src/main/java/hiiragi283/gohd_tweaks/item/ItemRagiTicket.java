package hiiragi283.gohd_tweaks.item;

import hiiragi283.gohd_tweaks.base.ItemBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemRagiTicket extends ItemBase {

    //コンストラクタの宣言
    public ItemRagiTicket() {
        super("ragi_ticket", 0); //IDの設定
    }

    //Rarityを得るメソッド
    @Nonnull
    public EnumRarity getRarity(@Nonnull ItemStack item) {
        //EPICを返す
        return EnumRarity.EPIC;
    }
}