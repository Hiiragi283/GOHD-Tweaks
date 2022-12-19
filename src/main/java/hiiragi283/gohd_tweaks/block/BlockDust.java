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
import java.awt.*;

public class BlockDust extends BlockClimate {
    public BlockDust() {
        super(Material.GROUND, "dustblock", 5);
        this.setHardness(1.5F);
        this.setResistance(15.0F);
        this.setSoundType(SoundType.STONE);
        this.setTickRandomly(true);
    }

    @Override
    public int tickRate(@Nonnull World world) {
        return 40;
    }

    public static class ColorBlockDust implements IBlockColor {

        //着色の仕方を定義するメソッド
        @Override
        public int colorMultiplier(@Nonnull IBlockState state, IBlockAccess access, BlockPos pos, int tintindex) {
            int meta = state.getBlock().getMetaFromState(state);
            if (tintindex == 0) {
                if (meta == 0) return new Color(0xC2D0D8).getRGB();
                else if (meta == 1) return new Color(0xC6C4E2).getRGB();
                else if (meta == 2) return new Color(255, 0, 31).getRGB();
                else if (meta == 3) return new Color(0xBE9A45).getRGB();
                else if (meta == 4) return new Color(0x818D88).getRGB();
                else if (meta == 5) return new Color(0xD1A35B).getRGB();
                else return RagiColor.RagiRed.getRGB();
            } else return RagiColor.RagiRed.getRGB();
        }
    }
}