package hiiragi283.gohd_tweaks;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;

public class Reference {
    //MOD IDの定義
    public static final String MOD_ID = "gohd_tweaks";
    //Mod名の定義
    public static final String MOD_NAME = "GOHD Tweaks";
    //Modのバージョンの定義
    public static final String VERSION = "v0.0.1";
    //依存関係の定義
    public static final String DEPENDENCIES = "required-after:dcs_lib;required-after:dcs_climate";
    //対応するMCのバージョンの定義
    public static final String MC_VERSIONS = "[1.12,1.12.2]";
    //Client側のProxyの定義
    public static final String CLIENT_PROXY_CLASS = "hiiragi283.gohd_tweaks.proxy.ClientProxy";
    //Server側のProxyの定義
    public static final String SERVER_PROXY_CLASS = "hiiragi283.gohd_tweaks.proxy.CommonProxy";
    //Serverの定義 (コマンド実行用)
    public static final MinecraftServer server = Minecraft.getMinecraft().getIntegratedServer();
}
