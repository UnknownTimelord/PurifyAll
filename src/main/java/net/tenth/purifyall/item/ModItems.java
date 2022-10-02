package net.tenth.purifyall.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tenth.purifyall.PurifyAll;
import net.tenth.purifyall.fluid.ModFluids;
import net.tenth.purifyall.item.custom.BucketPurifyingAgent;
import net.tenth.purifyall.item.custom.PurifyingAgent;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PurifyAll.MOD_ID);

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> REDSTONE_PURIFYING_AGENT = ITEMS.register("redstone_purifying_agent",
            ()-> new PurifyingAgent((ModItemProperties) new ModItemProperties()
                    .purifying_level(1)
                    .tab(ModCreativeModeTab.PURIFY_TAB)));
    public static final RegistryObject<Item> DIAMOND_PURIFYING_AGENT = ITEMS.register("diamond_purifying_agent",
            ()-> new PurifyingAgent((ModItemProperties) new ModItemProperties()
                    .purifying_level(2)
                    .tab(ModCreativeModeTab.PURIFY_TAB)));
    public static final RegistryObject<Item> EMERALD_PURIFYING_AGENT = ITEMS.register("emerald_purifying_agent",
            ()-> new PurifyingAgent((ModItemProperties) new ModItemProperties()
                    .purifying_level(4)
                    .tab(ModCreativeModeTab.PURIFY_TAB)));
    public static final RegistryObject<Item> PURIFYING_LIQUID_BUCKET = ITEMS.register("purifying_liquid_bucket",
            ()-> new BucketPurifyingAgent(ModFluids.SOURCE_PURIFYING_FLUID, (ModItemProperties) new ModItemProperties()
                    .purifying_level(8)
                    .tab(ModCreativeModeTab.PURIFY_TAB)
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)));
}
