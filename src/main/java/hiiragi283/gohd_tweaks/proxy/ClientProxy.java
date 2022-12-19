package hiiragi283.gohd_tweaks.proxy;

import hiiragi283.gohd_tweaks.GOHDInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;

public class ClientProxy extends CommonProxy {

    //代入されたItemに応じてモデルファイルのパスを登録するメソッド
    @SideOnly(Side.CLIENT)
    public void SetModel(Item item) {
        //itemがメタデータを使用する場合
        if (item.getHasSubtypes()) {
            //メタデータが最大値になるまで処理を繰り返す
            for (int i = 0; i < item.getMetadata(283) + 1; i++) {
                ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName() + "_" + i, "inventory"));
            }
        } else {
            //itemが耐久地を持っている場合，メタデータが0番のものだけ設定
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName() + "_" + 0, "inventory"));
        }
    }

    //メタデータによらず特定のモデルファイルだけを利用させるメソッド
    @SideOnly(Side.CLIENT)
    public void SetModelSame(Item item) {
        //メタデータが最大値になるまで処理を繰り返す
        for (int i = 0; i < item.getMetadata(283) + 1; i++) {
            ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
        }
    }

    //代入されたIItemColorをItemに登録するメソッド
    @SideOnly(Side.CLIENT)
    public void SetColor(IItemColor color, Item item) {
        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(color, item);
    }

    //各Itemのモデルファイルのパスを指定するメソッド
    public void SetModels() {
        SetModel(GOHDInit.ItemBookDebug);
        SetModel(GOHDInit.ItemGroutFormed);
        SetModel(GOHDInit.ItemPartsAssembly);
        SetModelSame(GOHDInit.ItemBlockDust);
        SetModelSame(GOHDInit.ItemMoldTitanium);
        SetModelSame(GOHDInit.ItemRagiTicket);
        SetModelSame(GOHDInit.ItemRuler);
        SetModelSame(GOHDInit.ItemSandPaper);
        SetModelSame(GOHDInit.ItemSandPaperDiamond);
    }

    //各Itemの着色を指定するメソッド
    public void SetColors() {
    }
}