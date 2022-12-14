package hiiragi283.gohd_tweaks.init;

import hiiragi283.gohd_tweaks.util.RagiList;
import hiiragi283.gohd_tweaks.util.RagiNBT;
import hiiragi283.gohd_tweaks.util.RagiRecipe;
import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.oredict.OreDictionary;

public class GOHDRecipe {

    //クラフトレシピを登録するメソッド
    public static void addCrafting() {
        RagiRecipe.addShaped("mix", new ItemStack(GOHDRegistry.BlockDust, 1, 3), "AAA", "AAB", "BBB", 'A', "dustGold", 'B', "dustSilver");
        RagiRecipe.addShaped("mix", new ItemStack(GOHDRegistry.BlockDust, 1, 4), "AAA", "AAA", "BBB", 'A', "dustIron", 'B', "dustNickel");
        RagiRecipe.addShaped("mix", new ItemStack(GOHDRegistry.BlockDust, 1, 5), "AAA", "AAB", "BBB", 'A', "dustCopper", 'B', "dustNickel");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 0), "AAA", "AAA", "AAA", 'A', "dustPlatinum");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 1), "AAA", "AAA", "AAA", 'A', "dustIridium");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 2), "AAA", "AAA", "AAA", 'A', "dustMithril");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 3), "AAA", "AAA", "AAA", 'A', "dustElectrum");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 4), "AAA", "AAA", "AAA", 'A', "dustInvar");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 5), "AAA", "AAA", "AAA", 'A', "dustConstantan");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 6), "AAA", "AAA", "BCC", 'A', "dustIron", 'B', "dustCoal", 'C', "itemSilicon");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 7), "AAA", "AAB", "BCC", 'A', "dustGold", 'B', "dustRedstone", 'C', "dustGlowstone");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 8), "AAA", "AAA", "BCD", 'A', "dustGold", 'B', "dustRedstone", 'C', "dustGlowstone", 'D', "dustEnderPearl");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 9), "AAA", "AAA", "BBB", 'A', "dustRedstone", 'B', "itemSilicon");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 10), "AAA", "AAA", "ABB", 'A', "dustIron", 'B', "dustRedstone");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 11), "AAA", "AAA", "ABB", 'A', "dustIron", 'B', "dustEnderPearl");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 12), "AAA", "AAA", "BCC", 'A', "dustIron", 'B', "dustCoal", 'C', "dustObsidian");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 13), "AAA", "AAA", "ABB", 'A', "dustGold", 'B', "dustSoulSand");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.BlockDust, 1, 14), "AAA", "AAA", "BBB", 'A', "dustTitanium", 'B', "dustEndstone");
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.ItemMoldTitanium, 1, 0), "ABA", 'A', "ingotTitaniumAlloy", 'B', RagiUtils.getStack("thermalfoundation:material", 1, 512));
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.ItemMoldTitanium, 1, 1), "ABA", 'A', "ingotTitaniumAlloy", 'B', RagiUtils.getStack("thermalfoundation:material", 1, 513));
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.ItemMoldTitanium, 1, 2), "ABA", 'A', "ingotTitaniumAlloy", 'B', RagiUtils.getStack("thermalfoundation:material", 1, 514));
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.ItemMoldTitanium, 1, 3), "ABA", 'A', "ingotTitaniumAlloy", 'B', RagiUtils.getStack("thermalfoundation:material", 1, 515));
        RagiRecipe.addShaped(new ItemStack(GOHDRegistry.ItemSandPaper), " A ", "ABA", " A ", 'A', "dustGarnet", 'B', "paper");
        RagiRecipe.addShapeless(new ItemStack(GOHDRegistry.ItemSandPaperDiamond), Ingredient.fromItems(GOHDRegistry.ItemSandPaper), RagiRecipe.setOreDict("gemDiamond"));

        RagiRecipe.addShaped(RagiUtils.getStack("astralsorcery:blockaltar", 1, 0), "ABA", "ACA", "A A", 'A', "blockMarble", 'B', RagiUtils.getStack("astralsorcery:blockblackmarble", 1, OreDictionary.WILDCARD_VALUE), 'C', "workbench");
        RagiRecipe.addShapedOverride("botania:fertilizer_dye", RagiUtils.getStack("botania:fertilizer", 1, 0), "AA", "AB", 'A', RagiUtils.getStack("minecraft:dye", 1, 15), 'B', RagiUtils.getStack("twilightforest:liveroot", 1, 0));
        RagiRecipe.addShapedOverride("inspirations:building/mulch/plain", RagiUtils.getStack("inspirations:mulch", 2, 0), " A ", "A A", " A ", 'A', "stickWood");
        RagiRecipe.addShapedOverride("minecraft:furnace", RagiUtils.getStack("minecraft:furnace", 1, 0), "AAA", "ABA", "AAA", 'A', "cobblestone", 'B', RagiUtils.getStack("dcs_climate:dcs_tinder", 1, 1));
        RagiRecipe.addShapedOverride("minecraft:slime", RagiUtils.getStack("minecraft:slime", 1, 0), "AAA", "AAA", "AAA", 'A', RagiUtils.getStack("minecraft:slime_ball", 1, 0));
        RagiRecipe.addShapedOverride("tconstruct:common/slime/pink/congealed", RagiUtils.getStack("tconstruct:slime_congealed", 1, 5), "AA", "AA", 'A', RagiUtils.getStack("tconstruct:edible", 1, 5));
        RagiRecipe.addShapedOverride("tconstruct:common/slime/pink/slimeblock", RagiUtils.getStack("tconstruct:slime", 1, 5), "AAA", "AAA", "AAA", 'A', RagiUtils.getStack("tconstruct:edible", 1, 5));
        RagiRecipe.addShapedOverride("tconstruct:gadgets/slimeboots/fallback", RagiUtils.getStack("tconstruct:slime_boots", 1, 5), "A A", "B B", 'A', RagiUtils.getStack("tconstruct:edible", 1, 5), 'B', RagiUtils.getStack("tconstruct:slime_congealed", 1, 5));
        RagiRecipe.addShapedOverride("tconstruct:gadgets/slimesling/fallback", RagiUtils.getStack("tconstruct:slimesling", 1, 5), "ABA", "C C", " C ", 'A', "string", 'B', RagiUtils.getStack("tconstruct:slime_congealed", 1, 5), 'C', RagiUtils.getStack("tconstruct:slime_congealed", 1, 5));
        RagiRecipe.addShapedOverride("tconstruct:smeltery/smeltery_controller", RagiUtils.getStack("tconstruct:smeltery_controller", 1, 0), "ABA", "ACA", "ADA", 'A', RagiUtils.getStack("tconstruct:materials", 1, 0), 'B', RagiUtils.getStack("tconstruct:seared_furnace_controller", 1, 0), 'C', RagiUtils.getStack("tconstruct:tinker_tank_controller", 1, 0), 'D', RagiUtils.getStack("dcs_climate:dcs_device_chamber", 1, 0));
        RagiRecipe.addShapeless(RagiNBT.chestMimic(), RagiRecipe.setOreDict("itemArtifact"), Ingredient.fromStacks(RagiUtils.getStack("minecraft:trapped_chest", 1, 0)), Ingredient.fromStacks(RagiUtils.getStack("gohd_tweaks:ragi_ticket", 1, 0)));
        RagiRecipe.addShapelessOverride("botania:lexicon", RagiUtils.getStack("botania:lexicon", 1, 0), Ingredient.fromStacks(RagiUtils.getStack("twilightforest:magic_map_focus", 1, 0)), Ingredient.fromStacks(RagiUtils.getStack("minecraft:book", 1, 0)));
    }

    //クラフトレシピを削除するメソッド
    public static void removeCrafting() {
        //LIST_CRAFTING_REMOVE内のレシピを削除する
        for (String registryName : RagiList.LIST_CRAFTING_REMOVE) {
            RagiRecipe.remove(registryName);
        }
        //BotaniaのAzulejoのレシピを削除する
        for (int i = 1; i < 15; i++) {
            RagiRecipe.remove("botania:custombrick_" + i);
        }
        //HaCのDesktop Accessoryのレシピを削除する
        for (int i = 1; i < 9; i++) {
            RagiRecipe.remove("dcs_climate:main_build/dcs_desktop_accessories_" + i);
        }
        //Railcraftの金属素材のレシピを削除する
        for (int i = 0; i < 10; i++) {
            RagiRecipe.remove("railcraft:metal#" + i + "$1");
            RagiRecipe.remove("railcraft:ingot#" + i + "$1");
            RagiRecipe.remove("railcraft:ingot#" + i + "$2");
            RagiRecipe.remove("railcraft:nugget#" + i + "$1");
        }
        //Railcraftの建材のレシピを削除する
        for (String decoration : RagiList.LIST_RC_DECORATION) {
            for (String meta : RagiList.LIST_RC_META) {
                RagiRecipe.remove("railcraft:" + decoration + meta);
            }
        }
        //Thermal Foundationのブロックのレシピを削除する
        for (int i = 1; i < 9; i++) {
            RagiRecipe.remove("thermalfoundation:storage_" + i);
            RagiRecipe.remove("thermalfoundation:storage_alloy_" + i);
        }
        //Thermal Foundationの素材のレシピを削除する
        for (int i = 8; i < 80; i++) {
            RagiRecipe.remove("thermalfoundation:material_" + i);
        }
    }

    //かまどレシピを追加するメソッド
    public static void addFurnace() {
        RagiRecipe.addFurnace(RagiUtils.getStack("appliedenergistics2:material", 1, 22), RagiUtils.getStack("gohd_tweaks:parts_assembly", 1, 2));
        RagiRecipe.addFurnace(RagiUtils.getStack("appliedenergistics2:material", 1, 23), RagiUtils.getStack("gohd_tweaks:parts_assembly", 1, 0));
        RagiRecipe.addFurnace(RagiUtils.getStack("appliedenergistics2:material", 1, 24), RagiUtils.getStack("gohd_tweaks:parts_assembly", 1, 1));
        RagiRecipe.addFurnace(RagiUtils.getStack("threng:material", 1, 6), RagiUtils.getStack("gohd_tweaks:parts_assembly", 1, 3));
        RagiRecipe.addFurnace(RagiUtils.getStack("threng:material", 1, 14), RagiUtils.getStack("gohd_tweaks:parts_assembly", 1, 4));
    }

    //かまどレシピを削除するメソッド
    public static void removeFurnace() {
        RagiRecipe.removeFurnace(RagiUtils.getStack("minecraft:coal", 1, 1));
        RagiRecipe.removeFurnace(RagiUtils.getStack("minecraft:log2", 1, OreDictionary.WILDCARD_VALUE));
        RagiRecipe.removeFurnace(RagiUtils.getStack("minecraft:log", 1, OreDictionary.WILDCARD_VALUE));
        RagiRecipe.removeFurnace(RagiUtils.getStack("thermalfoundation:material", 1, 130));
        RagiRecipe.removeFurnace(RagiUtils.getStack("thermalfoundation:material", 1, 132));
        RagiRecipe.removeFurnace(RagiUtils.getStack("thermalfoundation:material", 1, 133));
        RagiRecipe.removeFurnace(RagiUtils.getStack("thermalfoundation:material", 1, 134));
        RagiRecipe.removeFurnace(RagiUtils.getStack("thermalfoundation:material", 1, 135));
        RagiRecipe.removeFurnace(RagiUtils.getStack("thermalfoundation:material", 1, 136));
        RagiRecipe.removeFurnace(RagiUtils.getStack("thermalfoundation:material", 1, 160));
        RagiRecipe.removeFurnace(RagiUtils.getStack("thermalfoundation:material", 1, 161));
        RagiRecipe.removeFurnace(RagiUtils.getStack("thermalfoundation:material", 1, 162));
        RagiRecipe.removeFurnace(RagiUtils.getStack("thermalfoundation:material", 1, 163));
        RagiRecipe.removeFurnace(RagiUtils.getStack("thermalfoundation:material", 1, 164));
    }
}