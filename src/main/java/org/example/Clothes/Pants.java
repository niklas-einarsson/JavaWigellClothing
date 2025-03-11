package org.example.Clothes;

public class Pants extends Clothes {

    private String fit;
    private String length;

    public Pants(int id, String name, String size, String material, String color, String length, String fit, double price) {
        super(id, name, size, material, color, price);
        this.length = length;
        this.fit = fit;
    }

    public Pants() {

    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Pants{" +
                "fit='" + fit + '\'' +
                ", length=" + length +
                "} " + super.toString();
    }
}
