package hiiragi283.gohd_tweaks.item;

import defeatedcrow.hac.core.util.DCUtil;
import defeatedcrow.hac.main.api.IPressMold;
import hiiragi283.gohd_tweaks.base.ItemBase;
import hiiragi283.gohd_tweaks.util.RagiUtils;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class ItemMoldTitanium extends ItemBase implements IPressMold {

    //Itemの定義
    public ItemMoldTitanium() {
        super("mold_titanium", 3);
    }

    //翻訳キーを得るメソッド
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        //メタデータによらず一定の翻訳キーを返す
        return super.getUnlocalizedName();
    }

    //Itemにtooltipを付与するメソッド
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        ItemStack output = this.getOutput(stack);
        tooltip.add("§lOutput: " + output.getDisplayName());
        tooltip.add("§b§l=== Tips ===");
        tooltip.add(I18n.format("dcs.tip.mold2"));
    }

    //完成品からメタデータを設定するメソッド
    @Override
    public ItemStack setOutput(ItemStack mold, ItemStack output, int num) {
        int meta = -1;
        if (DCUtil.isSameItem(output, RagiUtils.getStack("thermalfoundation", "material", 4, 512), false)) {
            meta = 0;
        } else if (DCUtil.isSameItem(output, RagiUtils.getStack("thermalfoundation", "material", 4, 513), false)) {
            meta = 1;
        } else if (DCUtil.isSameItem(output, RagiUtils.getStack("thermalfoundation", "material", 4, 514), false)) {
            meta = 2;
        } else if (DCUtil.isSameItem(output, RagiUtils.getStack("thermalfoundation", "material", 4, 515), false)) {
            meta = 3;
        }
        if (meta >= 0) {
            ItemStack next = new ItemStack(mold.getItem(), mold.getCount(), meta);
            return next;
        } else return ItemStack.EMPTY;
    }

    //メタデータから完成品を取得するメソッド
    @Override
    public ItemStack getOutput(ItemStack mold) {
        int m = mold.getItemDamage();
        if (m == 0) return RagiUtils.getStack("thermalfoundation", "material", 4, 512);
        else if (m == 1) return RagiUtils.getStack("thermalfoundation", "material", 4, 513);
        else if (m == 2) return RagiUtils.getStack("thermalfoundation", "material", 4, 514);
        else if (m == 3) return RagiUtils.getStack("thermalfoundation", "material", 4, 515);
        return null;
    }

    //わからん
    @Override
    public int getRecipeNumber(ItemStack mold) {
        return 0;
    }

    //レシピを設定するメソッド
    @Override
    public List<ItemStack> getInputs(ItemStack mold) {
        List<ItemStack> list = new ArrayList<ItemStack>();
        int m = mold.getItemDamage();
        if (m == 0) {
            list.add(RagiUtils.getStack("enderio", "item_alloy_ingot", 2, 3));
            list.add(RagiUtils.getStack("thermalfoundation", "material", 1, 352));
        } else if (m == 1) {
            list.add(RagiUtils.getStack("enderio", "item_alloy_ingot", 2, 3));
            list.add(RagiUtils.getStack("thermalfoundation", "material", 1, 33));
        } else if (m == 2) {
            list.add(RagiUtils.getStack("enderio", "item_alloy_ingot", 2, 3));
            list.add(RagiUtils.getStack("thermalfoundation", "material", 1, 322));
        } else if (m == 3) {
            list.add(RagiUtils.getStack("enderio", "item_alloy_ingot", 2, 3));
            list.add(RagiUtils.getStack("thermalfoundation", "material", 1, 353));
        }
        return list;
    }
}