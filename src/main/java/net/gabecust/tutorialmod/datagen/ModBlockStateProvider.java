package net.gabecust.tutorialmod.datagen;

import net.gabecust.tutorialmod.TutorialMod;
import net.gabecust.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ALUMINUM_ORE);
        blockWithItem(ModBlocks.RAW_ALUMINUM_BLOCK);
        blockWithItem(ModBlocks.ALUMINUM_BLOCK);
        blockWithItem(ModBlocks.PURPLE_GOLD_BLOCK);
        blockWithItem(ModBlocks.OLD_GOLD_BLOCK);
        blockCubeBottomTopWithItem(ModBlocks.OLDER_GOLD_BLOCK);
        blockWithItem(ModBlocks.OLD_IRON_BLOCK);
        blockWithItem(ModBlocks.OLD_DIAMOND_BLOCK);
        blockWithItem(ModBlocks.OLD_EMERALD_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockCubeBottomTopWithItem(RegistryObject<Block> blockRegistryObject) {
        String name = blockRegistryObject.getId().getPath();
        simpleBlockWithItem(blockRegistryObject.get(), models().cubeBottomTop(name,
                modLoc("block/" + name + "_side"),
                modLoc("block/" + name + "_bottom"),
                modLoc("block/" + name + "_top")));
    }

}
