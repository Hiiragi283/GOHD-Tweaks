package hiiragi283.gohd_tweaks.items;

import com.google.common.collect.Sets;
import hiiragi283.gohd_tweaks.Reference;
import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Set;

public class ItemSandPaper extends ItemTool {

    public static final Set<Block> BLOCKS = Sets.newHashSet(RagiUtils.getBlock("minecraft", "air"));
    private final String NameSandPaper = "sandpaper";

    public ItemSandPaper() {
        super(ToolMaterial.WOOD, BLOCKS); //ToolMaterialはWOODを継承，採掘は行わないので対象のブロックは適当に空気を設定
        this.setRegistryName(Reference.MOD_ID, NameSandPaper); //IDの設定
        this.setCreativeTab(CreativeTabs.TOOLS); //表示するクリエイティブタブの設定
        this.setMaxDamage(1024); //最大耐久地を1024に設定
        this.setUnlocalizedName(NameSandPaper); //翻訳キーをIDから取得
    }

    //アイテムを右クリックすると呼ばれるイベント
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
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
                //レシピチェック用のbool変数
                boolean isPolished = false;
                //花崗岩・閃緑岩・安山岩の研磨レシピ
                if (state.getBlock() == RagiUtils.getBlock("minecraft", "stone") && block.getMetaFromState(state) % 2 == 1) {
                    world.setBlockState(pos, block.getStateFromMeta(block.getMetaFromState(state) + 1));
                    isPolished = true;
                }
                //焼き石・石ハーフ->つなぎ目のない石ハーブブロック
                else if (state == RagiUtils.getBlock("minecraft", "stone").getDefaultState() || state == RagiUtils.getBlock("minecraft", "double_stone_slab").getStateFromMeta(0)) {
                    world.setBlockState(pos, RagiUtils.getBlock("minecraft", "double_stone_slab").getStateFromMeta(8));
                    isPolished = true;
                }
                //砂岩->つなぎ目のない砂岩
                else if (block == RagiUtils.getBlock("minecraft", "sandstone") || state == RagiUtils.getBlock("minecraft", "double_stone_slab").getStateFromMeta(1)) {
                    world.setBlockState(pos, RagiUtils.getBlock("minecraft", "double_stone_slab").getStateFromMeta(9));
                    isPolished = true;
                }
                //赤砂岩->つなぎ目のない赤砂岩
                else if (block == RagiUtils.getBlock("minecraft", "red_sandstone") || block == RagiUtils.getBlock("minecraft", "double_stone_slab2")) {
                    world.setBlockState(pos, RagiUtils.getBlock("minecraft", "double_stone_slab2").getStateFromMeta(8));
                    isPolished = true;
                }
                //レシピが完了した場合
                if (isPolished) {
                    //stackの耐久地を1減らす
                    stack.damageItem(1, player);
                    //とりあえず音鳴らすか
                    world.playSound(null, player.getPosition(), RagiUtils.getSound("minecraft", "block.gravel.hit"), SoundCategory.BLOCKS, 1.0F, 0.1F);
                }
            }
            //実験は成功だ!
            return new ActionResult(EnumActionResult.SUCCESS, stack);
        }
        //何がいけなかったのだろうか
        return new ActionResult(EnumActionResult.FAIL, stack);
    }
}
