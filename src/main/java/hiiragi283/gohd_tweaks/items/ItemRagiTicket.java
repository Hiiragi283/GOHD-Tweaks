package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.util.ItemCommon;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemRagiTicket extends ItemCommon {
    private final int maxMeta;

    //Itemの定義
    public ItemRagiTicket() {
        super("ragi_ticket"); //IDの設定
        maxMeta = 0; //メタデータの最大値を0に設定
    }


    //メタデータの最大値を得るメソッド
    public int getMaxMeta() {
        //maxMetaに代入された値を返す
        return maxMeta;
    }

    //Rarityを得るメソッド
    public EnumRarity getRarity(ItemStack item) {
        //EPICを返す
        return EnumRarity.EPIC;
    }
}
