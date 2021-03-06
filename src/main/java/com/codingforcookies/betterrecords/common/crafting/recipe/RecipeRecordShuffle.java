package com.codingforcookies.betterrecords.common.crafting.recipe;

import com.codingforcookies.betterrecords.item.ItemMultiRecord;
import com.codingforcookies.betterrecords.item.ItemRecord;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RecipeRecordShuffle implements IRecipe {

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world) {
        ItemStack record = null;
        boolean shuffle = false;
        for(int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
            ItemStack itemstack = inventoryCrafting.getStackInSlot(i);
            if(itemstack != null) {
                if(itemstack.getItem() instanceof ItemMultiRecord && itemstack.getTagCompound() != null) if(record != null) return false;
                else record = itemstack;
                else if(itemstack.getItem() == Item.getItemFromBlock(Blocks.REDSTONE_TORCH)) if(shuffle) return false;
                else shuffle = true;
                else return false;
            }
        }
        return record != null && shuffle;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        ItemStack record = null;
        boolean shuffle = false;
        for(int i = 0; i < inventoryCrafting.getSizeInventory(); i++){
            ItemStack itemstack = inventoryCrafting.getStackInSlot(i);
            if(itemstack != null) {
                if(itemstack.getItem() instanceof ItemRecord && itemstack.getTagCompound() != null) if(record != null) return null;
                else record = itemstack;
                else if(itemstack.getItem() == Item.getItemFromBlock(Blocks.REDSTONE_TORCH)) if(shuffle) return null;
                else shuffle = true;
                else return null;
            }
        }
        if(record == null || !shuffle) return null;
        else{
            ItemStack newRecord = ItemStack.copyItemStack(record);
            if(newRecord.getTagCompound() == null) newRecord.setTagCompound(new NBTTagCompound());
            newRecord.getTagCompound().setBoolean("shuffle", true);
            return newRecord;
        }
    }

    @Override
    public int getRecipeSize(){
        return 10;
    }

    @Override
    public ItemStack getRecipeOutput(){
        return null;
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inv) {
        inv.clear();
        return new ItemStack[] {};
    }
}
