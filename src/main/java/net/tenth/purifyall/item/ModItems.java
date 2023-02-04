package net.tenth.purifyall.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tenth.purifyall.PurifyAll;
import net.tenth.purifyall.fluid.ModFluids;
import net.tenth.purifyall.item.custom.Hammer;
import net.tenth.purifyall.item.custom.Plate;
import net.tenth.purifyall.item.custom.PurifyingAgent;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PurifyAll.MOD_ID);

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> REDSTONE_PURIFYING_AGENT = ITEMS.register("redstone_purifying_agent",
            ()-> new PurifyingAgent((ModItemProperties) new ModItemProperties()
                    .customProperties(1, "")
                    .craftRemainder(Items.SUGAR)
                    .tab(ModCreativeModeTab.PURIFY_TAB)));
    public static final RegistryObject<Item> DIAMOND_PURIFYING_AGENT = ITEMS.register("diamond_purifying_agent",
            ()-> new PurifyingAgent((ModItemProperties) new ModItemProperties()
                    .customProperties(2, "")
                    .craftRemainder(Items.SUGAR)
                    .tab(ModCreativeModeTab.PURIFY_TAB)));
    public static final RegistryObject<Item> EMERALD_PURIFYING_AGENT = ITEMS.register("emerald_purifying_agent",
            ()-> new PurifyingAgent((ModItemProperties) new ModItemProperties()
                    .customProperties(4, "")
                    .craftRemainder(Items.SUGAR)
                    .tab(ModCreativeModeTab.PURIFY_TAB)));
    public static final RegistryObject<Item> PURIFYING_LIQUID_BUCKET = ITEMS.register("purifying_liquid_bucket",
            ()-> new BucketItem(ModFluids.SOURCE_PURIFYING_FLUID, (ModItemProperties) new ModItemProperties()
                    .customProperties(8, "")
                    .tab(ModCreativeModeTab.PURIFY_TAB)
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)));

    /* Hammers */

    public static final TagKey<Item> stone_hammer_excluded = ItemTags.create(new ResourceLocation(PurifyAll.MOD_ID, "tools/hammers/stone_excluded"));
    public static final TagKey<Item> stone_and_gold_and_copper_excluded = ItemTags.create(new ResourceLocation(PurifyAll.MOD_ID, "tools/hammers/stone_gold_copper_excluded"));
    public static final TagKey<Item> diamond_plus = ItemTags.create(new ResourceLocation(PurifyAll.MOD_ID, "tools/hammers/diamond_plus"));
    public static final TagKey<Item> all_hammers = ItemTags.create(new ResourceLocation(PurifyAll.MOD_ID, "tools/hammers/all"));

    public static final RegistryObject<Item> STONE_HAMMER = ITEMS.register("stone_hammer",
            ()-> new Hammer(Tiers.STONE, 0, 0,
                    (ModItemProperties) new ModItemProperties()
                            .defaultDurability(10)
                            .tab(ModCreativeModeTab.PURIFY_TAB)));

    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            ()-> new Hammer(Tiers.IRON, 0, 0,
                    (ModItemProperties) new ModItemProperties()
                            .defaultDurability(100)
                            .tab(ModCreativeModeTab.PURIFY_TAB)));

    public static final RegistryObject<Item> COPPER_HAMMER = ITEMS.register("copper_hammer",
            ()-> new Hammer(Tiers.IRON, 0, 0,
                    (ModItemProperties) new ModItemProperties()
                            .defaultDurability(80)
                            .tab(ModCreativeModeTab.PURIFY_TAB)));

    public static final RegistryObject<Item> GOLD_HAMMER = ITEMS.register("gold_hammer",
            ()-> new Hammer(Tiers.GOLD, 0, 0,
                    (ModItemProperties) new ModItemProperties()
                            .defaultDurability(50)
                            .tab(ModCreativeModeTab.PURIFY_TAB)));

    public static final RegistryObject<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            ()-> new Hammer(Tiers.DIAMOND, 0, 0,
                    (ModItemProperties) new ModItemProperties()
                            .defaultDurability(500)
                            .tab(ModCreativeModeTab.PURIFY_TAB)));

    public static final RegistryObject<Item> NETHERITE_HAMMER = ITEMS.register("netherite_hammer",
            ()-> new Hammer(Tiers.NETHERITE, 0, 0,
                    (ModItemProperties) new ModItemProperties()
                            .defaultDurability(1000)
                            .tab(ModCreativeModeTab.PURIFY_TAB)));

    /* Plates */

    public static final TagKey<Item> tier_one = ItemTags.create(new ResourceLocation(PurifyAll.MOD_ID, "plates/tier_one"));
    public static final TagKey<Item> tier_two = ItemTags.create(new ResourceLocation(PurifyAll.MOD_ID, "plates/tier_two"));

    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate",
            ()-> new Plate((ModItemProperties) new ModItemProperties()
                    .plate_levels(1, 0)
                    .tab(ModCreativeModeTab.PURIFY_TAB)));

    public static final RegistryObject<Item> COPPER_PLATE = ITEMS.register("copper_plate",
            ()-> new Plate((ModItemProperties) new ModItemProperties()
                    .plate_levels(1, 1)
                    .tab(ModCreativeModeTab.PURIFY_TAB)));

    public static final RegistryObject<Item> GOLD_PLATE = ITEMS.register("gold_plate",
            ()-> new Plate((ModItemProperties) new ModItemProperties()
                    .plate_levels(0, 2)
                    .tab(ModCreativeModeTab.PURIFY_TAB)));

    public static final RegistryObject<Item> DIAMOND_PLATE = ITEMS.register("diamond_plate",
            ()-> new Plate((ModItemProperties) new ModItemProperties()
                    .plate_levels(4, 4)
                    .tab(ModCreativeModeTab.PURIFY_TAB)));

    public static final RegistryObject<Item> NETHERITE_PLATE = ITEMS.register("netherite_plate",
            ()-> new Plate((ModItemProperties) new ModItemProperties()
                    .plate_levels(8, 8)
                    .tab(ModCreativeModeTab.PURIFY_TAB)));
}
