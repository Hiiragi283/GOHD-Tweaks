package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.GOHDInit;
import hiiragi283.gohd_tweaks.util.ItemBlockCommon;

public class ItemBlockDust extends ItemBlockCommon {
    public ItemBlockDust() {
        super(GOHDInit.BlockDust);
    }

    public int getMaxMeta() {
        return 5;
    }
}
