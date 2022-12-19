package hiiragi283.gohd_tweaks.util;

import java.awt.*;

public class RagiColor {

    //ひいらぎさんのテーマカラー
    public static Color RagiRed = new Color(255, 0, 31);

    //2つの色の中間色を取得するメソッド
    public Color mixColor(Color color1, Color color2) {
        //color1とcolor2の各RGB値の平均値を計算
        int aveR = (color1.getRed() + color2.getRed()) / 2;
        int aveG = (color1.getGreen() + color2.getGreen()) / 2;
        int aveB = (color1.getBlue() + color2.getBlue()) / 2;
        //中間 (管理) 色を返す
        return new Color(aveR, aveG, aveB);
    }

    //混合色から元の色を取得するメソッド
    public Color getBaseColor(Color colorMixed, Color colorBase1) {
        //colorMixedとcolorBase1の各RGB値の差分を計算
        int red2 = colorMixed.getRed() * 2 - colorBase1.getRed();
        int green2 = colorMixed.getGreen() * 2 - colorBase1.getGreen();
        int blue2 = colorMixed.getBlue() * 2 - colorBase1.getBlue();
        //混成前の色を返す
        return new Color(red2, green2, blue2);
    }
}