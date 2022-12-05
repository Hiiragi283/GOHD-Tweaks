package hiiragi283.gohd_tweaks.items;

import hiiragi283.gohd_tweaks.util.ItemCommon;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class ItemBookSyntax extends ItemCommon {

    private final int maxMeta;

    public ItemBookSyntax() {
        super("book_syntax");
        maxMeta = 0;
    }

    public int getMaxMeta() {
        return maxMeta;
    }

    public EnumRarity getRarity(ItemStack item) {
        return EnumRarity.EPIC;
    }

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        MinecraftServer server = Minecraft.getMinecraft().getIntegratedServer();
        if (!world.isRemote) {
            server.getCommandManager().executeCommand(player, "ct syntax");
            server.getCommandManager().executeCommand(player, "ct reload");
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name", new Object()));
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.syntax.name", new Object()));
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name", new Object()));
        }
        return new ActionResult(EnumActionResult.SUCCESS, stack);
    }
}
