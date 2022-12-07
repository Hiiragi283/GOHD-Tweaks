package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.GOHDInit;
import hiiragi283.gohd_tweaks.base.ItemBlockCommon;

public class ItemBlockDust extends ItemBlockCommon {

    //Itemの定義
    public ItemBlockDust() {
        super(GOHDInit.BlockDust); //BlockからItemを生成する
    }

    //メタデータの最大値を得るメソッド
    public int getMaxMeta() {
        //5を返す
        return 5;
    }
}
