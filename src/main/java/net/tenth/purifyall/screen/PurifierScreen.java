package net.tenth.purifyall.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.TooltipFlag;
import net.tenth.purifyall.PurifyAll;
import net.tenth.purifyall.config.PurifyAllConfig;
import net.tenth.purifyall.screen.renderer.EnergyInfoArea;
import net.tenth.purifyall.screen.renderer.FluidTankRenderer;
import net.tenth.purifyall.util.MouseUtil;

import java.util.Optional;

public class PurifierScreen extends AbstractContainerScreen<PurifierMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(PurifyAll.MOD_ID, "textures/gui/purifier_gui.png");
    private EnergyInfoArea energyInfoArea;
    private FluidTankRenderer renderer;

    public PurifierScreen(PurifierMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        assignEnergyInfoArea();
        assignFluidRenderer();
    }

    private void assignFluidRenderer() {
        renderer = new FluidTankRenderer(PurifyAllConfig.purifier_fluid_capacity.get(), true, 10, 66);
    }

    private void assignEnergyInfoArea() {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        energyInfoArea = new EnergyInfoArea(x + 156, y + 13, menu.blockEntity.getEnergyStorage());
    }

    @Override
    protected void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        renderEnergyAreaTooltips(pPoseStack, pMouseX, pMouseY, x, y);
        renderFluidAreaTooltips(pPoseStack, pMouseX, pMouseY, x, y);
    }

    private void renderFluidAreaTooltips(PoseStack pPoseStack, int pMouseX, int pMouseY, int x, int y) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 9, 13, 8, 64)) {
            renderTooltip(pPoseStack, renderer.getTooltip(menu.getFluidStack(), TooltipFlag.Default.NORMAL),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }

    private void renderEnergyAreaTooltips(PoseStack pPoseStack, int pMouseX, int pMouseY, int x, int y) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 156, 13, 6, 62)) {
            renderTooltip(pPoseStack, energyInfoArea.getTooltips(),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);
        renderProgressArrow(pPoseStack, x, y);
        energyInfoArea.draw(pPoseStack);
        renderer.render(pPoseStack, x + 9, y + 13, menu.getFluidStack());
    }

    private void renderProgressArrow(PoseStack pPoseStack, int x, int y) {
        if(menu.isCrafting()) {
            blit(pPoseStack, x + 85, y + 42, 176, 0, menu.getScaledProgress(), 8);
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, width, height);
    }

}
