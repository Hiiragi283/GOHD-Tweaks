package hiiragi283.gohd_tweaks.util;

import java.awt.*;

public enum RagiMaterialEnum {

    //enumの宣言
    //ENUM(index, id, color)
    PLATINUM(0, "platinum", new Color(98, 209, 243)),
    IRIDIUM(1, "iridium", new Color(197, 195, 221)),
    MANA_INFUSED(2, "mana_infused", new Color(90, 131, 151)),
    ELECTRUM(3, "electrum", new Color(200, 176, 74)),
    INVAR(4, "invar", new Color(153, 163, 153)),
    CONSTANTAN(5, "constantan", new Color(211, 159, 72)),
    ELECTRICAL_STEEL(8, "electrical_steel", new Color(201, 201, 201)),
    ENERGETIC_ALLOY(9, "energetic_alloy", new Color(255, 166, 56)),
    VIBRANT_ALLOY(13, "vibrant_alloy", new Color(207, 244, 116)),
    REDSTONE_ALLOY(11, "redstone_alloy", new Color(229, 86, 86)),
    CONDUCTIVE_IRON(6, "conductive_iron", new Color(217, 178, 171)),
    PULSATING_IRON(10, "pulsating_iron", new Color(145, 235, 167)),
    DARK_STEEL(7, "dark_steel", new Color(99, 99, 99)),
    SOULARIUM(12, "soularium", new Color(132, 112, 85)),
    END_STEEL(14, "end_steel", new Color(236, 229, 187));

    //public変数の宣言
    public final int index;
    public final String id;
    public final Color color;

    //コンストラクタの宣言
    RagiMaterialEnum(int index, String id, Color color) {
        this.index = index;
        this.id = id;
        this.color = color;
    }

    //colorをint型に変換して返すメソッド
    public int getColorHex() {
        return color.getRGB();
    }
}