package org.example.BusinessObject;

public class CEO extends BusinessObject {

    private static int nextId = 1;

    public CEO(int id, String name) {
        id = nextId++;
        this.name = name;
        System.out.println("Ny CEO skapad med namn: " + name);
    }

    public CEO() {
        id=nextId++;
    }

    @Override
    public String toString() {
        return "CEO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
