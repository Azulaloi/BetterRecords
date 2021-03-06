package com.codingforcookies.betterrecords.common.crafting;

import com.codingforcookies.betterrecords.block.ModBlocks;
import com.codingforcookies.betterrecords.common.crafting.recipe.*;
import com.codingforcookies.betterrecords.item.ModItem;
import com.codingforcookies.betterrecords.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public final class ModCrafingRecipes {

    public static void init() {

        RecipeSorter.register("betterrecords:urlmultirecord", RecipeMultiRecord.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
        GameRegistry.addRecipe(new RecipeMultiRecord());

        RecipeSorter.register("betterrecords:urlrecordrepeatable", RecipeRecordRepeatable.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
        GameRegistry.addRecipe(new RecipeRecordRepeatable());

        RecipeSorter.register("betterrecords:urlrecordshuffle", RecipeRecordShuffle.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
        GameRegistry.addRecipe(new RecipeRecordShuffle());

        RecipeSorter.register("betterrecords:freqcrystal", RecipeColoredFreqCrystal.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
        GameRegistry.addRecipe(new RecipeColoredFreqCrystal());

        RecipeSorter.register("betterrecords:urlrecord", RecipeColoredRecord.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
        GameRegistry.addRecipe(new RecipeColoredRecord());

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.INSTANCE.getItemFrequencyCrystal()), "RQR", "QDQ", "RQR", 'R', Items.REDSTONE, 'Q', Items.QUARTZ, 'D', Items.DIAMOND);

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.INSTANCE.getItemRecord()), "record", Items.ENDER_EYE));

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.INSTANCE.getItemWire(), 4), "WWW", "III", "WWW", 'I', Items.IRON_INGOT, 'W', new ItemStack(Blocks.WOOL, 1, 15));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.INSTANCE.getItemWire(), 4), "WIW", "WIW", "WIW", 'I', Items.IRON_INGOT, 'W', new ItemStack(Blocks.WOOL, 1, 15));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.INSTANCE.getItemWireCutters()), "I I", " I ", "WIW", 'I', Items.IRON_INGOT, 'W', new ItemStack(Blocks.WOOL, 1, 15));

        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.INSTANCE.getBlockRecordEtcher()), "HIH", "PQP", "PPP", 'H', Blocks.WOODEN_SLAB, 'I', Items.IRON_INGOT, 'P', Blocks.PLANKS, 'Q', Items.QUARTZ);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.INSTANCE.getBlockRecordPlayer()), "GGG", "PDP", "PPP", 'G', Blocks.GLASS_PANE, 'P', Blocks.PLANKS, 'D', Blocks.DIAMOND_BLOCK);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.INSTANCE.getBlockFrequencyTuner()), "SHH", "PQP", "PIP", 'H', Blocks.WOODEN_SLAB, 'I', Items.IRON_INGOT, 'S', Items.STICK, 'P', Blocks.PLANKS, 'Q', ModItems.INSTANCE.getItemFrequencyCrystal());
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.INSTANCE.getBlockRadio()), "HIH", "PQP", "PHP", 'H', Blocks.WOODEN_SLAB, 'I', Items.IRON_INGOT, 'P', Blocks.PLANKS, 'Q', ModItems.INSTANCE.getItemFrequencyCrystal());
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.INSTANCE.getBlockSpeakerSM()), "LLW", "QDW", "LLW", 'L', Blocks.LOG, 'W', new ItemStack(Blocks.WOOL, 1, 15), 'D', Items.DIAMOND, 'Q', Items.QUARTZ);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.INSTANCE.getBlockSpeakerMD()), "LLW", "ESW", "LLW", 'L', Blocks.LOG, 'W', new ItemStack(Blocks.WOOL, 1, 15), 'S', ModBlocks.INSTANCE.getBlockSpeakerSM(), 'E', Items.ENDER_EYE);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.INSTANCE.getBlockSpeakerLG()), "LLW", "CMW", "LLW", 'L', Blocks.LOG, 'W', new ItemStack(Blocks.WOOL, 1, 15), 'M', ModBlocks.INSTANCE.getBlockSpeakerMD(), 'C', Items.COMPARATOR);

        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.INSTANCE.getBlockStrobeLight()), "GGG", "GRG", "CTC", 'G', Blocks.GLASS, 'C', Items.COMPARATOR, 'R', Blocks.REDSTONE_LAMP, 'T', Blocks.REDSTONE_TORCH);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.INSTANCE.getBlockLaser()), "LLL", "LQG", "HLH", 'L', Blocks.LOG, 'H', Blocks.WOODEN_SLAB, 'G', Blocks.GLASS, 'Q', Items.QUARTZ);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.INSTANCE.getBlockLaserCluster()), "LLL", "LRL", "LLL", 'L', ModBlocks.INSTANCE.getBlockLaser(), 'R', Items.REDSTONE);
    }
}
