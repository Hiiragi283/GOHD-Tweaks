package hiiragi283.gohd_tweaks.item;

import hiiragi283.gohd_tweaks.base.ItemToolClick;
import hiiragi283.gohd_tweaks.util.RagiMap;
import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.SoundEvent;

public class ItemSandPaperDiamond extends ItemToolClick {

    //コンストラクタの宣言
    public ItemSandPaperDiamond() {
        super("sandpaper_diamond", 8192); //ItemSandPaperクラスを継承
    }
    @Override
    public IBlockState RecipeMap(IBlockState state) {
        return RagiMap.MapSandpaper.get(state);
    }

    @Override
    public IBlockState RecipeMap(Block block) {
        return RagiMap.MapSandpaperBlock.get(block);
    }

    @Override
    public SoundEvent RecipeSound() {
        return RagiUtils.getSound("minecraft", "block.gravel.hit");
    }
}