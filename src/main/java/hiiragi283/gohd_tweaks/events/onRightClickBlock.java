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

import java.util.Map;
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
        IBlockState blockstate = world.getBlockState(pos);
        Block block = blockstate.getBlock();
        //サーバー側のみで実行
        if (!world.isRemote) {
            //デバッグ用
            if (item.getRegistryName().toString().equals("theoneprobe:creativeprobe")) {
                player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name"));
                //ブロックの翻訳名をチャットに表示
                player.sendMessage(new TextComponentString("§lName:§r " + block.getPickBlock(blockstate, player.rayTrace(0, 0), world, pos, player).getDisplayName()));
                //ブロックのIDをチャットに表示
                player.sendMessage(new TextComponentString("§lID:§r " + block.getRegistryName()));
                //ブロックのBlockstateをチャットに表示
                player.sendMessage(new TextComponentString("§lBlockstate:§r " + blockstate));
                //ブロックのHardnessをチャットに表示
                player.sendMessage(new TextComponentString("§lHardness:§r " + block.getBlockHardness(blockstate, world, pos)));
                //ブロックのResistanceをチャットに表示
                player.sendMessage(new TextComponentString("§lResistance:§r " + block.getExplosionResistance(player)));
                //適正ツールをチャットに表示
                player.sendMessage(new TextComponentString("§lHarvest Tool:§r " + block.getHarvestTool(blockstate)));
                //適正レベルをチャットに表示
                player.sendMessage(new TextComponentString("§lHarvest Level:§r " + block.getHarvestLevel(blockstate)));
            }
            //根ブロックを苔玉で右クリックすると苔を生やすwww
            /*if (item.getRegistryName().toString().equals("tconstruct:materials") && stack.getMetadata() == 18) {
                //blockstateが根ブロックに等しい場合
                if (blockstate == RagiUtils.getBlock("twilightforest", "root").getStateFromMeta(0)) {
                    //blockstateを根ブロック(苔)に差し替える
                    world.setBlockState(pos, block.getStateFromMeta(1));
                    //これだけだと味気ないので音も生やす
                    world.playSound(null, pos, RagiUtils.getSound("minecraft", "block.waterlily.place"), SoundCategory.BLOCKS, 1.0F, 1.0F);
                    //苔玉を1つ減らす
                    stack.shrink(1);
                }
            }*/
            //stackCompareと対応する組み合わせがある場合
            if (Objects.nonNull(RagiMap.MapRightClickBlock.get(stackCompare))) {
                //対応するMapを取得する
                Map<IBlockState, IBlockState> recipeMap = RagiMap.MapRightClickBlock.get(stackCompare);
                //recipeMap内の各keyに対して実行
                for (IBlockState stateKey : recipeMap.keySet()) {
                    //stateKeyと対応する組み合わせがある場合
                    if (Objects.nonNull(recipeMap.get(stateKey))) {
                        //blockstateを差し替える
                        world.setBlockState(pos, recipeMap.get(stateKey));
                        //stackのサイズを1つ減らす
                        stack.shrink(1);
                        //負荷軽減のためbreakで無駄な検索を省く
                        break;
                    }
                }
            }
        }
    }
}
