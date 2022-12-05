package hiiragi283.gohd_tweaks;

import hiiragi283.gohd_tweaks.blocks.BlockDust;
import hiiragi283.gohd_tweaks.blocks.BlockGroutFormed;
import hiiragi283.gohd_tweaks.items.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
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

    public static void Register() {
        //Blockの登録
        ForgeRegistries.BLOCKS.register(BlockDust);
        ForgeRegistries.BLOCKS.register(BlockGroutFormed);
        //Itemの登録
        ForgeRegistries.ITEMS.register(ItemBlockDust);
        ForgeRegistries.ITEMS.register(ItemBookSpawn);
        ForgeRegistries.ITEMS.register(ItemBookSyntax);
        ForgeRegistries.ITEMS.register(ItemGroutFormed);
        ForgeRegistries.ITEMS.register(ItemPartsAssembly);
        ForgeRegistries.ITEMS.register(ItemRagiTicket);
    }
}
