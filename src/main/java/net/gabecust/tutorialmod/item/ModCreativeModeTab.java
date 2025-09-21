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

    public static final RegistryObject<CreativeModeTab> GABECUST_ITEMS_TAB = CREATIVE_MODE_TABS.register("gabecust_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.YGUIL.get()))
                    .title(Component.translatable("creativetab.gabecustmod.gabecust_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.YGUIL.get());
                        output.accept(ModItems.RZN.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> GABECUST_BLOCKS_TAB = CREATIVE_MODE_TABS.register("gabecust_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.YGUIL_BLOCK.get()))
                    .withTabsBefore(GABECUST_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.gabecustmod.gabecust_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.YGUIL_BLOCK.get());
                        output.accept(ModBlocks.RZN_BLOCK.get());

                    }).build());

    public static void register(IEventBus eventBus) { CREATIVE_MODE_TABS.register(eventBus); }
}
