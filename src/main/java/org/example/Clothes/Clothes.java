package org.example.Clothes;

import org.example.BusinessObject.BusinessObject;

public abstract class Clothes extends BusinessObject {

    private String size;
    private String material;
    private String color;
    private double price;

    public Clothes(int id, String name, String size, String material, String color, double price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.material = material;
        this.color = color;
        this.price = price;
    }

    public Clothes() {
        price = 300.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
