package hiiragi283.gohd_tweaks.base;

import com.google.common.collect.Sets;
import hiiragi283.gohd_tweaks.Reference;
import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Set;

//Sandpaper系の継承用のクラス
public class ItemToolClick extends ItemTool {

    public static final Set<Block> BLOCKS = Sets.newHashSet(RagiUtils.getBlock("minecraft", "air"));

    //コンストラクタの宣言
    public ItemToolClick(String ID, int maxDamage) {
        super(ToolMaterial.WOOD, BLOCKS); //ToolMaterialはWOODを継承，採掘は行わないので対象のブロックは適当に空気を設定
        this.setRegistryName(Reference.MOD_ID, ID); //IDの設定
        this.setCreativeTab(CreativeTabs.TOOLS); //表示するクリエイティブタブの設定
        this.setMaxDamage(maxDamage); //最大耐久地をmaxDamageに設定
        this.setUnlocalizedName(ID); //翻訳キーをIDから取得
    }

    //onItemRightClickに使用するレシピマップを指定するメソッド
    //あえてメソッドとして記述することで, Overrideできるようにする
    public IBlockState RecipeMap(IBlockState state) {
        return null;
    }

    public IBlockState RecipeMap(Block block) {
        return null;
    }

    //レシピ完了時に鳴らす音もメソッドにしておく
    public SoundEvent RecipeSound() {
        return null;
    }

    //アイテムを右クリックすると呼ばれるイベント
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        //保持しているアイテムをItemStack型で取得
        ItemStack stack = player.getHeldItem(hand);
        //サーバー側のみで実行
        if (!world.isRemote) {
            //playerの視線を取得
            RayTraceResult ray = this.rayTrace(world, player, false);
            //視線の先がブロックの場合
            if (ray.typeOfHit == RayTraceResult.Type.BLOCK) {
                //ブロックまわりの値の取得
                BlockPos pos = ray.getBlockPos();
                IBlockState state = world.getBlockState(pos);
                Block block = state.getBlock();
                //stateと対応する組み合わせがある場合
                if (Objects.nonNull(RecipeMap(state))) {
                    //対応するstateで置き換える
                    world.setBlockState(pos, RecipeMap(state));
                    //stackの耐久地を1減らす
                    stack.damageItem(1, player);
                    //とりあえず音鳴らすか
                    world.playSound(null, pos, RecipeSound(), SoundCategory.BLOCKS, 1.0F, 0.5F);
                }
                //blockと対応する組み合わせがある場合
                else if (Objects.nonNull(RecipeMap(block))) {
                    //対応するstateで置き換える
                    world.setBlockState(pos, RecipeMap(block));
                    //stackの耐久地を1減らす
                    stack.damageItem(1, player);
                    //とりあえず音鳴らすか
                    world.playSound(null, pos, RecipeSound(), SoundCategory.BLOCKS, 1.0F, 0.5F);
                }
            }
            //実験は成功だ!
            return new ActionResult<>(EnumActionResult.SUCCESS, stack);
        }
        //何がいけなかったのだろうか
        return new ActionResult<>(EnumActionResult.FAIL, stack);
    }
}