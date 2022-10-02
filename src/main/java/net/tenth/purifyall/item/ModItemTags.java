package net.tenth.purifyall.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.tenth.purifyall.PurifyAll;

public class ModItemTags {
    public static final TagKey<Item> purifying_level = ItemTags.create(new ResourceLocation(PurifyAll.MOD_ID));

}
