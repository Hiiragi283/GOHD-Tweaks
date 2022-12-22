package hiiragi283.gohd_tweaks;

import hiiragi283.gohd_tweaks.integration.IntegrationCore;
import hiiragi283.gohd_tweaks.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

//Modの定義
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES, acceptedMinecraftVersions = Reference.MC_VERSIONS)

public class GOHDTweaks {

    //Proxyの定義
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    //Pre-Initializationの段階で呼ばれるevent
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GOHDInit.RegisterBlocks();
        GOHDInit.RegisterEvents();
        GOHDInit.RegisterItems();
        proxy.loadPreInit();
    }

    //Initializationの段階で呼ばれるevent
    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {
        proxy.loadInit();
    }

    //Post-Initializationの段階で呼ばれるevent
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        IntegrationCore.loadInit();
        proxy.loadPostInit();
    }
}