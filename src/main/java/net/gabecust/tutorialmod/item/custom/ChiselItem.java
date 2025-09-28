package net.gabecust.tutorialmod.item.custom;

import net.gabecust.tutorialmod.block.ModBlocks;
import net.gabecust.tutorialmod.component.ModDataComponentTypes;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {

    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.GOLD_BLOCK, ModBlocks.OLD_GOLD_BLOCK.get(),
                    Blocks.IRON_BLOCK, ModBlocks.OLD_IRON_BLOCK.get(),
                    Blocks.DIAMOND_BLOCK, ModBlocks.OLD_DIAMOND_BLOCK.get(),
                    Blocks.EMERALD_BLOCK, ModBlocks.OLD_EMERALD_BLOCK.get(),

                    ModBlocks.OLD_GOLD_BLOCK.get(), Blocks.GOLD_BLOCK,
                    ModBlocks.OLD_IRON_BLOCK.get(), Blocks.IRON_BLOCK,
                    ModBlocks.OLD_DIAMOND_BLOCK.get(), Blocks.DIAMOND_BLOCK,
                    ModBlocks.OLD_EMERALD_BLOCK.get(), Blocks.EMERALD_BLOCK
            );

    public ChiselItem(Properties pProperties){
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)){
            if(!level.isClientSide()){
                level.setBlockAndUpdate(pContext.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1,((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.ZOMBIE_VILLAGER_CONVERTED, SoundSource.BLOCKS, 0.6f, 1.75f);

                ((ServerLevel)level).sendParticles(ParticleTypes.DRAGON_BREATH,
                        pContext.getClickedPos().getX() + 0.5, pContext.getClickedPos().getY() + 0.5, pContext.getClickedPos().getZ() + 0.5,
                        45, 0.5, 0.5, 0.5, 0.1);

                pContext.getItemInHand().set(ModDataComponentTypes.COORDINATES.get(), pContext.getClickedPos());
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.gabecustmod.chisel"));

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
