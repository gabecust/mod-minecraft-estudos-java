package net.gabecust.tutorialmod.item;

import net.gabecust.tutorialmod.TutorialMod;
import net.gabecust.tutorialmod.item.custom.ChiselItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    // adicionar aqui os novo itens

    public static final RegistryObject<Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum",
    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot",
    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PURPLE_GOLD_INGOT = ITEMS.register("purple_gold_ingot",
    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
    () -> new ChiselItem(new Item.Properties().rarity(Rarity.UNCOMMON).durability(32)));

    public static final RegistryObject<Item> OLD_ENCHANTED_GOLDEN_APPLE = ITEMS.register("old_enchanted_golden_apple",
    () -> new Item(new Item.Properties().rarity(Rarity.EPIC).food(ModFoodProperties.OLD_ENCHANTED_GOLDEN_APPLE).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));

    //

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
