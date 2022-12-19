package hiiragi283.gohd_tweaks.block;

import hiiragi283.gohd_tweaks.base.BlockClimate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

import javax.annotation.Nonnull;

public class BlockGroutFormed extends BlockClimate {
    public BlockGroutFormed() {
        super(Material.GRASS, "grout_formed", 3);
        this.setHardness(3.0F);
        this.setResistance(0.5F);
        this.setSoundType(SoundType.GROUND);
    }

    @Override
    public boolean isFullCube(@Nonnull IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(@Nonnull IBlockState state) {
        return false;
    }
}