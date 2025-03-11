package org.example.Builder;

import org.example.Clothes.Pants;

public class PantsBuilder {

    private Pants pants = new Pants();

    public PantsBuilder addSize(String size) {
        pants.setSize(size);
        return this;
    }

    public PantsBuilder addColor(String color) {
        pants.setColor(color);
        return this;
    }

    public PantsBuilder addMaterial(String material) {
        pants.setMaterial(material);
        return this;
    }


    public Pants build() {
        if (pants.getColor() == null) {
            throw new IllegalArgumentException("Color for pants is null");
        }
        if (pants.getSize() == null) {
            throw new IllegalArgumentException("Size for pants is null");
        }
        if (pants.getMaterial() == null) {
            throw new IllegalArgumentException("Material for pants is null");
        }
        return pants;
    }


}
