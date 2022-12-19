package hiiragi283.gohd_tweaks.base;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;

public class ItemBlockBase extends ItemBlock {

    //private変数の宣言
    private final int maxMeta;

    //コンストラクタの宣言
    public ItemBlockBase(Block block, int maxMeta) {
        super(block); //BlockからItemを生成する
        this.setRegistryName(Objects.requireNonNull(block.getRegistryName())); //翻訳キーはblockのものから取得
        this.setHasSubtypes(true); //メタデータを使用する
        this.maxMeta = maxMeta; //メタデータの最大値を代入
    }

    //メタデータの最大値を得るメソッド
    public int getMaxMeta() {
        //maxMetaを返す
        return maxMeta;
    }

    //メタデータを得るメソッド
    @Override
    public int getMetadata(int damage) {
        //代入した値とmaxMetaを比較し、小さい方を返す
        return Math.min(damage, getMaxMeta());
    }

    //翻訳キーを得るメソッド
    @Nonnull
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        //メタデータごとに異なる翻訳キーを返す
        return super.getUnlocalizedName() + "." + stack.getMetadata();
    }

    //メタデータ付きアイテムをクリエイティブタブに登録するメソッド
    @Override
    @ParametersAreNonnullByDefault
    @SideOnly(Side.CLIENT) //Client側のみ
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        if (this.isInCreativeTab(tab)) {
            //listの定義
            List<ItemStack> list = Lists.newArrayList();
            //maxMetaまで処理を繰り返す
            for (int i = 0; i < getMaxMeta() + 1; i++) {
                list.add(new ItemStack(this, 1, i));
            }
            //list内のすべてのアイテムをクリエイティブタブに登録
            subItems.addAll(list);
        }
    }
}