package net.tenth.purifyall.event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tenth.purifyall.PurifyAll;
import net.tenth.purifyall.block.entity.ModBlockEntities;
import net.tenth.purifyall.block.entity.renderer.PurifierBlockEntityRenderer;
import net.tenth.purifyall.item.ModItems;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = PurifyAll.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void blockFaceMined(PlayerInteractEvent event) {
            if(event.getFace() != null) {
                PurifyAll.setFaceMined(event.getFace());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = PurifyAll.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.PURIFIER.get(),
                    PurifierBlockEntityRenderer::new);
        }
    }
}
