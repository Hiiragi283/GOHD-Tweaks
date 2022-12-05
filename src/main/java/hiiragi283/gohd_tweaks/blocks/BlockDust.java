package hiiragi283.gohd_tweaks.blocks;

import hiiragi283.gohd_tweaks.util.BlockClimate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockDust extends BlockClimate {
    public BlockDust() {
        super(Material.GROUND, "dustblock", 15);
        this.setHardness(1.5F);
        this.setResistance(15.0F);
        this.setSoundType(SoundType.STONE);
        this.setTickRandomly(true);
    }

    @Override
    public int tickRate(World world) {
        return 40;
    }
}
