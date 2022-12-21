package hiiragi283.gohd_tweaks.block;

import hiiragi283.gohd_tweaks.base.BlockClimate;
import hiiragi283.gohd_tweaks.util.RagiColor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class BlockDust extends BlockClimate implements IBlockColor{
    public BlockDust() {
        super(Material.GROUND, "dustblock", 14);
        this.setHardness(1.5F);
        this.setResistance(15.0F);
        this.setSoundType(SoundType.STONE);
        this.setTickRandomly(true);
    }

    @Override
    public int tickRate(@Nonnull World world) {
        return 40;
    }

    //着色の仕方を定義するメソッド
    @Override
    public int colorMultiplier(@Nonnull IBlockState state, IBlockAccess access, BlockPos pos, int tintindex) {
        int meta = state.getBlock().getMetaFromState(state);
        return RagiColor.setColorDust(meta, tintindex);
    }
}