package hiiragi283.gohd_tweaks.item;

import hiiragi283.gohd_tweaks.base.ItemBase;
import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ItemBookDebug extends ItemBase {

    //コンストラクタの宣言
    public ItemBookDebug() {
        super("book_debug", 1); //IDの設定
    }

    //Rarityを得るメソッド
    @Nonnull
    public EnumRarity getRarity(@Nonnull ItemStack item) {
        //EPICを返す
        return EnumRarity.EPIC;
    }

    //アイテムを右クリックすると呼ばれるevent
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        //Spawn用
        if (stack.getMetadata() == 0) {
            //各値の取得
            BlockPos spawnPoint = world.getSpawnPoint();
            double SpawnX = spawnPoint.getX() + 0.5; //ブロックの中心に来るよう調整
            double SpawnY = 128.0; //高度チェックが面倒なのでy=128に固定
            double SpawnZ = spawnPoint.getZ() + 0.5; //ブロックの中心に来るよう調整
            //プレイヤーを指定した座標にテレポート
            player.setLocationAndAngles(SpawnX, SpawnY, SpawnZ, 0, 0);
            //サーバー側のみで実行
            if (!world.isRemote) {
                //チャットにテキストを流す
                player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name", new Object()));
                player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.spawn.name", new Object()));
                player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name", new Object()));
            }
        }
        //CrT用
        else if (stack.getMetadata() == 1) {
            //サーバー側のみで実行
            if (!world.isRemote) {
                //コマンドを実行
                RagiUtils.executeCommand(player, "ct syntax");
                RagiUtils.executeCommand(player, "ct reload");
                //チャットにテキストを流す
                player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name", new Object()));
                player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.syntax.name", new Object()));
                player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name", new Object()));
            }
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
}
