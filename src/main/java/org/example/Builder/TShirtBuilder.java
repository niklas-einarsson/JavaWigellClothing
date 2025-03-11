package org.example.Builder;

import org.example.Clothes.TShirt;

public class TShirtBuilder {

    private TShirt tshirt = new TShirt();

    public TShirtBuilder addSize(String size) {
        tshirt.setSize(size);
        return this;
    }

    public TShirtBuilder addColor(String color) {
        tshirt.setColor(color);
        return this;
    }

    public TShirtBuilder addMaterial(String material) {
        tshirt.setMaterial(material);
        return this;
    }

    public TShirt build() {
        if(tshirt.getSize() == null) {
            throw new IllegalArgumentException("Size for tshirt is null");
        }
        if(tshirt.getColor() == null) {
            throw new IllegalArgumentException("Color for tshirt is null");
        }
        if(tshirt.getMaterial() == null) {
            throw new IllegalArgumentException("Material for tshirt is null");
        }
        return tshirt;
    }
}
