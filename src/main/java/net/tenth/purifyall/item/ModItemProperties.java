package net.tenth.purifyall.item;

import net.minecraft.world.item.Item;

public class ModItemProperties extends Item.Properties{
    float purifying_level = 0;

    public Item.Properties purifying_level(float purifying_level) {
        this.purifying_level = purifying_level;
        return this;
    }

    public float get_purifying_level()
    {
        return this.purifying_level;
    }
}
