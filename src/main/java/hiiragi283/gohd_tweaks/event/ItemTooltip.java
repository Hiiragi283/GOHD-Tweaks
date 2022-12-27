package hiiragi283.gohd_tweaks.event;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;
import java.util.Objects;

public class ItemTooltip {

    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent event) {
        //プレイヤーがnullでない場合
        if (Objects.nonNull(event.getEntityPlayer())) {
            //クライアント側のみで実行
            if (event.getEntityPlayer().world.isRemote) {
                //各値の取得
                EntityPlayer player = event.getEntityPlayer();
                ItemStack stack = event.getItemStack();
                NBTTagCompound tag = stack.getTagCompound();
                List<String> tooltips = event.getToolTip();
                //tagとBlockEntityTagの返り値がともにnullでない場合
                if (Objects.nonNull(tag) && Objects.nonNull(tag.getCompoundTag("BlockEntityTag"))) {
                    //BlockEntityTagの返り値を取得
                    NBTTagCompound tagBlock = tag.getCompoundTag("BlockEntityTag");
                    //LootTable返り値がnullでない場合
                    if (Objects.nonNull(tagBlock.getString("LootTable"))) {
                        //LootTableの返り値を取得
                        String lootTable = tagBlock.getString("LootTable");
                        //LootTableの返り値が"artifacts:mimic_underground"と等しい場合
                        if (lootTable.equals("artifacts:mimic_underground")) {
                            //ツールチップを追加
                            tooltips.add(I18n.format("tooltip.safety_mimic.name"));
                        }
                    }
                }
            }
        }
    }
}