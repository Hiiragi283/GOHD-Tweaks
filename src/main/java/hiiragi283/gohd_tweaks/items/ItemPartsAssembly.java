package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.util.ItemCommon;

public class ItemPartsAssembly extends ItemCommon {

    private final int maxMeta;

    //Itemの定義
    public ItemPartsAssembly() {
        super("parts_assembly"); //IDの設定
        maxMeta = 4; //メタデータの最大値を4に設定
    }

    //メタデータの最大値を得るメソッド
    public int getMaxMeta() {
        //maxMetaに代入された値を返す
        return maxMeta;
    }
}
