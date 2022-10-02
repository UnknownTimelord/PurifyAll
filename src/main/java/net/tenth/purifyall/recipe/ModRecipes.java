package net.tenth.purifyall.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tenth.purifyall.PurifyAll;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, PurifyAll.MOD_ID);

    public static final RegistryObject<RecipeSerializer<PurifierRecipe>> PURIFIER_RECIPE_SERIALIZER = SERIALIZERS.register("purifying",
            ()-> PurifierRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
