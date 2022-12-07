package hiiragi283.gohd_tweaks.util;

import hiiragi283.gohd_tweaks.Reference;
import net.minecraft.block.Block;
import net.minecraft.command.ICommandSender;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class RagiUtils {

    //コマンドを実行するメソッド
    public static void executeCommand(ICommandSender sender, String command) {
        Reference.server.getCommandManager().executeCommand(sender, command);
    }

    //ResourceLocationからBlockを取得するメソッド
    public static Block getBlock(String domain, String path) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(domain, path));
    }

    //液体名からFluidを取得するメソッド
    public static Fluid getFluid(String name) {
        return net.minecraftforge.fluids.FluidRegistry.getFluid(name);
    }

    //ResourceLocationからItemを取得するメソッド
    public static Item getItem(String domain, String path) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(domain, path));
    }

    //ResourceLocationなどからItemStackを取得するメソッド
    public static ItemStack getStack(String domain, String path, int amount, int meta) {
        return new ItemStack(getItem(domain, path), amount, meta);
    }

    //ResourceLocationからPotionを取得するメソッド
    public static Potion getPotion(String domain, String path) {
        return ForgeRegistries.POTIONS.getValue(new ResourceLocation(domain, path));
    }

    //ResourceLocationなどからPotionEffectを取得するメソッド
    public static PotionEffect getPotionEffect(String domain, String path, int time, int level) {
        return new PotionEffect(getPotion(domain, path), time, level);
    }

    //ResourceLocationからSoundEventを取得するメソッド
    public static SoundEvent getSound(String domain, String path) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(domain, path));
    }
}
