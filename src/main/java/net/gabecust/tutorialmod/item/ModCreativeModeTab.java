package net.gabecust.tutorialmod.item;

import net.gabecust.tutorialmod.TutorialMod;
import net.gabecust.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    // adicionar aqui as abas do criativo

    public static final RegistryObject<CreativeModeTab> GABECUST_ITEMS_TAB = CREATIVE_MODE_TABS.register("gabecust_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALUMINUM_INGOT.get()))
                    .title(Component.translatable("creativetab.gabecustmod.gabecust_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_ALUMINUM.get());
                        output.accept(ModItems.ALUMINUM_INGOT.get());
                        output.accept(ModItems.PURPLE_GOLD_INGOT.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> GABECUST_BLOCKS_TAB = CREATIVE_MODE_TABS.register("gabecust_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ALUMINUM_BLOCK.get()))
                    .withTabsBefore(GABECUST_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.gabecustmod.gabecust_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ALUMINUM_ORE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ALUMINUM_BLOCK.get());
                        output.accept(ModBlocks.ALUMINUM_BLOCK.get());
                        output.accept(ModBlocks.PURPLE_GOLD_BLOCK.get());
                        output.accept(ModBlocks.OLD_GOLD_BLOCK.get());
                        output.accept(ModBlocks.OLD_IRON_BLOCK.get());
                        output.accept(ModBlocks.OLD_DIAMOND_BLOCK.get());
                        output.accept(ModBlocks.OLD_EMERALD_BLOCK.get());

                    }).build());

    //

    public static void register(IEventBus eventBus) { CREATIVE_MODE_TABS.register(eventBus); }
}
