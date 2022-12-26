package hiiragi283.gohd_tweaks;

import net.minecraftforge.common.config.Config;

@Config(modid = Reference.MOD_ID)
public class GOHDConfig {

    @Config.Comment("If true, GOHD Tweaks throws debug log")
    public static boolean isDebug = false;
}
