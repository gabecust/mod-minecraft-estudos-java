package net.gabecust.tutorialmod.datagen;

import net.gabecust.tutorialmod.TutorialMod;
import net.gabecust.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider{
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_ALUMINUM.get());
        basicItem(ModItems.ALUMINUM_INGOT.get());
        basicItem(ModItems.PURPLE_GOLD_INGOT.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.OLD_ENCHANTED_GOLDEN_APPLE.get());
    }
}
