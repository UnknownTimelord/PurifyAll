package net.tenth.purifyall.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.tenth.purifyall.PurifyAll;
import net.tenth.purifyall.recipe.PurifierRecipe;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIPurifyAllPlugin implements IModPlugin {

    public static RecipeType<PurifierRecipe> PURIFYING_TYPE =
            new RecipeType<>(PurifierRecipeCategory.UID, PurifierRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(PurifyAll.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                PurifierRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<PurifierRecipe> recipePurifying = rm.getAllRecipesFor(PurifierRecipe.Type.INSTANCE);
        registration.addRecipes(PURIFYING_TYPE, recipePurifying);
    }
}
