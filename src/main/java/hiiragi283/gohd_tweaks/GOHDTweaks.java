package hiiragi283.gohd_tweaks;

import hiiragi283.gohd_tweaks.init.GOHDRegistry;
import hiiragi283.gohd_tweaks.integration.IntegrationCore;
import hiiragi283.gohd_tweaks.proxy.CommonProxy;
import hiiragi283.gohd_tweaks.util.RagiOreDict;
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
        GOHDRegistry.RegisterBlocks();
        GOHDRegistry.RegisterEvents();
        GOHDRegistry.RegisterItems();
        GOHDRegistry.RegisterRecipes();
        proxy.loadPreInit();
    }

    //Initializationの段階で呼ばれるevent
    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {
        RagiOreDict.registerOreDict();
        proxy.loadInit();
    }

    //Post-Initializationの段階で呼ばれるevent
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        IntegrationCore.loadInit();
        proxy.loadPostInit();
    }
}