package hiiragi283.gohd_tweaks.base;

import defeatedcrow.hac.api.blockstate.DCState;
import hiiragi283.gohd_tweaks.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockBase extends Block {

    //private変数の宣言
    private final int maxMeta;

    //コンストラクタの宣言
    public BlockBase(Material Material, String ID, int maxMeta) {
        super(Material); //Materialを設定
        this.setRegistryName(Reference.MOD_ID, ID); //IDの設定
        this.setCreativeTab(CreativeTabs.DECORATIONS); //表示するクリエイティブタブの設定
        this.setDefaultState(this.blockState.getBaseState().withProperty(DCState.TYPE16, 0)); //デフォルトのBlockstateをTYPE16の0番に設定
        this.setUnlocalizedName(ID); //翻訳キーをIDから取得
        this.maxMeta = maxMeta; //メタデータの最大値を代入
    }

    //メタデータの最大値を得るメソッド
    public int getMaxMeta() {
        //maxMetaを返す
        return maxMeta;
    }

    //Blockstateの登録をするメソッド
    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        //TYPE16を使用すると、Blockstateは"type=0"から"type=15"までが登録される
        return new BlockStateContainer(this, DCState.TYPE16);
    }

    //Blockstateからメタデータを得るメソッド
    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        //TYPE16をもとにBlockstateからメタデータを返す
        i = state.getValue(DCState.TYPE16);
        //メタデータがmaxMetaよりも大きい場合、最大値を返す
        if (i > maxMeta) i = maxMeta;
        return i;
    }

    //メタデータからBlockstateを得るメソッド
    @Nonnull
    @Override
    public IBlockState getStateFromMeta(int meta) {
        //metaをmaxMeteで割った剰余を求める
        int i = meta % maxMeta;
        //TYPE16をもとに指定したメタデータからBlockstateを返す
        IBlockState state = this.getDefaultState().withProperty(DCState.TYPE16, i);
        return state;
    }

    //Blockstateをもとにドロップするアイテムのメタデータを指定するメソッド
    @Override
    public int damageDropped(IBlockState state) {
        //TYPE16をもとにBlockstateからメタデータを返す
        int i = state.getValue(DCState.TYPE16);
        //メタデータがmaxMetaよりも大きい場合、最大値を返す
        if (i > maxMeta) i = maxMeta;
        return i;
    }

    //ドロップするアイテムを得るメソッド
    @Nonnull
    @Override
    public Item getItemDropped(IBlockState state, @Nonnull Random rand, int fortune) {
        //Blockstateからブロックを取得し、更にそこからアイテムを取得して返す
        return Item.getItemFromBlock(state.getBlock());
    }

    //ドロップする確率を得るメソッド
    @Override
    public int quantityDropped(@Nonnull Random random) {
        //常にドロップさせるので1を返す
        return 1;
    }
}