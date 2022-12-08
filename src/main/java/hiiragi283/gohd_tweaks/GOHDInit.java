package hiiragi283.gohd_tweaks;

import hiiragi283.gohd_tweaks.blocks.BlockDust;
import hiiragi283.gohd_tweaks.blocks.BlockGroutFormed;
import hiiragi283.gohd_tweaks.events.onPlayerLoggedIn;
import hiiragi283.gohd_tweaks.events.onPlayerTick;
import hiiragi283.gohd_tweaks.events.onRightClickBlock;
import hiiragi283.gohd_tweaks.items.*;
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
    public static Item ItemBookSpawn = new ItemBookSpawn();
    public static Item ItemBookSyntax = new ItemBookSyntax();
    public static Item ItemGroutFormed = new ItemGroutFormed();
    public static Item ItemPartsAssembly = new ItemPartsAssembly();
    public static Item ItemRagiTicket = new ItemRagiTicket();
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
        MinecraftForge.EVENT_BUS.register(new onPlayerLoggedIn());
        MinecraftForge.EVENT_BUS.register(new onPlayerTick());
        MinecraftForge.EVENT_BUS.register(new onRightClickBlock());
    }

    //Itemを登録するメソッド
    public static void RegisterItems() {
        ForgeRegistries.ITEMS.register(ItemBlockDust);
        ForgeRegistries.ITEMS.register(ItemBookSpawn);
        ForgeRegistries.ITEMS.register(ItemBookSyntax);
        ForgeRegistries.ITEMS.register(ItemGroutFormed);
        ForgeRegistries.ITEMS.register(ItemPartsAssembly);
        ForgeRegistries.ITEMS.register(ItemRagiTicket);
        ForgeRegistries.ITEMS.register(ItemSandPaper);
        ForgeRegistries.ITEMS.register(ItemSandPaperDiamond);
    }
}
