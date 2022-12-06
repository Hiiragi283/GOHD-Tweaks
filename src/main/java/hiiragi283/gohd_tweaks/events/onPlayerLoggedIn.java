package hiiragi283.gohd_tweaks.events;

import hiiragi283.gohd_tweaks.util.GOHDUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class onPlayerLoggedIn {

    //プレイヤーがログインすると呼ばれるevent
    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        //各値の取得
        EntityPlayer player = event.player;
        World world = player.world;
        //サーバー側のみで実行
        if (!world.isRemote) {
            //音声とチャットを流す
            //Hypixelで慣れ親しんだこの音声を再び聞いたとき，感動で泣きそうになりました
            world.playSound(null, player.getPosition(), GOHDUtils.getSound("minecraft", "entity.player.levelup"), SoundCategory.BLOCKS, 1.0F, 0.5F);
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name"));
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.welcome.name"));
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name"));
        }
    }
}
