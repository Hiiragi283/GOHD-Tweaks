package hiiragi283.gohd_tweaks;

import hiiragi283.gohd_tweaks.proxy.CommonProxy;
import hiiragi283.gohd_tweaks.integration.IntegrationCore;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Modの定義
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES, acceptedMinecraftVersions = Reference.MC_VERSIONS)
public class GOHDTweaks {

    //ログ出力用
    public static final Logger LoggerGOHD = LogManager.getLogger(Reference.MOD_ID);
    //Proxyの定義
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    //Instanceの定義
    @Mod.Instance(Reference.MOD_ID)
    public static GOHDTweaks Instance;

    //Pre-Initializationの段階で呼ばれるevent
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //GOHDInitの登録
        GOHDInit.Init();
        //ItemのModelの登録
        proxy.Init();
    }

    //Post-Initializationの段階で呼ばれるevent
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        //他modとの連携レシピの登録
        IntegrationCore.Init();
    }
}
