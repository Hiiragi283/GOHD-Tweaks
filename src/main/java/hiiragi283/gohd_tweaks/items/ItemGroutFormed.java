package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.GOHDInit;
import hiiragi283.gohd_tweaks.util.ItemBlockCommon;

public class ItemGroutFormed extends ItemBlockCommon {
    public ItemGroutFormed() {
        super(GOHDInit.BlockGroutFormed);
    }

    public int getMaxMeta() {
        return 2;
    }
}
