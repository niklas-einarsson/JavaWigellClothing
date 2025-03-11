package org.example.Clothes;

public class Skirt extends Clothes {

    private String waistline;
    private String pattern;


    public Skirt(int id, String name, String size, String material, String color, String waistline, String pattern, double price) {
        super(id, name, size, material, color, price);
        this.waistline = waistline;
        this.pattern = pattern;
    }

    public Skirt() {
        System.out.println("Kjol skapad med id " + id);

    }

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "Skirt{" +
                "waistline=" + waistline +
                ", pattern='" + pattern + '\'' +
                "} " + super.toString();
    }
}
