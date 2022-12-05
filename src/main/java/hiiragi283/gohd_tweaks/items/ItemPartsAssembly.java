package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.util.ItemCommon;

public class ItemPartsAssembly extends ItemCommon {

    private final int maxMeta;

    public ItemPartsAssembly() {
        super("parts_assembly");
        maxMeta = 4;
    }

    public int getMaxMeta() {
        return maxMeta;
    }
}
