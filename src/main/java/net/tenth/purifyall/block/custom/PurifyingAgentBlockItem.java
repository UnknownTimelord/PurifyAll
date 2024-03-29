package net.tenth.purifyall.block.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.tenth.purifyall.item.ModItemProperties;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PurifyingAgentBlockItem extends BlockItem {
    public PurifyingAgentBlockItem(Block pBlock, ModItemProperties pProperties) {
        super(pBlock, pProperties);
        this.purifying_level = pProperties.get_purifying_level();
        this.machine_frame_material = pProperties.get_machine_frame_material();
    }
    private final String machine_frame_material;
    private float purifying_level = -1;

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()){
            if(this.purifying_level >= 0)
            {
                pTooltipComponents.add(Component.literal("Purifying Level: " + this.purifying_level)
                        .withStyle(ChatFormatting.BOLD, ChatFormatting.AQUA));
            } else if (this.machine_frame_material != "") {
                pTooltipComponents.add(Component.literal("Machine Frame of material: " + this.machine_frame_material)
                        .withStyle(ChatFormatting.BOLD, ChatFormatting.AQUA));
            } else {
                pTooltipComponents.add(Component.literal("Purifies items using FE and Purifying Agent")
                        .withStyle(ChatFormatting.BOLD, ChatFormatting.AQUA));
            }
        } else {
            pTooltipComponents.add(Component.literal("Press SHIFT for more information")
                    .withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }


}
