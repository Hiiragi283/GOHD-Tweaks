package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.base.ItemBase;

public class ItemPartsAssembly extends ItemBase {


    //Itemの定義
    public ItemPartsAssembly() {
        super("parts_assembly"); //IDの設定
    }

    //メタデータの最大値を得るメソッド
    public int getMaxMeta() {
        //4を返す
        return 4;
    }
}
