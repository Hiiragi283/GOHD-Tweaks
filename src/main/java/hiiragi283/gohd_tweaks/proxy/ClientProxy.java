package hiiragi283.gohd_tweaks.proxy;

import hiiragi283.gohd_tweaks.GOHDInit;
import hiiragi283.gohd_tweaks.GOHDTweaks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {

    //代入されたItemとmetaに応じてモデルファイルのパスを登録するメソッド
    @SideOnly(Side.CLIENT)
    public static void setModel(Item item) {
        //itemがメタデータを使用する場合
        if (item.getHasSubtypes()) {
            GOHDTweaks.LoggerGOHD.info(item.getRegistryName() + " uses " + item.getMetadata(32768) + " metadata!");
            //メタデータが最大値になるまで処理を繰り返す
            for (int i = 0; i < item.getMetadata(283) + 1; i++) {
                ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName() + "_" + i, "inventory"));
            }
        } else {
            GOHDTweaks.LoggerGOHD.info(item.getRegistryName() + " doesn't use metadata...");
            //itemが耐久地を持っている場合，メタデータが0番のものだけ設定
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName() + "_" + 0, "inventory"));
        }
    }

    //Client側のProxyで行われる処理をまとめたメソッド
    public void Init() {
        setModels();
    }

    //各Itemのモデルファイルのパスを指定するメソッド
    public void setModels() {
        setModel(GOHDInit.ItemBlockDust);
        setModel(GOHDInit.ItemBookSpawn);
        setModel(GOHDInit.ItemBookSyntax);
        setModel(GOHDInit.ItemGroutFormed);
        setModel(GOHDInit.ItemPartsAssembly);
        setModel(GOHDInit.ItemRagiTicket);
        setModel(GOHDInit.ItemSandPaper);
        setModel(GOHDInit.ItemSandPaperDiamond);
    }
}
