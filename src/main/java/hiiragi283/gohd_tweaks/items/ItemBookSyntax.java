package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.util.RagiUtils;
import hiiragi283.gohd_tweaks.base.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class ItemBookSyntax extends ItemBase {

    //Itemの定義
    public ItemBookSyntax() {
        super("book_syntax"); //IDの設定
    }

    //メタデータの最大値を得るメソッド
    public int getMaxMeta() {
        //0を返す
        return 0;
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
        return new ActionResult(EnumActionResult.SUCCESS, stack);
    }
}
