package hiiragi283.gohd_tweaks.util;

import hiiragi283.gohd_tweaks.GOHDConfig;
import hiiragi283.gohd_tweaks.Reference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RagiLogger {

    public static final Logger LOGGER_GOHD = LogManager.getLogger(Reference.MOD_ID);

    public static void info(Object info) {
        LOGGER_GOHD.info(info);
    }

    public static void warn(Object info) {
        LOGGER_GOHD.warn(info);
    }

    public static void error(Object info) {
        LOGGER_GOHD.error(info);
    }

    public static void infoDebug(Object info) {
        if (GOHDConfig.isDebug) {
            LOGGER_GOHD.info(info);
        }
    }

    public static void warnDebug(Object info) {
        if (GOHDConfig.isDebug) {
            LOGGER_GOHD.warn(info);
        }
    }

    public static void errorDebug(Object info) {
        if (GOHDConfig.isDebug) {
            LOGGER_GOHD.error(info);
        }
    }
}
