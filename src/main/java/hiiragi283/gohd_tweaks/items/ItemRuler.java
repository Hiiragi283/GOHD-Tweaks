package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.base.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import java.util.Objects;

public class ItemRuler extends ItemBase {

    //Itemの定義
    public ItemRuler() {
        super("stainless_ruler", 0); //IDの設定
    }

    //Rarityを得るメソッド
    public EnumRarity getRarity(ItemStack item) {
        //RAREを返す
        return EnumRarity.RARE;
    }

    //アイテムを右クリックすると呼ばれるevent
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        //各値の取得
        ItemStack stack = player.getHeldItem(hand);
        //サーバー側のみで実行
        if (world.isRemote) {
            //プレイヤーの座標を取得
            BlockPos pos = player.getPosition();
            //stackがNBTタグを持っていない場合
            if (Objects.isNull(stack.getTagCompound())) {
                //NBTタグを生成
                NBTTagCompound nbtRuler = new NBTTagCompound();
                //nbtRulerに取得した座標を書き込んでいく
                nbtRuler.setInteger("fromX", pos.getX());
                nbtRuler.setInteger("fromY", pos.getY());
                nbtRuler.setInteger("fromZ", pos.getZ());
                //nbtRulerをNBTタグに代入
                stack.setTagCompound(nbtRuler);
            }
            //stackがNBTタグを持っている場合
            else {
                //stackからNBTタグを取得
                NBTTagCompound nbtRuler = stack.getTagCompound();
                //nbtRulerから座標を取得
                int fromX = nbtRuler.getInteger("fromX");
                int fromY = nbtRuler.getInteger("fromY");
                int fromZ = nbtRuler.getInteger("fromZ");
                String fromPos = "§b(" + fromX + ", " + fromY + ", " + fromX + ")§r§e";
                String toPos = "§b(" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")§r§e";
                //2点間の座標について計算
                int difX = Math.abs(fromX - pos.getX());
                int difY = Math.abs(fromY - pos.getY());
                int difZ = Math.abs(fromZ - pos.getZ());
                double sumLine = Math.pow(difX, 2) + Math.pow(difY, 2) + Math.pow(difZ, 2);
                double line = Math.sqrt(sumLine);
                //2点間の座標の計算結果をチャットに流す
                player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name"));
                player.sendMessage(new TextComponentString("§ePosition from: " + fromPos + " to: " + toPos));
                player.sendMessage(new TextComponentString("§eDifference of X: §r§b" + difX));
                player.sendMessage(new TextComponentString("§eDifference of Y: §r§b" + difY));
                player.sendMessage(new TextComponentString("§eDifference of Z: §r§b" + difZ));
                player.sendMessage(new TextComponentString("§eStraight distance: §r§b" + line));
                player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name"));
                //nbtRulerに取得した座標を書き込んでいく
                nbtRuler.setInteger("fromX", pos.getX());
                nbtRuler.setInteger("fromY", pos.getY());
                nbtRuler.setInteger("fromZ", pos.getZ());
                //nbtRulerをNBTタグに代入
                stack.setTagCompound(nbtRuler);
            }
        }
        return new ActionResult(EnumActionResult.SUCCESS, stack);
    }
}