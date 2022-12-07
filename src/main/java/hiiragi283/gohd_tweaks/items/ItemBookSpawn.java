package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.util.ItemCommon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class ItemBookSpawn extends ItemCommon {

    private final int maxMeta;

    //Itemの定義
    public ItemBookSpawn() {
        super("book_spawn"); //IDの設定
        maxMeta = 0; //メタデータの最大値を0に設定
    }

    //メタデータの最大値を得るメソッド
    public int getMaxMeta() {
        //maxMetaに代入された値を返す
        return maxMeta;
    }

    //Rarityを得るメソッド
    public EnumRarity getRarity(ItemStack item) {
        //EPICを返す
        return EnumRarity.EPIC;
    }

    //アイテムを右クリックすると呼ばれるevent
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        //各値の取得
        ItemStack stack = player.getHeldItem(hand);
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
        return new ActionResult(EnumActionResult.SUCCESS, stack);
    }
}
