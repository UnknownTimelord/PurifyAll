package net.tenth.purifyall.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public final class PurifyAllConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> energy_to_purify;
    public static final ForgeConfigSpec.ConfigValue<Integer> purifier_energy_capacity;
    public static final ForgeConfigSpec.ConfigValue<Integer> purifier_fluid_capacity;
    public static final ForgeConfigSpec.ConfigValue<Integer> purifier_craft_time;

    static {
        BUILDER.push("Config for Purify All!");
        BUILDER.comment("I recommend setting these vales BEFORE playing, changing these around might screw up existing worlds");
        energy_to_purify = BUILDER.comment("Int value for the FE/t cost for purifying").define("Energy to Purify", 100);
        purifier_craft_time = BUILDER.comment("Int value for the ticks it takes to purify").define("Ticks to Purify", 100);
        purifier_energy_capacity = BUILDER.comment("Int value for the energy storage\n" +
                "WARNING: For recipes to work this must be at least (FE/t cost) * (purifying time)").define("Energy Storage Size", 640000);
        purifier_fluid_capacity = BUILDER.comment("Int value for the Purifier's tank (in mB)\n" +
                "Needs to be AT LEAST as big as the SMALLEST recipe.\n" +
                "(Ex. 500mB crafts need a tank at least 500mB big\nWARNING: Anything smaller than 1000mB renders buckets USELESS").define("Purifier Tank Size", 64000);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public static void register() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SPEC, "purifyall-common.toml");
    }

}
