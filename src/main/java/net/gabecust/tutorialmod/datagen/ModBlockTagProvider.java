package net.gabecust.tutorialmod.datagen;

import net.gabecust.tutorialmod.TutorialMod;
import net.gabecust.tutorialmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider{

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ALUMINUM_ORE.get())
                .add(ModBlocks.RAW_ALUMINUM_BLOCK.get())
                .add(ModBlocks.ALUMINUM_BLOCK.get())
                .add(ModBlocks.PURPLE_GOLD_BLOCK.get())
                .add(ModBlocks.OLD_GOLD_BLOCK.get())
                .add(ModBlocks.OLDER_GOLD_BLOCK.get())
                .add(ModBlocks.OLD_IRON_BLOCK.get())
                .add(ModBlocks.OLD_DIAMOND_BLOCK.get())
                .add(ModBlocks.OLD_EMERALD_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ALUMINUM_ORE.get())
                .add(ModBlocks.RAW_ALUMINUM_BLOCK.get())
                .add(ModBlocks.ALUMINUM_BLOCK.get())
                .add(ModBlocks.OLD_IRON_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PURPLE_GOLD_BLOCK.get())
                .add(ModBlocks.OLD_GOLD_BLOCK.get())
                .add(ModBlocks.OLDER_GOLD_BLOCK.get())
                .add(ModBlocks.OLD_DIAMOND_BLOCK.get())
                .add(ModBlocks.OLD_EMERALD_BLOCK.get());
    }
}
