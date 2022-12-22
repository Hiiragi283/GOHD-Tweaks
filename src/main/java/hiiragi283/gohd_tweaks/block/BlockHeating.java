package hiiragi283.gohd_tweaks.block;

import defeatedcrow.hac.api.blockstate.DCState;
import defeatedcrow.hac.api.climate.BlockSet;
import defeatedcrow.hac.api.climate.IClimate;
import hiiragi283.gohd_tweaks.GOHDInit;
import hiiragi283.gohd_tweaks.base.BlockClimate;
import hiiragi283.gohd_tweaks.util.RagiColor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockHeating extends BlockClimate implements IBlockColor {

    //コンストラクタの宣言
    public BlockHeating() {
        super(Material.GROUND, "heating_metal", 5);
        this.setHardness(1.5F);
        this.setResistance(15.0F);
        this.setSoundType(SoundType.STONE);
        this.setTickRandomly(true);
    }

    @Override
    public int tickRate(@Nonnull World world) {
        return 100;
    }

    @Override
    public void updateTick(World world, @Nonnull BlockPos pos, @Nonnull IBlockState state, @Nonnull Random rand) {
        if (!world.isRemote && state != null && state.getBlock() != null) {
            IClimate clm = this.onUpdateClimate(world, pos, state);
            if (!this.onClimateChange(world, pos, state, clm)) {
                BlockSet set = getFailureProduct(state);
                if (set != null) {
                    IBlockState retS = set.getState();
                    world.setBlockState(pos, retS, 2);
                    world.notifyNeighborsOfStateChange(pos, set.block, true);
                    if (playSEOnChanging(0)) {
                        world.playSound(null, pos, getSE(0), SoundCategory.BLOCKS, 0.8F, 2.0F);
                    }
                }
                world.scheduleUpdate(pos, this, this.tickRate(world) + rand.nextInt(21));
            }
        }
    }

    public static BlockSet getFailureProduct(IBlockState state) {
        int i = DCState.getInt(state, DCState.TYPE16);
        switch (i) {
            case 0:
            case 1:
                return new BlockSet(GOHDInit.BlockHeating, 2);
            case 3:
            case 4:
                return new BlockSet(GOHDInit.BlockHeating, 5);
        }
        return null;
    }

    //着色の仕方を定義するメソッド
    @Override
    public int colorMultiplier(@Nonnull IBlockState state, IBlockAccess access, BlockPos pos, int tintindex) {
        int meta = state.getBlock().getMetaFromState(state);
        return RagiColor.setColorHeating(meta, tintindex);
    }

}