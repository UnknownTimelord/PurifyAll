package net.tenth.purifyall.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.tenth.purifyall.item.ModItemProperties;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BucketPurifyingAgent extends BucketItem {
    public BucketPurifyingAgent( java.util.function.Supplier<? extends net.minecraft.world.level.material.Fluid> supplier,
                                 ModItemProperties pProperties) {
        super(supplier, pProperties);
        this.purifying_level = pProperties.get_purifying_level();
    }
    private float purifying_level = -1;

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()){
            if(this.purifying_level >= 0) {
                pTooltipComponents.add(Component.literal("Purifying Level: " + this.purifying_level)
                        .withStyle(ChatFormatting.BOLD, ChatFormatting.AQUA));
            } else {
                pTooltipComponents.add(Component.literal("No Purifying Level")
                        .withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_RED));
            }
        } else {
            pTooltipComponents.add(Component.literal("Press SHIFT for more information")
                    .withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
