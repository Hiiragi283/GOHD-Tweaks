package hiiragi283.gohd_tweaks.events;

import hiiragi283.gohd_tweaks.util.RagiMap;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class onRightClickBlock {

    //ブロックを右クリックすると呼ばれるevent
    @SubscribeEvent
    public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        //各値の取得
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        ItemStack stackCompare = new ItemStack(item, 1, stack.getMetadata()); //比較用にスタック数を1に置き換えたもの
        EntityPlayer player = event.getEntityPlayer();
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        //サーバー側のみで実行
        if (!world.isRemote) {
            //デバッグ用
            if (item.getRegistryName().toString().equals("theoneprobe:creativeprobe")) {
                player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name"));
                //ブロックの翻訳名をチャットに表示
                player.sendMessage(new TextComponentString("§lName:§r " + block.getPickBlock(state, player.rayTrace(0, 0), world, pos, player).getDisplayName()));
                //ブロックのIDをチャットに表示
                player.sendMessage(new TextComponentString("§lID:§r " + block.getRegistryName()));
                //ブロックのBlockstateをチャットに表示
                player.sendMessage(new TextComponentString("§lBlockstate:§r " + state));
                //ブロックのHardnessをチャットに表示
                player.sendMessage(new TextComponentString("§lHardness:§r " + block.getBlockHardness(state, world, pos)));
                //ブロックのResistanceをチャットに表示
                player.sendMessage(new TextComponentString("§lResistance:§r " + block.getExplosionResistance(player)));
                //適正ツールをチャットに表示
                player.sendMessage(new TextComponentString("§lHarvest Tool:§r " + block.getHarvestTool(state)));
                //適正レベルをチャットに表示
                player.sendMessage(new TextComponentString("§lHarvest Level:§r " + block.getHarvestLevel(state)));
            }
            //stackCompareと対応する組み合わせがある場合
            if (Objects.nonNull(RagiMap.MapRightClickItem.get(stackCompare))) {
                //対応するIBlockStateを取得する
                IBlockState stateFrom = RagiMap.MapRightClickItem.get(stackCompare);
                //stateとstateFromが一致、かつstateFromと対応する組み合わせがある場合
                if (state.equals(stateFrom) && Objects.nonNull(RagiMap.MapSandpaperBlock.get(stateFrom))) {
                    //posにあるblockstateを取得した値で上書きする
                    world.setBlockState(pos, RagiMap.MapRightClickBlock.get(stateFrom));
                    //stackを1つ減らす
                    stack.shrink(1);
                }
            }
        }
    }
}
