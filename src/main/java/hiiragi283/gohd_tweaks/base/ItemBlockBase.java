package hiiragi283.gohd_tweaks.base;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
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
    public String getUnlocalizedName(@Nonnull ItemStack stack) {
        //メタデータが0のみの場合、なにもしない
        if (maxMeta == 0) return super.getUnlocalizedName();
            //メタデータを使う場合、メタデータごとに異なる翻訳キーを返す
        else return super.getUnlocalizedName() + "." + stack.getMetadata();
    }

    //メタデータ付きアイテムをクリエイティブタブに登録するメソッド
    @Override
    @ParametersAreNonnullByDefault
    @SideOnly(Side.CLIENT) //Client側のみ
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        if (this.isInCreativeTab(tab)) {
            //listの定義
            List<ItemStack> list = Lists.newArrayList();
            //メタデータの最大値まで処理を繰り返す
            for (int i = 0; i < getMaxMeta() + 1; i++) {
                list.add(new ItemStack(this, 1, i));
            }
            //list内のすべてのアイテムをクリエイティブタブに登録
            subItems.addAll(list);
        }
    }

    //Itemにtooltipを付与するメソッド
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@Nonnull ItemStack stack, World world, @Nonnull List<String> tooltip, @Nonnull ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, ITooltipFlag.TooltipFlags.NORMAL);
    }
}