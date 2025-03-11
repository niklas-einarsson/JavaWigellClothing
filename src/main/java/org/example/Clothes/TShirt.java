package org.example.Clothes;

public class TShirt extends Clothes {

    private String sleeves;
    private String neck;

    public TShirt(int id, String name, String size, String material, String color, String sleeves, String neck, double price) {
        super(id, name, size, material, color, price);
        this.sleeves = sleeves;
        this.neck = neck;
    }

    public TShirt() {

    }

    public String getSleeves() {
        return sleeves;
    }

    public void setSleeves(String sleeves) {
        this.sleeves = sleeves;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "sleeves='" + sleeves + '\'' +
                ", neck='" + neck + '\'' +
                "} " + super.toString();
    }
}
