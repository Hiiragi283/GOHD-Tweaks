package hiiragi283.gohd_tweaks;

import hiiragi283.gohd_tweaks.proxy.CommonProxy;
import hiiragi283.gohd_tweaks.recipes.IntegrationCore;
import hiiragi283.gohd_tweaks.util.GOHDUtils;
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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

//Modの定義
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES, acceptedMinecraftVersions = Reference.MC_VERSIONS)
public class GOHDTweaks {

    //ログ出力用
    public static final Logger LoggerGOHD = LogManager.getLogger(Reference.MOD_ID);
    //Proxyの定義
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    //Instanceの定義
    @Mod.Instance(Reference.MOD_ID)
    public static GOHDTweaks Instance;

    //Pre-Initializationの段階で呼ばれるevent
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //このクラスをイベントに登録
        MinecraftForge.EVENT_BUS.register(this);
        //BlockやItemの登録
        GOHDInit.Register();
        //ItemのModelの登録
        proxy.Register();
    }

    //Post-Initializationの段階で呼ばれるevent
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        //他modとの連携レシピの登録
        IntegrationCore.Init();
    }

    //プレイヤーがログインすると呼ばれるevent
    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        //各値の取得
        EntityPlayer player = event.player;
        World world = player.world;
        //サーバー側のみで実行
        if (!world.isRemote) {
            //音声とチャットを流す
            //Hypixelで慣れ親しんだこの音声を再び聞いたとき，感動で泣きそうになりました
            world.playSound(null, player.getPosition(), GOHDUtils.getSound("minecraft", "entity.player.levelup"), SoundCategory.BLOCKS, 1.0F, 0.5F);
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name"));
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.welcome.name"));
            player.sendMessage(new TextComponentTranslation("text.gohd_tweaks.decoration_line.name"));
        }
    }

    //各tickにおいてプレイヤーを対象に呼ばれるevent
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        //各値の取得
        EntityPlayer player = event.player;
        World world = player.world;
        BlockPos pos = player.getPosition();
        IBlockState blockstate = world.getBlockState(pos);
        Block block = blockstate.getBlock();
        //20tickに1回実行する (負荷対策) && サーバー側のみで実行
        if (world.getWorldTime() % 20 == 0 && !world.isRemote) {
            //プレイヤーが利き手にアイテムを持っている場合
            if (Objects.isNull(player.getHeldItemMainhand())) {
                //アイテムの値を取得する
                ItemStack stackMain = player.getHeldItemMainhand();
                Item itemMain = stackMain.getItem();
            }
            //プレイヤーが利き手ではない方の手にアイテムを持っている場合
            if (Objects.isNull(player.getHeldItemOffhand())) {
                //アイテムの値を取得する
                ItemStack stackOff = player.getHeldItemOffhand();
                Item itemOff = stackOff.getItem();
            }
        }
    }

    //ブロックを右クリックすると呼ばれるevent
    @SubscribeEvent
    public void onRightClickBlock(RightClickBlock event) {
        //各値の取得
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
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
            if (item.getRegistryName().toString().equals("tconstruct:materials") && stack.getMetadata() == 18) {
                //blockstateが根ブロックに等しい場合
                if (blockstate == GOHDUtils.getBlock("twilightforest", "root").getStateFromMeta(0)) {
                    //blockstateを根ブロック(苔)に差し替える
                    world.setBlockState(pos, block.getStateFromMeta(1));
                    //これだけだと味気ないので音も生やす
                    world.playSound(null, pos, GOHDUtils.getSound("minecraft", "block.waterlily.place"), SoundCategory.BLOCKS, 1.0F, 1.0F);
                }
            }
        }
    }
}
