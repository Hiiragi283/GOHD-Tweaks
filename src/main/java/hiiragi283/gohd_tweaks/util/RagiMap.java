package hiiragi283.gohd_tweaks.util;

import net.minecraft.block.state.IBlockState;

import java.util.HashMap;
import java.util.Map;

public class RagiMap {
    //MapSandpaperの定義
    public static Map<IBlockState, IBlockState> MapSandpaper = new HashMap<IBlockState, IBlockState>() {
        {
            //MapSandpaperにレシピを書きこんでいく
            put(RagiUtils.getBlock("minecraft", "double_stone_slab2").getDefaultState(), RagiUtils.getBlock("minecraft", "double_stone_slab2").getStateFromMeta(8));
            put(RagiUtils.getBlock("minecraft", "double_stone_slab").getStateFromMeta(0), RagiUtils.getBlock("minecraft", "double_stone_slab").getStateFromMeta(8));
            put(RagiUtils.getBlock("minecraft", "double_stone_slab").getStateFromMeta(1), RagiUtils.getBlock("minecraft", "double_stone_slab").getStateFromMeta(9));
            put(RagiUtils.getBlock("minecraft", "red_sandstone").getDefaultState(), RagiUtils.getBlock("minecraft", "double_stone_slab2").getStateFromMeta(8));
            put(RagiUtils.getBlock("minecraft", "sandstone").getDefaultState(), RagiUtils.getBlock("minecraft", "double_stone_slab").getStateFromMeta(9));
            put(RagiUtils.getBlock("minecraft", "stone").getDefaultState(), RagiUtils.getBlock("minecraft", "double_stone_slab").getStateFromMeta(8));
            put(RagiUtils.getBlock("minecraft", "stone").getStateFromMeta(1), RagiUtils.getBlock("minecraft", "stone").getStateFromMeta(2));
            put(RagiUtils.getBlock("minecraft", "stone").getStateFromMeta(3), RagiUtils.getBlock("minecraft", "stone").getStateFromMeta(4));
            put(RagiUtils.getBlock("minecraft", "stone").getStateFromMeta(5), RagiUtils.getBlock("minecraft", "stone").getStateFromMeta(6));
        }
    };
}
