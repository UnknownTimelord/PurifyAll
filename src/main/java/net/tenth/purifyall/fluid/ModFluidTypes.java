package net.tenth.purifyall.fluid;

import com.mojang.math.Vector3f;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tenth.purifyall.PurifyAll;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation PURIFYING_OVERLAY_RL = new ResourceLocation("misc/in_purifying_water");

    public static DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, PurifyAll.MOD_ID);

    public static RegistryObject<FluidType> PURIFYING_FLUID_TYPE = register("purifying_fluid",
            FluidType.Properties.create().canConvertToSource(false));

    public static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, ()-> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, PURIFYING_OVERLAY_RL,
                0xA1800000, new Vector3f(8.903f, 4.59f, 0.417f), properties));
    }

    public static void register(IEventBus eventBus)
    {
        FLUID_TYPES.register(eventBus);
    }
}
