package net.tenth.purifyall.item;

import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;

public class ModItemProperties extends Item.Properties{
    float purifying_level = 0;
    float plate_efficiency = 0;
    float plate_strength = 0;
    String machine_frame_material = "";

    Direction faceMined;

    public Item.Properties customProperties(float purifying_level, String machine_frame_material) {
        this.machine_frame_material = machine_frame_material;
        this.purifying_level = purifying_level;
        return this;
    }

    public Item.Properties faceMined(Direction faceMined) {
        this.faceMined = faceMined;
        return this;
    }
    public Item.Properties plate_levels(float plate_strength, float plate_efficiency) {
        this.plate_strength = plate_strength;
        this.plate_efficiency = plate_efficiency;
        return this;
    }

    public float get_purifying_level()
    {
        return this.purifying_level;
    }
    public float get_plate_strength()
    {
        return this.plate_strength;
    }
    public float get_plate_efficiency()
    {
        return this.plate_efficiency;
    }
    public String get_machine_frame_material() { return this.machine_frame_material; }

}
