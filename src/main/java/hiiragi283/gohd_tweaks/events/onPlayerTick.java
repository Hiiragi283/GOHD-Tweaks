package hiiragi283.gohd_tweaks.events;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Objects;

public class onPlayerTick {

    //各tickにおいてプレイヤーを対象に呼ばれるevent
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        //20tickに1回実行する (負荷対策) && サーバー側のみで実行
        if (event.player.world.getWorldTime() % 20 == 0 && !event.player.world.isRemote) {
            //各値の取得
            EntityPlayer player = event.player;
            World world = player.world;
            BlockPos pos = player.getPosition();
            IBlockState blockstate = world.getBlockState(pos);
            Block block = blockstate.getBlock();
            //プレイヤーが利き手にアイテムを持っている場合
            if (Objects.isNull(player.getHeldItemMainhand())) {
                //アイテムの値を取得する
                ItemStack stackMain = player.getHeldItemMainhand();
                Item itemMain = stackMain.getItem();
            }
            //プレイヤーが利き手ではない方の手にアイテムを持っている場合
            if (Objects.isNull(player.getHeldItemOffhand())) {
                //アイテムの値を取得する
                ItemStack stackOff = player.getHeldItemOffhand();
                Item itemOff = stackOff.getItem();
            }
        }
    }
}