package hiiragi283.gohd_tweaks.block;

import hiiragi283.gohd_tweaks.base.BlockClimate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

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
}