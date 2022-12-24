package hiiragi283.gohd_tweaks;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reference {
    //MOD IDの定義
    public static final String MOD_ID = "gohd_tweaks";
    //Mod名の定義
    public static final String MOD_NAME = "GOHD Tweaks";
    //Modのバージョンの定義
    public static final String VERSION = "v0.5.0";
    //依存関係の定義
    public static final String DEPENDENCIES = "required-after:dcs_lib;required-after:dcs_climate";
    //対応するMCのバージョンの定義
    public static final String MC_VERSIONS = "[1.12,1.12.2]";
    //Client側のProxyの定義
    public static final String CLIENT_PROXY_CLASS = "hiiragi283.gohd_tweaks.proxy.ClientProxy";
    //Server側のProxyの定義
    public static final String SERVER_PROXY_CLASS = "hiiragi283.gohd_tweaks.proxy.ServerProxy";
    //ログ出力用
    public static final Logger LOGGER_GOHD = LogManager.getLogger(Reference.MOD_ID);
    //Serverの定義 (コマンド実行用)
    public static final MinecraftServer SERVER = Minecraft.getMinecraft().getIntegratedServer();

}