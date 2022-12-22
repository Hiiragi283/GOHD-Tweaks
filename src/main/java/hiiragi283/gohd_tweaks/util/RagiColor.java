package hiiragi283.gohd_tweaks.util;

import java.awt.*;

public class RagiColor {

    //ひいらぎさんのテーマカラー
    public static final Color RAGI_RED = new Color(255, 0, 31);
    public static final Color CLEAR = new Color(255, 255, 255, 0);

    //2つの色の中間色を取得するメソッド
    public static Color getColorAve(Color color1, Color color2) {
        //color1とcolor2の各RGB値の平均値を計算
        int aveR = (color1.getRed() + color2.getRed()) / 2;
        int aveG = (color1.getGreen() + color2.getGreen()) / 2;
        int aveB = (color1.getBlue() + color2.getBlue()) / 2;
        //中間 (管理) 色を返す
        return new Color(aveR, aveG, aveB);
    }

    //混合色から元の色を取得するメソッド
    public static Color getColorDif(Color colorMixed, Color colorBase1) {
        //colorMixedとcolorBase1の各RGB値の差分を計算
        int red2 = colorMixed.getRed() * 2 - colorBase1.getRed();
        int green2 = colorMixed.getGreen() * 2 - colorBase1.getGreen();
        int blue2 = colorMixed.getBlue() * 2 - colorBase1.getBlue();
        //混成前の色を返す
        return new Color(red2, green2, blue2);
    }

    //Dustの色を返すメソッド
    public static int setColorDust(int meta, int tintindex) {
        //tintindexが0の場合
        if (tintindex == 0) {
            //listMaterialの長さを取得
            int length = RagiList.LIST_MATERIAL.size();
            //metaが0以上length未満の場合
            if (meta >= 0 && meta < length) {
                //LIST_MATERIALからenumを取得
                RagiMaterialEnum material = RagiList.LIST_MATERIAL.get(meta);
                //enumから色を取得
                return material.getColorHex();
            }
            //metaが範囲外の場合
            else return CLEAR.getRGB();
        }
        //tintindexが0以外の場合
        else return CLEAR.getRGB();
    }

    //Heating Metalの色を返すメソッド
    public static int setColorHeating(int meta, int tintindex) {
        //tintindexが0の場合
        if (tintindex == 0) {
            //metaを3で割ったあまりが0でない場合
            if (meta % 3 != 0) {
                //metaを3で割った商が0の場合
                if (meta / 3 == 0) {
                    return RagiMaterialEnum.DARK_STEEL.getColorHex();
                }
                //metaを3で割った商が1の場合
                else if (meta / 3 == 1) {
                    return RagiMaterialEnum.END_STEEL.getColorHex();
                }
                //それ以外の場合
                else return CLEAR.getRGB();
            }
            //それ以外の場合
            else return CLEAR.getRGB();
        }
        //それ以外の場合
        else return CLEAR.getRGB();
    }
}