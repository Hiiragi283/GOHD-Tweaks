package hiiragi283.gohd_tweaks.init;

import hiiragi283.gohd_tweaks.base.ItemBase;
import hiiragi283.gohd_tweaks.base.ItemBlockBase;
import hiiragi283.gohd_tweaks.block.BlockDust;
import hiiragi283.gohd_tweaks.block.BlockGroutFormed;
import hiiragi283.gohd_tweaks.block.BlockHeating;
import hiiragi283.gohd_tweaks.event.PlayerChangedDimension;
import hiiragi283.gohd_tweaks.event.PlayerLoggedIn;
import hiiragi283.gohd_tweaks.event.PlayerTick;
import hiiragi283.gohd_tweaks.event.RightClickBlock;
import hiiragi283.gohd_tweaks.item.*;
import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class GOHDRegistry {
    //Blockの定義
    public static Block BlockDust = new BlockDust();
    public static Block BlockGroutFormed = new BlockGroutFormed();
    public static Block BlockHeating = new BlockHeating();
    //Itemの定義
    public static Item ItemBlockDust = new ItemBlockDust();
    public static Item ItemBlockHeating = new ItemBlockHeating();
    public static Item ItemBookDebug = new ItemBookDebug();
    public static Item ItemDust = new ItemDust();
    public static Item ItemGroutFormed = new ItemBlockBase(GOHDRegistry.BlockGroutFormed, 2);
    public static Item ItemMoldTitanium = new ItemMoldTitanium();
    public static Item ItemPartsAssembly = new ItemBase("parts_assembly", 4);
    public static Item ItemRagiTicket = new ItemRagiTicket();
    public static Item ItemRuler = new ItemRuler();
    public static Item ItemSandPaper = new ItemSandPaper();
    public static Item ItemSandPaperDiamond = new ItemSandPaperDiamond();

    //Blockを登録するメソッド
    public static void registerBlocks() {
        ForgeRegistries.BLOCKS.register(BlockDust);
        ForgeRegistries.BLOCKS.register(BlockGroutFormed);
        ForgeRegistries.BLOCKS.register(BlockHeating);
    }

    //Eventを登録するメソッド
    public static void registerEvents() {
        MinecraftForge.EVENT_BUS.register(new PlayerChangedDimension());
        MinecraftForge.EVENT_BUS.register(new PlayerLoggedIn());
        MinecraftForge.EVENT_BUS.register(new PlayerTick());
        MinecraftForge.EVENT_BUS.register(new RightClickBlock());
    }

    //Itemを登録するメソッド
    public static void registerItems() {
        ForgeRegistries.ITEMS.register(ItemBlockDust);
        ForgeRegistries.ITEMS.register(ItemBlockHeating);
        ForgeRegistries.ITEMS.register(ItemBookDebug);
        ForgeRegistries.ITEMS.register(ItemDust);
        ForgeRegistries.ITEMS.register(ItemGroutFormed);
        ForgeRegistries.ITEMS.register(ItemMoldTitanium);
        ForgeRegistries.ITEMS.register(ItemPartsAssembly);
        ForgeRegistries.ITEMS.register(ItemRagiTicket);
        ForgeRegistries.ITEMS.register(ItemRuler);
        ForgeRegistries.ITEMS.register(ItemSandPaper);
        ForgeRegistries.ITEMS.register(ItemSandPaperDiamond);
    }

    //鉱石辞書を登録するメソッド
    public static void registerOreDict() {
        RagiUtils.setOreDict("dustSoulSand", new ItemStack(GOHDRegistry.ItemDust, 1, 0));
        RagiUtils.setOreDict("dustEndstone", new ItemStack(GOHDRegistry.ItemDust, 1, 1));
    }

}