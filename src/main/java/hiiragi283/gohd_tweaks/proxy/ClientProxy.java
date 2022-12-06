package hiiragi283.gohd_tweaks.proxy;

import hiiragi283.gohd_tweaks.GOHDInit;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {

    //代入されたItemとmetaに応じてモデルファイルのパスを登録するメソッド
    @SideOnly(Side.CLIENT)
    public static void setModel(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName() + "_" + meta, "inventory"));
    }

    //各Itemのモデルファイルのパスを指定するメソッド
    public void setModels() {
        setModel(GOHDInit.ItemBlockDust, 0);
        setModel(GOHDInit.ItemBlockDust, 1);
        setModel(GOHDInit.ItemBlockDust, 2);
        setModel(GOHDInit.ItemBlockDust, 3);
        setModel(GOHDInit.ItemBlockDust, 4);
        setModel(GOHDInit.ItemBlockDust, 5);
        setModel(GOHDInit.ItemBookSpawn, 0);
        setModel(GOHDInit.ItemBookSyntax, 0);
        setModel(GOHDInit.ItemGroutFormed, 0);
        setModel(GOHDInit.ItemGroutFormed, 1);
        setModel(GOHDInit.ItemGroutFormed, 2);
        setModel(GOHDInit.ItemPartsAssembly, 0);
        setModel(GOHDInit.ItemPartsAssembly, 1);
        setModel(GOHDInit.ItemPartsAssembly, 2);
        setModel(GOHDInit.ItemPartsAssembly, 3);
        setModel(GOHDInit.ItemPartsAssembly, 4);
        setModel(GOHDInit.ItemRagiTicket, 0);
        setModel(GOHDInit.ItemSandPaper, 0);
    }

    //Client側のProxyで行われる処理をまとめたメソッド
    public void Init() {
        setModels();
    }
}
