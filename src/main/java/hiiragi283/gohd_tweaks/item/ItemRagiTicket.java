package hiiragi283.gohd_tweaks.item;

import hiiragi283.gohd_tweaks.base.ItemBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemRagiTicket extends ItemBase {

    //Itemの定義
    public ItemRagiTicket() {
        super("ragi_ticket", 0); //IDの設定
    }

    //Rarityを得るメソッド
    public EnumRarity getRarity(ItemStack item) {
        //EPICを返す
        return EnumRarity.EPIC;
    }
}