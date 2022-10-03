package net.tenth.purifyall.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.tenth.purifyall.PurifyAll;
import net.tenth.purifyall.block.ModBlocks;
import net.tenth.purifyall.config.PurifyAllConfig;
import net.tenth.purifyall.recipe.PurifierRecipe;

import java.util.List;

public class PurifierRecipeCategory implements IRecipeCategory<PurifierRecipe> {
    public final static ResourceLocation UID =
            new ResourceLocation(PurifyAll.MOD_ID, "purifying");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(PurifyAll.MOD_ID, "textures/gui/purifier_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public PurifierRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.PURIFIER.get()));
    }

    @Override
    public RecipeType<PurifierRecipe> getRecipeType() {
        return JEIPurifyAllPlugin.PURIFYING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Purifier");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PurifierRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 66, 38)
                .addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 9, 13)
                .addIngredients(ForgeTypes.FLUID_STACK, List.of(recipe.getFluid()))
                        .setFluidRenderer(PurifyAllConfig.purifier_fluid_capacity.get(), false, 10, 66);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 106, 38).addItemStack(recipe.getResultItem());

    }
}
