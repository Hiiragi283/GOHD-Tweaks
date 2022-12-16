package hiiragi283.gohd_tweaks.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class RagiMap {

    //祭壇クラフトのレシピマップの定義
    public static Map<String, Boolean> MapAltarRemove = new HashMap<String, Boolean>() {
        {
            //MapAltarRemoveにレシピを書き込んでいく
            put("block_black_marble_chiseled_wall", true);
            put("block_black_marble_engraved_wall", true);
            put("block_black_marble_runed_wall", true);
            put("block_black_marble_wall", true);
            put("block_infused_wood_fence", true);
            put("block_infused_wood_fence_gate", true);
            put("block_marble_arch_wall", true);
            put("block_marble_brick_wall", true);
            put("block_marble_chiseled_wall", true);
            put("block_marble_engraved_wall", true);
            put("block_marble_runed_wall", true);
            put("block_marble_wall", true);
            put("block_starmetal", true);
            put("infused_wood_arch", true);
            put("infused_wood_column", true);
            put("infused_wood_engraved", true);
            put("infused_wood_planks", false);
            put("ingot_starmetal", true);
            put("internal/altar/black_marble_arch", true);
            put("internal/altar/black_marble_bricks", true);
            put("internal/altar/black_marble_chiseled", true);
            put("internal/altar/black_marble_engraved", true);
            put("internal/altar/black_marble_pillar", true);
            put("internal/altar/black_marble_runed", true);
            put("internal/altar/marble_arch", true);
            put("internal/altar/marble_bricks", true);
            put("internal/altar/marble_chiseled", true);
            put("internal/altar/marble_engraved", true);
            put("internal/altar/marble_pillar", true);
            put("internal/altar/marble_runed", true);
            put("marble_slab", true);
            put("marble_stairs", true);
            put("block_black_marble_arch_wall", true);
            put("block_black_marble_brick_wall", true);
        }
    };

    //Sandpaperのレシピマップの定義
    public static Map<IBlockState, IBlockState> MapSandpaper = new HashMap<IBlockState, IBlockState>() {
        {
            //MapSandpaperにレシピを書きこんでいく
            put(RagiUtils.getState("minecraft", "double_stone_slab", 0), RagiUtils.getState("minecraft", "double_stone_slab", 8));
            put(RagiUtils.getState("minecraft", "double_stone_slab", 1), RagiUtils.getState("minecraft", "double_stone_slab", 9));
            put(RagiUtils.getState("minecraft", "stone", 1), RagiUtils.getState("minecraft", "stone", 2));
            put(RagiUtils.getState("minecraft", "stone", 3), RagiUtils.getState("minecraft", "stone", 4));
            put(RagiUtils.getState("minecraft", "stone", 5), RagiUtils.getState("minecraft", "stone", 6));
            put(RagiUtils.getState("tconstruct", "brownstone", 0), RagiUtils.getState("tconstruct", "brownstone", 2));
            put(RagiUtils.getState("tconstruct", "seared", 0), RagiUtils.getState("tconstruct", "seared", 2));
            put(RagiUtils.getState("twilightforest", "deadrock", 2), RagiUtils.getState("twilightforest", "deadrock", 0));
            put(RagiUtils.getState("twilightforest", "maze_stone", 0), RagiUtils.getState("twilightforest", "maze_stone", 2));
        }
    };

    //Sandpaperのレシピマップの定義 (メタデータ無視用)
    public static Map<Block, IBlockState> MapSandpaperBlock = new HashMap<Block, IBlockState>() {
        {
            //MapSandpaperBlockにレシピを書きこんでいく
            put(RagiUtils.getBlock("appliedenergistics2", "sky_stone_block"), RagiUtils.getState("appliedenergistics2", "smooth_sky_stone_block", 0));
            put(RagiUtils.getBlock("biomesoplenty", "hard_ice"), RagiUtils.getState("railcraft", "frostbound", 2));
            put(RagiUtils.getBlock("minecraft", "double_stone_slab2"), RagiUtils.getState("minecraft", "double_stone_slab2", 8));
            put(RagiUtils.getBlock("minecraft", "nether_brick"), RagiUtils.getState("railcraft", "nether", 2));
            put(RagiUtils.getBlock("minecraft", "red_nether_brick"), RagiUtils.getState("railcraft", "red_nether", 2));
            put(RagiUtils.getBlock("minecraft", "red_sandstone"), RagiUtils.getState("minecraft", "double_stone_slab2", 8));
            put(RagiUtils.getBlock("minecraft", "sandstone"), RagiUtils.getState("minecraft", "double_stone_slab", 9));
            put(RagiUtils.getBlock("minecraft", "stone"), RagiUtils.getState("minecraft", "double_stone_slab", 8));
        }
    };
}