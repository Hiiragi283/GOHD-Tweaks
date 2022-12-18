package hiiragi283.gohd_tweaks.integration.jei;

import hiiragi283.gohd_tweaks.util.RagiMap;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

public class SandpaperRecipe {

    //private変数の宣言 (before)
    public final IBlockState stateBefore;
    public final Block blockBefore;
    public final int metaBefore;
    public final ItemStack stackBefore;
    public final String nameBefore;

    //private変数の宣言 (after)
    public final IBlockState stateAfter;
    public final Block blockAfter;
    public final int metaAfter;
    public final ItemStack stackAfter;
    public final String nameAfter;

    public SandpaperRecipe(IBlockState recipe) {
        //変化前のstateからItemStackなどを生成
        stateBefore = recipe;
        blockBefore = stateBefore.getBlock();
        metaBefore = blockBefore.getMetaFromState(stateBefore);
        stackBefore = new ItemStack(blockBefore, 1, metaBefore);
        nameBefore = stackBefore.getDisplayName();
        //変化後のstateからItemStackなどを生成
        stateAfter = RagiMap.MapSandpaper.get(stateBefore);
        blockAfter = stateAfter.getBlock();
        metaAfter = blockAfter.getMetaFromState(stateAfter);
        stackAfter = new ItemStack(blockAfter, 1, metaAfter);
        nameAfter = stackAfter.getDisplayName();
    }
}