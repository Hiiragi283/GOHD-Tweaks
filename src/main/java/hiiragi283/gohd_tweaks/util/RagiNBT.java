package hiiragi283.gohd_tweaks.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nonnull;

public class RagiNBT {

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