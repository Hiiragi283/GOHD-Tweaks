package hiiragi283.gohd_tweaks.event;

import hiiragi283.gohd_tweaks.Reference;
import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class RightClickBlock {

    //ブロックを右クリックすると呼ばれるevent
    @SubscribeEvent
    public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        //サーバー側のみで実行
        if (!event.getWorld().isRemote) {
            //各値の取得
            ItemStack stack = event.getItemStack();
            Item item = stack.getItem();
            ItemStack stackCompare = new ItemStack(item, 1, stack.getMetadata()); //比較用にスタック数を1に置き換えたもの
            EntityPlayer player = event.getEntityPlayer();
            World world = event.getWorld();
            BlockPos pos = event.getPos();
            IBlockState state = world.getBlockState(pos);
            Block block = state.getBlock();
            //取得した値をログに出力
            /*Reference.LOGGER_GOHD.info("============");
            Reference.LOGGER_GOHD.info(stack);
            Reference.LOGGER_GOHD.info(item);
            Reference.LOGGER_GOHD.info(stackCompare);
            Reference.LOGGER_GOHD.info(player);
            Reference.LOGGER_GOHD.info(world);
            Reference.LOGGER_GOHD.info(pos);
            Reference.LOGGER_GOHD.info(state);
            Reference.LOGGER_GOHD.info(block);*/
            //デバッグ用
            if (Objects.requireNonNull(item.getRegistryName()).toString().equals("theoneprobe:creativeprobe")) {
                player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name"));
                //ブロックの翻訳名をチャットに表示
                player.sendMessage(new TextComponentString("§lName:§r " + block.getPickBlock(state, Objects.requireNonNull(player.rayTrace(0, 0)), world, pos, player).getDisplayName()));
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
                player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name"));
            }
            //根ブロックを苔玉で右クリックすると苔を生やすwww
            if (item.getRegistryName().toString().equals("tconstruct:materials") && stack.getMetadata() == 18) {
                //blockstateが根ブロックに等しい場合
                if (state == RagiUtils.getBlock("twilightforest", "root").getStateFromMeta(0)) {
                    //blockstateを根ブロック(苔)に差し替える
                    world.setBlockState(pos, block.getStateFromMeta(1));
                    //これだけだと味気ないので音も生やす
                    world.playSound(null, pos, RagiUtils.getSound("minecraft", "block.waterlily.place"), SoundCategory.BLOCKS, 1.0F, 1.0F);
                    //苔玉を1つ減らす
                    stack.shrink(1);
                }
            }
        }
    }
}