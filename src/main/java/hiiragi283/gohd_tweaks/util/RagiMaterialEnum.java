package hiiragi283.gohd_tweaks.util;

import java.awt.*;

public enum RagiMaterialEnum {

    PLATINUM(0, "platinum", new Color(98,209,243)),
    IRIDIUM(1, "iridium", new Color(197,195,221)),
    MANA_INFUSED(2, "mana_infused", new Color(90,131,151)),
    ELECTRUM(3, "electrum", new Color(200,176,74)),
    INVAR(4, "invar", new Color(153,163,153)),
    CONSTANTAN(5, "constantan", new Color(211,159,72));

    public final String id;
    public final int index;
    public final Color color;

    private RagiMaterialEnum(int index, String id, Color color) {
        this.index = index;
        this.id = id;
        this.color = color;
    }

    public int getColorHex() {
        return color.getRGB();
    }
}
