package net.tenth.purifyall.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.extensions.IForgeItem;
import net.tenth.purifyall.PurifyAll;
import net.tenth.purifyall.item.ModItemProperties;
import net.tenth.purifyall.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Hammer extends PickaxeItem implements IForgeItem {
    public Hammer(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, ModItemProperties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        if(PurifyAll.getFaceMined() != null) {
            this.faceMined = PurifyAll.getFaceMined();
        }
    }
    private Direction faceMined = PurifyAll.getFaceMined();
    private Direction finalFaceMined;

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()){
            pTooltipComponents.add(Component.literal("Mines in a 3x3 area. Also used to craft plates.")
                    .withStyle(ChatFormatting.BOLD, ChatFormatting.AQUA));
        } else {
            pTooltipComponents.add(Component.literal("Press SHIFT for more information")
                    .withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player) {
        this.finalFaceMined = PurifyAll.getFaceMined();
        return super.onBlockStartBreak(itemstack, pos, player);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack copy = itemStack.copy();
        if(copy.getDamageValue() == copy.getMaxDamage() - 1) {
            return itemStack;
        }
        else {
            copy.setDamageValue(copy.getDamageValue() + 1);
        }
        return copy;
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(pStack.getDamageValue() >= pStack.getMaxDamage()) {
            pStack.shrink(1);
            pLevel.playSound(null, pEntity.blockPosition(), SoundEvents.ITEM_BREAK, SoundSource.AMBIENT, 100f, 0f);
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }
    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        pStack.setDamageValue(pStack.getDamageValue() + 1);
        if(pState.getBlock() == Blocks.IRON_BLOCK) {

            return true;
        }
        switch (this.finalFaceMined) {
            case NORTH -> {
                pLevel.destroyBlock(pPos.above(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.below(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.above().west(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.below().west(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.west(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.above().east(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.below().east(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.east(), true, pEntityLiving, 0);
            }
            case EAST -> {
                pLevel.destroyBlock(pPos.above(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.below(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.above().north(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.below().north(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.north(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.above().south(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.below().south(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.south(), true, pEntityLiving, 0);
            }
            case SOUTH -> {
                pLevel.destroyBlock(pPos.above(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.below(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.above().east(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.below().east(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.east(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.above().west(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.below().west(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.west(), true, pEntityLiving, 0);
            }
            case WEST -> {
                pLevel.destroyBlock(pPos.above(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.below(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.above().south(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.below().south(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.south(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.above().north(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.below().north(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.north(), true, pEntityLiving, 0);
            }
            case UP, DOWN -> {
                pLevel.destroyBlock(pPos.north(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.north().west(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.north().east(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.east(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.south(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.south().west(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.south().east(), true, pEntityLiving, 0);
                pLevel.destroyBlock(pPos.west(), true, pEntityLiving, 0);
            }
        }
        return true;
    }
}
