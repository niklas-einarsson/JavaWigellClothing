package org.example.Builder;

import org.example.Clothes.Skirt;

public class SkirtBuilder {

    private Skirt skirt = new Skirt();


    public SkirtBuilder addSize(String size) {
        skirt.setSize(size);
        return this;
    }

    public SkirtBuilder addColor(String color) {
        skirt.setColor(color);
        return this;
    }

    public SkirtBuilder addMaterial(String material) {
        skirt.setMaterial(material);
        return this;
    }

    public Skirt build() {
        if(skirt.getColor() == null) {
            throw new IllegalArgumentException("Color for skirt is null");
        }
        if(skirt.getMaterial() == null) {
            throw new IllegalArgumentException("Material for skirt is null");
        }
        if(skirt.getSize() == null) {
            throw new IllegalArgumentException("Size for skirt is null");
        }

        return skirt;

    }



}
