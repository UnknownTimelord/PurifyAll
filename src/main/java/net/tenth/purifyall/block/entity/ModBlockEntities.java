package net.tenth.purifyall.block.entity;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tenth.purifyall.PurifyAll;
import net.tenth.purifyall.block.ModBlocks;

public class ModBlockEntities {
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PurifyAll.MOD_ID);

    public static final RegistryObject<BlockEntityType<PurifierBlockEntity>> PURIFIER =
            BLOCK_ENTITES.register("purifier", ()->
                    BlockEntityType.Builder.of(PurifierBlockEntity::new,
                            ModBlocks.PURIFIER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITES.register(eventBus);
    }
}
