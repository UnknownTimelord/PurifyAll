package net.tenth.purifyall.block;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tenth.purifyall.PurifyAll;
import net.tenth.purifyall.block.custom.PurifierBlock;
import net.tenth.purifyall.block.custom.PurifyingAgentBlockItem;
import net.tenth.purifyall.fluid.ModFluids;
import net.tenth.purifyall.item.ModCreativeModeTab;
import net.tenth.purifyall.item.ModItemProperties;
import net.tenth.purifyall.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PurifyAll.MOD_ID);

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab, int purifying_level, String machine_frame_material)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, purifying_level, machine_frame_material);

        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block, CreativeModeTab tab, int purifying_level, String machine_frame_material)
    {
        return ModItems.ITEMS.register(name, ()-> new PurifyingAgentBlockItem(block.get(),(ModItemProperties) new ModItemProperties().customProperties(purifying_level, machine_frame_material).tab(tab)));
    }

    // THANKS FOR THESE HELPER CLASSES KJOE! SO MUCH BETTER THAN REGISTERING THE BLOCK AND ITEMS EVERY TIME! :D

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }

    public static final RegistryObject<Block> REDSTONE_PURIFYING_AGENT_BLOCK = ModBlocks.registerBlock("redstone_purifying_agent_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.SAND)
                    .strength(1f)
                    .sound(SoundType.GRAVEL)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.PURIFY_TAB, 9, "");
    public static final RegistryObject<Block> DIAMOND_PURIFYING_AGENT_BLOCK = ModBlocks.registerBlock("diamond_purifying_agent_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.SAND)
                    .strength(1f)
                    .sound(SoundType.GRAVEL)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.PURIFY_TAB, 18, "");
    public static final RegistryObject<Block> EMERALD_PURIFYING_AGENT_BLOCK = ModBlocks.registerBlock("emerald_purifying_agent_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.SAND)
                    .strength(1f)
                    .sound(SoundType.GRAVEL)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.PURIFY_TAB, 32, "");
    public static final RegistryObject<LiquidBlock> PURIFYING_FLUID_BLOCK = BLOCKS.register("purifying_fluid_block",
            ()-> new LiquidBlock(ModFluids.SOURCE_PURIFYING_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryObject<Block> PURIFIER = ModBlocks.registerBlock("purifier",
            ()-> new PurifierBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()), ModCreativeModeTab.PURIFY_TAB, -1, "");

    public static final RegistryObject<Block> IRON_MACHINE_FRAME = ModBlocks.registerBlock("iron_machine_frame",
            ()-> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()), ModCreativeModeTab.PURIFY_TAB, -1, "iron");

    public static final RegistryObject<Block> COPPER_MACHINE_FRAME = ModBlocks.registerBlock("copper_machine_frame",
            ()-> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()), ModCreativeModeTab.PURIFY_TAB, -1, "copper");

    public static final RegistryObject<Block> GOLD_MACHINE_FRAME = ModBlocks.registerBlock("gold_machine_frame",
            ()-> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()), ModCreativeModeTab.PURIFY_TAB, -1, "gold");

    public static final RegistryObject<Block> DIAMOND_MACHINE_FRAME = ModBlocks.registerBlock("diamond_machine_frame",
            ()-> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()), ModCreativeModeTab.PURIFY_TAB, -1, "diamond");

    public static final RegistryObject<Block> NETHERITE_MACHINE_FRAME = ModBlocks.registerBlock("netherite_machine_frame",
            ()-> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()), ModCreativeModeTab.PURIFY_TAB, -1, "netherite");

}
