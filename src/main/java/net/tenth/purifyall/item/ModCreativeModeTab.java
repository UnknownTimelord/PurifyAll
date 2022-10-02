package net.tenth.purifyall.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab PURIFY_TAB = new CreativeModeTab("purify_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.REDSTONE_PURIFYING_AGENT.get());
        }
    };
}
