package hiiragi283.gohd_tweaks;

import hiiragi283.gohd_tweaks.base.ItemBase;
import hiiragi283.gohd_tweaks.base.ItemBlockBase;
import hiiragi283.gohd_tweaks.block.BlockDust;
import hiiragi283.gohd_tweaks.block.BlockGroutFormed;
import hiiragi283.gohd_tweaks.event.onPlayerChangedDimension;
import hiiragi283.gohd_tweaks.event.onPlayerLoggedIn;
import hiiragi283.gohd_tweaks.event.onPlayerTick;
import hiiragi283.gohd_tweaks.event.onRightClickBlock;
import hiiragi283.gohd_tweaks.item.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class GOHDInit {
    //Blockの定義
    public static Block BlockDust = new BlockDust();
    public static Block BlockGroutFormed = new BlockGroutFormed();
    //Itemの定義
    public static Item ItemBlockDust = new ItemBlockDust();
    public static Item ItemBookDebug = new ItemBookDebug();
    public static Item ItemGroutFormed = new ItemBlockBase(GOHDInit.BlockGroutFormed, 2);
    public static Item ItemMoldTitanium = new ItemMoldTitanium();
    public static Item ItemPartsAssembly = new ItemBase("parts_assembly", 4);
    public static Item ItemRagiTicket = new ItemRagiTicket();
    public static Item ItemRuler = new ItemRuler();
    public static Item ItemSandPaper = new ItemSandPaper();
    public static Item ItemSandPaperDiamond = new ItemSandPaperDiamond();

    //GOHDInit内のメソッドをまとめて登録するメソッド
    public static void Init() {
        RegisterBlocks();
        RegisterEvents();
        RegisterItems();
    }

    //Blockを登録するメソッド
    public static void RegisterBlocks() {
        ForgeRegistries.BLOCKS.register(BlockDust);
        ForgeRegistries.BLOCKS.register(BlockGroutFormed);
    }

    //Eventを登録するメソッド
    public static void RegisterEvents() {
        MinecraftForge.EVENT_BUS.register(new onPlayerChangedDimension());
        MinecraftForge.EVENT_BUS.register(new onPlayerLoggedIn());
        MinecraftForge.EVENT_BUS.register(new onPlayerTick());
        MinecraftForge.EVENT_BUS.register(new onRightClickBlock());
    }

    //Itemを登録するメソッド
    public static void RegisterItems() {
        ForgeRegistries.ITEMS.register(ItemBlockDust);
        ForgeRegistries.ITEMS.register(ItemBookDebug);
        ForgeRegistries.ITEMS.register(ItemGroutFormed);
        ForgeRegistries.ITEMS.register(ItemMoldTitanium);
        ForgeRegistries.ITEMS.register(ItemPartsAssembly);
        ForgeRegistries.ITEMS.register(ItemRagiTicket);
        ForgeRegistries.ITEMS.register(ItemRuler);
        ForgeRegistries.ITEMS.register(ItemSandPaper);
        ForgeRegistries.ITEMS.register(ItemSandPaperDiamond);
    }
}