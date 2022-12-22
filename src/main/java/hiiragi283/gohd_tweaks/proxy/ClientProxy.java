package hiiragi283.gohd_tweaks.proxy;

import hiiragi283.gohd_tweaks.GOHDInit;
import hiiragi283.gohd_tweaks.block.BlockDust;
import hiiragi283.gohd_tweaks.block.BlockHeating;
import hiiragi283.gohd_tweaks.item.ItemBlockDust;
import hiiragi283.gohd_tweaks.item.ItemBlockHeating;
import hiiragi283.gohd_tweaks.item.ItemDust;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;

public class ClientProxy extends CommonProxy {

    //Pre-Initializationで読み込むメソッド
    public void loadPreInit() {
        setModels();
    }

    //Initializationで読み込むメソッド
    public void loadInit() {
        setColors();
    }

    //Post-Initializationで読み込むメソッド
    public void loadPostInit() {}

    //代入されたItemに応じてモデルファイルのパスを登録するメソッド
    @SideOnly(Side.CLIENT)
    public void setModel(Item item) {
        //itemがメタデータを使用する場合
        if (item.getHasSubtypes()) {
            //メタデータが最大値になるまで処理を繰り返す
            for (int i = 0; i < item.getMetadata(283) + 1; i++) {
                ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName() + "_" + i, "inventory"));
            }
        } else {
            //itemが耐久地を持っている場合，IDから設定
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
        }
    }

    //メタデータによらず特定のモデルファイルだけを利用させるメソッド
    @SideOnly(Side.CLIENT)
    public void setModelSame(Item item) {
        //メタデータが最大値になるまで処理を繰り返す
        for (int i = 0; i < item.getMetadata(283) + 1; i++) {
            ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
        }
    }

    //代入されたIBlockColorをBlockに登録するメソッド
    @SideOnly(Side.CLIENT)
    public void setColor(IBlockColor color, Block block) {
        Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(color, block);
    }

    //代入されたIItemColorをItemに登録するメソッド
    @SideOnly(Side.CLIENT)
    public void setColor(IItemColor color, Item item) {
        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(color, item);
    }

    //各Itemのモデルファイルのパスを指定するメソッド
    public void setModels() {
        setModel(GOHDInit.ItemBlockHeating);
        setModel(GOHDInit.ItemBookDebug);
        setModel(GOHDInit.ItemGroutFormed);
        setModel(GOHDInit.ItemPartsAssembly);
        setModelSame(GOHDInit.ItemBlockDust);
        setModelSame(GOHDInit.ItemDust);
        setModelSame(GOHDInit.ItemMoldTitanium);
        setModelSame(GOHDInit.ItemRagiTicket);
        setModelSame(GOHDInit.ItemRuler);
        setModelSame(GOHDInit.ItemSandPaper);
        setModelSame(GOHDInit.ItemSandPaperDiamond);
    }

    //各Itemの着色を指定するメソッド
    public void setColors() {
        setColor(new BlockDust(), GOHDInit.BlockDust);
        setColor(new BlockHeating(), GOHDInit.BlockHeating);
        setColor(new ItemBlockDust(), GOHDInit.ItemBlockDust);
        setColor(new ItemBlockHeating(), GOHDInit.ItemBlockHeating);
        setColor(new ItemDust(), GOHDInit.ItemDust);
    }
}