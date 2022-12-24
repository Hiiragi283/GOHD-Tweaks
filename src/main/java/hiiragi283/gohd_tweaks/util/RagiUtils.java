package hiiragi283.gohd_tweaks.util;

import hiiragi283.gohd_tweaks.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Objects;

public class RagiUtils {

    //コマンドを実行するメソッド
    public static void executeCommand(ICommandSender sender, String command) {
        if (Objects.nonNull(Reference.SERVER)) {
            Reference.SERVER.getCommandManager().executeCommand(sender, command);
        }
    }

    //ResourceLocationからBlockを取得するメソッド
    //Blockがnullの場合はバリアブロックを返す
    public static Block getBlock(String domain, String path) {
        ResourceLocation location = new ResourceLocation(domain, path);
        Block block = ForgeRegistries.BLOCKS.getValue(location);
        if (Objects.nonNull(block)) return block;
        else {
            Reference.LOGGER_GOHD.warn("The block <" + location + "> was not found!");
            return Blocks.BARRIER;
        }
    }

    //液体名からFluidを取得するメソッド
    //Fluidがnullの場合は水を返す
    public static Fluid getFluid(String name) {
        Fluid fluid = net.minecraftforge.fluids.FluidRegistry.getFluid(name);
        Fluid water = net.minecraftforge.fluids.FluidRegistry.getFluid("water");
        if (Objects.nonNull(fluid)) return fluid;
        else {
            Reference.LOGGER_GOHD.warn("The fluid <fluid:" + name + "> was not found!");
            return water;
        }
    }

    //ResourceLocationからItemを取得するメソッド
    //Itemがnullの場合はバリアブロックを返す
    public static Item getItem(String domain, String path) {
        ResourceLocation location = new ResourceLocation(domain, path);
        Item item = ForgeRegistries.ITEMS.getValue(location);
        Item barrier = ForgeRegistries.ITEMS.getValue(new ResourceLocation("minecraft", "barrier"));
        if (Objects.nonNull(item)) return item;
        else {
            Reference.LOGGER_GOHD.warn("The item <" + location + "> was not found!");
            return barrier;
        }
    }

    //ResourceLocationなどからItemStackを取得するメソッド
    //ItemStackがnullの場合はバリアブロックを返す
    public static ItemStack getStack(String domain, String path, int amount, int meta) {
        ResourceLocation location = new ResourceLocation(domain, path);
        Item item = ForgeRegistries.ITEMS.getValue(location);
        if (Objects.nonNull(item)) return new ItemStack(item, amount, meta);
        else {
            Reference.LOGGER_GOHD.warn("The item stack <" + location + ":" + meta + "> * " + amount + " was not found!");
            return new ItemStack(getItem("minecraft", "barrier"), amount, 0);
        }
    }

    //ResourceLocationなどからIBlockStateを取得するメソッド
    //IBlockStateがnullの場合はバリアブロックを返す
    public static IBlockState getState(String domain, String path, int meta) {
        Block block = getBlock(domain, path);
        IBlockState state = block.getStateFromMeta(meta);
        if (block != Blocks.BARRIER) return state;
        else {
            Reference.LOGGER_GOHD.warn("The blockstate <blockstate:" + block + ":" + meta + "> was not found!");
            return Blocks.BARRIER.getDefaultState();
        }
    }

    public static IBlockState getState(Block block, int meta) {
        IBlockState state = block.getStateFromMeta(meta);
        if (block != Blocks.BARRIER) return state;
        else {
            Reference.LOGGER_GOHD.warn("The blockstate <blockstate:" + block + ":" + meta + "> was not found!");
            return Blocks.BARRIER.getDefaultState();
        }
    }

    //ResourceLocationからPotionを取得するメソッド
    //Potionがnullの場合は不運を返す
    public static Potion getPotion(String domain, String path) {
        ResourceLocation location = new ResourceLocation(domain, path);
        Potion potion = ForgeRegistries.POTIONS.getValue(location);
        Potion unluck = ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "unluck"));
        if (Objects.nonNull(potion)) return potion;
        else {
            Reference.LOGGER_GOHD.warn("The potion <potion:" + location + "> was not found!");
            return unluck;
        }
    }

    //ResourceLocationなどからPotionEffectを取得するメソッド
    public static PotionEffect getPotionEffect(String domain, String path, int time, int level) {
        return new PotionEffect(getPotion(domain, path), time, level);
    }

    //ResourceLocationからSoundEventを取得するメソッド
    //SoundEventがnullの場合はレベルアップの音を返す
    public static SoundEvent getSound(String domain, String path) {
        ResourceLocation location = new ResourceLocation(domain, path);
        SoundEvent sound = ForgeRegistries.SOUND_EVENTS.getValue(location);
        SoundEvent levelUp = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("minecraft", "entity.player.levelup"));
        if (Objects.nonNull(sound)) return sound;
        else {
            Reference.LOGGER_GOHD.warn("The sound <soundevent:" + location + "> was not found!");
            return levelUp;
        }
    }

    //クラフトレシピを削除するメソッド
    public static void removeCrafting(ResourceLocation location) {
        //locationからレシピを取得
        IRecipe recipeBefore = CraftingManager.getRecipe(location);
        //recipeBeforeから素材のリストを取得
        NonNullList<Ingredient> ingBefore = recipeBefore.getIngredients();
        //ingBeforeの中身を消す
        ingBefore.clear();
        //置き換え後のレシピを作成
        IRecipe recipeAfter = new ShapedRecipes(location.toString(), 1, 1, ingBefore, ItemStack.EMPTY);
        //recipeAfterに名前を設定
        recipeAfter.setRegistryName(location);
        //レシピを置き換える
        ForgeRegistries.RECIPES.register(recipeAfter);
        //
        Reference.LOGGER_GOHD.info("The recipe <recipe" + location + "> was removed successfully!");
    }

    //鉱石辞書を追加するメソッド
    public static void setOreDict(String oreDict, ItemStack stack) {
        OreDictionary.registerOre(oreDict, stack);
        Reference.LOGGER_GOHD.info("New ore dictionary <ore:" + oreDict + "> was added to" + stackToBracket(stack));
    }

    //titleコマンドをより簡潔に実行するメソッド
    public static void setTitle(EntityPlayer player, String title, String subtitle) {
        //コマンドの実行結果を出力しないようにする
        RagiUtils.executeCommand(player, "gamerule sendCommandFeedback false");
        //titleの設定
        RagiUtils.executeCommand(player, "title @p times 20 60 20");
        RagiUtils.executeCommand(player, "title @p title [{\"translate\":\"" + title + "\"}]");
        RagiUtils.executeCommand(player, "title @p subtitle {\"translate\":\"" + subtitle + "\"}");
    }

    //Hypixelで慣れ親しんだこの音声を再び聞いたとき，感動で泣きそうになりました
    public static void soundHypixel(World world, BlockPos pos) {
        world.playSound(null, pos, RagiUtils.getSound("minecraft", "entity.player.levelup"), SoundCategory.BLOCKS, 1.0F, 0.5F);
    }

    //ItemStackをCrTのブラケット記法に変換するメソッド (ログ出力用)
    public static String stackToBracket(ItemStack stack) {
        Item item = stack.getItem();
        ResourceLocation location = item.getRegistryName();
        int amount = stack.getCount();
        int meta = stack.getMetadata();
        return "<" + location + ":" + meta + "> * " + amount;
    }
}