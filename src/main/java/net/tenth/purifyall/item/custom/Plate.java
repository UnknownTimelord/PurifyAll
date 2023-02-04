package net.tenth.purifyall.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.tenth.purifyall.item.ModItemProperties;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Plate extends Item {
    public Plate(ModItemProperties pProperties) {
        super(pProperties);
        this.plate_strength = pProperties.get_plate_strength();
        this.plate_efficiency = pProperties.get_plate_efficiency();
    }
    private float plate_strength = 0;
    private float plate_efficiency = 0;

    public float get_plate_strength() {
        return this.plate_strength;
    }

    public float get_plate_efficiency() {
        return this.plate_efficiency;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()){
            if(this.plate_strength >= 0) {
                pTooltipComponents.add(Component.literal("Plate Strength: " + this.plate_strength)
                        .withStyle(ChatFormatting.BOLD, ChatFormatting.AQUA));
            } else {
                pTooltipComponents.add(Component.literal("Adds no plate strength")
                        .withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_RED));
            }
            if(this.plate_efficiency >= 0) {
                pTooltipComponents.add(Component.literal("Plate Efficiency: " + this.plate_efficiency)
                        .withStyle(ChatFormatting.BOLD, ChatFormatting.AQUA));
            } else {
                pTooltipComponents.add(Component.literal("Adds no plate efficiency")
                        .withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_RED));
            }
        } else {
            pTooltipComponents.add(Component.literal("Press SHIFT for more information")
                    .withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
