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

    public ItemBookSpawn() {
        super("book_spawn");
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
        BlockPos spawnPoint = world.getSpawnPoint();
        double SpawnX = spawnPoint.getX() + 0.5;
        double SpawnY = 128.0;
        double SpawnZ = spawnPoint.getZ() + 0.5;
        player.setLocationAndAngles(SpawnX, SpawnY, SpawnZ, 0, 0);
        if (!world.isRemote) {
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name", new Object()));
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.spawn.name", new Object()));
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name", new Object()));
        }
        return new ActionResult(EnumActionResult.SUCCESS, stack);
    }
}
