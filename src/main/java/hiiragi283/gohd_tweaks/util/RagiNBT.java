package hiiragi283.gohd_tweaks.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nonnull;

public class RagiNBT {

    //Safety Mimicを生成するメソッド
    public static ItemStack chestMimic() {
        ItemStack chest = RagiUtils.getStack("minecraft:chest", 1, 0);
        NBTTagCompound nbtLoot = new NBTTagCompound();
        nbtLoot.setString("LootTable", "artifacts:mimic_underground");
        NBTTagCompound nbtName = new NBTTagCompound();
        nbtName.setString("LocName", "item.safety_mimic.name");
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("BlockEntityTag", nbtLoot);
        nbt.setTag("display", nbtName);
        chest.setTagCompound(nbt);
        return chest;
    }

    //stackに名前を設定するメソッド
    public static ItemStack setName(@Nonnull ItemStack stack, String name) {
        NBTTagCompound nbtBase = new NBTTagCompound();
        NBTTagCompound nbtName = new NBTTagCompound();
        nbtName.setString("Name", name);
        nbtBase.setTag("display", nbtName);
        stack.setTagCompound(nbtBase);
        return stack;
    }

    //stackに翻訳した名前を設定するメソッド
    public static ItemStack setLocName(@Nonnull ItemStack stack, String name) {
        NBTTagCompound nbtBase = new NBTTagCompound();
        NBTTagCompound nbtName = new NBTTagCompound();
        nbtName.setString("LocName", name);
        nbtBase.setTag("display", nbtName);
        stack.setTagCompound(nbtBase);
        return stack;
    }
}