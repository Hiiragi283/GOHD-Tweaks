package hiiragi283.gohd_tweaks.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class RagiList {

    //削除するクラフトレシピの名前のリスト
    public static final List<String> LIST_CRAFTING_REMOVE = new ArrayList<String>() {{
        add("appliedenergistics2:decorative/certus_quartz_pillar");
        add("appliedenergistics2:decorative/chiseled_quartz_block");
        add("astralsorcery:shaped/black_marble_arch");
        add("astralsorcery:shaped/black_marble_bricks");
        add("astralsorcery:shaped/black_marble_chiseled");
        add("astralsorcery:shaped/black_marble_engraved");
        add("astralsorcery:shaped/black_marble_pillar");
        add("astralsorcery:shaped/black_marble_runed");
        add("astralsorcery:shaped/marble_arch");
        add("astralsorcery:shaped/marble_bricks");
        add("astralsorcery:shaped/marble_chiseled");
        add("astralsorcery:shaped/marble_engraved");
        add("astralsorcery:shaped/marble_pillar");
        add("astralsorcery:shaped/marble_runed");
        add("astralsorcery:shaped/infused_wood_arch");
        add("astralsorcery:shaped/infused_wood_column");
        add("astralsorcery:shaped/infused_wood_engraved");
        add("biomesoplenty:chiseled_white_sandstone");
        add("biomesoplenty:sapphire");
        add("biomesoplenty:smooth_white_sandstone");
        add("botania:custombrick_0_alt");
        add("botania:dreamwood_3");
        add("botania:dreamwood_4");
        //add("botania:fertilizer_dye");
        //add("botania:lexicon");
        add("botania:livingrock_1");
        add("botania:livingrock_3");
        add("botania:livingrock_4");
        add("botania:livingwood_3");
        add("botania:livingwood_4");
        add("botania:quartztypeblaze_1");
        add("botania:quartztypeblaze_2");
        add("botania:quartztypedark_1");
        add("botania:quartztypedark_2");
        add("botania:quartztypeelf_1");
        add("botania:quartztypeelf_2");
        add("botania:quartztypelavender_1");
        add("botania:quartztypelavender_2");
        add("botania:quartztypemana_1");
        add("botania:quartztypemana_2");
        add("botania:quartztypered_1");
        add("botania:quartztypered_2");
        add("botania:quartztypesunny_1");
        add("botania:quartztypesunny_2");
        add("dcs_climate:main/dcs_planks_0");
        add("dcs_climate:main_build/dcs_desktop_accessories_0_2");
        add("dcs_climate:main_container/dcs_gem_blue_1");
        add("dcs_climate:main_yagen/dcs_gem_layer_4");
        add("enderio:ender_dust");
        //add("inspirations:building/mulch/plain");
        add("mia:biomesoplenty/bamboo_thatching");
        add("mia:mia/packed_paper/packed_paper_swap_0");
        add("mia:mia/packed_paper/packed_paper_swap_1");
        add("mia:mia/packed_paper/packed_paper_swap_2");
        add("mia:mia/packed_paper/packed_paper_swap_3");
        add("minecraft:chiseled_quartz_block");
        add("minecraft:chiseled_red_sandstone");
        add("minecraft:chiseled_sandstone");
        add("minecraft:chiseled_stonebrick");
        //add("minecraft:furnace");
        add("minecraft:pillar_quartz_block");
        add("minecraft:polished_granite");
        add("minecraft:purpur_pillar");
        //add("minecraft:slime");
        add("minecraft:smooth_red_sandstone");
        add("minecraft:smooth_sandstone");
        add("railcraft:cone_oven_red$2");
        //add("tconstruct:common/slime/pink/congealed");
        //add("tconstruct:common/slime/pink/slimeblock");
        //add("tconstruct:gadgets/slimeboots/fallback");
        //add("tconstruct:gadgets/slimesling/fallback");
        add("tconstruct:smeltery/casting_basin");
        add("tconstruct:smeltery/casting_table");
        add("tconstruct:smeltery/channel");
        add("tconstruct:smeltery/faucet");
        //add("tconstruct:smeltery/smeltery_controller");
        add("thermalfoundation:material_99");
        add("thermalfoundation:material_100");
        add("thermalfoundation:storage");
        add("thermalfoundation:storage_alloy");
    }};

    //素材のリスト
    public static final List<RagiMaterialEnum> LIST_MATERIAL = new ArrayList<RagiMaterialEnum>() {{
        add(RagiMaterialEnum.PLATINUM);
        add(RagiMaterialEnum.IRIDIUM);
        add(RagiMaterialEnum.MANA_INFUSED);
        add(RagiMaterialEnum.ELECTRUM);
        add(RagiMaterialEnum.INVAR);
        add(RagiMaterialEnum.CONSTANTAN);
        add(RagiMaterialEnum.ELECTRICAL_STEEL);
        add(RagiMaterialEnum.ENERGETIC_ALLOY);
        add(RagiMaterialEnum.VIBRANT_ALLOY);
        add(RagiMaterialEnum.REDSTONE_ALLOY);
        add(RagiMaterialEnum.CONDUCTIVE_IRON);
        add(RagiMaterialEnum.PULSATING_IRON);
        add(RagiMaterialEnum.DARK_STEEL);
        add(RagiMaterialEnum.SOULARIUM);
        add(RagiMaterialEnum.END_STEEL);
    }};


    //
    public static final List<String> LIST_RC_DECORATION = new ArrayList<String>() {{
        add("andesite");
        add("badlands");
        add("bleachedbone");
        add("bloodstained");
        add("diorite");
        add("frostbound");
        add("granite");
        add("infernal");
        add("jaded");
        add("nether");
        add("pearlized");
        add("red_nether");
        add("sandy");
    }};

    //
    public static final List<String> LIST_RC_META = new ArrayList<String>() {{
        add("#0$1");
        add("#1$1");
        add("#3$1");
        add("#4$1");
    }};
}