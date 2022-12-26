package hiiragi283.gohd_tweaks.base;

import defeatedcrow.hac.api.climate.*;
import defeatedcrow.hac.api.recipe.IClimateSmelting;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import defeatedcrow.hac.config.CoreConfigDC;
import defeatedcrow.hac.core.util.DCUtil;
import hiiragi283.gohd_tweaks.GOHDTweaks;
import hiiragi283.gohd_tweaks.Reference;
import hiiragi283.gohd_tweaks.util.RagiLogger;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public class BlockClimate extends BlockBase {

    //public変数の宣言
    public final boolean forceUpdate = true;

    //コンストラクタの宣言
    public BlockClimate(Material material, String ID, int max) {
        super(material, ID, max); //BlockCommonクラスを継承
    }

    //tick更新の頻度を得るメソッド
    @Override
    public int tickRate(@Nonnull World world) {
        //100を返す
        return 100;
    }

    //canClimateUpdateかどうかを得るメソッド
    public boolean canClimateUpdate(IBlockState state) {
        //trueを返す
        return true;
    }

    //
    @Override
    @ParametersAreNonnullByDefault
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer,
                                ItemStack stack) {
        //isForcedTickUpdateがtrueの場合
        if (this.isForcedTickUpdate()) {
            //21tick後にブロック更新をはさむ
            world.scheduleUpdate(pos, this, this.tickRate(world) + world.rand.nextInt(21));
        }
    }

    @Override
    @ParametersAreNonnullByDefault
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(world, pos, state, rand);
        if (!world.isRemote && canClimateUpdate(state)) {
            IClimate clm = this.onUpdateClimate(world, pos, state);
            if (!this.onClimateChange(world, pos, state, clm) && this.isForcedTickUpdate()) {
                world.scheduleUpdate(pos, this, this.tickRate(world) + rand.nextInt(21));
            }
        }
    }

    public IClimate onUpdateClimate(World world, BlockPos pos, IBlockState state) {
        IClimate c = ClimateAPI.calculator.getClimate(world, pos, checkingRange());
        return c;
    }

    public boolean onClimateChange(World world, BlockPos pos, IBlockState state, IClimate clm) {
        if (clm != null) {
            DCHeatTier heat = clm.getHeat();
            DCHumidity hum = clm.getHumidity();
            DCAirflow air = clm.getAirflow();
            int meta = this.damageDropped(state);
            ItemStack check = new ItemStack(this, 1, meta);
            IClimateSmelting recipe = RecipeAPI.registerSmelting.getRecipe(clm, check);
            if (recipe != null && recipe.additionalRequire(world, pos)) {
                ItemStack output = recipe.getOutput();
                if (!DCUtil.isEmpty(output) && output.getItem() instanceof ItemBlock) {
                    Block ret = ((ItemBlock) output.getItem()).getBlock();
                    IBlockState retS = ret.getStateFromMeta(output.getMetadata());
                    if (world.setBlockState(pos, retS, 2)) {
                        world.notifyNeighborsOfStateChange(pos, ret, true);
                        // 効果音
                        if (playSEOnChanging(meta)) {
                            world.playSound(null, pos, getSE(meta), SoundCategory.BLOCKS, 0.8F, 2.0F);
                            RagiLogger.infoDebug("Smelting! " + output.getDisplayName());
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //気候精錬した際に流すSEを得るメソッド
    public SoundEvent getSE(int meta) {
        //溶岩源が固まる音を返す
        return SoundEvents.BLOCK_LAVA_EXTINGUISH;
    }

    //SEを流すかどうかを得るメソッド
    public boolean playSEOnChanging(int meta) {
        //当然! 再生だッ!
        return true;
    }

    //強制的にtick更新を起こすかどうがを得るメソッド
    public boolean isForcedTickUpdate() {
        //forceUpdateに代入された値を返す
        return forceUpdate;
    }

    //気候の探索範囲を得るメソッド
    public int[] checkingRange() {
        //HaC側のコンフィグから指定する
        return CoreConfigDC.ranges;
    }
}
