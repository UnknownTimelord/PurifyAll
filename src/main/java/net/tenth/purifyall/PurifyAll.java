package net.tenth.purifyall;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tenth.purifyall.block.ModBlocks;
import net.tenth.purifyall.block.entity.ModBlockEntities;
import net.tenth.purifyall.config.PurifyAllConfig;
import net.tenth.purifyall.fluid.ModFluidTypes;
import net.tenth.purifyall.fluid.ModFluids;
import net.tenth.purifyall.item.ModItems;
import net.tenth.purifyall.networking.ModMessages;
import net.tenth.purifyall.recipe.ModRecipes;
import net.tenth.purifyall.screen.ModMenuTypes;
import net.tenth.purifyall.screen.PurifierScreen;
import org.slf4j.Logger;

@Mod(PurifyAll.MOD_ID)
public class PurifyAll
{
    public static final String MOD_ID = "purifyall";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PurifyAll()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModMessages.register();
        PurifyAllConfig.register();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_PURIFYING_FLUID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_PURIFYING_FLUID.get(), RenderType.translucent());

            MenuScreens.register(ModMenuTypes.PURIFIER_MENU.get(), PurifierScreen::new);
        }
    }
}
