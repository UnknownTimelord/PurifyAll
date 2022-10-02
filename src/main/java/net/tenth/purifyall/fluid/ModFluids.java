package net.tenth.purifyall.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tenth.purifyall.PurifyAll;
import net.tenth.purifyall.block.ModBlocks;
import net.tenth.purifyall.item.ModItems;

public class ModFluids {
    public static DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, PurifyAll.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_PURIFYING_FLUID = FLUIDS.register("purifying_fluid",
            ()-> new ForgeFlowingFluid.Source(ModFluids.PURIFYING_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_PURIFYING_FLUID = FLUIDS.register("flowing_purifying_fluid",
            ()-> new ForgeFlowingFluid.Flowing(ModFluids.PURIFYING_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties PURIFYING_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.PURIFYING_FLUID_TYPE, SOURCE_PURIFYING_FLUID, FLOWING_PURIFYING_FLUID).block(ModBlocks.PURIFYING_FLUID_BLOCK).bucket(ModItems.PURIFYING_LIQUID_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
