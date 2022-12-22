package hiiragi283.gohd_tweaks.event;

import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerChangedDimension {
    //プレイヤーがディメンションを移動すると呼ばれるevent
    @SubscribeEvent
    public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        //サーバー側のみで実行
        if (!event.player.world.isRemote) {
            //各値の取得
            EntityPlayer player = event.player;
            World world = player.world;
            int dimID = event.toDim;
            //音声を流す
            RagiUtils.soundHypixel(world, player.getPosition());
            //ディメンションのidによって表示するtitleを変える
            switch (dimID) {
                case -1:
                    RagiUtils.setTitle(player, "text.gohd_tweaks.travel_nether.name", "text.gohd_tweaks.travel_nether_sub.name");
                    break;
                case 0:
                    RagiUtils.setTitle(player, "text.gohd_tweaks.travel_overworld.name", "text.gohd_tweaks.travel_overworld_sub.name");
                    break;
                case 1:
                    RagiUtils.setTitle(player, "text.gohd_tweaks.travel_end.name", "text.gohd_tweaks.travel_end_sub.name");
                    break;
                case 7:
                    RagiUtils.setTitle(player, "text.gohd_tweaks.travel_twilight.name", "text.gohd_tweaks.travel_twilight_sub.name");
                    break;
            }
        }
    }
}