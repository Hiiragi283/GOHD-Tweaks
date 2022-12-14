package hiiragi283.gohd_tweaks.event;

import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerLoggedIn {

    //プレイヤーがログインすると呼ばれるevent
    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        //サーバー側のみで実行
        if (!event.player.world.isRemote) {
            //各値の取得
            EntityPlayer player = event.player;
            World world = player.world;
            //音声を流す
            RagiUtils.soundHypixel(world, player.getPosition());
            //さらにHypixelから学んだ結果
            RagiUtils.setTitle(player, "text.gohd_tweaks.welcome.name", "text.gohd_tweaks.welcome_sub.name");
        }
    }
}